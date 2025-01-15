package org.jeecg.modules.tiangong.service.impl;

import org.jeecg.modules.tiangong.entity.BizInventoryItem;
import org.jeecg.modules.tiangong.entity.Inventory;
import org.jeecg.modules.tiangong.entity.InventoryGroup;
import org.jeecg.modules.tiangong.mapper.InventoryGroupMapper;
import org.jeecg.modules.tiangong.service.IInventoryGroupService;
import org.jeecg.modules.tiangong.service.IInventoryService;
import org.jeecg.modules.tiangong.service.IBizInventoryItemService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.boot.starter.lock.client.RedissonLockClient;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Arrays;

/**
 * @Description: 库存组
 * @Author: jeecg-boot
 * @Date:   2025-01-15
 * @Version: V1.0
 */
@Slf4j
@Service
public class InventoryGroupServiceImpl extends ServiceImpl<InventoryGroupMapper, InventoryGroup> implements IInventoryGroupService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    @Autowired
    private RedissonLockClient redissonLock;
    
    @Autowired
    private IInventoryService inventoryService;
    
    @Autowired
    private IBizInventoryItemService inventoryItemService;

    private static final String INVENTORY_KEY_PREFIX = "inventory:";
    private static final String INVENTORY_LOCK_PREFIX = "inventory_lock:";
    private static final long WAIT_TIME = 3000;
    private static final long LEASE_TIME = 10000;
    private static final String DATE_PATTERN = "yyyyMMdd";

    /**
     * 创建或更新库存
     * @param groupId 库存组ID
     */
    public void createOrUpdateInventory(String groupId) {
        // 1. 获取库存组信息
        InventoryGroup inventoryGroup = this.getById(groupId);
        if (inventoryGroup == null) {
            throw new RuntimeException("库存组不存在");
        }

        // 2. 获取库存组关联的库存ID列表
        String inventoryIds = inventoryGroup.getInventoryId();
        if (StringUtils.isEmpty(inventoryIds)) {
            throw new RuntimeException("库存组未关联任何库存");
        }

        // 3. 遍历每个库存ID
        Arrays.stream(inventoryIds.split(";"))
              .forEach(inventoryId -> {
                  // 获取库存信息
                  Inventory inventory = inventoryService.getById(inventoryId);
                  if (inventory == null) {
                      return; // 跳过不存在的库存
                  }

                  // 获取该库存的所有时段
                  List<BizInventoryItem> inventoryItems = inventoryItemService.list(
                      new LambdaQueryWrapper<BizInventoryItem>()
                          .eq(BizInventoryItem::getInventoryId, inventoryId)
                  );

                  // 为每个时段设置库存
                  for (BizInventoryItem item : inventoryItems) {
                      String redisKey = generateInventoryKey(groupId, inventoryId, item.getId());
                      String lockKey = INVENTORY_LOCK_PREFIX + redisKey;
                      
                      try {
                          if (redissonLock.tryLock(lockKey, -1, LEASE_TIME)) {
                              try {
                                  // 设置库存数量
                                  redisTemplate.opsForValue().set(redisKey, item.getQuantity());
                                  log.info("设置库存成功 - groupId: {}, inventoryId: {}, itemId: {}, quantity: {}", 
                                          groupId, inventoryId, item.getId(), item.getQuantity());
                              } finally {
                                  redissonLock.unlock(lockKey);
                              }
                          } else {
                              log.warn("获取锁失败 - lockKey: {}", lockKey);
                          }
                      } catch (Exception e) {
                          log.error("设置库存失败", e);
                          throw new RuntimeException("设置库存失败", e);
                      }
                  }
              });
    }

    /**
     * 扣减库存
     * @param groupId 库存组ID
     * @param inventoryId 库存ID
     * @param itemId 时段ID
     * @param quantity 扣减数量
     * @param date 库存日期
     * @return 是否扣减成功
     */
    public boolean deductInventory(String groupId, String inventoryId, String itemId, int quantity, LocalDate date) {
        String redisKey = generateInventoryKey(groupId, inventoryId, itemId, date);
        String lockKey = INVENTORY_LOCK_PREFIX + redisKey;
        
        try {
            if (redissonLock.tryLock(lockKey, WAIT_TIME, LEASE_TIME)) {
                try {
                    Integer currentStock = (Integer) redisTemplate.opsForValue().get(redisKey);
                    if (currentStock == null || currentStock < quantity) {
                        log.warn("库存不足 - date: {}, currentStock: {}, deductQuantity: {}", 
                                date.format(DateTimeFormatter.ofPattern(DATE_PATTERN)), currentStock, quantity);
                        return false;
                    }
                    
                    // 扣减库存
                    redisTemplate.opsForValue().set(redisKey, currentStock - quantity);
                    log.info("扣减库存成功 - date: {}, groupId: {}, inventoryId: {}, itemId: {}, quantity: {}, remainingStock: {}", 
                            date.format(DateTimeFormatter.ofPattern(DATE_PATTERN)), 
                            groupId, inventoryId, itemId, quantity, currentStock - quantity);
                    return true;
                } finally {
                    redissonLock.unlock(lockKey);
                }
            } else {
                log.warn("获取锁失败 - date: {}, lockKey: {}", 
                        date.format(DateTimeFormatter.ofPattern(DATE_PATTERN)), lockKey);
                return false;
            }
        } catch (Exception e) {
            log.error("扣减库存失败 - date: {}", date.format(DateTimeFormatter.ofPattern(DATE_PATTERN)), e);
            throw new RuntimeException("扣减库存失败", e);
        }
    }

    /**
     * 生成Redis库存key
     * 格式: inventory:groupId:inventoryId:itemId:yyyyMMdd
     */
    private String generateInventoryKey(String groupId, String inventoryId, String itemId) {
        String currentDate = DateTimeFormatter.ofPattern(DATE_PATTERN)
                .format(LocalDate.now());
        return INVENTORY_KEY_PREFIX + groupId + ":" + inventoryId + ":" + itemId + ":" + currentDate;
    }

    /**
     * 生成指定日期的Redis库存key
     * 格式: inventory:groupId:inventoryId:itemId:yyyyMMdd
     */
    private String generateInventoryKey(String groupId, String inventoryId, String itemId, LocalDate date) {
        String formatDate = DateTimeFormatter.ofPattern(DATE_PATTERN)
                .format(date);
        return INVENTORY_KEY_PREFIX + groupId + ":" + inventoryId + ":" + itemId + ":" + formatDate;
    }
}

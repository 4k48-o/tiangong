package org.jeecg.modules.tiangong.service.impl;

import org.jeecg.modules.tiangong.entity.Inventory;
import org.jeecg.modules.tiangong.entity.BizInventoryItem;
import org.jeecg.modules.tiangong.mapper.BizInventoryItemMapper;
import org.jeecg.modules.tiangong.mapper.InventoryMapper;
import org.jeecg.modules.tiangong.service.IInventoryService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

/**
 * @Description: 库存
 * @Author: jeecg-boot
 * @Date:   2025-01-09
 * @Version: V1.0
 */
@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory> implements IInventoryService {

	@Autowired
	private InventoryMapper inventoryMapper;
	@Autowired
	private BizInventoryItemMapper bizInventoryItemMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		bizInventoryItemMapper.deleteByMainId(id);
		inventoryMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			bizInventoryItemMapper.deleteByMainId(id.toString());
			inventoryMapper.deleteById(id);
		}
	}
	
}

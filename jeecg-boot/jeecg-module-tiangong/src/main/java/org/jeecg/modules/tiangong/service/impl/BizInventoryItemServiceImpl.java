package org.jeecg.modules.tiangong.service.impl;

import org.jeecg.modules.tiangong.entity.BizInventoryItem;
import org.jeecg.modules.tiangong.mapper.BizInventoryItemMapper;
import org.jeecg.modules.tiangong.service.IBizInventoryItemService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 库存时段表
 * @Author: jeecg-boot
 * @Date:   2025-01-09
 * @Version: V1.0
 */
@Service
public class BizInventoryItemServiceImpl extends ServiceImpl<BizInventoryItemMapper, BizInventoryItem> implements IBizInventoryItemService {
	
	@Autowired
	private BizInventoryItemMapper bizInventoryItemMapper;
	
	@Override
	public List<BizInventoryItem> selectByMainId(String mainId) {
		return bizInventoryItemMapper.selectByMainId(mainId);
	}
}

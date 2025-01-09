package org.jeecg.modules.tiangong.service;

import org.jeecg.modules.tiangong.entity.BizInventoryItem;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 库存时段表
 * @Author: jeecg-boot
 * @Date:   2025-01-09
 * @Version: V1.0
 */
public interface IBizInventoryItemService extends IService<BizInventoryItem> {

  /**
   * 通过主表id查询子表数据
   *
   * @param mainId
   * @return List<BizInventoryItem>
   */
	public List<BizInventoryItem> selectByMainId(String mainId);
}

package org.jeecg.modules.tiangong.service;

import org.jeecg.modules.tiangong.entity.BizInventoryItem;
import org.jeecg.modules.tiangong.entity.Inventory;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 库存
 * @Author: jeecg-boot
 * @Date:   2025-01-09
 * @Version: V1.0
 */
public interface IInventoryService extends IService<Inventory> {

	/**
	 * 删除一对多
	 *
	 * @param id
	 */
	public void delMain (String id);
	
	/**
	 * 批量删除一对多
	 *
	 * @param idList
	 */
	public void delBatchMain (Collection<? extends Serializable> idList);


}

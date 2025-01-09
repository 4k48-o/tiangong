package org.jeecg.modules.tiangong.mapper;

import java.util.List;
import org.jeecg.modules.tiangong.entity.BizInventoryItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 库存时段表
 * @Author: jeecg-boot
 * @Date:   2025-01-09
 * @Version: V1.0
 */
public interface BizInventoryItemMapper extends BaseMapper<BizInventoryItem> {

	/**
	 * 通过主表id删除子表数据
	 *
	 * @param mainId 主表id
	 * @return boolean
	 */
	public boolean deleteByMainId(@Param("mainId") String mainId);

   /**
    * 通过主表id查询子表数据
    *
    * @param mainId 主表id
    * @return List<BizInventoryItem>
    */
	public List<BizInventoryItem> selectByMainId(@Param("mainId") String mainId);

}

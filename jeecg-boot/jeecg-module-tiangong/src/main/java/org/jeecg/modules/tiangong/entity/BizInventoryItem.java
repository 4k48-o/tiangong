package org.jeecg.modules.tiangong.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.UnsupportedEncodingException;

/**
 * @Description: 库存时段表
 * @Author: jeecg-boot
 * @Date:   2025-01-09
 * @Version: V1.0
 */
@Data
@TableName("biz_inventory_item")
@ApiModel(value="biz_inventory_item对象", description="库存时段表")
public class BizInventoryItem implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
	/**库存id*/
    @ApiModelProperty(value = "库存id")
    private java.lang.String inventoryId;
	/**时段名称*/
	@Excel(name = "时段名称", width = 15)
    @ApiModelProperty(value = "时段名称")
    private java.lang.String timeSlotName;
	/**时段别名*/
	@Excel(name = "时段别名", width = 15)
    @ApiModelProperty(value = "时段别名")
    private java.lang.String timeSlotAlias;
	/**时段编号*/
	@Excel(name = "时段编号", width = 15)
    @ApiModelProperty(value = "时段编号")
    private java.lang.String timeSlotSn;
	/**时段排序*/
	@Excel(name = "时段排序", width = 15)
    @ApiModelProperty(value = "时段排序")
    private java.lang.Integer timeSlotSort;
	/**时段开始时间*/
	@Excel(name = "时段开始时间", width = 15)
    @ApiModelProperty(value = "时段开始时间")
    private java.lang.String startTime;
	/**时段结束时间*/
	@Excel(name = "时段结束时间", width = 15)
    @ApiModelProperty(value = "时段结束时间")
    private java.lang.String endTime;
	/**库存数量*/
	@Excel(name = "库存数量", width = 15)
    @ApiModelProperty(value = "库存数量")
    private java.lang.Integer quantity;
}

package org.jeecg.modules.tiangong.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 库存
 * @Author: jeecg-boot
 * @Date:   2025-01-09
 * @Version: V1.0
 */
@Data
@TableName("biz_inventory")
@ApiModel(value="biz_inventory对象", description="库存")
public class Inventory implements Serializable {
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
	/**库存名称*/
    @Excel(name = "库存名称", width = 15)
    @ApiModelProperty(value = "库存名称")
    private java.lang.String name;
	/**库存编号*/
    @Excel(name = "库存编号", width = 15)
    @ApiModelProperty(value = "库存编号")
    private java.lang.String inventorySn;
	/**库存总量*/
    @Excel(name = "库存总量", width = 15)
    @ApiModelProperty(value = "库存总量")
    private java.lang.Integer totalCapacity;
	/**库存类型*/
    @Excel(name = "库存类型", width = 15)
    @ApiModelProperty(value = "库存类型")
    private java.lang.String inventoryType;
	/**生成频率*/
    @Excel(name = "生成频率", width = 15)
    @ApiModelProperty(value = "生成频率")
    private java.lang.Integer inventoryGenerationDays;
	/**开始日期*/
    @Excel(name = "开始日期", width = 15)
    @ApiModelProperty(value = "开始日期")
    private java.lang.String startDate;
	/**结束日期*/
    @Excel(name = "结束日期", width = 15)
    @ApiModelProperty(value = "结束日期")
    private java.lang.String endDate;
}

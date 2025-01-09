package org.jeecg.modules.tiangong.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 设备表
 * @Author: jeecg-boot
 * @Date:   2025-01-06
 * @Version: V1.0
 */
@Data
@TableName("biz_device")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="biz_device对象", description="设备表")
public class Device implements Serializable {
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
	/**设备名称*/
	@Excel(name = "设备名称", width = 15)
    @ApiModelProperty(value = "设备名称")
    private java.lang.String name;
	/**设备编号*/
	@Excel(name = "设备编号", width = 15)
    @ApiModelProperty(value = "设备编号")
    private java.lang.String deviceSn;
	/**设备ip地址*/
	@Excel(name = "设备ip地址", width = 15)
    @ApiModelProperty(value = "设备ip地址")
    private java.lang.String ip;
	/**门区*/
	@Excel(name = "门区", width = 15, dictTable = "biz_gate", dicText = "gate_name", dicCode = "id")
	@Dict(dictTable = "biz_gate", dicText = "gate_name", dicCode = "id")
    @ApiModelProperty(value = "门区")
    private java.lang.String gateId;
	/**景区ID*/
	@Excel(name = "景区ID", width = 15)
    @ApiModelProperty(value = "景区ID")
    private java.lang.String scenicAreaId;
	/**是否在线*/
    @Excel(name = "是否在线", width = 15,replace = {"是_Y","否_N"} )
    @ApiModelProperty(value = "是否在线")
    private java.lang.String online;
	/**设备类型*/
	@Excel(name = "设备类型", width = 15, dicCode = "device_type")
	@Dict(dicCode = "device_type")
    @ApiModelProperty(value = "设备类型")
    private java.lang.String deviceType;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String remark;
}

package org.jeecg.modules.tiangong.entity;

import lombok.Data;
import java.io.Serializable;

import org.jeecg.common.aspect.annotation.Dict;
import org.jeecgframework.poi.excel.annotation.Excel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModelProperty;
/**
 * 预定信息规则
 * @author 老杨
 * @date 2024年12月21日22:20:14
 */
@Data
@TableName("biz_advance_booking_rule")
public class AdvanceBooking implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @Excel(name = "规则名称", width = 15)
    @ApiModelProperty(value = "规则名称")
    private String name;

    @Excel(name = "规则编码", width = 15)
    @ApiModelProperty(value = "规则编码")
    private String sn;


    @Excel(name = "截止预定时间相较出行日的提前天数", width = 15)
    @ApiModelProperty(value = "截止预定时间相较出行日的提前天数")
    private Integer advanceBookingDays;
    
    
    @Excel(name = "截止预定时间的时刻", width = 15)
    @ApiModelProperty(value = "截止预定时间的时刻,格式为HH:mm")
    private String advanceBookingTime;
    
    @Excel(name = "截止预定时间相较场次时间的类型", width = 15)
    @ApiModelProperty(value = "截止预定时间相较场次时间的类型")
    @Dict (dicCode = "session_time_type")
    private SessionTimeType sessionTimeType;
    
    @Excel(name = "截止预定时间相较场次时间的偏移值", width = 15)
    @ApiModelProperty(value = "截止预定时间相较场次时间的偏移值")
    private Integer advanceBookingMinutesSessionOffset;
    
    @Excel(name = "最早可购买时间相较出行日的提前天数", width = 15)
    @ApiModelProperty(value = "最早可购买时间相较出行日的提前天数")
    private Integer earliestBookingDays;
    
    
    @Excel(name = "最早可购买时间的时刻,格式为HH:mm", width = 15)
    @ApiModelProperty(value = "最早可购买时间的时刻,格式为HH:mm")
    private String earliestBookingTime;
    
    @ApiModelProperty(value = "下单后多少小时可用")
    @Excel(name = "下单后多少小时可用", width = 15)
    private Integer passLimitHours;
    
    
    @ApiModelProperty(value = "下单后多少分钟可用")
    @Excel(name = "下单后多少分钟可用", width = 15)
    private Integer passLimitMinutes;


    @Excel(name = "预定说明", width = 15)
    @ApiModelProperty(value = "预定说明")
    private String description;
}

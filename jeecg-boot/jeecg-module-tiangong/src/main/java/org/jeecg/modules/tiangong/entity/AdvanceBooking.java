package org.jeecg.modules.tiangong.entity;

import lombok.Data;
import java.io.Serializable;
import javax.validation.constraints.*;
import io.swagger.annotations.ApiModelProperty;
/**
 * 预定信息
 * @author 老杨
 * @date 2024年12月21日22:20:14
 */
@Data
public class AdvanceBooking implements Serializable {
    
    private static final long serialVersionUID = 1L;

    
    @ApiModelProperty(value = "截止预定时间相较出行日的提前天数")
    private Integer advanceBookingDays;
    
    
    @Pattern(regexp = "^([01][0-9]|2[0-3]):[0-5][0-9]$", message = "截止预定时间的时刻格式不正确")
    @ApiModelProperty(value = "截止预定时间的时刻，格式为HH:mm")
    private String advanceBookingTime;
    
    
    @ApiModelProperty(value = "截止预定时间相较场次时间的类型")
    private SessionTimeType sessionTimeType;
    
    
    @ApiModelProperty(value = "截止预定时间相较场次时间的偏移值")
    private Integer advanceBookingMinutesSessionOffset;
    
    
    @ApiModelProperty(value = "最早可购买时间相较出行日的提前天数")
    private Integer earliestBookingDays;
    
    
    @Pattern(regexp = "^([01][0-9]|2[0-3]):[0-5][0-9]$", message = "最早可购买时间的时刻格式不正确")
    @ApiModelProperty(value = "最早可购买时间的时刻，格式为HH:mm")
    private String earliestBookingTime;
    
    @ApiModelProperty(value = "下单后多少小时可用")
    private Integer passLimitHours;
    
    
    @ApiModelProperty(value = "下单后多少分钟可用")
    private Integer passLimitMinutes;
    
    @Size(max = 500, message = "预定说明长度不能超过500个字符")
    @ApiModelProperty(value = "预定说明")
    private String description;
}

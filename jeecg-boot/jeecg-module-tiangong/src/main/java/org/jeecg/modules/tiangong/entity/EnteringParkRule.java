package org.jeecg.modules.tiangong.entity;
import  org.jeecg.modules.tiangong.entity.enums.TakeTicketType;
import  org.jeecg.modules.tiangong.entity.enums.OptionsType;
import  org.jeecg.modules.tiangong.entity.enums.VoucherType;

import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import  org.jeecg.modules.tiangong.entity.enums.ValidDateType;

import net.sf.jsqlparser.statement.ExplainStatement.OptionType;



@Data
@TableName("biz_entering_park_rule")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EnteringParkRule", description="入园规则")


public class EnteringParkRule {

    public TakeTicketType takeTicketType;
    
    public OptionsType optionsType;

    public VoucherType voucherType;

    public  String voucherRemark;

    public String voucherIdentityRemark;

    public String enterTime;

    public String enterAddress;

    public String locationDescription;

    public String  remark;

    public String openHours;

    public String pickUpTicketTime;

    public String pickUpTicketAddress;

    public OptionType enterDateOption;

    public String validDateDescription;

    public ValidDateType validDateType;

    public String validPeriodDates;

    public String validSpecifyDate;

    public String validSpecifyStartDate;
}

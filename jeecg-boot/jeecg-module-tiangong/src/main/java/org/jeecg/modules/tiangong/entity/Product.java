package org.jeecg.modules.tiangong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import org.jeecg.common.aspect.annotation.Dict;
import org.jeecg.modules.tiangong.entity.enums.*;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 产品实体类
 */
@Data
@TableName("biz_product")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Product对象", description="产品信息")
public class Product implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @NotNull(message = "产品名称不能为空")
    @Size(min = 1, max = 200, message = "产品名称长度必须在1到200个字符之间")
    @Excel(name = "产品名称", width = 15)
    @ApiModelProperty(value = "产品名称", required = true)
    private String productName;

    @NotEmpty(message = "收费项目名称不能为空")
    @Excel(name = "收费项目名称", width = 15)
    @ApiModelProperty(value = "收费项目名称", required = true)
    private String spuName;

    // @Excel(name = "外部类目ID", width = 15)
    // @ApiModelProperty(value = "外部类目ID")
    // private String categoryId;

    // @Excel(name = "外部类目名", width = 15)
    // @ApiModelProperty(value = "外部类目名")
    // private String categoryName;

    // @Excel(name = "当前语言", width = 15)
    // @ApiModelProperty(value = "当前语言")
    // private String dataLanguage;

    // @Excel(name = "费用包含的出行人数量", width = 15)
    // @ApiModelProperty(value = "费用包含的出行人数量")
    // private CostIncludeTravellerInfo costIncludeTravellerInfo;

    
    // @Excel(name = "预约类型", width = 15)
    // @ApiModelProperty(value = "预约类型")
    // @Dict(dicCode = "reservation_type")
    // private ReservationType reservationType;

    @NotEmpty(message = "票种名称不能为空")
    @Excel(name = "票种名称", width = 15)
    @ApiModelProperty(value = "票种名称", required = true)
    private String ticketKindName;

    @Excel(name = "票种ID", width = 15)
    @ApiModelProperty(value = "票种ID")
    private String ticketKindId;

    @Excel(name = "场次名称", width = 15)
    @ApiModelProperty(value = "场次名称")
    private String sessionName;

    @Excel(name = "区域名称", width = 15)
    @ApiModelProperty(value = "区域名称")
    private String regionName;

    @Excel(name = "是否实名制", width = 15)
    @ApiModelProperty(value = "是否实名制")
    @Dict(dicCode = "real_name_type")
    private RealNameType realName;

    @NotNull(message = "门票分类不能为空")
    @Excel(name = "门票分类", width = 15)
    @ApiModelProperty(value = "门票分类", required = true)
    @Dict(dicCode = "ticket_category")
    private TicketCategory ticketCategory;

    // @NotNull(message = "出票类型不能为空")
    // @Excel(name = "出票类型", width = 15)
    // @ApiModelProperty(value = "出票类型", required = true)
    // @Dict(dicCode = "ticket_type")
    // private TicketType ticketType;

    @Excel(name = "库存类型", width = 15)
    @ApiModelProperty(value = "库存类型")
    @Dict(dicCode = "stock_type")
    private StockType stockType;

    // @Excel(name = "是否立即确认", width = 15)
    // @ApiModelProperty(value = "是否立即确认")
    // @Dict(dicCode = "options_type")
    // private OptionsType instantConfirm;

    // @Excel(name = "二次确认时长", width = 15)
    // @ApiModelProperty(value = "二次确认时长(分钟)")
    // private Integer instantConfirmMinute;

    // @Excel(name = "发送凭证时间类型", width = 15)
    // @ApiModelProperty(value = "发送凭证时间类型")
    // @Dict(dicCode = "time_type")
    // private VoucherTimeType voucherMinuteType;

    // @Excel(name = "二次确认时长类型", width = 15)
    // @ApiModelProperty(value = "二次确认时长类型")
    // @Dict(dicCode = "time_type")
    // private VoucherTimeType instantConfirmType;

    // @Excel(name = "发送凭证时间", width = 15)
    // @ApiModelProperty(value = "发送凭证时间(分钟)")
    // private Integer voucherMinute;

    // @Excel(name = "确认方式描述", width = 15)
    // @ApiModelProperty(value = "确认方式描述")
    // private String confirmDescription;

    @Excel(name = "注意事项", width = 15)
    @ApiModelProperty(value = "注意事项")
    private String note;

    // @Excel(name = "特殊信息", width = 15)
    // @ApiModelProperty(value = "特殊信息")
    // private String specialInfo;

    @Excel(name = "描述", width = 15)
    @ApiModelProperty(value = "描述")
    private String description;

    @Excel(name = "交通信息", width = 15)
    @ApiModelProperty(value = "交通信息")
    private String transport;

    // @Excel(name = "接送详情", width = 15)
    // @ApiModelProperty(value = "接送详情")
    // private String pickUpDescription;

    @NotNull(message = "费用包含不能为空")
    @Excel(name = "费用包含", width = 15)
    @ApiModelProperty(value = "费用包含", required = true)
    private String costInclude;

    @Excel(name = "费用不包含", width = 15)
    @ApiModelProperty(value = "费用不包含")
    private String costNotInclude;

    // @Min(value = -11, message = "时区必须大于等于-11")
    // @Max(value = 12, message = "时区必须小于等于12")
    // @Excel(name = "时区", width = 15)
    // @ApiModelProperty(value = "时区")
    // private Integer timeZone;

    @NotNull(message = "是否场次票不能为空")
    @Excel(name = "是否场次票", width = 15)
    @ApiModelProperty(value = "是否场次票", required = true)
    @Dict(dicCode = "options_type")
    private OptionsType isSessionTicket;

    @Excel(name = "是否零元票", width = 15)
    @ApiModelProperty(value = "是否零元票")
    @Dict(dicCode = "options_type")
    private OptionsType isZeroTicket;

    @Excel(name = "是否区间票", width = 15)
    @ApiModelProperty(value = "是否区间票")
    @Dict(dicCode = "options_type")
    private OptionsType isIntervalTicket;

    @NotNull(message = "是否区域票不能为空")
    @Excel(name = "是否区域票", width = 15)
    @ApiModelProperty(value = "是否区域票", required = true)
    @Dict(dicCode = "options_type")
    private OptionsType isAreaTicket;

    @Excel(name = "发票说明", width = 15)
    @ApiModelProperty(value = "发票说明")
    private String invoiceDescription;

    @Excel(name = "保险说明", width = 15)
    @ApiModelProperty(value = "保险说明")
    private String insuranceDescription;

    @Excel(name = "使用条件", width = 15)
    @ApiModelProperty(value = "使用条件")
    private String applicationCondition;

    // @Excel(name = "币种", width = 15)
    // @ApiModelProperty(value = "币种")
    // private String currency;

    @Excel(name = "扩展信息", width = 15)
    @ApiModelProperty(value = "扩展信息")
    private String extInfo;

    @Excel(name = "销售开始日期", width = 15)
    @ApiModelProperty(value = "销售开始日期 格式:yyyy-MM-dd")
    private String saleStartDate;

    @Excel(name = "销售开始时间", width = 15)
    @ApiModelProperty(value = "销售开始时间 格式:HH:mm:ss")
    private String saleStartTime;

    @Excel(name = "销售结束日期", width = 15)
    @ApiModelProperty(value = "销售结束日期 格式:yyyy-MM-dd")
    private String saleEndDate;

    @Excel(name = "销售结束时间", width = 15)
    @ApiModelProperty(value = "销售结束时间 格式:HH:mm:ss")
    private String saleEndTime;

    @Excel(name = "星期几可售", width = 15)
    @ApiModelProperty(value = "星期几可售")
    private String saleWeekDay;

    // @Excel(name = "结算方式", width = 15)
    // @ApiModelProperty(value = "结算方式")
    // @Dict(dicCode = "settlement_type")
    // private SettlementType settlementType;

    @Excel(name = "上架开始时间", width = 20)
    @ApiModelProperty(value = "上架开始时间 格式:yyyy-MM-dd HH:mm:ss")
    private String onlineStartDate;

    @Excel(name = "上架结束时间", width = 20)
    @ApiModelProperty(value = "上架结束时间 格式:yyyy-MM-dd HH:mm:ss")
    private String onlineEndDate;

    // @Excel(name = "产品URL列表", width = 15)
    // @ApiModelProperty(value = "产品URL列表")
    // private List<String> productUrl;

    // @Excel(name = "是否有轮椅通道", width = 15)
    // @ApiModelProperty(value = "是否有轮椅通道")
    // @Dict(dicCode = "options_type")
    // private OptionsType wheelchairAccess;

    // @Excel(name = "是否包含免排队", width = 15)
    // @ApiModelProperty(value = "是否包含免排队")
    // @Dict(dicCode = "options_type")
    // private OptionsType skipLine;

    // @Excel(name = "亮点介绍", width = 15)
    // @ApiModelProperty(value = "亮点介绍")
    // private String highlights;

    @Excel(name = "区间名称", width = 15)
    @ApiModelProperty(value = "区间名称")
    private String intervalName;
}

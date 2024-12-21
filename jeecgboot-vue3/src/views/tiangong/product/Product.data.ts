import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '产品名称',
    align: "center",
    dataIndex: 'productName'
  },
  {
    title: '收费项目名称',
    align: "center",
    dataIndex: 'spuName'
  },
  {
    title: '外部类目ID',
    align: "center",
    dataIndex: 'categoryId'
  },
  {
    title: '外部类目名',
    align: "center",
    dataIndex: 'categoryName'
  },
  {
    title: '当前语言',
    align: "center",
    dataIndex: 'dataLanguage'
  },
  {
    title: '费用包含的出行人数量',
    align: "center",
    dataIndex: 'costIncludeTravellerInfo'
  },
  {
    title: '预约类型',
    align: "center",
    dataIndex: 'reservationType'
  },
  {
    title: '票种名称',
    align: "center",
    dataIndex: 'ticketKindName'
  },
  {
    title: '票种ID',
    align: "center",
    dataIndex: 'ticketKindId'
  },
  {
    title: '场次名称',
    align: "center",
    dataIndex: 'sessionName'
  },
  {
    title: '区域名称',
    align: "center",
    dataIndex: 'regionName'
  },
  {
    title: '是否实名制',
    align: "center",
    dataIndex: 'realName'
  },
  {
    title: '门票分类',
    align: "center",
    dataIndex: 'ticketCategory'
  },
  {
    title: '出票类型',
    align: "center",
    dataIndex: 'ticketType'
  },
  {
    title: '库存类型',
    align: "center",
    dataIndex: 'stockType'
  },
  {
    title: '是否立即确认',
    align: "center",
    dataIndex: 'instantConfirm'
  },
  {
    title: '二次确认时长(分钟)',
    align: "center",
    dataIndex: 'instantConfirmMinute'
  },
  {
    title: '发送凭证时间类型',
    align: "center",
    dataIndex: 'voucherMinuteType'
  },
  {
    title: '二次确认时长类型',
    align: "center",
    dataIndex: 'instantConfirmType'
  },
  {
    title: '发送凭证时间(分钟)',
    align: "center",
    dataIndex: 'voucherMinute'
  },
  {
    title: '确认方式描述',
    align: "center",
    dataIndex: 'confirmDescription'
  },
  {
    title: '注意事项',
    align: "center",
    dataIndex: 'note'
  },
  {
    title: '特殊信息',
    align: "center",
    dataIndex: 'specialInfo'
  },
  {
    title: '描述',
    align: "center",
    dataIndex: 'description'
  },
  {
    title: '交通信息',
    align: "center",
    dataIndex: 'transport'
  },
  {
    title: '接送详情',
    align: "center",
    dataIndex: 'pickUpDescription'
  },
  {
    title: '费用包含',
    align: "center",
    dataIndex: 'costInclude'
  },
  {
    title: '费用不包含',
    align: "center",
    dataIndex: 'costNotInclude'
  },
  {
    title: '时区',
    align: "center",
    dataIndex: 'timeZone'
  },
  {
    title: '是否场次票',
    align: "center",
    dataIndex: 'isSessionTicket'
  },
  {
    title: '是否零元票',
    align: "center",
    dataIndex: 'isZeroTicket'
  },
  {
    title: '是否区间票',
    align: "center",
    dataIndex: 'isIntervalTicket'
  },
  {
    title: '是否区域票',
    align: "center",
    dataIndex: 'isAreaTicket'
  },
  {
    title: '发票说明',
    align: "center",
    dataIndex: 'invoiceDescription'
  },
  {
    title: '保险说明',
    align: "center",
    dataIndex: 'insuranceDescription'
  },
  {
    title: '使用条件',
    align: "center",
    dataIndex: 'applicationCondition'
  },
  {
    title: '币种',
    align: "center",
    dataIndex: 'currency'
  },
  {
    title: '扩展信息',
    align: "center",
    dataIndex: 'extInfo'
  },
  {
    title: '销售开始日期 格式：yyyy-MM-dd',
    align: "center",
    dataIndex: 'saleStartDate'
  },
  {
    title: '销售开始时间 格式：HH:mm:ss',
    align: "center",
    dataIndex: 'saleStartTime'
  },
  {
    title: '销售结束日期 格式：yyyy-MM-dd',
    align: "center",
    dataIndex: 'saleEndDate'
  },
  {
    title: '销售结束时间 格式：HH:mm:ss',
    align: "center",
    dataIndex: 'saleEndTime'
  },
  {
    title: '星期几可售',
    align: "center",
    dataIndex: 'saleWeekDay'
  },
  {
    title: '结算方式',
    align: "center",
    dataIndex: 'settlementType'
  },
  {
    title: '上架开始时间 格式：yyyy-MM-dd HH:mm:ss',
    align: "center",
    dataIndex: 'onlineStartDate'
  },
  {
    title: '上架结束时间 格式：yyyy-MM-dd HH:mm:ss',
    align: "center",
    dataIndex: 'onlineEndDate'
  },
  {
    title: '产品URL列表',
    align: "center",
    dataIndex: 'productUrl'
  },
  {
    title: '是否有轮椅通道',
    align: "center",
    dataIndex: 'wheelchairAccess'
  },
  {
    title: '是否包含免排队',
    align: "center",
    dataIndex: 'skipLine'
  },
  {
    title: '亮点介绍',
    align: "center",
    dataIndex: 'highlights'
  },
  {
    title: '区间名称',
    align: "center",
    dataIndex: 'intervalName'
  },
];

// 高级查询数据
export const superQuerySchema = {
  productName: {title: '产品名称',order: 0,view: 'text', type: 'string',},
  spuName: {title: '收费项目名称',order: 1,view: 'text', type: 'string',},
  categoryId: {title: '外部类目ID',order: 2,view: 'text', type: 'string',},
  categoryName: {title: '外部类目名',order: 3,view: 'text', type: 'string',},
  dataLanguage: {title: '当前语言',order: 4,view: 'text', type: 'string',},
  costIncludeTravellerInfo: {title: '费用包含的出行人数量',order: 5,view: 'text', type: 'string',},
  reservationType: {title: '预约类型',order: 6,view: 'text', type: 'string',},
  ticketKindName: {title: '票种名称',order: 7,view: 'text', type: 'string',},
  ticketKindId: {title: '票种ID',order: 8,view: 'text', type: 'string',},
  sessionName: {title: '场次名称',order: 9,view: 'text', type: 'string',},
  regionName: {title: '区域名称',order: 10,view: 'text', type: 'string',},
  realName: {title: '是否实名制',order: 11,view: 'text', type: 'string',},
  ticketCategory: {title: '门票分类',order: 12,view: 'text', type: 'string',},
  ticketType: {title: '出票类型',order: 13,view: 'text', type: 'string',},
  stockType: {title: '库存类型',order: 14,view: 'text', type: 'string',},
  instantConfirm: {title: '是否立即确认',order: 15,view: 'text', type: 'string',},
  instantConfirmMinute: {title: '二次确认时长(分钟)',order: 16,view: 'number', type: 'number',},
  voucherMinuteType: {title: '发送凭证时间类型',order: 17,view: 'text', type: 'string',},
  instantConfirmType: {title: '二次确认时长类型',order: 18,view: 'text', type: 'string',},
  voucherMinute: {title: '发送凭证时间(分钟)',order: 19,view: 'number', type: 'number',},
  confirmDescription: {title: '确认方式描述',order: 20,view: 'textarea', type: 'string',},
  note: {title: '注意事项',order: 21,view: 'textarea', type: 'string',},
  specialInfo: {title: '特殊信息',order: 22,view: 'textarea', type: 'string',},
  description: {title: '描述',order: 23,view: 'textarea', type: 'string',},
  transport: {title: '交通信息',order: 24,view: 'textarea', type: 'string',},
  pickUpDescription: {title: '接送详情',order: 25,view: 'textarea', type: 'string',},
  costInclude: {title: '费用包含',order: 26,view: 'textarea', type: 'string',},
  costNotInclude: {title: '费用不包含',order: 27,view: 'textarea', type: 'string',},
  timeZone: {title: '时区',order: 28,view: 'number', type: 'number',},
  isSessionTicket: {title: '是否场次票',order: 29,view: 'text', type: 'string',},
  isZeroTicket: {title: '是否零元票',order: 30,view: 'text', type: 'string',},
  isIntervalTicket: {title: '是否区间票',order: 31,view: 'text', type: 'string',},
  isAreaTicket: {title: '是否区域票',order: 32,view: 'text', type: 'string',},
  invoiceDescription: {title: '发票说明',order: 33,view: 'textarea', type: 'string',},
  insuranceDescription: {title: '保险说明',order: 34,view: 'textarea', type: 'string',},
  applicationCondition: {title: '使用条件',order: 35,view: 'textarea', type: 'string',},
  currency: {title: '币种',order: 36,view: 'text', type: 'string',},
  extInfo: {title: '扩展信息',order: 37,view: 'textarea', type: 'string',},
  saleStartDate: {title: '销售开始日期 格式：yyyy-MM-dd',order: 38,view: 'text', type: 'string',},
  saleStartTime: {title: '销售开始时间 格式：HH:mm:ss',order: 39,view: 'text', type: 'string',},
  saleEndDate: {title: '销售结束日期 格式：yyyy-MM-dd',order: 40,view: 'text', type: 'string',},
  saleEndTime: {title: '销售结束时间 格式：HH:mm:ss',order: 41,view: 'text', type: 'string',},
  saleWeekDay: {title: '星期几可售',order: 42,view: 'text', type: 'string',},
  settlementType: {title: '结算方式',order: 43,view: 'text', type: 'string',},
  onlineStartDate: {title: '上架开始时间 格式：yyyy-MM-dd HH:mm:ss',order: 44,view: 'text', type: 'string',},
  onlineEndDate: {title: '上架结束时间 格式：yyyy-MM-dd HH:mm:ss',order: 45,view: 'text', type: 'string',},
  productUrl: {title: '产品URL列表',order: 46,view: 'text', type: 'string',},
  wheelchairAccess: {title: '是否有轮椅通道',order: 47,view: 'text', type: 'string',},
  skipLine: {title: '是否包含免排队',order: 48,view: 'text', type: 'string',},
  highlights: {title: '亮点介绍',order: 49,view: 'textarea', type: 'string',},
  intervalName: {title: '区间名称',order: 50,view: 'text', type: 'string',},
};

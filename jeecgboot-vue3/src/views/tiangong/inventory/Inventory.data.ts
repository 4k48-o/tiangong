import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '库存名称',
    align:"center",
    dataIndex: 'name'
  },
  {
    title: '库存编号',
    align:"center",
    dataIndex: 'inventorySn'
  },
  {
    title: '库存总量',
    align:"center",
    dataIndex: 'totalCapacity'
  },
  {
    title: '库存类型',
    align:"center",
    dataIndex: 'inventoryType'
  },
  {
    title: '生成频率',
    align:"center",
    dataIndex: 'inventoryGenerationDays'
  },
  {
    title: '开始日期',
    align:"center",
    dataIndex: 'startDate'
  },
  {
    title: '结束日期',
    align:"center",
    dataIndex: 'endDate'
  },
];

//子表列表数据
export const bizInventoryItemColumns: BasicColumn[] = [
  {
    title: '库存id',
    align:"center",
    dataIndex: 'inventoryId'
  },
  {
    title: '时段名称',
    align:"center",
    dataIndex: 'timeSlotName'
  },
  {
    title: '时段别名',
    align:"center",
    dataIndex: 'timeSlotAlias'
  },
  {
    title: '时段编号',
    align:"center",
    dataIndex: 'timeSlotSn'
  },
  {
    title: '时段排序',
    align:"center",
    dataIndex: 'timeSlotSort'
  },
  {
    title: '时段开始时间',
    align:"center",
    dataIndex: 'startTime'
  },
  {
    title: '时段结束时间',
    align:"center",
    dataIndex: 'endTime'
  },
  {
    title: '库存数量',
    align:"center",
    dataIndex: 'quantity'
  },
];

// 高级查询数据
export const superQuerySchema = {
  name: {title: '库存名称',order: 0,view: 'text', type: 'string',},
  inventorySn: {title: '库存编号',order: 1,view: 'text', type: 'string',},
  totalCapacity: {title: '库存总量',order: 2,view: 'number', type: 'number',},
  inventoryType: {title: '库存类型',order: 3,view: 'text', type: 'string',},
  inventoryGenerationDays: {title: '生成频率',order: 4,view: 'number', type: 'number',},
  startDate: {title: '开始日期',order: 5,view: 'text', type: 'string',},
  endDate: {title: '结束日期',order: 6,view: 'text', type: 'string',},
};

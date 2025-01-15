import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '库存组名称',
    align: "center",
    dataIndex: 'groupName'
  },
  {
    title: '库存组别名',
    align: "center",
    dataIndex: 'groupAlias'
  },
  {
    title: '库存',
    align: "center",
    dataIndex: 'inventoryId_dictText'
  },
];

// 高级查询数据
export const superQuerySchema = {
  groupName: {title: '库存组名称',order: 0,view: 'text', type: 'string',},
  groupAlias: {title: '库存组别名',order: 1,view: 'text', type: 'string',},
  inventoryId: {title: '库存',order: 2,view: 'list_multi', type: 'string',dictTable: "biz_inventory", dictCode: 'id', dictText: 'name',},
};

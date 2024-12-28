import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '规则名称',
    align: "center",
    dataIndex: 'name'
  },
  {
    title: '规则编号',
    align: "center",
    dataIndex: 'sn'
  },
];

// 高级查询数据
export const superQuerySchema = {
  name: {title: '规则名称',order: 0,view: 'text', type: 'string',},
  sn: {title: '规则编号',order: 1,view: 'text', type: 'string',},
};

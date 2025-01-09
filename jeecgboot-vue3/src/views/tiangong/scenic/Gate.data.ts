import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '门区名称',
    align: "center",
    dataIndex: 'gateName'
  },
  {
    title: '门区类型',
    align: "center",
    dataIndex: 'gateType_dictText'
  },
  {
    title: '门区描述',
    align: "center",
    dataIndex: 'gateDesc'
  },
  {
    title: '隶属景点',
    align: "center",
    dataIndex: 'scenicAreaId_dictText'
  },
];

// 高级查询数据
export const superQuerySchema = {
  gateName: {title: '门区名称',order: 0,view: 'text', type: 'string',},
  gateType: {title: '门区类型',order: 1,view: 'list', type: 'string',dictCode: '',},
  gateDesc: {title: '门区描述',order: 2,view: 'textarea', type: 'string',},
  scenicAreaId: {title: '隶属景点',order: 3,view: 'list', type: 'string',dictTable: "biz_scenic_area", dictCode: 'id', dictText: 'name',},
};

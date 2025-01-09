import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '景区名称',
    align: "center",
    dataIndex: 'name'
  },
  {
    title: '景区类型',
    align: "center",
    dataIndex: 'typeId_dictText'
  },
  {
    title: '激活状态',
    align: "center",
    dataIndex: 'status',
    customRender:({text}) => {
       return  render.renderSwitch(text, [{text:'是',value:'Y'},{text:'否',value:'N'}]);
     },
  },
];

// 高级查询数据
export const superQuerySchema = {
  name: {title: '景区名称',order: 0,view: 'text', type: 'string',},
  typeId: {title: '景区类型',order: 1,view: 'list', type: 'string',dictCode: 'scenic_area_type',},
  status: {title: '激活状态',order: 2,view: 'switch', type: 'string',},
};

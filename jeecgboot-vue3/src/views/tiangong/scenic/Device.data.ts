import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '设备名称',
    align: "center",
    dataIndex: 'name'
  },
  {
    title: '设备编号',
    align: "center",
    dataIndex: 'deviceSn'
  },
  {
    title: '设备ip地址',
    align: "center",
    dataIndex: 'ip'
  },
  {
    title: '门区',
    align: "center",
    dataIndex: 'gateId_dictText'
  },
  {
    title: '景区ID',
    align: "center",
    dataIndex: 'scenicAreaId'
  },
  {
    title: '是否在线',
    align: "center",
    dataIndex: 'online',
    customRender:({text}) => {
       return  render.renderSwitch(text, [{text:'是',value:'Y'},{text:'否',value:'N'}]);
     },
  },
  {
    title: '设备类型',
    align: "center",
    dataIndex: 'deviceType_dictText'
  },
  {
    title: '备注',
    align: "center",
    dataIndex: 'remark'
  },
];

// 高级查询数据
export const superQuerySchema = {
  name: {title: '设备名称',order: 0,view: 'text', type: 'string',},
  deviceSn: {title: '设备编号',order: 1,view: 'text', type: 'string',},
  ip: {title: '设备ip地址',order: 2,view: 'text', type: 'string',},
  gateId: {title: '门区',order: 3,view: 'list', type: 'string',dictTable: "biz_gate", dictCode: 'id', dictText: 'gate_name',},
  scenicAreaId: {title: '景区ID',order: 4,view: 'text', type: 'string',},
  online: {title: '是否在线',order: 5,view: 'switch', type: 'string',},
  deviceType: {title: '设备类型',order: 6,view: 'list', type: 'string',dictCode: 'device_type',},
  remark: {title: '备注',order: 7,view: 'text', type: 'string',},
};

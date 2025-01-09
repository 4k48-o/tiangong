import {defHttp} from '/@/utils/http/axios';
import { useMessage } from "/@/hooks/web/useMessage";

const { createConfirm } = useMessage();

enum Api {
  list = '/tiangong/inventory/list',
  save= '/tiangong/inventory/add',
  edit= '/tiangong/inventory/edit',
  deleteOne = '/tiangong/inventory/delete',
  deleteBatch = '/tiangong/inventory/deleteBatch',
  importExcel = '/tiangong/inventory/importExcel',
  exportXls = '/tiangong/inventory/exportXls',
  bizInventoryItemList = '/tiangong/inventory/listBizInventoryItemByMainId',
  bizInventoryItemSave= '/tiangong/inventory/addBizInventoryItem',
  bizInventoryItemEdit= '/tiangong/inventory/editBizInventoryItem',
  bizInventoryItemDelete = '/tiangong/inventory/deleteBizInventoryItem',
  bizInventoryItemDeleteBatch = '/tiangong/inventory/deleteBatchBizInventoryItem',
}
/**
 * 导出api
 * @param params
 */
export const getExportUrl = Api.exportXls;

/**
 * 导入api
 */
export const getImportUrl = Api.importExcel;

/**
 * 列表接口
 * @param params
 */
export const list = (params) =>
  defHttp.get({ url: Api.list, params });

/**
 * 删除单个
 */
export const deleteOne = (params,handleSuccess) => {
  return defHttp.delete({ url: Api.deleteOne, params }, { joinParamsToUrl: true }).then(() => {
    handleSuccess();
  });
}

/**
 * 批量删除
 * @param params
 */
export const batchDelete = (params, handleSuccess) => {
  createConfirm({
    iconType: 'warning',
    title: '确认删除',
    content: '是否删除选中数据',
    okText: '确认',
    cancelText: '取消',
    onOk: () => {
      return defHttp.delete({ url: Api.deleteBatch, data: params }, { joinParamsToUrl: true }).then(() => {
        handleSuccess();
      });
    }
  });
}

/**
 * 保存或者更新
 * @param params
 */
export const saveOrUpdate = (params, isUpdate) => {
  let url = isUpdate ? Api.edit : Api.save;
  return defHttp.post({ url: url, params },{ isTransformResponse: false });
}
  
/**
 * 列表接口
 * @param params
 */
export const bizInventoryItemList = (params) => {
  if(params['inventoryId']){
    return defHttp.get({ url: Api.bizInventoryItemList, params });
  }
  return Promise.resolve({});
}

/**
 * 删除单个
 */
export const bizInventoryItemDelete = (params,handleSuccess) => {
  return defHttp.delete({ url: Api.bizInventoryItemDelete, params }, { joinParamsToUrl: true }).then(() => {
    handleSuccess();
  });
}

/**
 * 批量删除
 * @param params
 */
export const bizInventoryItemDeleteBatch = (params, handleSuccess) => {
  createConfirm({
    iconType: 'warning',
    title: '确认删除',
    content: '是否删除选中数据',
    okText: '确认',
    cancelText: '取消',
    onOk: () => {
      return defHttp.delete({ url: Api.bizInventoryItemDeleteBatch, data: params }, { joinParamsToUrl: true }).then(() => {
        handleSuccess();
      });
    }
  });
}

/**
 * 保存或者更新
 * @param params
 */
export const  bizInventoryItemSaveOrUpdate = (params, isUpdate) => {
  let url = isUpdate ? Api.bizInventoryItemEdit : Api.bizInventoryItemSave;
  return defHttp.post({ url: url, params },{ isTransformResponse: false });
}

/**
 * 导入
 */
export const bizInventoryItemImportUrl = '/tiangong/inventory/importBizInventoryItem'

/**
 * 导出
 */
export const bizInventoryItemExportXlsUrl = '/tiangong/inventory/exportBizInventoryItem'

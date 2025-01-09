<template>
  <a-spin :spinning="confirmLoading">
    <JFormContainer :disabled="disabled">
      <template #detail>
        <a-form class="antd-modal-form" v-bind="formItemLayout" ref="formRef" name="BizInventoryItemForm">
          <a-row>
						<a-col :span="24">
							<a-form-item label="库存id" v-bind="validateInfos.inventoryId" id="BizInventoryItem-inventoryId" name="inventoryId">
								<a-input v-model:value="formData.inventoryId" placeholder="请输入库存id"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="时段名称" v-bind="validateInfos.timeSlotName" id="BizInventoryItem-timeSlotName" name="timeSlotName">
								<a-input v-model:value="formData.timeSlotName" placeholder="请输入时段名称"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="时段别名" v-bind="validateInfos.timeSlotAlias" id="BizInventoryItem-timeSlotAlias" name="timeSlotAlias">
								<a-input v-model:value="formData.timeSlotAlias" placeholder="请输入时段别名"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="时段编号" v-bind="validateInfos.timeSlotSn" id="BizInventoryItem-timeSlotSn" name="timeSlotSn">
								<a-input v-model:value="formData.timeSlotSn" placeholder="请输入时段编号"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="时段排序" v-bind="validateInfos.timeSlotSort" id="BizInventoryItem-timeSlotSort" name="timeSlotSort">
								<a-input-number v-model:value="formData.timeSlotSort" placeholder="请输入时段排序" style="width: 100%" />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="时段开始时间" v-bind="validateInfos.startTime" id="BizInventoryItem-startTime" name="startTime">
								<time-picker placeholder="请选择时段开始时间" value-format="HH:mm:ss"  v-model:value="formData.startTime" style="width: 100%"  allow-clear />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="时段结束时间" v-bind="validateInfos.endTime" id="BizInventoryItem-endTime" name="endTime">
								<time-picker placeholder="请选择时段结束时间" value-format="HH:mm:ss"  v-model:value="formData.endTime" style="width: 100%"  allow-clear />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="库存数量" v-bind="validateInfos.quantity" id="BizInventoryItem-quantity" name="quantity">
								<a-input-number v-model:value="formData.quantity" placeholder="请输入库存数量" style="width: 100%" />
							</a-form-item>
						</a-col>
          </a-row>
        </a-form>
      </template>
    </JFormContainer>
  </a-spin>
</template>

<script lang="ts" setup>
  import { ref, reactive, defineExpose, nextTick, onMounted, inject, defineProps, unref } from 'vue';
  import { defHttp } from '/@/utils/http/axios';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { TimePicker } from 'ant-design-vue';
  import { getValueType } from '/@/utils';
  import { bizInventoryItemSaveOrUpdate } from '../Inventory.api';
  import { Form } from 'ant-design-vue';
  import JFormContainer from '/@/components/Form/src/container/JFormContainer.vue';

  //接收主表id
  const mainId = inject('mainId');
  const formRef = ref();
  const useForm = Form.useForm;
  const emit = defineEmits(['register', 'ok']);
  const formData = reactive<Record<string, any>>({
    id: '',
        inventoryId: '',   
        timeSlotName: '',   
        timeSlotAlias: '',   
        timeSlotSn: '',   
        timeSlotSort: undefined,
        startTime: '',   
        endTime: '',   
        quantity: undefined,
  });
  const { createMessage } = useMessage();
  const labelCol = ref<any>({ xs: { span: 24 }, sm: { span: 5 } });
  const wrapperCol = ref<any>({ xs: { span: 24 }, sm: { span: 16 } });
  const confirmLoading = ref<boolean>(false);
  //表单验证
  const validatorRules = {
    inventoryId: [{ required: true, message: '请输入库存id!'},],
    timeSlotName: [{ required: true, message: '请输入时段名称!'},],
    timeSlotAlias: [{ required: true, message: '请输入时段别名!'},],
    timeSlotSn: [{ required: true, message: '请输入时段编号!'},],
    timeSlotSort: [{ required: true, message: '请输入时段排序!'},],
    startTime: [{ required: true, message: '请输入时段开始时间!'},],
    endTime: [{ required: true, message: '请输入时段结束时间!'},],
    quantity: [{ required: true, message: '请输入库存数量!'},],
  };
  const { resetFields, validate, validateInfos } = useForm(formData, validatorRules, { immediate: false });
  const props = defineProps({
    disabled: { type: Boolean, default: false },
  });
  const formItemLayout = {
    labelCol: { xs: { span: 24 }, sm: { span: 5 } },
    wrapperCol: { xs: { span: 24 }, sm: { span: 16 } },
  };
  
  /**
   * 新增
   */
  function add() {
    edit({});
  }

  /**
   * 编辑
   */
  function edit(record) {
    nextTick(() => {
      resetFields();
      const tmpData = {};
      Object.keys(formData).forEach((key) => {
        if(record.hasOwnProperty(key)){
          tmpData[key] = record[key]
        }
      })
      //赋值
      Object.assign(formData,tmpData);
    });
  }

  /**
   * 提交数据
   */
  async function submitForm() {
    // 触发表单验证
    try {
      // 触发表单验证
      await validate();
    } catch ({ errorFields }) {
      if (errorFields) {
        const firstField = errorFields[0];
        if (firstField) {
          formRef.value.scrollToField(firstField.name, { behavior: 'smooth', block: 'center' });
        }
      }
      return Promise.reject(errorFields);
    }
    confirmLoading.value = true;
    const isUpdate = ref<boolean>(false);
    //时间格式化
    let model = formData;
    if (model.id) {
      isUpdate.value = true;
    }
   
    //循环数据
    for (let data in model) {
      //如果该数据是数组并且是字符串类型
      if (model[data] instanceof Array) {
        let valueType = getValueType(formRef.value.getProps, data);
        //如果是字符串类型的需要变成以逗号分割的字符串
        if (valueType === 'string') {
          model[data] = model[data].join(',');
        }
      }
    }
    if (unref(mainId)) {
      model['inventoryId'] = unref(mainId);
    }
    await bizInventoryItemSaveOrUpdate(model, isUpdate.value)
      .then((res) => {
        if (res.success) {
          createMessage.success(res.message);
          emit('ok');
        } else {
          createMessage.warning(res.message);
        }
      })
      .finally(() => {
        confirmLoading.value = false;
      });
  }


  defineExpose({
    add,
    edit,
    submitForm,
  });
</script>

<style lang="less" scoped>
  .antd-modal-form {
    padding: 14px;
  }
</style>

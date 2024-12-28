<template>
  <a-spin :spinning="confirmLoading">
    <JFormContainer :disabled="disabled">
      <template #detail>
        <a-form ref="formRef" class="antd-modal-form" :labelCol="labelCol" :wrapperCol="wrapperCol" name="AdvanceBookingRuleForm">
          <a-row>
						<a-col :span="24">
							<a-form-item label="规则名称" v-bind="validateInfos.name" id="AdvanceBookingRuleForm-name" name="name">
								<a-input v-model:value="formData.name" placeholder="请输入规则名称"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="规则编号" v-bind="validateInfos.sn" id="AdvanceBookingRuleForm-sn" name="sn">
								<a-input v-model:value="formData.sn" placeholder="请输入规则编号"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="截止预定时间相较出行日的提前天数" v-bind="validateInfos.advanceBookingDays" id="AdvanceBookingRuleForm-advanceBookingDays" name="advanceBookingDays">
								<a-input-number v-model:value="formData.advanceBookingDays" placeholder="请输入截止预定时间相较出行日的提前天数" style="width: 100%" />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="截止预定时间的时刻" v-bind="validateInfos.advanceBookingTime" id="AdvanceBookingRuleForm-advanceBookingTime" name="advanceBookingTime">
								<time-picker placeholder="请选择截止预定时间的时刻" value-format="HH:mm:ss"  v-model:value="formData.advanceBookingTime" style="width: 100%"  allow-clear />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="截止预定时间相较场次时间的类型" v-bind="validateInfos.sessionTimeType" id="AdvanceBookingRuleForm-sessionTimeType" name="sessionTimeType">
								<j-dict-select-tag v-model:value="formData.sessionTimeType" dictCode="session_time_type" placeholder="请选择截止预定时间相较场次时间的类型"  allow-clear />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="截止预定时间相较场次时间的偏移值" v-bind="validateInfos.abmSessionOffset" id="AdvanceBookingRuleForm-abmSessionOffset" name="abmSessionOffset">
								<a-input-number v-model:value="formData.abmSessionOffset" placeholder="请输入截止预定时间相较场次时间的偏移值" style="width: 100%" />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="最早可购买时间相较出行日的提前天数" v-bind="validateInfos.earliestBookingDays" id="AdvanceBookingRuleForm-earliestBookingDays" name="earliestBookingDays">
								<a-input-number v-model:value="formData.earliestBookingDays" placeholder="请输入最早可购买时间相较出行日的提前天数" style="width: 100%" />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="最早可购买时间的时刻" v-bind="validateInfos.earliestBookingTime" id="AdvanceBookingRuleForm-earliestBookingTime" name="earliestBookingTime">
								<a-input v-model:value="formData.earliestBookingTime" placeholder="请输入最早可购买时间的时刻"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="下单后多少小时可用" v-bind="validateInfos.passLimitHours" id="AdvanceBookingRuleForm-passLimitHours" name="passLimitHours">
								<a-input-number v-model:value="formData.passLimitHours" placeholder="请输入下单后多少小时可用" style="width: 100%" />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="下单后多少分钟可用" v-bind="validateInfos.passLimitMinutes" id="AdvanceBookingRuleForm-passLimitMinutes" name="passLimitMinutes">
								<a-input-number v-model:value="formData.passLimitMinutes" placeholder="请输入下单后多少分钟可用" style="width: 100%" />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="预定说明" v-bind="validateInfos.description" id="AdvanceBookingRuleForm-description" name="description">
								<a-textarea v-model:value="formData.description" :rows="4" placeholder="请输入预定说明" />
							</a-form-item>
						</a-col>
          </a-row>
        </a-form>
      </template>
    </JFormContainer>
  </a-spin>
</template>

<script lang="ts" setup>
  import { ref, reactive, defineExpose, nextTick, defineProps, computed, onMounted } from 'vue';
  import { defHttp } from '/@/utils/http/axios';
  import { useMessage } from '/@/hooks/web/useMessage';
  import JDictSelectTag from '/@/components/Form/src/jeecg/components/JDictSelectTag.vue';
  import { TimePicker } from 'ant-design-vue';
  import { getValueType } from '/@/utils';
  import { saveOrUpdate } from '../AdvanceBookingRule.api';
  import { Form } from 'ant-design-vue';
  import JFormContainer from '/@/components/Form/src/container/JFormContainer.vue';
  const props = defineProps({
    formDisabled: { type: Boolean, default: false },
    formData: { type: Object, default: () => ({})},
    formBpm: { type: Boolean, default: true }
  });
  const formRef = ref();
  const useForm = Form.useForm;
  const emit = defineEmits(['register', 'ok']);
  const formData = reactive<Record<string, any>>({
    id: '',
    name: '',   
    sn: '',   
    advanceBookingDays: undefined,
    advanceBookingTime: '',   
    sessionTimeType: '',   
    abmSessionOffset: undefined,
    earliestBookingDays: undefined,
    earliestBookingTime: '',   
    passLimitHours: undefined,
    passLimitMinutes: undefined,
    description: '',   
  });
  const { createMessage } = useMessage();
  const labelCol = ref<any>({ xs: { span: 24 }, sm: { span: 5 } });
  const wrapperCol = ref<any>({ xs: { span: 24 }, sm: { span: 16 } });
  const confirmLoading = ref<boolean>(false);
  //表单验证
  const validatorRules = reactive({
    name: [{ required: true, message: '请输入规则名称!'},],
    sn: [{ required: true, message: '请输入规则编号!'},],
    advanceBookingDays: [{ required: true, message: '请输入截止预定时间相较出行日的提前天数!'},],
    advanceBookingTime: [{ required: true, message: '请输入截止预定时间的时刻!'},],
    sessionTimeType: [{ required: true, message: '请输入截止预定时间相较场次时间的类型!'},],
    earliestBookingDays: [{ required: true, message: '请输入最早可购买时间相较出行日的提前天数!'},],
    earliestBookingTime: [{ required: true, message: '请输入最早可购买时间的时刻!'},],
  });
  const { resetFields, validate, validateInfos } = useForm(formData, validatorRules, { immediate: false });

  // 表单禁用
  const disabled = computed(()=>{
    if(props.formBpm === true){
      if(props.formData.disabled === false){
        return false;
      }else{
        return true;
      }
    }
    return props.formDisabled;
  });

  
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
      Object.assign(formData, tmpData);
    });
  }

  /**
   * 提交数据
   */
  async function submitForm() {
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
    await saveOrUpdate(model, isUpdate.value)
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

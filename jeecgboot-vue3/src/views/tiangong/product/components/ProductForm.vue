<template>
  <a-spin :spinning="confirmLoading">
    <JFormContainer :disabled="disabled">
      <template #detail>
        <a-form ref="formRef" class="antd-modal-form" :labelCol="labelCol" :wrapperCol="wrapperCol" name="ProductForm">
          <a-divider>必填信息</a-divider>
          <a-row>
            <a-col :span="24">
              <a-form-item label="产品名称" v-bind="validateInfos.productName" id="ProductForm-productName" name="productName">
                <a-input v-model:value="formData.productName" placeholder="请输入产品名称" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>

            <a-col :span="24">
              <a-form-item label="票种名称" v-bind="validateInfos.ticketKindName" id="ProductForm-ticketKindName" name="ticketKindName">
                <a-input v-model:value="formData.ticketKindName" placeholder="请输入票种名称" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>
            
            <a-col :span="24">
              <a-form-item label="门票分类" v-bind="validateInfos.ticketCategory" id="ProductForm-ticketCategory" name="ticketCategory">
                <j-dict-select-tag
                  v-model:value="formData.ticketCategory"
                  placeholder="请选择门票分类"
                  dictCode="ticket_category"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="是否场次票" v-bind="validateInfos.isSessionTicket" id="ProductForm-isSessionTicket" name="isSessionTicket">
                <j-dict-select-tag
                  v-model:value="formData.isSessionTicket"
                  placeholder="请选择是否场次票"
                  dictCode="options_type"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="是否区域票" v-bind="validateInfos.isAreaTicket" id="ProductForm-isAreaTicket" name="isAreaTicket">

                <j-dict-select-tag
                  v-model:value="formData.isAreaTicket"
                  placeholder="请输入是否区域票"
                  dictCode="options_type"
                  style="width: 100%"
                />

              </a-form-item>
            </a-col>
            
            <a-col :span="24">
              <a-form-item label="是否实名制" v-bind="validateInfos.realName" id="ProductForm-realName" name="realName" required>
                <j-dict-select-tag
                  v-model:value="formData.realName"
                  placeholder="请选择是否实名制"
                  dictCode="real_name_type"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="库存类型" v-bind="validateInfos.stockType" id="ProductForm-stockType" name="stockType" required>
                <j-dict-select-tag
                  v-model:value="formData.stockType"
                  placeholder="请选择库存类型"
                  dictCode="stock_type"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
       
             
            <a-col :span="24">
              <a-form-item label="是否零元票" v-bind="validateInfos.isZeroTicket" id="ProductForm-isZeroTicket" name="isZeroTicket" required>
                <j-dict-select-tag
                  v-model:value="formData.isZeroTicket"
                  placeholder="请选择是否零元票"
                  dictCode="options_type"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="是否区间票" v-bind="validateInfos.isIntervalTicket" id="ProductForm-isIntervalTicket" name="isIntervalTicket" required>
                <j-dict-select-tag
                  v-model:value="formData.isIntervalTicket"
                  placeholder="请选择是否区间票"
                  dictCode="options_type"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            
          </a-row>

          <a-divider>选填信息</a-divider>
          <a-row>
            <a-col :span="24">
              <a-form-item label="票种ID" v-bind="validateInfos.ticketKindId" id="ProductForm-ticketKindId" name="ticketKindId">
                <a-input v-model:value="formData.ticketKindId" placeholder="请输入票种ID" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="场次名称" v-bind="validateInfos.sessionName" id="ProductForm-sessionName" name="sessionName">
                <a-input v-model:value="formData.sessionName" placeholder="请输入场次名称" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>


            <a-col :span="24">
              <a-form-item label="区域名称" v-bind="validateInfos.regionName" id="ProductForm-regionName" name="regionName">
                <a-input v-model:value="formData.regionName" placeholder="请输入区域名称" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>
            
            <a-col :span="24">
              <a-form-item label="区间名称" v-bind="validateInfos.intervalName" id="ProductForm-intervalName" name="intervalName">
                <a-input v-model:value="formData.intervalName" placeholder="请输入区间名称" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>
            
            <a-col :span="24">
              <a-form-item label="描述" v-bind="validateInfos.description" id="ProductForm-description" name="description">
                <a-textarea v-model:value="formData.description" :rows="4" placeholder="请输入描述" style="width: 100%"></a-textarea>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="交通信息" v-bind="validateInfos.transport" id="ProductForm-transport" name="transport">
                <a-textarea v-model:value="formData.transport" :rows="4" placeholder="请输入交通信息" style="width: 100%"></a-textarea>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="接送详情" v-bind="validateInfos.pickUpDescription" id="ProductForm-pickUpDescription" name="pickUpDescription">
                <a-textarea v-model:value="formData.pickUpDescription" :rows="4" placeholder="请输入接送详情" style="width: 100%"></a-textarea>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="费用不包含" v-bind="validateInfos.costNotInclude" id="ProductForm-costNotInclude" name="costNotInclude">
                <a-textarea v-model:value="formData.costNotInclude" :rows="4" placeholder="请输入费用不包含" style="width: 100%"></a-textarea>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="销售开始日期" v-bind="validateInfos.saleStartDate" id="ProductForm-saleStartDate" name="saleStartDate">
                <a-date-picker
                  v-model:value="formData.saleStartDate"
                  placeholder="请选择销售开始日期"
                  format="YYYY-MM-DD"
                  valueFormat="YYYY-MM-DD"
                  :allowClear="true"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="销售开始时间" v-bind="validateInfos.saleStartTime" id="ProductForm-saleStartTime" name="saleStartTime">
                <a-time-picker
                  v-model:value="formData.saleStartTime"
                  placeholder="请选择销售开始时间"
                  format="HH:mm:ss"
                  valueFormat="HH:mm:ss"
                  :allowClear="true"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="销售结束日期" v-bind="validateInfos.saleEndDate" id="ProductForm-saleEndDate" name="saleEndDate">
                <a-date-picker
                  v-model:value="formData.saleEndDate"
                  placeholder="请选择销售结束日期"
                  format="YYYY-MM-DD"
                  valueFormat="YYYY-MM-DD"
                  :allowClear="true"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="销售结束时间" v-bind="validateInfos.saleEndTime" id="ProductForm-saleEndTime" name="saleEndTime">
                <a-time-picker
                  v-model:value="formData.saleEndTime"
                  placeholder="请选择销售结束时间"
                  format="HH:mm:ss"
                  valueFormat="HH:mm:ss"
                  :allowClear="true"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="星期几可售" v-bind="validateInfos.saleWeekDay" id="ProductForm-saleWeekDay" name="saleWeekDay">
                
                <j-select-multiple type="list_multi" v-model:value="formData.saleWeekDay" dictCode="week" placeholder="请选择星期几可售"  :triggerChange="false"/>

              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="上架开始时间" v-bind="validateInfos.onlineStartDate" id="ProductForm-onlineStartDate" name="onlineStartDate">
                <a-date-picker
                  v-model:value="formData.onlineStartDate"
                  placeholder="请选择上架开始时间"
                  format="YYYY-MM-DD HH:mm:ss"
                  valueFormat="YYYY-MM-DD HH:mm:ss"
                  :allowClear="true"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="上架结束时间" v-bind="validateInfos.onlineEndDate" id="ProductForm-onlineEndDate" name="onlineEndDate">
                <a-date-picker
                  v-model:value="formData.onlineEndDate"
                  placeholder="请选择上架结束时间"
                  format="YYYY-MM-DD HH:mm:ss"
                  valueFormat="YYYY-MM-DD HH:mm:ss"
                  :allowClear="true"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            
            
          </a-row>
        </a-form>
      </template>
    </JFormContainer>
  </a-spin>
</template>

<script lang="ts" setup>
  import { ref, reactive, defineExpose, nextTick, defineProps, computed, onMounted, watch } from 'vue';
  import { defHttp } from '/@/utils/http/axios';
  import { useMessage } from '/@/hooks/web/useMessage';
  import { getValueType } from '/@/utils';
  import { saveOrUpdate } from '../Product.api';
  import { Form } from 'ant-design-vue';
  import JDictSelectTag from '/@/components/Form/src/jeecg/components/JDictSelectTag.vue';
  import JSelectMultiple from '/@/components/Form/src/jeecg/components/JSelectMultiple.vue';
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
    productName: '',   
    ticketCategory: '',   
    isSessionTicket: '',   
    isAreaTicket: '',   
    reservationType: '',   
    realName: '',   
    stockType: '',   
    voucherMinuteType: '',   
    instantConfirmType: '',   
    isZeroTicket: '',   
    isIntervalTicket: '',   
    settlementType: '',   
    ticketKindId: '',   
    sessionName: '',   
    regionName: '',   
    description: '',   
    transport: '',   
    pickUpDescription: '',   
    costNotInclude: '',   
    saleStartDate: '',   
    saleStartTime: '',   
    saleEndDate: '',   
    saleEndTime: '',   
    saleWeekDay: '',   
    onlineStartDate: '',   
    onlineEndDate: '',   
    productUrl: '',   
    wheelchairAccess: '',   
    skipLine: '',   
    highlights: '',   
    intervalName: '',   
  });
  const { createMessage } = useMessage();
  const labelCol = ref<any>({ xs: { span: 24 }, sm: { span: 5 } });
  const wrapperCol = ref<any>({ xs: { span: 24 }, sm: { span: 16 } });
  const confirmLoading = ref<boolean>(false);
  //表单验证
  const validatorRules = reactive({
    productName: [{ required: true, message: '请输入产品名称!'},],
    ticketKindName: [{ required: true, message: '请输入票种名称!'},],
    ticketCategory: [{ required: true, message: '请输入门票分类!'},],
    isSessionTicket: [{ required: true, message: '请输入是否场次票!'},],
    isAreaTicket: [{ required: true, message: '请输入是否区域票!'},],
    realName: [{ required: true, message: '请输入是否实名制!'},],
    stockType: [{ required: true, message: '请输入库存类型!'},],
    isZeroTicket: [{ required: true, message: '请输入是否零元票!'},],
    isIntervalTicket: [{ required: true, message: '请输入是否区间票'},],
    sessionName: [], // 初始为空数组，将通过watch动态更新
    regionName: [], // 初始为空数组，将通过watch动态更新
    intervalName: [], // 初始为空数组，将通过watch动态更新
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

  // 监听isSessionTicket的变化
  watch(() => formData.isSessionTicket, (newVal) => {
    if (newVal === 'YES') { 
      validatorRules.sessionName = [{ required: true, message: '场次票必须输入场次名称!'}];
    } else {
      validatorRules.sessionName = [];
    }
    // 触发表单重新验证
    nextTick(() => {
      validate();
    });
  }, { immediate: true }); 

  // 监听isAreaTicket的变化
  watch(() => formData.isAreaTicket, (newVal) => {
    if (newVal === 'YES') { 
      validatorRules.regionName = [{ required: true, message: '区域票必须输入区域名称!'}];
    } else {
      validatorRules.regionName = [];
    }
    // 触发表单重新验证
    nextTick(() => {
      validate();
    });
  }, { immediate: true });

  // 监听isIntervalTicket的变化
  watch(() => formData.isIntervalTicket, (newVal) => {
    if (newVal === 'YES') { 
      validatorRules.intervalName = [{ required: true, message: '区间票必须输入区间名称!'}];
    } else {
      validatorRules.intervalName = [];
    }
    // 触发表单重新验证
    nextTick(() => {
      validate();
    });
  }, { immediate: true });

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

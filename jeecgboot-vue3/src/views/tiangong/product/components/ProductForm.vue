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
              <a-form-item label="收费项目名称" v-bind="validateInfos.spuName" id="ProductForm-spuName" name="spuName">
                <a-input v-model:value="formData.spuName" placeholder="请输入收费项目名称" allow-clear style="width: 100%"></a-input>
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
              <a-form-item label="出票类型" v-bind="validateInfos.ticketType" id="ProductForm-ticketType" name="ticketType">
                <j-dict-select-tag
                  v-model:value="formData.ticketType"
                  placeholder="请选择出票类型"
                  dictCode="ticket_type"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="费用包含" v-bind="validateInfos.costInclude" id="ProductForm-costInclude" name="costInclude">
                <a-textarea v-model:value="formData.costInclude" :rows="4" placeholder="请输入费用包含" style="width: 100%"></a-textarea>
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
                <a-input v-model:value="formData.isAreaTicket" placeholder="请输入是否区域票" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>
          </a-row>

          <a-divider>选填信息</a-divider>
          <a-row>
            <a-col :span="24">
              <a-form-item label="外部类目ID" v-bind="validateInfos.categoryId" id="ProductForm-categoryId" name="categoryId">
                <a-input v-model:value="formData.categoryId" placeholder="请输入外部类目ID" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="外部类目名" v-bind="validateInfos.categoryName" id="ProductForm-categoryName" name="categoryName">
                <a-input v-model:value="formData.categoryName" placeholder="请输入外部类目名" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="当前语言" v-bind="validateInfos.dataLanguage" id="ProductForm-dataLanguage" name="dataLanguage">
                <a-input v-model:value="formData.dataLanguage" placeholder="请输入当前语言" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="费用包含的出行人数量" v-bind="validateInfos.costIncludeTravellerInfo" id="ProductForm-costIncludeTravellerInfo" name="costIncludeTravellerInfo">
                <a-input v-model:value="formData.costIncludeTravellerInfo" placeholder="请输入费用包含的出行人数量" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="预约类型" v-bind="validateInfos.reservationType" id="ProductForm-reservationType" name="reservationType">
                <j-dict-select-tag
                  v-model:value="formData.reservationType"
                  placeholder="请选择预约类型"
                  dictCode="reservation_type"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
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
              <a-form-item label="是否实名制" v-bind="validateInfos.realName" id="ProductForm-realName" name="realName">
                <j-dict-select-tag
                  v-model:value="formData.realName"
                  placeholder="请选择是否实名制"
                  dictCode="real_name_type"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="库存类型" v-bind="validateInfos.stockType" id="ProductForm-stockType" name="stockType">
                <JDictSelectTag
                  v-model:value="formData.stockType"
                  placeholder="请选择库存类型"
                  dictCode="stock_type"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="是否立即确认" v-bind="validateInfos.instantConfirm" id="ProductForm-instantConfirm" name="instantConfirm">
                <a-input v-model:value="formData.instantConfirm" placeholder="请输入是否立即确认" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="二次确认时长(分钟)" v-bind="validateInfos.instantConfirmMinute" id="ProductForm-instantConfirmMinute" name="instantConfirmMinute">
                <a-input-number v-model:value="formData.instantConfirmMinute" placeholder="请输入二次确认时长(分钟)" style="width: 100%"></a-input-number>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="发送凭证时间类型" v-bind="validateInfos.voucherMinuteType" id="ProductForm-voucherMinuteType" name="voucherMinuteType">
                <j-dict-select-tag
                  v-model:value="formData.voucherMinuteType"
                  placeholder="请选择发送凭证时间类型"
                  dictCode="time_type"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="二次确认时长类型" v-bind="validateInfos.instantConfirmType" id="ProductForm-instantConfirmType" name="instantConfirmType">
                <j-dict-select-tag
                  v-model:value="formData.instantConfirmType"
                  placeholder="请选择二次确认时长类型"
                  dictCode="time_type"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="发送凭证时间(分钟)" v-bind="validateInfos.voucherMinute" id="ProductForm-voucherMinute" name="voucherMinute">
                <a-input-number v-model:value="formData.voucherMinute" placeholder="请输入发送凭证时间(分钟)" style="width: 100%"></a-input-number>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="确认方式描述" v-bind="validateInfos.confirmDescription" id="ProductForm-confirmDescription" name="confirmDescription">
                <a-textarea v-model:value="formData.confirmDescription" :rows="4" placeholder="请输入确认方式描述" style="width: 100%"></a-textarea>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="注意事项" v-bind="validateInfos.note" id="ProductForm-note" name="note">
                <a-textarea v-model:value="formData.note" :rows="4" placeholder="请输入注意事项" style="width: 100%"></a-textarea>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="特殊信息" v-bind="validateInfos.specialInfo" id="ProductForm-specialInfo" name="specialInfo">
                <a-textarea v-model:value="formData.specialInfo" :rows="4" placeholder="请输入特殊信息" style="width: 100%"></a-textarea>
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
              <a-form-item label="时区" v-bind="validateInfos.timeZone" id="ProductForm-timeZone" name="timeZone">
                <a-input-number v-model:value="formData.timeZone" placeholder="请输入时区" style="width: 100%"></a-input-number>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="是否零元票" v-bind="validateInfos.isZeroTicket" id="ProductForm-isZeroTicket" name="isZeroTicket">
                <j-dict-select-tag
                  v-model:value="formData.isZeroTicket"
                  placeholder="请选择是否零元票"
                  dictCode="options_type"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="是否区间票" v-bind="validateInfos.isIntervalTicket" id="ProductForm-isIntervalTicket" name="isIntervalTicket">
                <j-dict-select-tag
                  v-model:value="formData.isIntervalTicket"
                  placeholder="请选择是否区间票"
                  dictCode="options_type"
                  style="width: 100%"
                />
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="发票说明" v-bind="validateInfos.invoiceDescription" id="ProductForm-invoiceDescription" name="invoiceDescription">
                <a-textarea v-model:value="formData.invoiceDescription" :rows="4" placeholder="请输入发票说明" style="width: 100%"></a-textarea>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="保险说明" v-bind="validateInfos.insuranceDescription" id="ProductForm-insuranceDescription" name="insuranceDescription">
                <a-textarea v-model:value="formData.insuranceDescription" :rows="4" placeholder="请输入保险说明" style="width: 100%"></a-textarea>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="使用条件" v-bind="validateInfos.applicationCondition" id="ProductForm-applicationCondition" name="applicationCondition">
                <a-textarea v-model:value="formData.applicationCondition" :rows="4" placeholder="请输入使用条件" style="width: 100%"></a-textarea>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="币种" v-bind="validateInfos.currency" id="ProductForm-currency" name="currency">
                <a-input v-model:value="formData.currency" placeholder="请输入币种" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="扩展信息" v-bind="validateInfos.extInfo" id="ProductForm-extInfo" name="extInfo">
                <a-textarea v-model:value="formData.extInfo" :rows="4" placeholder="请输入扩展信息" style="width: 100%"></a-textarea>
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
                <a-input v-model:value="formData.saleWeekDay" placeholder="请输入星期几可售" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="结算方式" v-bind="validateInfos.settlementType" id="ProductForm-settlementType" name="settlementType">
                <j-dict-select-tag
                  v-model:value="formData.settlementType"
                  placeholder="请选择结算方式"
                  dictCode="settlement_type"
                  style="width: 100%"
                />
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
            <a-col :span="24">
              <a-form-item label="产品URL列表" v-bind="validateInfos.productUrl" id="ProductForm-productUrl" name="productUrl">
                <a-input v-model:value="formData.productUrl" placeholder="请输入产品URL列表" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="是否有轮椅通道" v-bind="validateInfos.wheelchairAccess" id="ProductForm-wheelchairAccess" name="wheelchairAccess">
                <a-input v-model:value="formData.wheelchairAccess" placeholder="请输入是否有轮椅通道" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="是否包含免排队" v-bind="validateInfos.skipLine" id="ProductForm-skipLine" name="skipLine">
                <a-input v-model:value="formData.skipLine" placeholder="请输入是否包含免排队" allow-clear style="width: 100%"></a-input>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="亮点介绍" v-bind="validateInfos.highlights" id="ProductForm-highlights" name="highlights">
                <a-textarea v-model:value="formData.highlights" :rows="4" placeholder="请输入亮点介绍" style="width: 100%"></a-textarea>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-form-item label="区间名称" v-bind="validateInfos.intervalName" id="ProductForm-intervalName" name="intervalName">
                <a-input v-model:value="formData.intervalName" placeholder="请输入区间名称" allow-clear style="width: 100%"></a-input>
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
  import { getValueType } from '/@/utils';
  import { saveOrUpdate } from '../Product.api';
  import { Form } from 'ant-design-vue';
  import JDictSelectTag from '/@/components/Form/src/jeecg/components/JDictSelectTag.vue';
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
    spuName: '',   
    categoryId: '',   
    categoryName: '',   
    dataLanguage: '',   
    costIncludeTravellerInfo: '',   
    reservationType: '',   
    ticketKindName: '',   
    ticketKindId: '',   
    sessionName: '',   
    regionName: '',   
    realName: '',   
    ticketCategory: '',   
    ticketType: '',   
    stockType: '',   
    instantConfirm: '',   
    instantConfirmMinute: undefined,
    voucherMinuteType: '',   
    instantConfirmType: '',   
    voucherMinute: undefined,
    confirmDescription: '',   
    note: '',   
    specialInfo: '',   
    description: '',   
    transport: '',   
    pickUpDescription: '',   
    costInclude: '',   
    costNotInclude: '',   
    timeZone: undefined,
    isSessionTicket: '',   
    isZeroTicket: '',   
    isIntervalTicket: '',   
    isAreaTicket: '',   
    invoiceDescription: '',   
    insuranceDescription: '',   
    applicationCondition: '',   
    currency: '',   
    extInfo: '',   
    saleStartDate: '',   
    saleStartTime: '',   
    saleEndDate: '',   
    saleEndTime: '',   
    saleWeekDay: '',   
    settlementType: '',   
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
    spuName: [{ required: true, message: '请输入收费项目名称!'},],
    ticketKindName: [{ required: true, message: '请输入票种名称!'},],
    ticketCategory: [{ required: true, message: '请输入门票分类!'},],
    ticketType: [{ required: true, message: '请输入出票类型!'},],
    costInclude: [{ required: true, message: '请输入费用包含!'},],
    isSessionTicket: [{ required: true, message: '请输入是否场次票!'},],
    isAreaTicket: [{ required: true, message: '请输入是否区域票!'},],
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

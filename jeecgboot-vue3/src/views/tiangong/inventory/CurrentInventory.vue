<template>
 <div class="p-2">
    <div>2025年01月10日11:12:09 实时库存</div>
    <a-calendar 
      :fullscreen="yes" 
      @panelChange="onPanelChange"
    >
      <template #dateCellRender="{ current }">
        <div style="padding: 0 10px;">
          <div v-for="item in this.getInventoryForDate(current)" :key=item.time_slot_sn >
            <div><span style="font-size: small;font-weight: bold;">{{item.time_slot_name}}</span></div>
            <a-progress :percent=" item.current_quantity / item.quantity * 100" />
          </div>
        </div>
      </template>
    </a-calendar>
 </div>
</template>
  
<script>
import { Calendar } from 'ant-design-vue'

export default {
  components: {
    'a-calendar': Calendar
  },
  data() {
    return {
      inventoryData: {
        // Example inventory data for future dates
        '2025-01-10': [
            {time_slot_name:"AM 08:00~12:00",time_slot_alias:"",time_slot_sn:"",quantity:500,current_quantity:300},
            {time_slot_name:"PM 12:00~17:00",time_slot_alias:"",time_slot_sn:"",quantity:500,current_quantity:270}
        ],
        '2025-01-11': [
        {time_slot_name:"AM 08:00~12:00",time_slot_alias:"",time_slot_sn:"",quantity:500,current_quantity:110},
        {time_slot_name:"PM 12:00~17:00",time_slot_alias:"",time_slot_sn:"",quantity:500,current_quantity:320}
        ],
        '2025-01-12': [
        {time_slot_name:"AM 08:00~12:00",time_slot_alias:"",time_slot_sn:"",quantity:500,current_quantity:320},
        {time_slot_name:"PM 12:00~17:00",time_slot_alias:"",time_slot_sn:"",quantity:500,current_quantity:330}
        ],
        '2025-01-13': [
        {time_slot_name:"AM 08:00~12:00",time_slot_alias:"",time_slot_sn:"",quantity:500,current_quantity:415},
        {time_slot_name:"PM 12:00~17:00",time_slot_alias:"",time_slot_sn:"",quantity:500,current_quantity:214}
        ],
        '2025-01-14': [ {time_slot_name:"AM 08:00~12:00",time_slot_alias:"",time_slot_sn:"",quantity:500,current_quantity:10},
        {time_slot_name:"PM 12:00~17:00",time_slot_alias:"",time_slot_sn:"",quantity:500,current_quantity:10}],
        '2025-01-15': [ {time_slot_name:"AM 08:00~12:00",time_slot_alias:"",time_slot_sn:"",quantity:500,current_quantity:10},
        {time_slot_name:"PM 12:00~17:00",time_slot_alias:"",time_slot_sn:"",quantity:500,current_quantity:10}],
        '2025-01-16': [ {time_slot_name:"AM 08:00~12:00",time_slot_alias:"",time_slot_sn:"",quantity:500,current_quantity:10},
        {time_slot_name:"PM 12:00~17:00",time_slot_alias:"",time_slot_sn:"",quantity:500,current_quantity:10}],
        '2025-01-17': [ {time_slot_name:"AM 08:00~12:00",time_slot_alias:"",time_slot_sn:"",quantity:500,current_quantity:10},
            {time_slot_name:"PM 12:00~17:00",time_slot_alias:"",time_slot_sn:"",quantity:500,current_quantity:10}]
      }
    }
  },
  methods: {
    getInventoryForDate(date) {
      // Convert date to formatted string
      const formattedDate = date.format('YYYY-MM-DD')
      return this.inventoryData[formattedDate] || ''
    },
    onPanelChange(value, mode) {
      console.log(value, mode)
    }
  }
}
</script>
  
 <style>
.ant-picker-calendar-full .ant-picker-panel .ant-picker-calendar-date-content{
    height: 120px;
}
</style>
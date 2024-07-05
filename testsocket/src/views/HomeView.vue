<template>
  <div class="home">
 
    <van-tabs v-model:active="activeName">
      <van-tab title="运行状态" name="a">
        <OperationaStatusView></OperationaStatusView>
      </van-tab>
      <van-tab title="实时监测" name="b">
        <MonitorinIntervals></MonitorinIntervals>
        <TempView></TempView>
        <HumiView></HumiView>
      </van-tab>
      <van-tab title="设备详情" name="c">
        <DeviceDetailView></DeviceDetailView>
      </van-tab>
    </van-tabs>
 
  </div>
</template>
<script setup>
import MonitorinIntervals from '@/components/MonitorinIntervals.vue'; 
import TempView from './TempView.vue';
import HumiView from './HumiView.vue';
import OperationaStatusView from './OperationaStatusView.vue';
import DeviceDetailView from './DeviceDetailView.vue';
import {ref} from 'vue'
const activeName = ref('a');
 
</script>

<style scoped>
.about {
  font-size: 24px;
  color: brown;
}
</style>
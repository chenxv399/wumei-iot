<template>
    <div id="context">
        <div class="ecarddiv">
          <CardDeviceOnline></CardDeviceOnline>
        </div>
        <div class="ecarddiv">
            <el-card style="max-width: 100%;font-size: 1rem;">
                <template #header>
                    <div class="card-header">
                        <i class="fa fa-th-large"></i>
                        <span style="margin-left: 10px;">监测数据</span>
                    </div>
                </template>
                <GauGe></GauGe>
            </el-card>
        </div>
    </div>
</template>
<script setup>
import GauGe from '@/components/GauGe.vue'
import CardDeviceOnline from '@/components/CardDeviceOnline.vue'
</script>
<style scoped>
#context {
    display: flex;
    flex-direction: column;
}

.ecarddiv {
    width: 100vw;
}
</style>
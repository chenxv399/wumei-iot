<template>
    <div>
        <van-nav-bar title="示例设备" left-text="返回" left-arrow @click-left="onClickLeft" />
 
        <TabBar></TabBar>
    </div>
</template>
<script setup> 
import TabBar from '@/components/TabBar.vue';   


const onClickLeft = () => history.back();
</script>
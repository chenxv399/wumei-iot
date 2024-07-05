<template>
    <div>
        <van-tabs v-model:active="active" type="card">
            <van-tab title="全部">
                <DisplaDeviceCard></DisplaDeviceCard>
            </van-tab>
            <van-tab title="卧室">内容 2</van-tab>
            <van-tab title="厨房">内容 3</van-tab>
            <van-tab title="书房">内容 2</van-tab>
            <van-tab title="卫生间">内容 3</van-tab>
        </van-tabs>
    </div>
</template>
<script setup>
import { ref } from 'vue'; 
import DisplaDeviceCard from '@/components/DisplaDeviceCard.vue'
const active = ref(0);
</script> 
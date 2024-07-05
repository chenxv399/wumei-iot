<template>
    <div>
        <router-view/>
        <van-tabbar v-model="active">
            <van-tabbar-item name="home" icon="setting-o" @click="toIndex" >设备</van-tabbar-item>
            <van-tabbar-item name="search" icon="search">定时</van-tabbar-item>
            <van-tabbar-item name="friends" icon="friends-o" @click="toLogs">日志</van-tabbar-item>
            <van-tabbar-item name="setting" icon="setting-o">统计</van-tabbar-item>
        </van-tabbar>
    </div>
</template>
<script setup>
import {ref} from 'vue' 
import { useRouter } from "vue-router";
const router = useRouter(); 

const toIndex = () => { 
   router.push('/index/home')
};
const toLogs = () => { 
   router.push('/index/logs')
};
const active = ref('home');
</script>
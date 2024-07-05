<template>
    <div class="login">
        <van-form @submit="onSubmit">
    <van-cell-group inset>
        <van-field
        v-model="username"
        name="用户名"
        label="用户名"
        placeholder="用户名"
        :rules="[{ required: true, message: '请填写用户名' }]"
        />
        <van-field
        v-model="password"
        type="password"
        name="密码"
        label="密码"
        placeholder="密码"
        :rules="[{ required: true, message: '请填写密码' }]"
        />
    </van-cell-group>
    <div style="margin: 16px;">
    <van-button round block type="primary" native-type="submit">
      提交
    </van-button>
  </div>
</van-form>   
</div>
</template>
<script setup>
import { ref } from 'vue';
import { useRouter } from "vue-router";
const router = useRouter(); 
const username = ref('');
const password = ref('');
const onSubmit = (values) => {
   console.log('submit', values);
   router.push('/index')
};
</script>
<style scoped>
.login{
    margin-top: 100px;
}
</style>
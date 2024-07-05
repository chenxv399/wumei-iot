<template>
    <div class="context"> 
        <div class="logs" v-for="(item,index) in arr" :key="index">
            <div>
                <span>运行挡位：</span>
                <span>中高速挡位</span>
            </div>
            <div style="margin-top: 1rem;display: flex;justify-content: space-between;">
                <div style="line-height: 25px;padding-right: 1vw;">
                    <van-button size="small" plain hairline type="primary">功能调节</van-button>
                </div>
                <div style="line-height: 50px;padding-right: 1vw;">
                    <van-icon name="notes" />
                    <span>{{ logsTime }}</span>
                </div> 
            </div>
        </div>
    </div>
</template>
<script setup>
import {ref} from "vue"
let arr = ref([1,2,3,4,5,6])
function getCustomFormattedDateTime() {
  var now = new Date();
  var year = now.getFullYear();
  var month = now.getMonth() + 1; // 月份是从0开始的
  var day = now.getDate();
  var hours = now.getHours();
  var minutes = now.getMinutes();
  var seconds = now.getSeconds();

  // 格式化月份、日期、小时、分钟和秒数，确保它们是两位数
  month = month < 10 ? '0' + month : month;
  day = day < 10 ? '0' + day : day;
  hours = hours < 10 ? '0' + hours : hours;
  minutes = minutes < 10 ? '0' + minutes : minutes;
  seconds = seconds < 10 ? '0' + seconds : seconds;

  // 组合成自定义格式的日期时间字符串
  return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
}
let logsTime = getCustomFormattedDateTime()
</script>
<style scoped>
.context{
    display: flex;
    flex-direction: column;
    background-color: #fbfbfb;
}
.logs{
    width: 90%;
    margin: 3vw auto;
    border: 1px solid #f0ebff;
    box-shadow: 6px 6px 10px -7px gray;
    height: 10vh;
    border-radius: 20px;
    display: flex;
    flex-direction: column;
    padding: 2vw;
    font-size: 1rem;
    color: rgb(112, 112, 112);
    background-color: #ffffff;
}
</style>
<template>
    <div>
        <div class="context">
                    <div class="cards" v-for="(item,index) in arr" :key="index">
                        <div class="cardTitle"> 
                            示例设备
                        </div>
                        <div class="cardContext">
                            <div>
                                <i class="fa fa-wifi"></i>
                                <span style="margin-left: 5px;">11.9°C</span>
                            </div>
                            <div>
                                <i class="fa fa-circle-o-notch"></i>
                                <span style="margin-left: 5px;">11.9%</span>
                            </div> 
                        </div>

                        <div class="cardContext">
                            <div>
                                <i class="fa fa-thermometer-0"></i>
                                <span style="margin-left: 5px;">11.9°C</span>
                            </div>
                            <div>
                                <i class="fa fa-thermometer-half"></i>
                                <span style="margin-left: 5px;">11.9%</span>
                            </div> 
                        </div>

                        <div class="cardContext" >
                            <div> 
                                <span>设备开关</span> 
                            </div>
                            <div>
                                <van-switch v-model="checked" size="15px"/> 
                            </div> 
                        </div>
                        <div class="cardContext">
                            <div> 
                                <span>运行挡位</span> 
                            </div>
                            <div>
                                <el-select placeholder="Select" style="width: 15vw;">
                                    <el-option key="0" label="低级" value="1" />
                                    <el-option key="1" label="中级" value="2" />
                                    <el-option key="2" label="高级" value="3" />
                                </el-select> 
                            </div> 
                        </div>
                    </div>  
                </div>
    </div>
</template>
<script setup>
import { ref } from 'vue'; 
const checked = ref(true);
const arr = ref([1,2,3,4,5,6])
</script>
<style scoped>
.context{
     display: flex;
     flex-wrap: wrap;
     justify-content: space-around; 
     font-size: 0.5rem; 
}
.cards{
    width: 40vw; 
    box-shadow: 6px 6px 10px -7px gray;
    border-radius: 10px;
    border: 1px solid gainsboro;
    margin-top: 20px; 
}
.cardTitle{
    line-height: 35px; 
    border-top-right-radius: 10px; 
    border-top-left-radius: 10px;
    height: 35px;
    background-color: #79bbff;
    color: aliceblue; 
    font-size: 1rem;
    padding-left:5px;
}
.cardContext{
    padding: 10px;
    display: flex;
    justify-content: space-around;
}
</style>
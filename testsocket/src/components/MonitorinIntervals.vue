<template>
    <div style="display: flex;flex-direction: column;padding-left: 10px;">
      <p style="color: aquamarine;font-size: 12px;"> 监测间隔(ms) 和 次数:</p>
      <div style="display: flex;justify-content: space-between;">
        <el-input style="width: 25vw;" placeholder="时间间隔" />
        <el-input style="width: 15vw;margin-left: 10px;" placeholder="次数" />
        <el-button type="warning" style="width: 20vw;margin-right: 5px;margin-left: 10px;">停止</el-button>
        <el-button type="success" style="width: 20vw;margin-right: 5px;">检测</el-button>
      </div> 
    </div>
</template>
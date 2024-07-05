<template>
  <div id="context">
      <div class="ecarddiv">
          <el-card style="max-width: 100%; ">
              <template #header>
                  <div class="card-header">
                      <i class="fa fa-th-large"></i>
                      <span style="margin-left: 10px;">设备在线</span>
                  </div>
              </template>
              <div style="display: flex;justify-content:space-between;">
                  <div>
                      <i class="fa fa-toggle-up"></i>
                      <span style="margin-left: 10px;">设备升级</span>
                  </div>
                  <span style="margin-left: 10px;">Version 1</span>
                  <el-button type="success">检查更新</el-button>
              </div>
              <div style="display: flex;justify-content:space-between;">
                  <div>
                      <i class="fa fa-power-off"></i>
                      <span style="margin-left: 10px;">设备开关</span>
                  </div>
                  <el-switch />
              </div>
              <div style="display: flex;justify-content:space-between;">
                  <div>
                      <i class="fa fa-reorder"></i>
                      <span style="margin-left: 10px;">运行挡位</span>
                  </div>
                  <el-select placeholder="Select" style="width: 225px">
                      <el-option key="0" label="低级" value="1" />
                      <el-option key="1" label="中级" value="2" />
                      <el-option key="2" label="高级" value="3" />
                  </el-select>
              </div>
              <div style="display: flex;justify-content:space-between;margin-top: 10px;">
                  <div>
                      <i class="fa fa-envelope-o"></i>
                      <span style="margin-left: 10px;">屏显消息</span>
                  </div>
                  <div style="border: 1px solid #dcdfe6; width: 225px;height: 30px;">
                      <input type="text" style="width: 145px; height: 25px;border: none;margin-right: 19px;">
                      <el-button type="primary" size="small">发送</el-button>
                  </div>
              </div>
              <div style="display: flex;justify-content:space-between;margin-top: 10px;">
                  <div>
                      <i class="fa fa-envelope-o"></i>
                      <span style="margin-left: 10px;">灯光颜色</span>
                  </div>
                  <div style="border: 1px solid #dcdfe6; width: 225px;height: 30px;">
                      <input type="text" style="width: 145px; height: 25px;border: none;margin-right: 19px;">
                      <el-button type="primary" size="small">发送</el-button>
                  </div>
              </div>
              <div style="display: flex;justify-content:space-between;margin-top: 10px;">
                  <div>
                      <i class="fa fa-envelope-o"></i>
                      <span style="margin-left: 10px;">上报监测</span>
                  </div>
                  <div style="border: 1px solid #dcdfe6; width: 225px;height: 30px;">
                      <input type="text" style="width: 145px; height: 23px;border: none;margin-right: 19px;">
                      <el-button type="primary" size="small">发送</el-button>
                  </div>
              </div>
          </el-card>
      </div> 
  </div>
</template>
<style scoped>
#context {
  display: flex;
  flex-direction: column;
}

.ecarddiv {
  width: 100vw; 
  font-size: 1rem;
}
</style>
<template>
  <div> 
    <div ref="chartRef" style="width: 100vw; height: 400px;"></div>
  </div>
</template>

<script setup>
  import { ref, onMounted } from 'vue'
  import * as echarts from 'echarts'
  // 用来记录后端返回数据的数组
  let getMsg = ref([])
  // 图表显示位置
  const chartRef = ref(null);  
  // echarts实例
  let chartInstance = null;
  // 创建WebSocket实例
  let websocket = new WebSocket("ws://localhost:8080/channel/echo?clientId=" + 10);

  const initChart = () => {
  if (chartRef.value) {
    chartInstance = echarts.init(chartRef.value);
    const option = {
      title: {
        text: '实时温度数据'
      },
      tooltip: {},
      xAxis: {
        type: 'category',
        data: [], // 时间戳
        boundaryGap: false, // 不留边界间隙
      },
      yAxis: {
        type: 'value',
        name: '温度'
      },
      series: [{
        data: [], // 温度数据
        type: 'line'
      }],
      // 添加dataZoom组件，实现滚动条
      dataZoom: [
        {
          type: 'slider', // 滑动条
          show: true,
          start: 0, // 初始位置
          end: 100, // 初始结束位置，可以根据需要调整
        },
        {
          type: 'inside', // 内置滑块，可选
          start: 0,
          end: 100,
        },
      ],
    };
    chartInstance.setOption(option);
  }
};

// 处理数据并更新图表，同时保持X轴数据长度恒定以实现滚动效果
const processDataAndUpdateChart = (dataStr) => {
  try {
    const data = JSON.parse(dataStr);
    if (data.time && data.temp) {
      // 限制X轴数据长度，例如只保留最近100个数据点
      const MAX_DATA_POINTS = 100;
      const timeData = chartInstance.getOption().xAxis[0].data;
      timeData.push(data.time);
      if (timeData.length > MAX_DATA_POINTS) {
        timeData.shift(); // 移除最老的数据点
      }

      const tempData = chartInstance.getOption().series[0].data;
      tempData.push(data.temp);
      if (tempData.length > MAX_DATA_POINTS) {
        tempData.shift(); // 移除最老的温度数据
      }

      chartInstance.setOption({
        xAxis: { data: timeData },
        series: [{ data: tempData }]
      });
      // 自动调整数据窗口，始终保持最新的数据可见
      chartInstance.dispatchAction({
        type: 'dataZoom',
        start: Math.max(0, timeData.length - MAX_DATA_POINTS) / timeData.length * 100,
        end: 100
      });
      chartInstance.resize();
    }
  } catch (error) {
    console.error('Error processing data:', error);
  }
};

  // 连接断开
  websocket.onclose = e => {
    console.log(`连接关闭: code=${e.code}, reason=${e.reason}`)
  }
  // 收到消息
  websocket.onmessage = e => {
    console.log(`收到消息：${e.data}`); 
    // 更新getMsg数组，用于列表展示
    getMsg.value.push(e.data); // 为了展示方便，这里仍转回字符串形式
    processDataAndUpdateChart(e.data);
  };
  // 异常
  websocket.onerror = e => {
    console.log("连接异常")
    console.error(e)
  }

  // 连接打开
  websocket.onopen = e => {
    console.log("连接打开", e);

    // 创建连接后，往服务器没隔一秒连续写入1条消息 
    setInterval(sentData, 2000);

    function sentData() {
      websocket.send("hello")
    }
    // 最后发送 bye，由服务器断开连接
    // websocket.send("bye");

    // 也可以由客户端主动断开
    // websocket.close();
  }

  onMounted(() => {
    initChart();
  });
</script>
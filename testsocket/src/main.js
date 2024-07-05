import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'  
import Vant from 'vant'; 
// 2. 引入组件样式
import 'vant/lib/index.css';
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import 'font-awesome/css/font-awesome.min.css'
createApp(App).use(ElementPlus).use(Vant).use(store).use(router).mount('#app')

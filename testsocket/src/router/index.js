import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import IndexView from '../views/IndexView.vue'
import LogsView from '../views/LogsView.vue'

const routes = [
  {
    path: '/',
    name: 'login',
    component: LoginView
  },
  {
    path: '/index',
    name: 'index',
    redirect:'/index/home'//默认页直接重定向到你要显示的默认页
  },
  {
    path: '/index/',
    name: 'IndexView',
    component: IndexView,
    children:[
        {
          path: 'home',//默认显示页路径
          name: 'home',
          component: HomeView, 
        } ,
        {
          path: 'logs',//默认显示页路径
          name: 'logs',
          component: LogsView, 
        } 
    ]
  } 
]


const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router

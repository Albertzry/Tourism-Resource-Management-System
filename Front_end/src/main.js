import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

import vueRouter from 'vue-router'
Vue.use(vueRouter)
import VueWechatTitle from 'vue-wechat-title' //动态修改title
Vue.use(VueWechatTitle);

import Home from "./views/Home.vue"
import Mine from "./views/Mine.vue"
import Login from "./views/Login.vue"
import Console from "./views/Console.vue"
import Hotel from "./views/Hotel.vue"
import Parking from "./views/Parking.vue"
import Guider from "./views/Guider.vue"
import Feedback from "./views/Feedback.vue"
import Travel_Agency from "./views/Travel_Agency.vue"
import Tourist_Attraction from "./views/Tourist_Attraction.vue"


const routes = [
    { path: '/home', component: Home,meta:{title:'首页'} },
    { path: '/mine', component: Mine ,meta:{title:'个人中心'}},
    { path: '/login', component: Login,meta:{title:'登录'}},
    { path: '/console', component: Console,meta:{title:'控制台'} },
    { path: '/hotel', component: Hotel,meta:{title:'酒店信息管理系统'}},
    { path: '/parking', component: Parking,meta:{title:'停车信息管理系统'}},
    { path: '/guider', component: Guider,meta:{title:'导游信息管理系统'}},
    { path: '/feedback', component: Feedback,meta:{title:'游客反馈信息管理系统'}},
    { path: '/travel_agency', component: Travel_Agency,meta:{title:'旅行社信息管理系统'}},
    { path: '/tourist_attraction', component: Tourist_Attraction,meta:{title:'景区信息管理系统'}},
]

const router = new vueRouter({
    routes
})


import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);

import axios from 'axios'
Vue.prototype.$axios = axios

new Vue({
    router,
    axios,
    render: h => h(App),
}).$mount('#app')
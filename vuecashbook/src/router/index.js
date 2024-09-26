import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginView from '@/views/common/LoginView.vue'
import member from './member/index.js'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: LoginView
  },
  ...member
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach(async (to, from, next) => {
  console.log(process.env.BASE_URL)
  console.log(to)
  console.log(from)
  next()
})

export default router

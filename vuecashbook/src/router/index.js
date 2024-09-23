import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginView from '@/views/common/LoginView.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: LoginView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach(async (to, from, next) => {
  console.log(process.env.BASE_URL)
  next()
})

export default router

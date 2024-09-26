import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from '@/plugin/axios.js'
import myPlugin from '@/plugin/myPlugin.js'

/** BOOTSTRAP CSS 적용 */
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
// 전역 컴포넌트 설정
import AlertComp from './components/common/AlertComp.vue'
import ConfirmComp from './components/common/ConfirmComp.vue'
import PopupLayout from './components/layouts/PopupLayout.vue'

/** BootStrap 사용 */
Vue.use(BootstrapVue)
Vue.use(myPlugin, { sameOption: true })

Vue.config.productionTip = false

// 전역변수 설정
Vue.prototype.$axios = axios
Vue.prototype.$store = store

// 전역 컴포넌트 설정
Vue.component('AlertComp', AlertComp)
Vue.component('ConfirmComp', ConfirmComp)
Vue.component('PopupLayout', PopupLayout)

new Vue({
  router,
  store,
  myPlugin,
  render: h => h(App)
}).$mount('body')

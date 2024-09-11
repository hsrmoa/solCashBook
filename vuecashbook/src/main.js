import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

/** BOOTSTRAP CSS 적용 */
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.config.productionTip = false
/** BootStrap 사용 */
Vue.use(BootstrapVue)
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('body')

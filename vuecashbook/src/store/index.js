import Vue from 'vue'
import Vuex from 'vuex'

/** store 모듈 */
import alertStore from './common/alertStore.js'
import confirmStore from './common/confirmStore.js'

Vue.use(Vuex)

// module vuex
const state = {}
const getters = {}
const mutations = {}
const actions = {}
const modules = {
  alert: alertStore,
  confirm: confirmStore
}

export default new Vuex.Store({
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
  modules
})

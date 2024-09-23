const alertStore = {
  namespaced: true,
  state: {
    alertOpen: false,
    alertMsg1: '',
    alertMsg2: '',
    btnOpt: {
      ok: '확인'
    },
    fnAlertOk: () => {}
  },
  getters: {
    GET_ALERT_OPEN: state => state.alertOpen,
    GET_ALERT_MSG1: state => state.alertMsg1,
    GET_ALERT_MSG2: state => state.alertMsg2,
    GET_ALERT_BTN_OPT: state => state.btnOpt
  },
  mutations: {
    /** 팝업 초기화 */
    SET_ALERT_CLEAR: (state) => {
      state.alertOpen = false
      state.alertMsg1 = ''
      state.alertMsg2 = ''
      state.btnOpt = {
        ok: '확인'
      }
    },
    /* ALERT 팝업 호출 */
    SET_ALERT_CALL: (state, payload) => {
      state.alertOpen = true
      state.alertMsg1 = payload.alertMsg1
      if (payload.fnAlertOk !== undefined) {
        state.fnAlertOk = payload.fnAlertOk
      }
      if (payload.alertMsg2 !== undefined) {
        state.alertMsg2 = payload.alertMsg2
      }
      if (payload.btnOpt !== undefined) {
        state.btnOpt = payload.btnOpt
      }
    },
    /* ALERT 팝업 닫기 */
    SET_ALERT_CLOSE: (state) => {
      state.alertOpen = false
    }
  },
  actions: {
    /* ALERT 팝업 초기화 */
    setAlertClear: ({ commit }) => {
      commit('SET_ALERT_CLEAR')
    },
    /* ALERT 팝업 호출 */
    alertCall: ({ commit }, payload) => {
      commit('SET_ALERT_CALL', payload)
    },
    /* ALERT 팝업 닫기 */
    alertClose: ({ commit }) => {
      commit('SET_ALERT_CLOSE')
    }
  }
}

export default alertStore

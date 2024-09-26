const alertStore = {
  namespaced: true,
  state: {
    confirmOpen: false,
    confirmMsg1: '',
    confirmMsg2: '',
    btnOpt: {
      yes: '확인',
      no: '취소'
    },
    fnYesCallback: () => {}
  },
  getters: {
    GET_CONFIRM_OPEN: state => state.confirmOpen,
    GET_CONFIRM_MSG1: state => state.confirmMsg1,
    GET_CONFIRM_MSG2: state => state.confirmMsg2,
    GET_CONFIRM_BTN_OPT: state => state.btnOpt
  },
  mutations: {
    /** 팝업 초기화 */
    SET_CONFIRM_CLEAR: (state) => {
      state.confirmOpen = false
      state.confirmMsg1 = ''
      state.confirmMsg2 = ''
      state.btnOpt = {
        yes: '확인',
        no: '취소'
      }
    },
    /* CONFIRM 팝업 호출 */
    SET_CONFIRM_CALL: (state, payload) => {
      state.confirmOpen = true
      state.confirmMsg1 = payload.confirmMsg1
      if (payload.fnYesCallback !== undefined) {
        state.fnYesCallback = payload.fnYesCallback
      }
      if (payload.confirmMsg2 !== undefined) {
        state.confirmMsg2 = payload.confirmMsg2
      }
      if (payload.btnOpt !== undefined) {
        state.btnOpt = payload.btnOpt
      }
    },
    /* CONFIRM 팝업 닫기 */
    SET_CONFIRM_CLOSE: (state) => {
      state.confirmOpen = false
    }
  },
  actions: {
    /* CONFIRM 팝업 초기화 */
    setConfirmClear: ({ commit }) => {
      commit('SET_CONFIRM_CLEAR')
    },
    /* CONFIRM 팝업 호출 */
    confirmCall: ({ commit }, payload) => {
      commit('SET_CONFIRM_CALL', payload)
    },
    /* CONFIRM 팝업 닫기 */
    confirmClose: ({ commit }) => {
      commit('SET_CONFIRM_CLOSE')
    }
  }
}

export default alertStore

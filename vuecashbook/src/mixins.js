import axios from 'axios'
import { mapActions } from 'vuex'
/*
* 믹스인(mixins.js) 파일 (=공통함수)
* 사용하는 이유 :: 각각의 컴포넌트에서 호출해서 사용하는 방식이 효율적이기 떄문에 사용
*/
export default {
  data () {
    return {
      alertOk: false,
      confirmOk: false
    }
  },
  methods: {
    ...mapActions('alert', [
      'setAlertClear',
      'alertCall',
      'alertClose'
    ]),
    /* ALERT 팝업 호출 */
    $Alert (message1, message2, callback, btnOption) {
      this.setAlertClear()
      this.alertOk = false
      this.alertCall({
        alertMsg1: message1,
        alertMsg2: message2,
        btnOpt: btnOption,
        fnAlertOk: callback
      })
    },
    /* ALERT 팝업 확인버튼 클릭 */
    $AlertOk (result) {
      this.alertOk = result
      this.$store.state.alert.fnAlertOk()
      this.alertClose()
    },
    /* AXIOS API 통신 */
    async $API (url, method, data) {
      return (await axios({
        method: method,
        url,
        data
      }).catch(e => {
        console.log(e)
      }))?.data
    },
    /* AXIOS API  POST 통신 */
    async $POST (url, param) {
      return (await axios({
        method: 'POST',
        url,
        data: JSON.stringify(param)
      }).catch(e => {
        console.log(e)
      }))?.data
    },
    /* AXIOS API  GET 통신 */
    async $GET (url, param) {
      let pamStr = ''
      if (!this.$cmmn.isNull(param)) {
        pamStr += '?'
        for (let i = 0; i < Object.keys(param).length; i++) {
          const keyName = Object.keys(param)[i]
          pamStr += keyName + '='
          pamStr += param[keyName] + '&'
        }
        pamStr = pamStr.substring(0, pamStr.length - 1)
      }
      url += pamStr
      return (await axios({
        method: 'GET',
        url
      }).catch(e => {
        console.log(e)
      }))?.data
    }
  }
}

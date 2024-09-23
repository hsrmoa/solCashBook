import mixins from '@/mixins.js'
import common from '@/global/common.js'

export default {
  install: function (Vue, options) {
    /** 전역 메소드 또는 속성 추가 */
    Vue.prototype.$cmmn = common
    Vue.mixin(mixins)
  }
}

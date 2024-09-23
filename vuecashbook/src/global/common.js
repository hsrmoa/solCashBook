export default {
  /**
   *  null 여부 체크함수
   * @param { * } str
   * @returns
   */
  isNull (str) {
    if (str === null || str === '' || str === undefined) {
      return true
    } else {
      return false
    }
  },
  /**
   * 엔터입력시
   * @param { * } e
   **/
  fnTextEnter (e, callback) {
    if (e.keyCode === 13) {
      return callback()
    }
  }
}

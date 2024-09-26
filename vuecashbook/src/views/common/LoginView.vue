<template>
  <main class="form-signin w-100 m-auto">
    <h1 class="h3 mb-3 fw-bold">로그인</h1>
    <div class="form-floating">
      <input type="text" class="form-control" id="userId" placeholder="아이디를 입력해주세요" v-model="userId">
      <label for="userId">아이디</label>
    </div>
    <div class="form-floating mt-2">
      <input type="password" class="form-control" id="userPwd" placeholder="비밀번호" v-model="userPwd">
      <label for="userPwd">비밀번호</label>
    </div>
    <button class="btn btn-primary w-100 py-2 mt-3" type="button" @click="fnLogin">로그인</button>
    <div class="d-flex">
      <button class="btn btn-link w-50 py-2 mt-1 mx-1" type="button">아이디/비밀번호 찾기</button>
      <button class="btn btn-link w-50 py-2 mt-1" type="button" @click="fnPageMove('/member/joinOpt')">회원가입</button>
    </div>
    <p class="mt-5 mb-3 text-body-secondary">© 2024-2031</p>
  </main>
</template>
<script>
export default {
  name: 'loginView',
  data () {
    return {
      userId: '',
      userPwd: ''
    }
  },
  methods: {
    /** 로그인버튼 클릭  */
    fnLogin () {
      if (this.fnLoginVaidation() === false) return
      this.fnLoginAction()
    },
    /* 로그인 시도 */
    async fnLoginAction () {
      console.log('로그인')
    },
    /** 로그인 validation 체크 */
    fnLoginVaidation () {
      if (this.$cmmn.isNull(this.userId)) {
        this.$Alert('아이디를 입력해주세요')
        return false
      }

      if (this.$cmmn.isNull(this.userPwd)) {
        this.$Alert('비밀번호를 입력해주세요')
        return false
      }
      return true
    },
    /** 페이지 이동 */
    fnPageMove () {
      this.$router.push('/member/joinOpt')
    }
  }
}
</script>

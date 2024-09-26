<template>
  <main class="form-signin w-100 m-auto">
    <h1 class="h3 mb-3 fw-bold text-center">
      회원정보
    </h1>
    <!--입력 FORM-->
    <!-- 그룹명 입력-->
    <div class="d-flex mt-2">
      <label
        class="col-sm-3 col-form-label fw-bold align-self-center text-left"
        for="grpMemberNm"
      >
        그룹명
      </label>
      <div class="col p-2">
        <label
          class="col-form-label fw-bold align-self-center text-left"
        >
          {{ grpMemberNm }}
        </label>
      </div>
    </div>
    <!-- 그룹명 입력-->
    <!-- ID 입력-->
    <div class="d-flex mt-2">
      <label
        class="col-sm-3 col-form-label fw-bold align-self-center text-left"
        for="memberId"
      >
        ID
      </label>
      <div class="col p-2">
        <div class="input-group">
          <input
            type="text"
            class="form-control"
            id="memberId"
            ref="memberId"
            v-model="memberId"
          />
          <button
            type="button"
            class="btn btn-primary"
          >
            중복체크
          </button>
        </div>
      </div>
    </div>
    <!-- ID 입력-->
    <!-- 비밀번호 입력-->
    <div class="d-flex mt-2">
      <label
        class="col-sm-3 col-form-label fw-bold align-self-center text-left"
        for="memberPwd"
      >
      비밀번호
      </label>
      <div class="col p-2">
        <input
          type="password"
          class="form-control"
          id="memberPwd"
          ref="memberPwd"
          v-model="memberPwd"
        />
      </div>
    </div>
    <!-- 비밀번호 입력-->
    <!-- 비밀번호 확인 입력-->
    <div class="d-flex mt-2">
      <label
        class="col-sm-3 col-form-label fw-bold align-self-center text-left"
        for="memberPwdChk"
      >
      비밀번호 확인
      </label>
      <div class="col p-2">
        <input
          type="password"
          class="form-control"
          id="memberPwdChk"
          ref="memberPwdChk"
          v-model="memberPwdChk"
        />
      </div>
    </div>
    <!-- 비밀번호 확인 입력-->
    <!-- 회원명 입력-->
    <div class="d-flex mt-2">
      <label
        class="col-sm-3 col-form-label fw-bold align-self-center text-left"
        for="memberNm"
      >
      회원명
      </label>
      <div class="col p-2">
        <input
          type="text"
          class="form-control"
          id="memberNm"
          ref="memberNm"
          v-model="memberNm"
        />
      </div>
    </div>
    <!-- 회원명 입력-->
    <!-- 휴대폰번호 입력-->
    <div class="d-flex mt-2">
      <label
        class="col-sm-3 col-form-label fw-bold align-self-center text-left"
        for="phoneFrtNum"
      >
      휴대폰번호
      </label>
      <div class="col p-2">
        <input
          type="text"
          class="form-control"
          id="phoneFrtNum"
          ref="phoneFrtNum"
          v-model="phoneFrtNum"
          maxlength="3"
        />
      </div>
      <label
        class="col-form-label fw-bold align-self-center text-center"
      > - </label>
      <div class="col p-2">
        <input
          type="text"
          class="form-control"
          id="phoneMidNum"
          ref="phoneMidNum"
          v-model="phoneMidNum"
          maxlength="4"
        />
      </div>
      <label
        class="col-form-label fw-bold align-self-center text-center"
      > - </label>
      <div class="col p-2">
        <input
          type="text"
          class="form-control"
          id="phoneLstNum"
          ref="phoneLstNum"
          v-model="phoneLstNum"
          maxlength="4"
        />
      </div>
    </div>
    <!-- 휴대폰번호 입력-->
    <!-- 이메일주소 입력-->
    <div class="d-flex mt-2">
      <label
        class="col-sm-3 col-form-label fw-bold align-self-center text-left"
        for="email"
      >
      이메일
      </label>
      <div class="col col-4 p-2">
        <input
          type="text"
          class="form-control"
          id="email"
          ref="email"
          v-model="email"
        />
      </div>
      <label
        class="col-form-label fw-bold align-self-center text-center"
      > @ </label>
      <div class="col p-2">
        <input
          type="text"
          class="form-control"
          id="emailAddress"
          ref="emailAddress"
          v-model="emailAddress"
        />
      </div>
    </div>
    <!-- 이메일주소 입력-->
    <!-- 성별 입력-->
    <div class="d-flex mt-2">
      <label
        class="col-sm-3 col-form-label fw-bold align-self-center text-left"
        for="genderM"
      >
      성별
      </label>
      <div class="col p-2 align-self-center">
        <div class="form-check form-check-inline">
          <input
            type="radio"
            class="form-check-input"
            id="genderM"
            ref="email"
            name="gender"
            value="M"
            v-model="gender"
          />
          <label
            class="form-check-label"
            for="genderM"
          >
            남성
          </label>
        </div>
        <div class="form-check form-check-inline">
          <input
            type="radio"
            class="form-check-input"
            id="genderF"
            ref="email"
            name="gender"
            value="F"
            v-model="gender"
          />
          <label
            class="form-check-label"
            for="genderF"
          >
            여성
          </label>
        </div>
      </div>
    </div>
    <!-- 성별 입력-->
    <!-- 생년월일 입력-->
    <div class="d-flex mt-2">
      <label
        class="col-sm-3 col-form-label fw-bold align-self-center text-left"
        for="memberBirthFrt"
      >
      생년월일
      </label>
      <div class="col p-2">
        <input
          type="text"
          class="form-control"
          id="memberBirthFrt"
          ref="memberBirthFrt"
          v-model="memberBirthFrt"
          maxlength="4"
        />
      </div>
      <label
        class="col-form-label fw-bold align-self-center text-center"
      > - </label>
      <div class="col p-2">
        <input
          type="text"
          class="form-control"
          id="memberBirthMid"
          ref="memberBirthMid"
          v-model="memberBirthMid"
          maxlength="2"
        />
      </div>
      <label
        class="col-form-label fw-bold align-self-center text-center"
      > - </label>
      <div class="col p-2">
        <input
          type="text"
          class="form-control"
          id="memberBirthLst"
          ref="memberBirthLst"
          v-model="memberBirthLst"
          maxlength="2"
        />
      </div>
    </div>
    <!-- 생년월일 입력-->
    <!--입력 FORM-->
    <!--버튼-->
    <div
      class="d-flex justify-content-center p-2 mt-3"
    >
      <button
        type="button"
        class="btn btn-primary px-4 w-100"
      >
        회원가입
      </button>
    </div>
    <!--버튼-->
  </main>
</template>
<script>
export default {
  name: 'joinMemberVue',
  props: {
    // 마스터회원 SEQ
    grpMemberSeq: {
      type: [String, Number],
      default: ''
    },
    joinType: {
      type: String,
      default: ''
    }
  },
  data () {
    return {
      grpMemberNm: '',
      memberId: '',
      memberPwd: '',
      memberPwdChk: '',
      memberNm: '',
      phoneFrtNum: '',
      phoneMidNum: '',
      phoneLstNum: '',
      email: '',
      emailAddress: '',
      gender: 'M',
      memberBirthFrt: '',
      memberBirthMid: '',
      memberBirthLst: ''
    }
  }
}
</script>

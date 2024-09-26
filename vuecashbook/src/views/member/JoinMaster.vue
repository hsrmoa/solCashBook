<template>
  <main class="form-signin w-100 m-auto">
    <h1
      class="h3 mb-3 fw-bold text-center"
    >
      그룹정보
    </h1>
    <!-- 마스터회원 등록 -->
    <div
      class="d-flex mt-2"
    >
      <label
        class="col-sm-2 col-form-label fw-bold align-self-center text-center"
        for="grpMemberNm"
      >
        그룹명
      </label>
      <div
        class="col p-2"
        v-if="joinType === 'M'"
      >
         <input
            type="text"
            class="form-control"
            id="grpMemberNm"
            ref="grpMemberNm"
            v-model="grpMemberNm"
         />
      </div>
      <div
        class="col p-2"
        v-if="joinType === 'U'"
      >
        <div class="input-group">
          <input
            type="text"
            class="form-control"
            id="grpMemberNm"
            ref="grpMemberNm"
            v-model="grpMemberNm"
            disabled
          />
          <button
            type="button"
            class="btn btn-primary"
            @click="fnJoinMasterPopCall"
          >
            검색
          </button>
        </div>
       </div>
    </div>
    <div
      class="d-flex justify-content-center p-2 mt-3"
    >
      <button
        type="button"
        class="btn btn-primary px-4 w-100"
        @click="fnGrpMemberJoin"
      >
        다음
      </button>
    </div>
    <!-- 마스터회원 등록 -->
    <PopupLayout
      ref="joinMasterGrpPopup"
      title="그룹정보"
      popWidth=60
      v-if="joinType === 'U'"
    >
      <JoinMasterPop />
    </PopupLayout>
  </main>
</template>
<script>
import JoinMasterPop from './popup/JoinMasterPop.vue'
export default {
  name: 'joinMasterVue',
  components: {
    JoinMasterPop
  },
  props: {
    joinType: {
      type: String,
      default: ''
    }
  },
  data () {
    return {
      grpMemberNm: '',
      grpMemberSeq: null
    }
  },
  methods: {
    /* 그룹정보 팝업 호출 */
    fnJoinMasterPopCall () {
      this.$refs.joinMasterGrpPopup.openPopup()
    },
    /* 다음버튼 클릭(=마스터회원 가입) */
    fnGrpMemberJoin () {
      if (!this.fnGrpRegVaidation()) return
      /** 마스터회원일때 */
      if (this.joinType === 'M') {
        const confirmMsg = '입력하신 ' + this.grpMemberNm + '명으로'
        this.$Confirm(confirmMsg, '그룹을 생성하시겠습니까?', this.fnGrpMemberJoinApi)
      } else {
        this.fnPageMove('joinMember', {
          grpMemberSeq: this.grpMemberSeq,
          joinType: this.joinType
        })
      }
    },
    /* 신규 마스터회원(그룹회원) 등록 API 서비스 */
    async fnGrpMemberJoinApi (result) {
      // Confirm 창에서 확인버튼 클릭했을 때
      if (result) {
        const params = {
          grpMemberNm: this.grpMemberNm,
          useYn: 'Y'
        }
        // 그룹회원가입 API 연결
        const data = await this.$POST('/member/grpJoin', params)
        // 그룹회원이 정상적으로 등록되었을 때
        if (data.resultCode === 200) {
          this.$Alert('그룹명으로 생성하였습니다.', '', () => {
            console.log(data.data)
            // 일반회원가입 작성 페이지 이동
            this.fnPageMove('joinMember', {
              grpMemberSeq: data.data,
              joinType: this.joinType
            })
          })
        } else {
          // 그룹회원 에러발생시
          const errType = data.errType
          if (!this.$cmmn.isNull(errType)) {
            this.fnAlertErrMsg(errType)
          } else {
            this.$Alert(data.errMsg)
          }
        }
      }
    },
    /* 에러TYPE에 맞는 메세지 출력 */
    fnAlertErrMsg (pErrType) {
      if (pErrType === 'GRPNM') {
        // 그룹명 존재
        this.$Alert('존재하는 그룹명입니다.', '다시 입력해주세요', () => {
          this.$refs.grpMemberNm.focus()
        })
      }
    },
    /* 페이지이동 */
    fnPageMove (pName, pParams) {
      this.$router.push({
        name: pName,
        params: pParams
      })
    },
    /* 마스터회원 등록시 valdiation */
    fnGrpRegVaidation () {
      /* 그룹명 미입력 체크 */
      if (this.$cmmn.isNull(this.grpMemberNm)) {
        this.$Alert('그룹명을 입력해주세요.')
        return false
      }
      /* 공백 확인 */
      if (this.grpMemberNm.indexOf(' ') !== -1) {
        this.$Alert('입력한 그룹명에 공백이 존재합니다.', '공백을 제거해주세요.')
        return false
      }
      return true
    }
  }
}
</script>

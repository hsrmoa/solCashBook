<template>
  <div
    class="modal-wrap"
    @click="this.fnConfirmClose"
  >
    <div
      class="modal-container"
      @click.stop=""
    >
      <div
        class="d-flex justify-content-center align-self-end p-2 mt-5"
      >
        <div>
          <h5
            class="h5 fw-bold text-center"
          >
            {{ this.$store.state.confirm.confirmMsg1 }}
          </h5>
          <h5
            class="h5 fw-bold text-center"
            v-if="this.$cmmn.isNull(this.$store.state.confirm.confirmMsg2) === false"
          >
            {{ this.$store.state.confirm.confirmMsg2 }}
          </h5>
        </div>
      </div>
      <!-- 검색버튼 -->
      <div
        class="d-flex justify-content-center p-2 mt-3"
      >
        <div>
          <button
            type="button"
            class="btn btn-primary px-4 me-3"
            @click="this.fnYesCheck"
          >
            {{ this.$store.state.confirm.btnOpt.yes }}
          </button>
          <button
            type="button"
            class="btn btn-secondary px-4 me-3"
            @click="this.fnNoCheck"
          >
          {{ this.$store.state.confirm.btnOpt.no }}
          </button>
        </div>
      </div>
      <!-- 검색버튼 -->
    </div>
  </div>
</template>
<script>
import { mapActions } from 'vuex'

export default {
  name: 'ConfirmComp',
  methods: {
    ...mapActions('confirm', ['setConfirmClear']),
    fnConfirmClose () {
      this.setConfirmClear()
    },
    /* 확인버튼 클릭시 */
    fnYesCheck () {
      this.$ConfirmOk(true)
    },
    /* 취소버튼 클릭시  */
    fnNoCheck () {
      this.$ConfirmOk(false)
    }
  }
}
</script>
<style scoped>
/* dimmed */
.modal-wrap {
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.4);
  z-index: 1000;
}
/* modal or popup */
.modal-container {
  position: relative;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 550px;
  background: #fff;
  border-radius: 10px;
  padding: 20px;
  box-sizing: border-box;
}
</style>

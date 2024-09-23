<template>
  <div
    class="modal-wrap"
    @click="this.fnAlertClose"
  >
    <div
      class="modal-container"
    >
      <div
        class="d-flex justify-content-center align-self-end p-2 mt-5"
      >
        <div>
          <h5 class="h5 fw-bold text-center">
            {{ this.$store.state.alert.alertMsg1 }}
          </h5>
          <h5
            class="h5 fw-bold text-center"
            v-if="this.$cmmn.isNull(this.$store.state.alert.alertMsg2)"
          >
            {{ this.$store.state.alert.alertMsg2 }}
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
            @click="fnOkCheck"
          >
            {{ this.$store.state.alert.btnOpt.ok }}
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
  name: 'alertComp',
  methods: {
    ...mapActions('alert', ['setAlertClear']),
    fnAlertClose () {
      this.setAlertClear()
    },
    /* ALERT 버튼 클릭시 */
    fnOkCheck () {
      this.$AlertOk(true)
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

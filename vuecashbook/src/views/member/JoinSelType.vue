<template>
  <main class="form-signin w-100 m-auto">
    <h1
      class="h3 mb-5 fw-bold text-center"
    >
      회원가입
    </h1>
    <div class="row row-cols-1 mb-3 text-center">
      <div class="col">
        <div
          class="card mb-4 rounded-3 shadow-sm border-primary"
        >
          <div
            class="card-header py-3 text-bg-primary border-primary"
          >
            <h4 class="my-0 f2-normal">마스터회원</h4>
          </div>
          <div class="card-body">
            <svg xmlns="http://www.w3.org/2000/svg"
              width="50"
              height="50"
              fill="currentColor"
              class="bi bi-person-circle mt-3 mb-4" viewBox="0 0 16 16">
              <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"></path>
              <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8m8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1"></path>
            </svg>
            <h4
              class="card-title pricing-card-title"
            >
              <small class="text-body-secondary fw-bold">
                마스터 회원
              </small>
            </h4>
            <button
              type="button"
              class="w-100 mt-4 btn btn-lg btn-primary"
              @click="fnPageMove('joinMaster','M')"
            >
              회원가입
            </button>
          </div>
        </div>
      </div>
    </div>
    <div class="row row-cols-1 mb-3 text-center">
      <div class="col">
        <div
          class="card mb-4 rounded-3 shadow-sm border-primary"
        >
          <div
            class="card-header py-3 text-bg-primary border-primary"
          >
            <h4 class="my-0 f2-normal">그룹회원</h4>
          </div>
          <div class="card-body">
            <svg xmlns="http://www.w3.org/2000/svg"
              width="50"
              height="50"
              fill="currentColor"
              class="bi bi-person-circle mt-3 mb-4" viewBox="0 0 16 16">
              <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"></path>
              <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8m8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1"></path>
            </svg>
            <h4
              class="card-title pricing-card-title"
            >
              <small class="text-body-secondary fw-bold">
                그룹 회원
              </small>
            </h4>
            <button
              type="button"
              class="w-100 mt-4 btn btn-lg btn-primary"
              @click="fnPageMove('joinMaster','U')"
            >
              회원가입
            </button>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>
<script>
export default {
  name: 'JoinSelType',
  methods: {
    /** 회원가입 페이지 이동 */
    fnPageMove (pName, pType) {
      this.$router.push({
        name: pName,
        params: {
          joinType: pType
        }
      })
    }
  }
}
</script>

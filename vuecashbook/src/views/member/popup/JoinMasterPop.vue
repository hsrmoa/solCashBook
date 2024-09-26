<template>
  <div class="p-2 mt-3">
    <!-- 검색바 -->
     <div
      class="p-4 bg-body-tertiary rounded-3 mb-3"
     >
      <div class="d-flex">
        <label
          class="col-sm-3 col-form-label fw-bold align-self-center text-center"
          for="schGrpMemberNm"
        >
          그룹명
        </label>
        <div class="col p-2 align-self-center">
          <input
            type="text"
            class="form-control"
            id="schGrpMemberNm"
          />
        </div>
        <div class="col col-sm-3 p-2 align-self-center">
          <button
            type="button"
            class="btn btn-primary"
          >
            검색
          </button>
        </div>
      </div>
    </div>
    <!-- 검색바 -->
  </div>
</template>
<script>
export default {
  name: 'joinMasterPopupVue'
}
</script>

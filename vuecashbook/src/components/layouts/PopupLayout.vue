<template>
  <div v-if="show">
    <!-- 팝업 컨텐츠 -->
    <div
      class="popup"
      :style="scrennWidth"
    >
      <div class="d-flex">
        <div class="p-2 flex-grow-1">
          <h1 class="h5 fw-bold align-self-center">
            {{ title }}
          </h1>
        </div>
        <div class="p-2">
          <button
            type="button"
            class="btn-close"
            aria-label="Close"
            @click="closePopup"
          ></button>
        </div>
      </div>
      <!-- 내용 -->
       <slot></slot>
    </div>
    <!-- 배경레이어 -->
    <div class="overlay"></div>
    <!-- 팝업 컨텐츠 -->
  </div>
</template>
<script>
export default {
  data () {
    return {
      show: false
    }
  },
  computed: {
    scrennWidth () {
      return 'width:' + this.popWidth + '%'
    }
  },
  props: {
    title: {
      type: String,
      default: ''
    },
    popWidth: {
      type: Number,
      default: 50
    }
  },
  methods: {
    openPopup () {
      this.show = true
    },
    closePopup () {
      this.show = false
    }
  }
}
</script>
<style scoped>
/* 스타일링 */
.popup {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background: white;
  padding: 20px;
  z-index: 500;
}

.overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  z-index: 499;
}
</style>

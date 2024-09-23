<template>
  <div>
  <!-- <main style="height:10vh;" class="d-flex flex-nowrap">
    <HeaderLayout />
  </main> -->
  <!-- <main style="height:90vh;" class="d-flex flex-nowrap">
    <LeftLayout />
    <div class="bd-cheatsheet container-fluid bg-body ">
      <router-view />
    </div>
  </main> -->
  <div class="d-flex align-items-center py-4 bg-body-tertiary" style="height: 100vh;">
    <router-view/>
  </div>
  <alert-comp v-show="this.$store.state.alert.alertOpen === true"></alert-comp>
  </div>
</template>
<script>
import AlertComp from './components/common/AlertComp.vue'
// import HeaderLayout from '@/components/layouts/HeaderLayout.vue'
// import LeftLayout from '@/components/layouts/LeftLayout.vue'
export default {
  components: { AlertComp },
  name: 'App'
  // components: {
  //   HeaderLayout,
  //   LeftLayout
  // }
}
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
.form-signin{
  max-width: 550px;
  padding: 1rem;
}
</style>

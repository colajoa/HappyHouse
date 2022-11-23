<template>
  <div id="app">
    <header-nav-bar :isBg="isBg"></header-nav-bar>
    <router-view></router-view>
  </div>
</template>

<script>
import HeaderNavBar from "@/components/HeaderNavBar.vue";

export default {
  name: "App",
  components: {
    HeaderNavBar,
  },
  data() {
    return {
      isBg: false,
    };
  },
  created() {
    if (this.$route.name != "main") {
      this.isBg = true;
    }
  },
  updated() {
    if (this.$route.name != "main") {
      this.isBg = true;
    } else {
      this.isBg = false;
    }
  },
};
</script>

<style>
body,
html,
#app {
  height: 100%;
}
@import "./assets/css/style.css";
@import "./assets/vendor/aos/aos.css";
@import "assets/vendor/bootstrap/css/bootstrap.min.css";
@import "assets/vendor/bootstrap-icons/bootstrap-icons.css";
@import "assets/vendor/boxicons/css/boxicons.min.css";
@import "assets/vendor/glightbox/css/glightbox.min.css";
@import "assets/vendor/swiper/swiper-bundle.min.css";
@import "assets/vendor/bootstrap/css/bootstrap-utilities.min.css";
</style>

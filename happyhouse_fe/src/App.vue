<template>
  <div id="app">
    <header-nav-bar></header-nav-bar>
    <router-view />
  </div>
</template>

<script>
import HeaderNavBar from "@/components/HeaderNavBar.vue";

export default {
  name: "App",
  components: {
    HeaderNavBar,
  },
};
</script>

<style>
@import "./assets/css/style.css";
@import "./assets/vendor/aos/aos.css";
@import "assets/vendor/bootstrap/css/bootstrap.min.css";
@import "assets/vendor/bootstrap-icons/bootstrap-icons.css";
@import "assets/vendor/boxicons/css/boxicons.min.css";
@import "assets/vendor/glightbox/css/glightbox.min.css";
@import "assets/vendor/swiper/swiper-bundle.min.css";
</style>

<template>
  <div id="app-apt">
    <div class="blank"></div>
    <!-- <apt-area></apt-area> -->
    <apt-nav></apt-nav>
    <apt-map></apt-map>
    <apt-list></apt-list>
    <apt-info></apt-info>
  </div>
</template>

<script>
import AptMap from "@/components/apt/AptMap.vue";
// import AptArea from "@/components/apt/AptArea.vue";
import AptList from "@/components/apt/AptList.vue";
import AptInfo from "@/components/apt/AptInfo.vue";
import AptNav from "@/components/apt/AptNav.vue";

export default {
  name: "AppApt",
  components: {
    AptMap,
    // AptArea,
    AptList,
    AptInfo,
    AptNav,
  },
};
</script>

<style scoped>
.blank {
  position: relative;
  width: fit-content;
  height: 88px;
}

#app-apt {
  height: 100%;
}
</style>

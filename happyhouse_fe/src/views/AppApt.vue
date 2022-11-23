<template>
  <div>
    <div class="blank"></div>
    <apt-area></apt-area>
    <!-- <apt-map></apt-map> -->
    <apt-list></apt-list>
    <apt-info></apt-info>
  </div>
</template>

<script>
// import AptMap from "@/components/apt/AptMap.vue";
import AptArea from "@/components/apt/AptArea.vue";
import AptList from "@/components/apt/AptList.vue";
import AptInfo from "@/components/apt/AptInfo.vue";

export default {
  name: "AppApt",
  components: {
    // AptMap,
    AptArea,
    AptList,
    AptInfo,
  },
};
</script>

<style scoped>
.blank {
  position: relative;
  width: fit-content;
  height: 104px;
}
</style>

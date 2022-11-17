<template>
  <div>
    <div class="blank"></div>
    <apt-area></apt-area>
    <apt-map></apt-map>
  </div>
</template>

<script>
import AptMap from "@/components/apt/AptMap.vue";
import AptArea from "@/components/apt/AptArea.vue";

export default {
  name: "AppApt",
  components: {
    AptMap,
    AptArea,
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

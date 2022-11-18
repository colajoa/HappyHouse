<template>
  <div>
    <div class="blank"></div>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "AppQna",
};
</script>

<style scoped>
.blank {
  position: relative;
  width: fit-content;
  height: 104px;
}
</style>

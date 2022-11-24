<template>
  <div>
    <h2 class="area-title">즐겨찾기</h2>
    <area-list-item></area-list-item>
  </div>
</template>

<script>
import AreaListItem from "./AreaListItem.vue";
export default {
  components: { AreaListItem },
};
</script>

<style scoped>
.area-title {
  margin-top: 16px;
  margin-left: 16px;
  margin-right: 16px;
}
</style>

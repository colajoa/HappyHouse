<template>
  <div>
    <h2 class="area-title">즐겨찾기</h2>
    <ul class="list-group" role="group">
      <area-list-item
        v-for="(area, index) in areas"
        :key="index"
        :area="area"
      ></area-list-item>
    </ul>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import AreaListItem from "./AreaListItem.vue";

export default {
  name: "AreaList",
  components: { AreaListItem },
  computed: {
    ...mapState("aptStore", ["areas"]),
  },
  created() {
    this.getAreas();
  },
  methods: {
    ...mapActions("aptStore", ["getAreaList"]),
    async getAreas() {
      await this.getAreaList();
    },
  },
};
</script>

<style scoped>
.area-title {
  margin-top: 16px;
  margin-left: 16px;
  margin-right: 16px;
}
</style>

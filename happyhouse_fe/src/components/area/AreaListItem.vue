<template>
  <div>
    <li
      class="list-group-item list-group-item-action"
      aria-current="true"
      data-bs-toggle="list"
      @click="setArea"
    >
      {{ area.address }}
    </li>
  </div>
</template>

<script>
import { mapActions } from "vuex";
export default {
  name: "AreaListItem",
  props: ["area"],
  methods: {
    ...mapActions("aptStore", ["detailArea"]),
    async setArea() {
      await this.detailArea(this.area);
    },
  },
};
</script>

<style scoped>
.list-group {
  border-radius: 0;
}
</style>

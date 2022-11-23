<template>
  <li @click="getAptDetail">
    {{ apt.아파트 }}
  </li>
</template>

<script>
import { mapActions } from "vuex";
export default {
  name: "AppListItem",
  props: {
    apt: Object,
  },
  methods: {
    ...mapActions("aptStore", ["detailApt"]),
    async getAptDetail() {
      await this.detailApt(this.apt);
    },
  },
};
</script>

<style></style>

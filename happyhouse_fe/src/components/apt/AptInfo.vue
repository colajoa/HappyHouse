<template>
  <div v-if="apt">
    <ul>
      <li>일련번호 : {{ apt.일련번호 }}</li>
      <li>아파트 : {{ apt.아파트 }}</li>
      <li>법정동 : {{ apt.법정동 }}</li>
      <li>층 : {{ apt.층 }}</li>
    </ul>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
export default {
  name: "AptInfo",
  computed: {
    ...mapState("aptStore", ["apt"]),
  },
  methods: {
    ...mapActions("aptStore", [""]),
  },
};
</script>

<style></style>

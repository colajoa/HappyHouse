<template>
  <div class="accordion" id="accordionExample" style="">
    <apt-list-item
      v-for="(apt, index) in apts"
      :key="index"
      :apt="apt"
      :index="index"
    >
    </apt-list-item>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import aptListItem from "@/components/apt/AptListItem.vue";

export default {
  name: "AptList",
  components: {
    aptListItem,
  },
  data() {
    return {};
  },
  created() {
    console.log(this.apts);
  },
  computed: {
    ...mapState("aptStore", ["apts"]),
  },
  methods: {
    ...mapActions("aptStore", [""]),
  },
};
</script>

<style scoped>
.accordion {
  overflow-y: scroll;
}
</style>

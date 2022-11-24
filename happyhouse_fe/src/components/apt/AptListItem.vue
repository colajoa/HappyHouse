<template>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingOne" @click="getAptDetail">
      <button
        class="accordion-button collapsed"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#collapseOne"
        aria-expanded="false"
        aria-controls="collapseOne"
      >
        {{ apt.아파트 }}
      </button>
    </h2>
    <div
      id="collapseOne"
      class="accordion-collapse collapse"
      aria-labelledby="headingOne"
      data-bs-parent="#accordionExample"
    >
      <div class="accordion-body">
        <strong>This is the first item's accordion body.</strong> It is shown by
        default, until the collapse plugin adds the appropriate classes that we
        use to style each element. These classes control the overall appearance,
        as well as the showing and hiding via CSS transitions. You can modify
        any of this with custom CSS or overriding our default variables. It's
        also worth noting that just about any HTML can go within the
        <code>.accordion-body</code>, though the transition does limit overflow.
        <apt-info></apt-info>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex";
import AptInfo from "./AptInfo.vue";
export default {
  components: { AptInfo },
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

<style scoped></style>

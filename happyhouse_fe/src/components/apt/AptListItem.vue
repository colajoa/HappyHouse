<template>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingOne" @click="getAptDetail">
      <button
        class="accordion-button collapsed"
        type="button"
        data-bs-toggle="collapse"
        :data-bs-target="`#apt${index}`"
        aria-expanded="false"
        aria-controls="collapseOne"
      >
        {{ apt.아파트 }}
      </button>
    </h2>
    <div
      :id="`apt${index}`"
      class="accordion-collapse collapse"
      aria-labelledby="headingOne"
      data-bs-parent="#accordionExample"
    >
      <div class="accordion-body">
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
    index: Number,
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

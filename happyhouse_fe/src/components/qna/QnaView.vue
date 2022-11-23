<template>
  <tr
    class="accordion-collapse collapse delay-zero"
    data-bs-parent="#qna-table"
  >
    <td>Q</td>
    <td colspan="4">{{ qna.content }}</td>
  </tr>
</template>

<script>
import { mapState, mapActions } from "vuex";

const qnaStore = "qnaStore";
export default {
  name: "QnaView",
  data() {
    return {};
  },
  computed: {
    ...mapState(qnaStore, ["qna", "qnaId", "isShow"]),
  },
  mounted() {
    this.getQna();
  },
  methods: {
    ...mapActions(qnaStore, ["detailQna"]),
    async getQna() {
      await this.detailQna(this.qnaId);
    },
  },
};
</script>

<style scoped></style>

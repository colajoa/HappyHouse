<template>
  <tr
    class="collapse accordion-collapse delay-zero"
    data-bs-parent="#qna-table"
    :id="'qna' + qna.idx"
    v-if="qna.reply"
  >
    <td>A</td>
    <td colspan="3">{{ reply.content }}</td>
    <td
      class="qna-button d-flex justify-content-center"
      v-if="userInfo.role == 'admin'"
    >
      <button class="btn btn-custom">수정</button>
    </td>
    <td v-else></td>
  </tr>
  <tr
    v-else
    class="collapse accordion-collapse delay-zero"
    data-bs-parent="#qna-table"
    :id="'qna' + qna.idx"
  >
    <td>A</td>
    <td colspan="3">답변 등록이 되지 않았습니다.</td>
    <td
      class="qna-button d-flex justify-content-center"
      v-if="userInfo.role == 'admin'"
    >
      <button class="btn btn-custom">답변</button>
    </td>
    <td v-else></td>
  </tr>
</template>

<script>
import { mapState } from "vuex";

const userStore = "userStore";
export default {
  name: "QnaReply",
  data() {
    return {};
  },
  mounted() {
    console.log(this.qna);
  },
  props: ["qna", "qnaId"],
  computed: {
    ...mapState(userStore, ["userInfo"]),
    ...mapState("qnaStore", ["reply"]),
  },
  methods: {},
};
</script>

<style scoped>
.delay-zero {
  transition: none;
}
</style>

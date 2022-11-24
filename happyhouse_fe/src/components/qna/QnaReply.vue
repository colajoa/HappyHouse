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
      <button
        class="btn btn-custom"
        data-bs-toggle="modal"
        data-bs-target="#modify"
      >
        수정
      </button>
      <qna-reply-update id="modify" :reply="reply"></qna-reply-update>
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
      <button
        class="btn btn-custom"
        data-bs-toggle="modal"
        data-bs-target="#register"
      >
        답변
      </button>
      <qna-reply-update id="register" :qnaId="qnaId"></qna-reply-update>
    </td>
    <td v-else></td>
  </tr>
</template>

<script>
import { mapState } from "vuex";
import QnaReplyUpdate from "./QnaReplyUpdate.vue";

const userStore = "userStore";
export default {
  components: { QnaReplyUpdate },
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

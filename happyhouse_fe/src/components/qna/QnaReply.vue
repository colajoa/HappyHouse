<template>
  <tr
    class="collapse accordion-collapse delay-zero"
    data-bs-parent="#qna-table"
    :id="'qna' + qna.idx"
    v-if="qna.isReply"
  >
    <td>A</td>

    <td colspan="3">{{ reply.content }}</td>
    <td
      class="qna-button d-flex justify-content-center"
      v-if="userInfo.role != user"
    >
      <button>수정</button>
    </td>
    <td v-if="userInfo.role == user"></td>
  </tr>
  <tr
    class="collapse accordion-collapse delay-zero"
    data-bs-parent="#qna-table"
    :id="'qna' + qna.idx"
    v-else
  >
    <td>A</td>
    <td colspan="3">답변 등록이 되지 않았습니다.</td>
    <td
      class="qna-button d-flex justify-content-center"
      v-if="userInfo.role != user"
    >
      <button>수정</button>
    </td>
    <td v-if="userInfo.role == user"></td>
  </tr>
</template>

<script>
import { mapActions, mapState } from "vuex";

const userStore = "userStore";
export default {
  name: "QnaReply",
  data() {
    return {};
  },
  props: {
    qna: [],
  },

  computed: {
    ...mapState(userStore, ["isLogin", "userInfo"]),
  },
};
</script>

<style scoped>
.delay-zero {
  transition: none;
}
</style>

<template>
  <tbody>
    <tr :key="qna" data-bs-toggle="collapse" :data-bs-target="'#qna' + qna.idx">
      <td>{{ qna.idx }}</td>
      <td class="view-btn accordion-item">
        {{ qna.title }}
      </td>
      <td>{{ qna.writer }}</td>
      <td>{{ qna.createdat }}</td>
      <td>{{ qna.hit }}</td>
    </tr>

    <!--QnA-->
    <tr
      :key="qna.idx"
      class="accordion-collapse collapse delay-zero"
      :id="'qna' + qna.idx"
      data-bs-parent="#qna-table"
    >
      <td>Q</td>
      <td class="qna-content" colspan="3">
        {{ qna.content }}
      </td>
      <td
        class="qna-button d-flex justify-content-center"
        v-if="userInfo.id == qna.writer"
      >
        <button
          class="btn btn-custom"
          data-bs-toggle="modal"
          data-bs-target="#modify"
        >
          수정
        </button>
        <qna-update id="modify" :qna="qna"></qna-update>
      </td>
      <td v-else></td>
    </tr>
    <qna-reply :key="qna.idx" :qna="qna" :qnaId="qna.idx"></qna-reply>
  </tbody>
</template>

<script>
import { mapState } from "vuex";
import QnaReply from "@/components/qna/QnaReply.vue";
import QnaUpdate from "@/components/qna/QnaUpdate.vue";

export default {
  name: "QnaListItem",
  components: {
    QnaReply,
    QnaUpdate,
  },
  props: {
    qna: Object,
  },
  created() {},
  computed: {
    ...mapState("userStore", ["userInfo"]),
  },
  data() {
    return {};
  },
  methods: {},
};
</script>

<style scoped>
.view-btn:hover {
  cursor: pointer;
}

.delay-zero {
  transition: none;
}
</style>
>

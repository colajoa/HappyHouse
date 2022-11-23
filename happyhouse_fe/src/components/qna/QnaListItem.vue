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
        v-if="userInfo.name == qna.writer"
      >
        <button class="btn btn-custom">수정</button>
      </td>
      <td v-else></td>
    </tr>
    <qna-reply :key="qna.idx" :qna="qna" :qnaId="qna.idx"></qna-reply>
  </tbody>
</template>

<script>
import { mapState } from "vuex";
import QnaReply from "@/components/qna/QnaReply.vue";

export default {
  name: "QnaListItem",
  components: {
    QnaReply,
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

<style></style>

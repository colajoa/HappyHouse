<template>
  <tr v-if="qna.isReply">
    <td>A</td>
    <td colspan="4">{{}}</td>
  </tr>
  <tr v-else>
    <td>A</td>
    <td colspan="4">답변 등록이 되지 않았습니다.</td>
  </tr>
</template>

<script>
export default {
  name: "QnaReply",
  data() {
    return {};
  },
  props: {
    qnaid: Number,
  },
};
</script>

<style></style>

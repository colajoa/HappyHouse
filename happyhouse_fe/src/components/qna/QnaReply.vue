<template>
  <tr
    class="collapse accordion-collapse"
    data-bs-parent="#qna-table"
    v-if="isReply"
  >
    <td>A</td>
    <td colspan="4">{{ reply.title }}</td>
    <td colspan="4">{{ reply.content }}</td>
  </tr>
  <tr class="collapse accordion-collapse" data-bs-parent="#qna-table" v-else>
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

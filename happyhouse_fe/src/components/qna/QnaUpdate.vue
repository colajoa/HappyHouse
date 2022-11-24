<template>
  <div
    class="modal fade"
    tabindex="-1"
    role="dialog"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">
            <input
              type="text"
              class="form-control form-control-lg"
              id=""
              placeholder="글 제목"
              v-model="title"
              ref="title"
            />
          </h5>
          <button
            type="button"
            class="close"
            data-bs-dismiss="modal"
            aria-label="Close"
          >
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <textarea
            class="form-control form-control-lg"
            id=""
            placeholder="내용을 입력하세요."
            v-model="content"
            ref="content"
            rows="10"
          ></textarea>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">
            삭제
          </button>
          <button type="button" class="btn btn-primary">수정</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "QnaUpdate",
  props: ["qna"],
  data() {
    return {
      title: null,
      content: null,
    };
  },
  created() {
    this.title = this.qna.title;
    this.content = this.qna.content;
  },
  methods: {},
};
</script>

<style></style>

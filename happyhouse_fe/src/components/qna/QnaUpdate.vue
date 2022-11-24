<template>
  <div
    class="modal fade"
    id="modify"
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
          <button
            type="button"
            class="btn btn-secondary"
            data-bs-dismiss="modal"
          >
            취소
          </button>
          <button
            type="button"
            class="btn btn-custom"
            @click="deleteQna"
            data-bs-dismiss="modal"
          >
            삭제
          </button>
          <button
            type="button"
            class="btn btn-custom"
            @click="updateQna"
            data-bs-dismiss="modal"
          >
            수정
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex";
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
  methods: {
    ...mapActions("qnaStore", ["modifyQna", "removeQna"]),
    async updateQna() {
      const qna = {
        idx: this.qna.idx,
        title: this.title,
        content: this.content,
      };
      try {
        await this.modifyQna(qna);
        this.$router.go();
      } catch (e) {
        console.log(e);
        alert("서버 오류입니다.\n잠시 후 다시 시도해주세요");
      }
    },
    async deleteQna() {
      try {
        await this.removeQna(this.qna.idx);
        this.$router.go();
      } catch (e) {
        console.log(e);
        alert("서버 오류입니다.\n잠시 후 다시 시도해주세요");
      }
    },
  },
};
</script>

<style></style>

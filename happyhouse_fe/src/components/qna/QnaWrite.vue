<template>
  <div
    class="modal fade"
    id="write-qna"
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
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          >
            <!-- <span aria-hidden="true">&times;</span> -->
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
            @click="register"
            data-bs-dismiss="modal"
          >
            등록
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
export default {
  name: "QnaWrite",
  props: ["qna"],
  data() {
    return {
      title: null,
      content: null,
    };
  },
  created() {},
  computed: {
    ...mapState("userStore", ["userInfo"]),
  },
  methods: {
    ...mapActions("qnaStore", ["registerQna"]),
    async register() {
      if (!this.isBlank()) return;

      const qna = {
        title: this.title,
        writer: this.userInfo.id,
        content: this.content,
      };
      try {
        await this.registerQna(qna);
        this.$router.go();
      } catch (e) {
        console.log(e);
        alert("서버 오류입니다.\n잠시 후 다시 시도해주세요");
      }
    },
    isBlank() {
      if (!this.title) {
        this.$refs.title.focus();
        return false;
      }
      if (!this.content) {
        this.$refs.content.focus();
        return false;
      }
      return true;
    },
  },
};
</script>

<style></style>

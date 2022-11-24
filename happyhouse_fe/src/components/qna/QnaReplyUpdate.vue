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
        <div class="modal-footer" v-if="reply">
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
            @click="deleteQnaReply"
            data-bs-dismiss="modal"
          >
            삭제
          </button>
          <button
            type="button"
            class="btn btn-custom"
            @click="updateQnaReply"
            data-bs-dismiss="modal"
          >
            수정
          </button>
        </div>
        <div class="modal-footer" v-else>
          <button
            type="button"
            class="btn btn-custom"
            @click="regReply"
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
import { mapActions } from "vuex";
export default {
  name: "QnaReplyUpdate",
  props: ["reply", "qnaId"],
  data() {
    return {
      content: null,
    };
  },
  created() {
    if (this.reply) this.content = this.reply.content;
  },
  methods: {
    ...mapActions("qnaStore", [
      "registerQnaReply",
      "modifyQnaReply",
      "removeQnaReply",
    ]),
    async updateQnaReply() {
      const reply = {
        qnaid: this.reply.qnaid,
        content: this.content,
      };
      try {
        await this.modifyQnaReply(reply);
        this.$router.go();
      } catch (e) {
        console.log(e);
        alert("서버 오류입니다.\n잠시 후 다시 시도해주세요");
      }
    },
    async deleteQnaReply() {
      try {
        await this.removeQnaReply(this.reply.qnaid);
        this.$router.go();
      } catch (e) {
        console.log(e);
        alert("서버 오류입니다.\n잠시 후 다시 시도해주세요");
      }
    },
    async regReply() {
      const reply = {
        qnaid: this.qnaId,
        content: this.content,
      };
      try {
        await this.registerQnaReply(reply);
        this.$router.go();
      } catch (e) {
        alert("서버 오류입니다.\n잠시 후 다시 시도해주세요.");
      }
    },
  },
};
</script>

<style></style>

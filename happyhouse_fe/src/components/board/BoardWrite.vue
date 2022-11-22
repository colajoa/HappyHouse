<template>
  <div>
    <h2 class="text-center fw-normal" style="color: #2f4d5a">공지사항 등록</h2>
    <div class="container">
      <div class="mb-3 d-flex justify-content-center">
        <input
          type="text"
          class="form-control form-control-lg"
          id=""
          placeholder="글 제목"
          v-model="title"
          ref="title"
        />
      </div>
      <div class="mb-3 d-flex justify-content-center">
        <textarea
          class="form-control form-control-lg"
          id=""
          placeholder="내용을 입력하세요."
          v-model="content"
          ref="content"
          rows="10"
        ></textarea>
      </div>
      <div class="d-flex justify-content-center">
        <div class="row">
          <div id="custom-btn-div" class="d-flex justify-content-end gap-2">
            <button class="btn btn-custom btn-lg" @click="boardWrite">
              작성
            </button>
            <router-link
              class="btn btn-custom btn-lg"
              :to="{ name: 'boardlist' }"
              >취소</router-link
            >
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex";

const boardStore = "boardStore";
export default {
  name: "BoardWrite",
  data() {
    return {
      title: null,
      writer: "admin",
      content: null,
    };
  },
  methods: {
    // FIXME: 관리자만 작성할 수 있도록 수정
    ...mapActions(boardStore, ["post"]),
    async boardWrite() {
      if (!this.isBlank()) return;
      const board = {
        title: this.title,
        writer: this.writer,
        content: this.content,
      };
      try {
        await this.post(board);
        this.$router.push("/board/list");
      } catch (e) {
        alert("서버에 오류가 발생했습니다. 잠시 후 다시 시도해주세요.");
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

<style scoped>
h2 {
  padding: 10px;
  margin-top: 50px;
  margin-bottom: 50px;
}
.form-control {
  width: 90%;
  border-radius: 0.2rem;
  padding-left: 1.5rem;
  padding-right: 1.5rem;
}

.row {
  width: 90%;
}

textarea {
  resize: none;
  padding-top: 2rem;
  padding-bottom: 2rem;
}
</style>

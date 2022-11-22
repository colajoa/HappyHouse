<template>
  <div>
    <h2 class="text-center fw-normal" style="color: #2f4d5a">공지사항 수정</h2>
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
          rows="10"
          v-model="content"
          ref="content"
        ></textarea>
      </div>
      <div class="d-flex justify-content-center">
        <div class="row">
          <div id="custom-btn-div" class="d-flex justify-content-end gap-2">
            <button class="btn btn-lg btn-custom" @click="modify">수정</button>
            <router-link
              class="btn btn-lg btn-custom"
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
import { mapActions, mapState } from "vuex";

const boardStore = "boardStore";
export default {
  name: "BoardUpdate",
  data() {
    return {
      idx: null,
      title: null,
      content: null,
    };
  },
  computed: {
    ...mapState(boardStore, ["board"]),
  },
  created() {
    const url = window.location.href.split("/");
    this.idx = url[5];
  },
  mounted() {
    this.title = this.board.title;
    this.content = this.board.content;
  },
  methods: {
    ...mapActions(boardStore, ["modifyBoard"]),
    async modify() {
      if (!this.isBlank()) return;
      const newBoard = {
        idx: this.idx,
        title: this.title,
        content: this.content,
      };
      try {
        await this.modifyBoard(newBoard);
        this.$router.replace(`/board/view/${this.idx}`);
      } catch (e) {
        alert("서버에 오류가 발생했습니다.\n잠시 후 시도해주세요.");
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

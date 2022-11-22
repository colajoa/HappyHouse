<template>
  <div>
    <h2 class="text-center fw-normal" style="color: #2f4d5a">질문 등록</h2>
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
          <div
            id="custom-btn-div"
            class="col-md-12 d-flex justify-content-end gap-2"
          >
            <button class="btn btn-custom btn-lg" @click="register">
              작성
            </button>
            <router-link class="btn btn-custom btn-lg" :to="{ name: 'qnalist' }"
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

const qnaStore = "qnaStore";
export default {
  name: "QnaWrite",
  data() {
    return {
      title: null,
      content: null,
    };
  },
  computed: {
    ...mapState("userStore", ["userInfo"]),
  },
  methods: {
    ...mapActions(qnaStore, ["registerQna"]),
    async register() {
      if (!this.isBlank()) return;
      const qna = {
        title: this.title,
        writer: this.userInfo.id,
        content: this.content,
      };
      try {
        await this.registerQna(qna);
        this.$router.replace("/qna/list");
      } catch (e) {
        alert("서버에 오류가 발생했습니다.\n잠시후에 시도해주세요.");
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

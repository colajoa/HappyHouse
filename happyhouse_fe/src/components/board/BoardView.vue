<template>
  <div>
    <h2 class="text-center fw-normal" style="color: #2f4d5a">공지사항 보기</h2>
    <div class="container">
      <div class="mb-3 d-flex justify-content-center">
        <div class="view-header">
          <div class="view-title">
            <label>{{ board.title }}</label>
          </div>
          <div class="view-writer">
            <div>{{ board.writer }}</div>
            <div class="view-info">
              <span>{{ board.createdat }}</span>
              <span>ㅣ 조회 {{ board.hit }}</span>
            </div>
          </div>
        </div>
      </div>

      <div class="mb-3 d-flex justify-content-center">
        <div class="view-content" id="">
          {{ board.content }}
          <div class=""></div>
        </div>
      </div>
      <div class="d-flex justify-content-center">
        <div class="row">
          <div id="custom-btn-div" class="d-flex justify-content-end gap-2">
            <router-link
              class="me-auto btn btn-custom btn-lg"
              :to="{ name: 'boardlist' }"
              >목록</router-link
            >
            <router-link
              :to="{ name: 'boardupdate' }"
              class="btn btn-lg btn-custom"
              >수정</router-link
            >
            <button class="btn btn-lg btn-custom" @click="removePost">
              삭제
            </button>
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
  name: "BoardView",
  data() {
    return {
      idx: null,
    };
  },
  async created() {
    const url = window.location.href.split("/");
    this.idx = Number.parseInt(url[5]);
    // 조회수
    await this.viewBoard(this.idx);
    this.getBoard();
  },
  computed: {
    ...mapState(boardStore, ["board"]),
  },
  methods: {
    ...mapActions(boardStore, ["viewBoard", "detailBoard", "removeBoard"]),
    async getBoard() {
      await this.detailBoard(this.idx);
    },
    async removePost() {
      const result = confirm("삭제하시겠습니까?");
      if (!result) return;
      try {
        await this.removeBoard(this.idx);
        this.$router.push("/board/list");
      } catch (e) {
        alert("삭제에 실패했습니다.\n 잠시 후 다시 시도해주세요.");
      }
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
  background: white;
}

.row {
  width: 90%;
}

textarea {
  resize: none;
  padding-top: 2rem;
  padding-bottom: 2rem;
}

.view-header {
  padding: 0.5rem 1.5rem;
  border: 0;
  width: 90%;
  color: #212529;
  background: white;
  min-height: calc(1.5em + 1rem + 2px);
  font-size: 1.25rem;
}

.view-title {
  font-size: 26px;
  margin-bottom: 8px;
}

.view-writer {
  font-size: 17px;
  font: bold;
}

.view-info span {
  font-size: 16px;
  margin-right: 8px;
  color: darkgray;
}

.view-content {
  width: 90%;
  padding: 1rem 1.5rem;
  background: white;
  min-height: calc(10em + 10rem + 2px);
  height: 30%;
  font-size: 1.25rem;
  font-weight: 400;
  line-height: 1.5;
  color: #212529;
  border-top: 0.5px solid #212529;
}
</style>

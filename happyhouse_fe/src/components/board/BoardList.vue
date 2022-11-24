<template>
  <div>
    <h2 class="text-center fw-normal" style="color: #2f4d5a">공지사항 목록</h2>
    <div class="table-responsive container">
      <div class="d-flex justify-content-center">
        <div v-if="!boards">공지사항이 존재하지 않습니다!</div>
        <table v-else class="table table-hover table-fixed text-center">
          <thead class="table-light">
            <tr>
              <th scope="col" class="table-index"></th>
              <th scope="col" class="table-title">제목</th>
              <th scope="col" class="table-writer">작성자</th>
              <th scope="col" class="table-date">등록일</th>
              <th scope="col" class="table-hit">조회</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="board in boards" :key="board.idx">
              <td>{{ board.idx }}</td>
              <td>
                <router-link
                  class="view-btn"
                  :to="{
                    name: 'boardview',
                    params: { articleno: board.idx },
                  }"
                  >{{ board.title }}</router-link
                >
              </td>
              <td>{{ board.writer }}</td>
              <td>{{ board.createdat }}</td>
              <td>{{ board.hit }}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div
        class="d-flex justify-content-center"
        v-if="userInfo && userInfo.role == 'admin'"
      >
        <div class="row">
          <div id="custom-btn-div" class="col-md-12 d-flex justify-content-end">
            <router-link
              class="btn btn-custom btn-lg"
              :to="{ name: 'boardwrite' }"
              >글쓰기</router-link
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
  name: "BoardList",
  data() {
    return {};
  },
  mounted() {
    this.getBoardList();
  },
  computed: {
    ...mapState("userStore", ["userInfo"]),
    ...mapState(boardStore, ["boards"]),
  },
  methods: {
    ...mapActions(boardStore, ["boardList"]),
    async getBoardList() {
      try {
        await this.boardList();
      } catch (e) {
        console.log(e.response.data.message);
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

.table-index {
  width: 8%;
}

.table-title {
  width: 35%;
}
.table-writer {
  width: 12%;
}

.table-date {
  width: 15%;
}

.table-hit {
  width: 8%;
}

table {
  width: 90%;
}

.row {
  width: 90%;
}

.view-btn {
  color: #212529;
  text-decoration: none;
}

.view-btn:hover {
  text-decoration: underline !important;
}
</style>

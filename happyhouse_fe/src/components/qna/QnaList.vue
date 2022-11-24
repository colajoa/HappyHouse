<template>
  <div>
    <h2 class="text-center fw-normal" style="color: #2f4d5a">질문 목록</h2>
    <div class="table-responsive container">
      <div class="d-flex justify-content-center">
        <div v-if="!qnas">
          Q&A가 존재하지 않습니다~.~<br />글을 작성해보세요!
        </div>
        <table
          v-else
          class="table table-hover table-fixed text-center accordion accordion-flush"
          id="qna-table"
        >
          <thead class="table-light">
            <tr>
              <th scope="col" class="table-index"></th>
              <th scope="col" class="table-title">제목</th>
              <th scope="col" class="table-writer">작성자</th>
              <th scope="col" class="table-date">등록일</th>
              <th scope="col" class="table-hit">조회</th>
            </tr>
          </thead>
          <qna-list-item
            v-for="qna in qnas"
            :key="qna.idx"
            :qna="qna"
            @click.native="setQnaDetail(qna.idx)"
          ></qna-list-item>
        </table>
      </div>
      <div class="d-flex justify-content-center">
        <div class="row">
          <div id="custom-btn-div" class="col-md-12 d-flex justify-content-end">
            <button
              class="btn btn-custom btn-lg"
              data-bs-toggle="modal"
              data-bs-target="#write-qna"
            >
              질문하기
            </button>
            <qna-write id="write-qna"></qna-write>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import QnaListItem from "./QnaListItem.vue";
import QnaWrite from "./QnaWrite.vue";

const qnaStore = "qnaStore";
const userStore = "userStore";
export default {
  name: "QnaList",
  components: { QnaListItem, QnaWrite },
  data() {
    return {
      index: null,
    };
  },
  mounted() {
    this.getQnaList();
  },
  computed: {
    ...mapState(qnaStore, ["qnas", "qna", "qnaId", "isShow"]),
    ...mapState(userStore, ["isLogin", "userInfo"]),
  },
  methods: {
    ...mapActions(qnaStore, ["qnaList", "viewQna", "getQnaReply"]),
    async getQnaList() {
      try {
        await this.qnaList();
      } catch (e) {
        console.log(e.response.data.message);
      }
    },
    async setQnaDetail(index) {
      await this.viewQna(index);
      await this.getQnaReply(index);
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
.delay-zero {
  transition: none;
}
</style>

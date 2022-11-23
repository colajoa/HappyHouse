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
          <tbody>
            <template v-for="qna in qnas">
              <tr
                :key="qna.idx"
                data-bs-toggle="collapse"
                :data-bs-target="'#qna' + qna.idx"
              >
                <td>{{ qna.idx }}</td>
                <td class="view-btn accordion-item" @click="getQna(qna.idx)">
                  {{ qna.title }}
                </td>
                <td>{{ qna.writer }}</td>
                <td>{{ qna.createdat }}</td>
                <td>{{ qna.hit }}</td>
              </tr>

              <!--QnA-->
              <tr
                :key="qna.idx"
                class="accordion-collapse collapse delay-zero"
                :id="'qna' + qna.idx"
                data-bs-parent="#qna-table"
              >
                <td>Q</td>
                <td class="qna-content" colspan="3">
                  {{ qna.content }}
                </td>
                <td
                  class="qna-button d-flex justify-content-center"
                  v-if="userInfo.role == user"
                >
                  <button>수정</button>
                </td>
                <td v-if="userInfo.role != user"></td>
              </tr>
              <qna-reply :key="qna.idx" :qna="qna"></qna-reply>
            </template>
          </tbody>
        </table>
      </div>
      <div class="d-flex justify-content-center">
        <div class="row">
          <div id="custom-btn-div" class="col-md-12 d-flex justify-content-end">
            <router-link
              class="btn btn-custom btn-lg"
              :to="{ name: 'qnawrite' }"
              >질문하기</router-link
            >
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import QnaReply from "./QnaReply.vue";
// import QnaView from "./QnaView.vue";
import { mapActions, mapState } from "vuex";

const qnaStore = "qnaStore";
const userStore = "userStore";
export default {
  name: "QnaList",
  // components: { QnaView },
  data() {
    return {
      idx: null,
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
    ...mapActions(qnaStore, ["qnaList", "detailQna", "setQnaId", "viewQna"]),
    async getQnaList() {
      try {
        await this.qnaList();
      } catch (e) {
        console.log(e.response.data.message);
      }
    },
    async getQna(index) {
      this.setQnaId(index);
      await this.viewQna(this.qnaId);
      await this.detailQna(this.qnaId);
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

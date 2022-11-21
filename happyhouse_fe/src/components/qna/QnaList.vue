<template>
  <div>
    <h2 class="text-center fw-normal" style="color: #2f4d5a">질문 목록</h2>
    <div class="table-responsive container">
      <div class="d-flex justify-content-center">
        <table class="table table-hover table-fixed text-center accordion">
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
              <tr :key="qna">
                <td>{{ qna.articleno }}</td>
                <td>
                  <router-link
                    :to="{
                      name: 'qnaview',
                      params: { articleno: data.item.articleno },
                    }"
                    >{{ qna.title }}</router-link
                  >
                </td>
                <td>{{ qna.author }}</td>
                <td>{{ qna.date }}</td>
                <td>{{ qna.hit }}</td>
              </tr>
              <tr :key="qna">
                <td>{{ qna.content }}</td>
              </tr>
              <qna-reply :key="qna" :qnaid="qnaid"></qna-reply>
            </template>
            <!--여기 위에는 진짜 출력-->
            <tr>
              <th scope="row">1</th>
              <td>
                <router-link
                  class="view-btn"
                  :to="{
                    name: 'qnaview',
                    params: { articleno: 1 },
                  }"
                  >테스트 링크</router-link
                >
              </td>
              <td>koreakoreakorea</td>
              <td>2022.11.20</td>
              <td>1</td>
            </tr>
            <tr>
              <th scope="row">2</th>
              <td>2</td>
              <td>2</td>
              <td>2</td>
              <td>1</td>
            </tr>
            <tr>
              <th scope="row">3</th>
              <td>3</td>
              <td>3</td>
              <td>3</td>
              <td>1</td>
            </tr>
            <tr>
              <th scope="row">4</th>
              <td>4</td>
              <td>4</td>
              <td>4</td>
              <td>1</td>
            </tr>
            <tr>
              <th scope="row">5</th>
              <td>5</td>
              <td>5</td>
              <td>5</td>
              <td>1</td>
            </tr>
            <tr>
              <th scope="row">6</th>
              <td>6</td>
              <td>6</td>
              <td>6</td>
              <td>1</td>
            </tr>
            <tr>
              <th scope="row">7</th>
              <td>7</td>
              <td>7</td>
              <td>7</td>
              <td>1</td>
            </tr>
            <tr>
              <th scope="row">8</th>
              <td>8</td>
              <td>8</td>
              <td>8</td>
              <td>1</td>
            </tr>
            <tr>
              <th scope="row">9</th>
              <td>9</td>
              <td>9</td>
              <td>9</td>
              <td>1</td>
            </tr>
            <tr>
              <th scope="row">10</th>
              <td>10</td>
              <td>10</td>
              <td>10</td>
              <td>1</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="d-flex justify-content-center">
        <div class="row">
          <div id="custom-btn-div" class="col-md-12 d-flex justify-content-end">
            <router-link
              class="btn btn-custom btn-lg"
              :to="{ name: 'qnawrite' }"
              >글쓰기</router-link
            >
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import QnaReply from "./QnaReply.vue";

export default {
  components: { QnaReply },
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

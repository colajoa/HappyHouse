<template>
  <div>
    <h2 class="text-center fw-normal" style="color: #2f4d5a">질문 목록</h2>
    <div class="table-responsive container">
      <div class="d-flex justify-content-center">
        <table class="table table-hover table-fixed text-center">
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
            <tr>
              <th scope="row">1</th>
              <td>1</td>
              <td>1</td>
              <td>1</td>
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
            <router-link class="btn btn-custom" :to="{ name: 'qnawrite' }"
              >글쓰기</router-link
            >
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scopeed>
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
</style>

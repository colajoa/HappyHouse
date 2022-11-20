<template>
  <div>
    <h2 class="text-center fw-normal" style="color: #2f4d5a">공지사항 등록</h2>
    <div class="table-responsive container">
      <table class="table table-hover table-fixed text-center">
        <thead class="table-light">
          <tr>
            <th scope="col">#</th>
            <th scope="col">First</th>
            <th scope="col">Last</th>
            <th scope="col">Handle</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
            <td>@fat</td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>Larry the Bird</td>
            <td>As</td>
            <td>@twitter</td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>Larry the Bird</td>
            <td>As</td>
            <td>@twitter</td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>Larry the Bird</td>
            <td>As</td>
            <td>@twitter</td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>Larry the Bird</td>
            <td>As</td>
            <td>@twitter</td>
          </tr>
        </tbody>
      </table>
      <div class="row">
        <div
          id="custom-btn-div"
          class="col-md-12 d-flex justify-content-end gap-2"
        >
          <button class="btn btn-custom">작성</button>
          <router-link class="btn btn-custom" :to="{ name: 'boardlist' }"
            >취소</router-link
          >
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
h2 {
  padding: 10px;
  margin-top: revert;
  margin-bottom: revert;
}
</style>

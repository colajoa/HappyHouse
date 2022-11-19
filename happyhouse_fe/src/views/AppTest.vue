<template>
  <div>
    <div class="blank"></div>
    <h2 class="text-center">공지사항 목록</h2>
    <div class="table-responsive container">
      <div class="row">
        <div class="gap-2 col-md-12 d-flex justify-content-end">
          <router-link class="btn btn-custom" :to="{ name: 'qna' }"
            >질문받는다.</router-link
          >
          <button type="button" class="btn btn-custom">글쓰기</button>
        </div>
      </div>
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
    </div>

    <ul class="nav nav-tabs" id="myTab" role="tablist">
      <li class="nav-item" role="presentation">
        <button
          class="nav-link active"
          id="home-tab"
          data-bs-toggle="tab"
          data-bs-target="#home-tab-pane"
          type="button"
          role="tab"
          aria-controls="home-tab-pane"
          aria-selected="true"
        >
          Home
        </button>
      </li>
      <li class="nav-item" role="presentation">
        <button
          class="nav-link"
          id="profile-tab"
          data-bs-toggle="tab"
          data-bs-target="#profile-tab-pane"
          type="button"
          role="tab"
          aria-controls="profile-tab-pane"
          aria-selected="false"
        >
          Profile
        </button>
      </li>
      <li class="nav-item" role="presentation">
        <button
          class="nav-link"
          id="contact-tab"
          data-bs-toggle="tab"
          data-bs-target="#contact-tab-pane"
          type="button"
          role="tab"
          aria-controls="contact-tab-pane"
          aria-selected="false"
        >
          Contact
        </button>
      </li>
      <li class="nav-item" role="presentation">
        <button
          class="nav-link"
          id="disabled-tab"
          data-bs-toggle="tab"
          data-bs-target="#disabled-tab-pane"
          type="button"
          role="tab"
          aria-controls="disabled-tab-pane"
          aria-selected="false"
          disabled
        >
          Disabled
        </button>
      </li>
    </ul>
    <div class="tab-content" id="myTabContent">
      <div
        class="tab-pane fade show active"
        id="home-tab-pane"
        role="tabpanel"
        aria-labelledby="home-tab"
        tabindex="0"
      >
        ...
      </div>
      <div
        class="tab-pane fade"
        id="profile-tab-pane"
        role="tabpanel"
        aria-labelledby="profile-tab"
        tabindex="0"
      >
        ...
      </div>
      <div
        class="tab-pane fade"
        id="contact-tab-pane"
        role="tabpanel"
        aria-labelledby="contact-tab"
        tabindex="0"
      >
        ...
      </div>
      <div
        class="tab-pane fade"
        id="disabled-tab-pane"
        role="tabpanel"
        aria-labelledby="disabled-tab"
        tabindex="0"
      >
        ...
      </div>
    </div>
    <div class="container text-center">
      <div class="row">
        <div class="col-md-1">.col-md-2</div>
        <div class="col-md-10">.col-md-8</div>
        <div class="col-md-1">.col-md-2</div>
      </div>
    </div>

    <div class="container">
      <div class="row">
        <div class="col-md-12 gap-2 d-md-flex justify-content-end">
          <button class="btn btn-primary me-md-2" type="button">Button</button>
          <button class="btn btn-primary" type="button">Button</button>
          <button class="btn btn-primary" type="button">Button</button>
          <button class="btn btn-primary" type="button">Button</button>
        </div>
      </div>
      <div class="row">
        <div class="d-grid gap-2 d-md-flex justify-content-end">
          <button class="btn btn-primary me-md-2" type="button">Button</button>
          <button class="btn btn-primary" type="button">Button</button>
          <button class="btn btn-primary" type="button">Button</button>
          <button class="btn btn-primary" type="button">Button</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
};
</script>

<style scoped>
.blank {
  position: relative;
  width: fit-content;
  height: 104px;
}

h2 {
  padding: 10px;
  margin-top: revert;
  margin-bottom: revert;
}

.btn-custom {
  --bs-btn-font-weight: 600;
  --bs-btn-color: white;
  --bs-btn-bg: #67b0d1; /*연한거*/
  --bs-btn-border-radius: 0.5rem;
  --bs-btn-hover-color: white;
  --bs-btn-hover-bg: #409cc5;
  --bs-btn-active-color: var(--bs-btn-color);
  --bs-btn-active-bg: var(--bs-btn-bg);
}

.btn-bd-primary {
  --bs-btn-font-weight: 600;
  --bs-btn-color: var(--bs-white);
  --bs-btn-bg: var(--bs-black);
  --bs-btn-border-color: var(--bd-violet);
  --bs-btn-border-radius: 0.5rem;
  --bs-btn-hover-color: var(--bs-black);
  --bs-btn-hover-bg: #{shade-color($bd-violet, 10%)};
  --bs-btn-hover-border-color: #{shade-color($bd-violet, 10%)};
  --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
  --bs-btn-active-color: var(--bs-btn-hover-color);
  --bs-btn-active-bg: #{shade-color($bd-violet, 20%)};
  --bs-btn-active-border-color: #{shade-color($bd-violet, 20%)};
}
.col-md-12 {
  padding-bottom: 10px;
}
</style>

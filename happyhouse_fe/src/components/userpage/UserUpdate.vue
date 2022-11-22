<template>
  <form>
    <img
      class="mb-4"
      src="@/assets/img/building-logo.png"
      alt=""
      width="100"
      height="100"
    />
    <h1 class="h3 mb-3 fw-normal" style="color: #2f4d5a">회원 정보 수정</h1>
    <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
      <li class="nav-item" role="presentation">
        <button
          class="nav-link active"
          id="info-tab"
          data-bs-toggle="tab"
          data-bs-target="#info-tab-pane"
          type="button"
          role="tab"
          aria-controls="info-tab-pane"
          aria-selected="true"
        >
          회원정보 수정
        </button>
      </li>
      <li class="nav-item" role="presentation">
        <button
          class="nav-link"
          id="password-tab"
          data-bs-toggle="tab"
          data-bs-target="#password-tab-pane"
          type="button"
          role="tab"
          aria-controls="password-tab-pane"
          aria-selected="false"
        >
          비밀번호 변경
        </button>
      </li>
    </ul>
    <div class="tab-content" id="myTabContent">
      <div
        class="tab-pane fade show active"
        id="info-tab-pane"
        role="tabpanel"
        aria-labelledby="info-tab"
        tabindex="0"
      >
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="form-first"
            placeholder="이름"
            v-model="name"
          />
          <label for="floatingInput">이름</label>
        </div>

        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="form-last"
            placeholder="전화번호"
            v-model="phoneNumber"
          />
          <label for="floatingInput">전화번호</label>
        </div>
        <button
          type="button"
          class="w-100 btn btn-lg btn-custom"
          @click="update"
        >
          회원정보 수정
        </button>
      </div>
      <!--비밀번호 변경-->
      <div
        class="tab-pane fade"
        id="password-tab-pane"
        role="tabpanel"
        aria-labelledby="password-tab"
        tabindex="0"
      >
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="form-first"
            placeholder="현재 비밀번호"
            v-model="password"
          />
          <label for="floatingInput">현재 비밀번호</label>
        </div>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="form-last"
            placeholder="새로운 비밀번호"
            v-model="newPassword"
          />
          <label for="floatingIput">새로운 비밀번호</label>
        </div>
        <button
          type="button"
          class="w-100 btn btn-lg btn-custom"
          @click="findId"
        >
          비밀번호 변경
        </button>
      </div>
    </div>
  </form>
</template>

<script>
export default {};
</script>

<style scoped>
.form-user .form-floating:focus-within {
  z-index: 2;
}

.form-user input#form-first {
  margin-top: 10px;
  margin-bottom: -1px;
  border-bottom-left-radius: 0;
  border-bottom-right-radius: 0;
}
.form-user input#form-middle {
  margin-bottom: -1px;
  border-radius: 0;
}
.form-user input#form-last {
  margin-bottom: 10px;
  border-top-right-radius: 0;
  border-top-left-radius: 0;
}

.nav-link {
  color: #67b0d1;
}
</style>

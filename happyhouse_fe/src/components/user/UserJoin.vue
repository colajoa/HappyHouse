<template>
  <form>
    <img
      class="mb-4"
      src="@/assets/img/building-logo.png"
      alt=""
      width="100"
      height="100"
    />
    <h1 class="h3 mb-3 fw-normal">HappyHouse</h1>

    <div class="form-floating">
      <input
        type="text"
        class="form-control"
        id="join-first"
        placeholder="아이디"
      />
      <label for="floatingInput">이름</label>
    </div>
    <div class="form-floating">
      <input
        type="password"
        class="form-control"
        id="join-middle"
        placeholder="아이디"
      />
      <label for="floatingInput">아이디</label>
    </div>
    <div class="form-floating">
      <input
        type="password"
        class="form-control"
        id="join-middle"
        placeholder="비밀번호"
      />
      <label for="floatingPassword">비밀번호</label>
    </div>
    <div class="form-floating">
      <input
        type="text"
        class="form-control"
        id="join-last"
        placeholder="전화번호"
      />
      <label for="floatingInput">전화번호</label>
    </div>

    <button class="w-100 btn btn-lg btn-primary">회원가입</button>
  </form>
</template>

<script>
export default {};
</script>

<style scoped>
.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-user input#join-first[type="text"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-user input#join-middle {
  margin-bottom: -1px;
  border-radius: 0;
}

.form-user input#join-last[type="text"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

.span-inline {
  display: inline-block;
  padding: 10px 15px;
  margin: 10px;
}
</style>

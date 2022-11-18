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
        id="floatingInput"
        placeholder="아이디"
      />
      <label for="floatingInput">아이디</label>
    </div>
    <div class="form-floating">
      <input
        type="password"
        class="form-control"
        id="floatingPassword"
        placeholder="비밀번호"
      />
      <label for="floatingPassword">비밀번호</label>
    </div>

    <button class="w-100 btn btn-lg btn-primary">로그인</button>
    <router-link :to="{ name: 'join' }">
      <span class="span-inline">회원가입</span>
    </router-link>
    <router-link :to="{ name: 'find' }">
      <span class="span-inline">아이디 / 비밀번호 찾기</span>
    </router-link>
  </form>
</template>

<script>
export default {};
</script>

<style scoped>
.form-user .form-floating:focus-within {
  z-index: 2;
}

.form-user input[type="text"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-user input[type="password"] {
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

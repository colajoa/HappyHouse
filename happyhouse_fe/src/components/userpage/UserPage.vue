<template>
  <form>
    <img
      class="mb-4"
      src="@/assets/img/building-logo.png"
      alt=""
      width="100"
      height="100"
    />
    <h2 class="mb-3" style="color: #2f4d5a">여기는 회원 이름</h2>

    <div class="">
      <div class="form-control" id="form-first" ref="name">
        <label></label>
      </div>
    </div>
    <div>
      <div class="form-control" id="form-middle" ref="id">
        <label>아이디</label>
      </div>
    </div>
    <div class="">
      <div class="form-control" id="form-middle" ref="password">
        <label>비밀번호</label>
      </div>
    </div>
    <div class="">
      <div class="form-control" id="form-last" ref="phoneNumber">
        <label>전화번호</label>
      </div>
    </div>

    <router-link :to="{ name: 'userupdate' }">
      <span id="custom-link" class="span-inline userupdate-btn">정보수정</span>
    </router-link>
    <router-link :to="{ name: 'userdelete' }">
      <span id="custom-link" class="span-inline userdelete-btn">회원탈퇴</span>
    </router-link>
  </form>
</template>

<script>
export default {};
</script>

<style scoped>
.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-user input#form-first[type="text"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-user input#form-middle {
  margin-bottom: -1px;
  border-radius: 0;
}

.form-user input#form-last[type="text"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

.span-inline {
  display: inline-block;
  padding: 10px 15px;
  margin: 15px;
}

.userupdate-btn {
  margin-right: 40px;
}

.userdelete-btn {
  margin-left: 40px;
}
#custom-link {
  color: #2f4d5a;
}

#custom-link:hover {
  color: #409cc5;
}
</style>

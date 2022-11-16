<template>
  <div>
    <h2>로그인 페이지</h2>
  </div>
</template>

<script>
export default {
  name: "UserLogin",
  data() {
    return {
      isLoginError: false,
      user: {
        userid: null,
        userpwd: null,
      },
    };
  },
};
</script>

<style></style>

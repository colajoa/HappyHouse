<template>
  <div></div>
</template>

<script>
import { mapActions, mapState } from "vuex";

const userStore = "userStore";

export default {
  name: "kakaoLogin",
  created() {
    if (this.$route.query.code) {
      this.login(this.$route.query.code);
    }
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  methods: {
    ...mapActions(userStore, ["setKakaoToken", "getKakaoToken"]),
    async login(code) {
      const { data } = await this.getKakaoToken(code);
      if (data.error) {
        alert("카카오톡 로그인 중 오류 발생");
        this.$router.replace("/user/login");
        return;
      }
      const result = await this.setKakaoToken(data);
      if (result != "OK") this.$router.push("/user/login");
      else this.$router.push("/");
    },
  },
};
</script>

<style></style>

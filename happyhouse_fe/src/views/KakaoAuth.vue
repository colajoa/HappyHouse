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
    ...mapActions(userStore, ["setKakaoToken"]),
    async login(code) {
      await this.setKakaoToken(code);
    },
  },
};
</script>

<style></style>

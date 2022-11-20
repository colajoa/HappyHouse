<template>
  <div></div>
</template>

<script>
import axios from "axios";
import http from "@/api/axios";
export default {
  name: "kakaoLogin",
  created() {
    if (this.$route.query.code) {
      this.setKakaoToken(this.$route.query.code);
    }
  },
  methods: {
    async setKakaoToken(code) {
      const { data } = await this.getKakaoToken(code);
      if (data.error) {
        alert("카카오톡 로그인 중 오류 발생");
        this.$router.replace("/user/login");
        return;
      }

      window.Kakao.Auth.setAccessToken(data.access_token);
      await http
        .post(
          "/house/user/login/kakao",
          JSON.stringify({ code: data.access_token })
        )
        .then((res) => {
          if (res.data == "OK") {
            this.$router.replace("/");
          } else {
            this.$router.replace("/user/login");
          }
        });
    },
    async getKakaoToken(code) {
      try {
        const data = {
          grant_type: "authorization_code",
          client_id: process.env.VUE_APP_CLIENT_ID,
          redirect_uri: "http://localhost:8080/kakao/login",
          code,
        };
        const queryString = Object.keys(data)
          .map((k) => encodeURIComponent(k) + "=" + encodeURIComponent(data[k]))
          .join("&");

        const result = await axios.post(
          `https://kauth.kakao.com/oauth/token`,
          queryString,
          {
            headers: {
              Authorization: "y5LuBjKrq1mLtRwRvJGcJiyA3D7rE2Z9",
              "Content-Type": "application/x-www-form-urlencoded",
            },
          }
        );
        return result;
      } catch (e) {
        console.log(e);
        return e;
      }
    },
  },
};
</script>

<style></style>

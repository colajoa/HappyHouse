import http from "@/api/axios.js";
import axios from "axios";

const userStore = {
  namespaced: true,
  state: {
    isLogin: false,
    isLoginError: false,
    userInfo: null,
    isValidToken: false,
  },
  getters: {
    checkUserInfo: function (state) {
      return state.userInfo;
    },
    checkToken: function (state) {
      return state.isValidToken;
    },
  },
  mutations: {
    SET_IS_LOGIN: (state, isLogin) => {
      state.isLogin = isLogin;
    },
    SET_IS_LOGIN_ERROR: (state, isLoginError) => {
      state.isLoginError = isLoginError;
    },
    SET_IS_VALID_TOKEN: (state, isValidToken) => {
      state.isValidToken = isValidToken;
    },
    SET_USER_INFO: (state, userInfo) => {
      state.isLogin = true;
      state.userInfo = userInfo;
    },
  },
  actions: {
    // 회원가입
    async userJoin(state, user) {
      await http.post("/house/user/join", user).then((res) => {
        if (res.status == 200) {
          return;
        }
      });
    },
    // Login
    async userConfirm({ commit }, user) {
      await http.post("/house/user/login", user).then((res) => {
        if (res.status == 200) {
          commit("SET_IS_LOGIN", true);
          commit("SET_IS_LOGIN_ERROR", false);
          commit("SET_IS_VALID_TOKEN", true);
          sessionStorage.setItem("token", res.data.token);
        }
      });
    },
    // Kakao Login
    async kakaoLogin() {
      window.Kakao.Auth.authorize({
        redirectUri: process.env.VUE_APP_REDIRECT_URI,
      });
    },
    // Set kakao AccessToken
    async setKakaoToken({ commit }, code) {
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
          // 성공
          if (res.data == "OK") {
            commit("SET_IS_LOGIN", true);
            commit("SET_IS_LOGIN_ERROR", false);
            commit("SET_IS_VALID_TOKEN", true);
            sessionStorage.setItem("token", data.access_token);
            this.$router.replace("/");
          }
          // 실패
          else {
            commit("SET_IS_LOGIN", false);
            commit("SET_IS_LOGIN_ERROR", true);
            commit("SET_IS_VALID_TOKEN", false);
            this.moveToLogin();
          }
        });
    },
    // Generate kakao AccessToken
    async getKakaoToken(code) {
      try {
        const data = {
          grant_type: "authorization_code",
          client_id: process.env.VUE_APP_CLIENT_ID,
          redirect_uri: process.env.VUE_APP_REDIRECT_URI,
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
              Authorization: process.env.VUE_APP_CLIENT_SECRET,
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
    // Logout
    async userLogout({ commit }) {
      await http.get("/house/user/logout").then((res) => {
        if (res.data == "OK") {
          sessionStorage.removeItem("token");
          commit("SET_IS_LOGIN", false);
          commit("SET_IS_LOGIN_ERROR", false);
          commit("SET_IS_VALID_TOKEN", false);
        }
      });
    },
    // 회원 정보 찾기
    async getUserInfo({ commit }) {
      await http
        .get("/house/user/info")
        .then((res) => {
          if (res.status == 200) {
            commit("SET_USER_INFO", res.data);
          } else {
            console.log("유저 정보 없음");
          }
        })
        .catch((e) => {
          console.log(e);
          commit("SET_IS_LOGIN", false);
          commit("SET_IS_VALID_TOKEN", false);
          this.moveToLogin();
        });
    },
    // 아이디 찾기
    async getUserId(state, user) {
      const id = await http.post("/house/user/id", user).then((res) => {
        if (res.status == 200) {
          return res.data;
        }
      });
      return id;
    },
    // 비밀번호 찾기
    async setNewPassword(user) {
      await http.post("/house/user/pwd", user);
    },
    moveToLogin() {
      this.$router.replace("/user/login");
    },
  },
};

export default userStore;

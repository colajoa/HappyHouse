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
      await http.post("/house/user/join", user);
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
    async setKakaoToken({ commit }, data) {
      window.Kakao.Auth.setAccessToken(data.access_token);
      return await http
        .post(
          "/house/user/login/kakao",
          JSON.stringify({ code: data.access_token })
        )
        .then(function (res) {
          // 성공
          if (res.data == "OK") {
            commit("SET_IS_LOGIN", true);
            commit("SET_IS_LOGIN_ERROR", false);
            commit("SET_IS_VALID_TOKEN", true);
            sessionStorage.setItem("token", data.access_token);
          }
          // 실패
          else {
            commit("SET_IS_LOGIN", false);
            commit("SET_IS_LOGIN_ERROR", true);
            commit("SET_IS_VALID_TOKEN", false);
          }
          return res.data;
        });
    },
    // Generate kakao AccessToken
    async getKakaoToken(state, authcode) {
      try {
        const data = {
          grant_type: "authorization_code",
          client_id: process.env.VUE_APP_CLIENT_ID,
          redirect_uri: process.env.VUE_APP_REDIRECT_URI,
          code: authcode,
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
          commit("SET_USER_INFO", null);
        }
      });
    },
    // 회원 정보 찾기
    async getUserInfo({ commit }, { from, token }) {
      console.log(from);
      http.defaults.headers["Authorization"] = token;
      await http
        .get(`/house/user/info/${from}`)
        .then((res) => {
          if (res.status == 200) {
            commit("SET_USER_INFO", res.data);
          } else {
            console.log("유저 정보 없음");
          }
        })
        .catch(function (e) {
          console.log(e);
          commit("SET_IS_LOGIN", false);
          commit("SET_IS_VALID_TOKEN", false);
          this.$router.replace("/user/login");
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
    async getUserByPassword(state, user) {
      await http.post("/house/user/pwd", user);
    },
    // 아이디 중복 검사
    async checkDuplicateId(state, id) {
      await http.get(`/house/user/check/${id}`);
    },
    // 유저 정보 수정
    async changeUserInfo(state, user) {
      await http.put("/house/user/update", user);
    },
    // 비밀번호 수정
    async changePassword(state, pwds) {
      await http.post("/house/user/changepwd", pwds);
    },
    // 회원 탈퇴하기
    async withdrawUser({ commit }, pwd) {
      await http.post("/house/user/withdraw", pwd).then((res) => {
        if (res.status == 200) {
          commit("SET_USER_INFO", null);
          commit("SET_IS_LOGIN", false);
          commit("SET_IS_LOGIN_ERROR", false);
          commit("SET_IS_VALID_TOKEN", false);
        }
      });
    },
  },
};

export default userStore;

<template>
  <form>
    <img
      class="mb-4"
      src="@/assets/img/building-logo.png"
      alt=""
      width="100"
      height="100"
    />
    <h1 class="h3 mb-3 fw-normal" style="color: #2f4d5a">HappyHouse</h1>
    <div class="form-floating">
      <input
        type="text"
        class="form-control"
        id="floatingInput"
        placeholder="아이디"
        v-model="id"
        ref="id"
      />
      <label for="floatingInput">아이디</label>
    </div>
    <div class="form-floating">
      <input
        type="password"
        class="form-control"
        id="floatingPassword"
        placeholder="비밀번호"
        v-model="password"
        ref="password"
      />
      <label for="floatingPassword">비밀번호</label>
    </div>

    <div>
      <button type="button" class="w-100 btn btn-lg btn-custom" @click="login">
        로그인
      </button>
      <a
        href="javascript:void(0)"
        class="login-button__item login-button__item--kakao kakao-login-btn"
        id="loginWithKakao"
        @click="kakaoLogin"
      >
        <svg
          width="30"
          height="30"
          viewBox="0 0 30 30"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
          class="login-button__item__logo"
        >
          <title>kakao 로고</title>
          <path
            fill-rule="evenodd"
            clip-rule="evenodd"
            d="M15 7C10.029 7 6 10.129 6 13.989C6 16.389 7.559 18.505 9.932 19.764L8.933 23.431C8.845 23.754 9.213 24.013 9.497 23.826L13.874 20.921C14.243 20.958 14.618 20.978 15 20.978C19.971 20.978 24 17.849 24 13.989C24 10.129 19.971 7 15 7Z"
            fill="black"
          ></path>
        </svg>
        카카오 로그인
      </a>
    </div>
    <router-link :to="{ name: 'join' }">
      <span id="custom-link" class="span-inline">회원가입</span>
    </router-link>
    <router-link :to="{ name: 'find' }">
      <span id="custom-link" class="span-inline">아이디 | 비밀번호 찾기</span>
    </router-link>
  </form>
</template>
<script>
import { mapActions, mapState } from "vuex";

const userStore = "userStore";
export default {
  name: "UserLogin",
  data() {
    return {
      id: null,
      password: null,
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  methods: {
    ...mapActions(userStore, [
      "userConfirm",
      "kakaoLogin",
      "getUserInfo",
      "moveToLogin",
    ]),
    async login() {
      try {
        await this.userConfirm({
          id: this.id,
          secret: this.password,
        });
        if (this.isLogin) {
          const token = sessionStorage.getItem("token");
          await this.getUserInfo(token);
          console.log(this.userInfo);
          this.$router.push({ name: "main" });
        }
      } catch (e) {
        console.log(e);
        if (e.response) {
          // ERROR
          const errorCode = e.response.data.code;
          if (errorCode === "USER_NOT_FOUND") {
            alert("아이디가 존재하지 않습니다.");
            this.$refs.id.focus();
          } else if (errorCode === "INVALID_PASSWORD") {
            alert("비밀번호가 일치하지 않습니다.");
            this.$refs.password.focus();
          } else {
            alert("서버 오류");
          }
        }
      }
    },
  },
};
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

#custom-link {
  color: #2f4d5a;
}

#custom-link:hover {
  color: #409cc5;
}

.login-button__item {
  display: block;
  box-sizing: border-box;
  width: 100%;
  height: 50px;
  padding: 14px 16px 15px;
  border: 1px solid #000;
  border-radius: 0.2rem;
  font-weight: 700;
  color: #000;
}

.login-button__item--kakao {
  height: 45px;
  padding-top: 11px;
  padding-bottom: 10px;
  border-color: #fee500;
  background-color: #fee500;
  font-size: 15px;
  line-height: 22px;
}

.kakao-login-btn {
  margin-top: 10px;
  text-decoration: none;
  text-align: center;
}

.login-button__item__logo {
  display: inline-block;
  margin-top: -4px;
  margin-right: -4px;
  vertical-align: top;
}
</style>

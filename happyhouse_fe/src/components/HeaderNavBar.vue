<template>
  <div>
    <header
      id="header"
      :class="[showBg ? 'fixed-top' : 'fixed-top header-transparent']"
    >
      <div class="container d-flex align-items-center justify-content-between">
        <div class="logo">
          <h1 class="text-light">
            <router-link :to="{ name: 'main' }"
              ><span>HappyHouse</span></router-link
            >
          </h1>
          <!-- Uncomment below if you prefer to use an image logo -->
          <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
        </div>

        <nav id="navbar" class="navbar">
          <!--로그인 전-->
          <ul>
            <li>
              <router-link class="nav-link scrollto" :to="{ name: 'board' }"
                >공지사항</router-link
              >
            </li>
            <li>
              <router-link class="nav-link scrollto" :to="{ name: 'user' }"
                >로그인 | 회원가입</router-link
              >
            </li>
            <i class="bi bi-list mobile-nav-toggle"></i>
          </ul>

          <!--로그인 후-->
          <ul>
            <li>
              <router-link class="nav-link scrollto" :to="{ name: 'test' }"
                >테스트 페이지</router-link
              >
            </li>
            <li>
              <router-link class="nav-link scrollto" :to="{ name: 'apt' }"
                >아파트 거래정보</router-link
              >
            </li>
            <li>
              <router-link class="nav-link scrollto" :to="{ name: 'board' }"
                >공지사항</router-link
              >
            </li>
            <li>
              <router-link class="nav-link scrollto" :to="{ name: 'qna' }"
                >질문받는다</router-link
              >
            </li>
            <li id="mypage">
              <router-link class="nav-link scrollto" :to="{ name: 'mypage' }">
                님
                <!-- {{ userInfo.name }}님 -->
              </router-link>
            </li>
            <!-- click 버튼 -->
            <li id="mypage">
              <router-link class="nav-link scrollto" :to="{ name: 'mypage' }">
                님
                <!-- {{ userInfo.name }}님 -->
              </router-link>
            </li>
            <li>
              <button class="nav-link scrollto" @click="logout">
                로그아웃
              </button>
            </li>
          </ul>
          <i class="bi bi-list mobile-nav-toggle"></i>
        </nav>
        <!-- .navbar -->
      </div>
    </header>
  </div>
</template>

<script>
import { mapGetters, mapState, mapActions } from "vuex";

const userStore = "userStore";
export default {
  name: "HeaderNavBar",
  data() {
    return {
      showBg: true,
    };
  },
  props: ["isBg"],
  created() {
    this.showBg = this.isBg;
  },
  computed: {
    ...mapState(userStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
  watch: {
    isBg() {
      this.showBg = this.isBg;
    },
  },
  methods: {
    ...mapActions(userStore, ["userLogout"]),
    async logout() {
      await this.userLogout();
    },
  },
};
</script>

<style scoped>
.navbar button {
  background: none;
  border: none;
}
</style>

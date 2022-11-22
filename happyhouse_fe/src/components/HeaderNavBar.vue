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

            <li class="dropdown">
              <a href="#"><span>Drop Down</span></a>
              <ul>
                <li><a href="#">Drop Down 1</a></li>

                <li><a href="#">Drop Down 2</a></li>
              </ul>
            </li>
            <!-- dropdown 버튼 -->
            <li id="mypage">
              <label for="user-btn">
                사용자님
                <!-- {{ userInfo.name }}님 -->
              </label>
              <input
                type="checkbox"
                id="user-btn"
                onclick=""
                autocomplete="off"
              />
              <ul class="user-menu">
                <li>
                  <router-link
                    class="nav-link scrollto"
                    :to="{ name: 'mypage' }"
                  >
                    마이페이지
                  </router-link>
                </li>
                <li>
                  <button class="nav-link scrollto" @click="logout">
                    로그아웃
                  </button>
                </li>
              </ul>
            </li>
            <!--dropdown 버튼 -->
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

#user-btn {
  display: none;
}
.user-menu {
  display: none;
}

#user-btn:checked + .user-menu {
  display: block;
  position: absolute;
  transition: 0.3s;
}
</style>

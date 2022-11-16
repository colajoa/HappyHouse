<template>
  <div>
    <header
      id="header"
      :class="[isBg ? 'fixed-top' : 'fixed-top header-transparent']"
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
          <ul>
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
            <li>
              <router-link class="nav-link scrollto" :to="{ name: 'user' }"
                >로그인 | 회원가입</router-link
              >
            </li>
          </ul>
        </nav>
        <!-- .navbar -->
      </div>
    </header>
  </div>
</template>

<script>
export default {
  name: "HeaderNavBar",
  data() {
    return {};
  },
  props: ["isBg"],
};
</script>

<style scoped></style>

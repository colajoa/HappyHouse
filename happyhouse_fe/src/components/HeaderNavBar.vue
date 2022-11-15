<template>
  <div>
    <header id="header" class="fixed-top header-transparent">
      <div class="container d-flex align-items-center justify-content-between">
        <div class="logo">
          <h1 class="text-light">
            <a href="/"><span>HappyHouse</span></a>
          </h1>
          <!-- Uncomment below if you prefer to use an image logo -->
          <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
        </div>

        <nav id="navbar" class="navbar">
          <ul>
            <li><a class="nav-link scrollto active" href="#hero">홈</a></li>
            <li>
              <a class="nav-link scrollto" href="#about">아파트 거래 정보</a>
            </li>
            <li><a class="nav-link scrollto" href="#services">공지사항</a></li>
            <li>
              <a class="nav-link scrollto" href="#portfolio">질문받는다</a>
            </li>
            <li>
              <a class="nav-link scrollto" href="#team">로그인 | 회원가입</a>
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
export default {
  name: "HeaderNavBar",
  data() {
    return {};
  },
};
</script>

<style></style>

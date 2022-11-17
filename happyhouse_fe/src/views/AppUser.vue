<template>
  <main id="main">
    <div id="divbody" class="text-center">
      <main class="form-signin w-100 m-auto">
        <form>
          <img
            class="mb-4"
            src="@/assets/img/building-logo.png"
            alt=""
            width="100"
            height="100"
          />
          <h1 class="h3 mb-3 fw-normal">HappyHouse</h1>

          <div class="form-floating">
            <input
              type="text"
              class="form-control"
              id="floatingInput"
              placeholder="아이디"
            />
            <label for="floatingInput">아이디</label>
          </div>
          <div class="form-floating">
            <input
              type="password"
              class="form-control"
              id="floatingPassword"
              placeholder="비밀번호"
            />
            <label for="floatingPassword">비밀번호</label>
          </div>

          <button class="w-100 btn btn-lg btn-primary">로그인</button>
        </form>
      </main>
    </div>
    <!-- ======= Portfolio Details Section ======= -->
    <!-- <section id="portfolio-details" class="portfolio-details">
      <div class="container">
        <div class="row gy-4">
          <div class="col-lg-8">
            <div class="portfolio-details-slider swiper">
              <div class="swiper-wrapper align-items-center">
                <div class="swiper-slide">
                  <img src="assets/img/portfolio/portfolio-1.jpg" alt="" />
                </div>

                <div class="swiper-slide">
                  <img src="assets/img/portfolio/portfolio-2.jpg" alt="" />
                </div>

                <div class="swiper-slide">
                  <img src="assets/img/portfolio/portfolio-3.jpg" alt="" />
                </div>
              </div>
              <div class="swiper-pagination"></div>
            </div>
          </div>

          <div class="col-lg-4">
            <div class="portfolio-info">
              <h3>Project information</h3>
              <ul>
                <li><strong>Category</strong>: Web design</li>
                <li><strong>Client</strong>: ASU Company</li>
                <li><strong>Project date</strong>: 01 March, 2020</li>
                <li>
                  <strong>Project URL</strong>:
                  <a href="#">www.example.com</a>
                </li>
              </ul>
            </div>
            <div class="portfolio-description">
              <h2>This is an example of portfolio detail</h2>
              <p>
                Autem ipsum nam porro corporis rerum. Quis eos dolorem eos
                itaque inventore commodi labore quia quia. Exercitationem
                repudiandae officiis neque suscipit non officia eaque itaque
                enim. Voluptatem officia accusantium nesciunt est omnis tempora
                consectetur dignissimos. Sequi nulla at esse enim cum deserunt
                eius.
              </p>
            </div>
          </div>
        </div>
      </div>
    </section> -->
    <!-- End Portfolio Details Section -->
  </main>
</template>

<script>
export default {};
</script>

<style scoped>
.fixed-top {
  position: relative;
}
#divbody {
  height: 100%;
}
#divbody {
  display: flex;
  align-items: center;
  padding-top: 150px;
  padding-bottom: 200px;
}

.form-signin {
  max-width: 330px;
  padding: 15px;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="text"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>

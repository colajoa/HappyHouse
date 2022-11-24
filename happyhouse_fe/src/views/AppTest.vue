<template>
  <div>
    <div class="blank"></div>
    <h2 class="text-center page-title">공지사항 목록</h2>
    <div class="table-responsive container">
      <div class="row">
        <div class="gap-2 col-md-12 d-flex justify-content-end">
          <router-link class="btn btn-custom btn-lg" :to="{ name: 'qna' }"
            >질문받는다.</router-link
          >
          <button type="button" class="btn btn-lg btn-custom">글쓰기</button>
        </div>
      </div>
      <button
        type="button"
        class="btn btn-primary"
        data-bs-toggle="button"
        aria-pressed="false"
        autocomplete="off"
      >
        Single toggle
      </button>
      <table
        class="table table-hover table-fixed text-center accordion accordion-flush"
        id="accordionFlushExample"
      >
        <thead class="table-light">
          <tr>
            <th scope="col">#</th>
            <th scope="col">First</th>
            <th scope="col">Last</th>
            <th scope="col">Handle</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>
              <div class="accordion-item">
                <h2 class="accordion-header" id="headingOne">
                  <button
                    class="accordion-button collapsed"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#collapseOne"
                    aria-expanded="false"
                    aria-controls="collapseOne"
                  >
                    Accordion Item #1
                  </button>
                </h2>
                <div
                  id="collapseOne"
                  class="accordion-collapse collapse"
                  aria-labelledby="headingOne"
                  data-bs-parent="#accordionFlushExample"
                >
                  <div class="accordion-body">
                    <strong>This is the first item's accordion body.</strong> It
                    is shown by default, until the collapse plugin adds the
                    appropriate classes that we use to style each element. These
                    classes control the overall appearance, as well as the
                    showing and hiding via CSS transitions. You can modify any
                    of this with custom CSS or overriding our default variables.
                    It's also worth noting that just about any HTML can go
                    within the <code>.accordion-body</code>, though the
                    transition does limit overflow.
                  </div>
                </div>
              </div>
            </td>
            <td>Otto</td>
            <td>@mdo</td>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td>
              <div class="accordion-item">
                <h2 class="accordion-header" id="flush-headingTwo">
                  <button
                    class="accordion-button collapsed"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#flush-collapseTwo"
                    aria-expanded="false"
                    aria-controls="flush-collapseTwo"
                  >
                    Accordion Item #2
                  </button>
                </h2>
                <div
                  id="flush-collapseTwo"
                  class="accordion-collapse collapse"
                  aria-labelledby="flush-headingTwo"
                  data-bs-parent="#accordionFlushExample"
                >
                  <div class="accordion-body">
                    Placeholder content for this accordion, which is intended to
                    demonstrate the <code>.accordion-flush</code> class. This is
                    the second item's accordion body. Let's imagine this being
                    filled with some actual content.
                  </div>
                </div>
              </div>
            </td>
            <td>Thornton</td>
            <td>@fat</td>
          </tr>
          <tr>
            <th scope="row">1</th>
            <td data-bs-toggle="collapse" data-bs-target="#test1">
              Larry the Bird
            </td>
            <td>As</td>
            <td>@twitter</td>
          </tr>
          <tr
            class="accordion-collapse collapse ani-test"
            id="test1"
            data-bs-parent="#accordionFlushExample"
          >
            <td>Q</td>
            <td colspan="4">테스트입니다.</td>
          </tr>

          <tr>
            <th scope="row">2</th>
            <td data-bs-toggle="collapse" data-bs-target="#test2">Larry</td>
            <td>As</td>
            <td>@twitter</td>
          </tr>
          <tr
            class="accordion-collapse collapse ani-test"
            id="test2"
            data-bs-parent="#accordionFlushExample"
          >
            <td>Q</td>
            <td colspan="4">테스트입니다.</td>
          </tr>

          <tr>
            <th scope="row">3</th>
            <td>Larry the</td>
            <td>As</td>
            <td>@twitter</td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>Larry the Bird</td>
            <td>As</td>
            <td>@twitter</td>
          </tr>
        </tbody>
      </table>
    </div>

    <ul class="nav nav-tabs" id="myTab" role="tablist">
      <li class="nav-item" role="presentation">
        <button
          class="nav-link active"
          id="home-tab"
          data-bs-toggle="tab"
          data-bs-target="#home-tab-pane"
          type="button"
          role="tab"
          aria-controls="home-tab-pane"
          aria-selected="true"
        >
          Home
        </button>
      </li>
      <li class="nav-item" role="presentation">
        <button
          class="nav-link"
          id="profile-tab"
          data-bs-toggle="tab"
          data-bs-target="#profile-tab-pane"
          type="button"
          role="tab"
          aria-controls="profile-tab-pane"
          aria-selected="false"
        >
          Profile
        </button>
      </li>
      <li class="nav-item" role="presentation">
        <button
          class="nav-link"
          id="contact-tab"
          data-bs-toggle="tab"
          data-bs-target="#contact-tab-pane"
          type="button"
          role="tab"
          aria-controls="contact-tab-pane"
          aria-selected="false"
        >
          Contact
        </button>
      </li>
      <li class="nav-item" role="presentation">
        <button
          class="nav-link"
          id="disabled-tab"
          data-bs-toggle="tab"
          data-bs-target="#disabled-tab-pane"
          type="button"
          role="tab"
          aria-controls="disabled-tab-pane"
          aria-selected="false"
          disabled
        >
          Disabled
        </button>
      </li>
    </ul>

    <div class="tab-content" id="myTabContent">
      <div
        class="tab-pane fade show active"
        id="home-tab-pane"
        role="tabpanel"
        aria-labelledby="home-tab"
        tabindex="0"
      >
        ...
      </div>
      <div
        class="tab-pane fade"
        id="profile-tab-pane"
        role="tabpanel"
        aria-labelledby="profile-tab"
        tabindex="0"
      >
        ...
      </div>
      <div
        class="tab-pane fade"
        id="contact-tab-pane"
        role="tabpanel"
        aria-labelledby="contact-tab"
        tabindex="0"
      >
        ...
      </div>
      <div
        class="tab-pane fade"
        id="disabled-tab-pane"
        role="tabpanel"
        aria-labelledby="disabled-tab"
        tabindex="0"
      >
        ...
      </div>
    </div>
    <div class="container themed-container text-center">
      <div class="row">
        <div class="col-md-1">.col-md-2</div>
        <div class="col-md-10">.col-md-8</div>
        <div class="col-md-1">.col-md-2</div>
      </div>
    </div>

    <div class="container">
      <div class="row">
        <div class="col-md-12 gap-2 d-flex justify-content-end">
          <button class="btn btn-primary" type="button">Button</button>
          <button class="btn btn-primary" type="button">Button</button>
          <button class="btn btn-primary" type="button">Button</button>
          <button class="btn btn-primary" type="button">Button</button>
        </div>
      </div>
      <div class="row">
        <div class="d-grid gap-2 d-md-flex justify-content-end">
          <button class="btn btn-primary" type="button">Button</button>
          <button class="btn btn-primary" type="button">Button</button>
          <button class="btn btn-primary" type="button">Button</button>
          <button class="btn btn-primary" type="button">Button</button>
        </div>
      </div>
    </div>

    <div class="container themed-container">
      <a
        href="javascript:void(0)"
        class="login-button__item login-button__item--kakao kakao-login-btn"
        id="loginWithKakao"
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

    <div class="container">
      <div class="form-floating">
        <textarea
          class="form-control"
          placeholder="Leave a comment here"
          id="floatingTextarea2"
          rows="10"
        ></textarea>
        <label for="floatingTextarea2">Comments</label>
      </div>
    </div>

    <div class="container">
      <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label"
          >Email address</label
        >
        <input
          type="email"
          class="form-control"
          id="exampleFormControlInput1"
          placeholder="name@example.com"
        />
      </div>
      <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label"
          >Example textarea</label
        >
        <textarea
          class="form-control"
          id="exampleFormControlTextarea1"
          rows="10"
        ></textarea>
      </div>
    </div>

    <!-- <div class="container">
      <div class="accordion accordion-flush" id="accordionExample">
        <div class="accordion-item">
          <h2 class="accordion-header" id="headingOne">
            <button
              class="accordion-button collapsed"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#collapseOne"
              aria-expanded="false"
              aria-controls="collapseOne"
            >
              Accordion Item #1
            </button>
          </h2>
          <div
            id="collapseOne"
            class="accordion-collapse collapse"
            aria-labelledby="headingOne"
            data-bs-parent="#accordionExample"
          >
            <div class="accordion-body">
              <strong>This is the first item's accordion body.</strong> It is
              shown by default, until the collapse plugin adds the appropriate
              classes that we use to style each element. These classes control
              the overall appearance, as well as the showing and hiding via CSS
              transitions. You can modify any of this with custom CSS or
              overriding our default variables. It's also worth noting that just
              about any HTML can go within the <code>.accordion-body</code>,
              though the transition does limit overflow.
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header" id="headingTwo">
            <button
              class="accordion-button collapsed"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#collapseTwo"
              aria-expanded="false"
              aria-controls="collapseTwo"
            >
              Accordion Item #2
            </button>
          </h2>
          <div
            id="collapseTwo"
            class="accordion-collapse collapse"
            aria-labelledby="headingTwo"
            data-bs-parent="#accordionExample"
          >
            <div class="accordion-body">
              <strong>This is the second item's accordion body.</strong> It is
              hidden by default, until the collapse plugin adds the appropriate
              classes that we use to style each element. These classes control
              the overall appearance, as well as the showing and hiding via CSS
              transitions. You can modify any of this with custom CSS or
              overriding our default variables. It's also worth noting that just
              about any HTML can go within the <code>.accordion-body</code>,
              though the transition does limit overflow.
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header" id="headingThree">
            <button
              class="accordion-button collapsed"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#collapseThree"
              aria-expanded="false"
              aria-controls="collapseThree"
            >
              Accordion Item #3
            </button>
          </h2>
          <div
            id="collapseThree"
            class="accordion-collapse collapse"
            aria-labelledby="headingThree"
            data-bs-parent="#accordionExample"
          >
            <div class="accordion-body">
              <strong>This is the third item's accordion body.</strong> It is
              hidden by default, until the collapse plugin adds the appropriate
              classes that we use to style each element. These classes control
              the overall appearance, as well as the showing and hiding via CSS
              transitions. You can modify any of this with custom CSS or
              overriding our default variables. It's also worth noting that just
              about any HTML can go within the <code>.accordion-body</code>,
              though the transition does limit overflow.
            </div>
          </div>
        </div>
      </div>
    </div> -->

    <div class="conatiner">
      <div class="accordion accordion-flush" id="accordionExample">
        <div class="accordion-item">
          <h2 class="accordion-header" id="headingOne">
            <button
              class="accordion-button collapsed"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#accordionCollapseOne"
              aria-expanded="false"
              aria-controls="accordionCollapseOne"
            >
              Lorem ipsum dolor sit amet consectetur.
            </button>
          </h2>
          <div
            id="accordionCollapseOne"
            class="accordion-collapse collapse"
            aria-labelledby="headingOne"
            data-bs-parent="#accordionExample"
          >
            <div class="accordion-body">
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo quam
              dolore ea pariatur veniam rem voluptatibus harum magni reiciendis
              maiores!
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header" id="headingTwo">
            <button
              class="accordion-button collapsed"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#accordionCollapseTwo"
              aria-expanded="false"
              aria-controls="accordionCollapseTwo"
            >
              Lorem ipsum dolor, sit amet consectetur adipisicing.
            </button>
          </h2>
          <div
            id="accordionCollapseTwo"
            class="accordion-collapse collapse"
            aria-labelledby="headingTwo"
            data-bs-parent="#accordionExample"
          >
            <div class="accordion-body">
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Enim ea
              nam exercitationem alias ad, repellendus eligendi ipsa rerum
              voluptatum aperiam.
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header" id="headingThree">
            <button
              class="accordion-button collapsed"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#accordionCollapseThree"
              aria-expanded="false"
              aria-controls="accordionCollapseThree"
            >
              Lorem ipsum dolor sit.
            </button>
          </h2>
          <div
            id="accordionCollapseThree"
            class="accordion-collapse collapse"
            aria-labelledby="headingThree"
            data-bs-parent="#accordionExample"
          >
            <div class="accordion-body">
              Lorem ipsum dolor sit amet consectetur, adipisicing elit. Possimus
              asperiores quidem ad quis veritatis in nulla rerum pariatur
              dolorum unde.
            </div>
          </div>
        </div>
      </div>

      <div class="container">
        <div class="dropdown">
          <button
            class="btn btn-secondary dropdown-toggle"
            type="button"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            Dropdown button
          </button>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
};
</script>

<style scoped>
/* sidebars */
body {
  min-height: 100vh;
  min-height: -webkit-fill-available;
}

html {
  height: -webkit-fill-available;
}

main {
  height: 100vh;
  height: -webkit-fill-available;
  max-height: 100vh;
  overflow-x: auto;
  overflow-y: hidden;
}

.dropdown-toggle {
  outline: 0;
}

.btn-toggle {
  padding: 0.25rem 0.5rem;
  font-weight: 600;
  color: rgba(0, 0, 0, 0.65);
  background-color: transparent;
}
.btn-toggle:hover,
.btn-toggle:focus {
  color: rgba(0, 0, 0, 0.85);
  background-color: #d2f4ea;
}

.btn-toggle::before {
  width: 1.25em;
  line-height: 0;
  content: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='16' height='16' viewBox='0 0 16 16'%3e%3cpath fill='none' stroke='rgba%280,0,0,.5%29' stroke-linecap='round' stroke-linejoin='round' stroke-width='2' d='M5 14l6-6-6-6'/%3e%3c/svg%3e");
  transition: transform 0.35s ease;
  transform-origin: 0.5em 50%;
}

.btn-toggle[aria-expanded="true"] {
  color: rgba(0, 0, 0, 0.85);
}
.btn-toggle[aria-expanded="true"]::before {
  transform: rotate(90deg);
}

.btn-toggle-nav a {
  padding: 0.1875rem 0.5rem;
  margin-top: 0.125rem;
  margin-left: 1.25rem;
}
.btn-toggle-nav a:hover,
.btn-toggle-nav a:focus {
  background-color: #d2f4ea;
}

.scrollarea {
  overflow-y: auto;
}
/* sidebars */

.blank {
  position: relative;
  width: fit-content;
  height: 104px;
}

.page-title {
  padding: 10px;
  margin-top: revert;
  margin-bottom: revert;
}

.btn-custom {
  --bs-btn-font-weight: 600;
  --bs-btn-color: white;
  --bs-btn-bg: #67b0d1; /*연한거*/
  --bs-btn-border-radius: 0.5rem;
  --bs-btn-hover-color: white;
  --bs-btn-hover-bg: #409cc5;
  --bs-btn-active-color: var(--bs-btn-color);
  --bs-btn-active-bg: var(--bs-btn-bg);
}

.btn-bd-primary {
  --bs-btn-font-weight: 600;
  --bs-btn-color: var(--bs-white);
  --bs-btn-bg: var(--bs-black);
  --bs-btn-border-color: var(--bd-violet);
  --bs-btn-border-radius: 0.5rem;
  --bs-btn-hover-color: var(--bs-black);
  --bs-btn-hover-bg: #{shade-color($bd-violet, 10%)};
  --bs-btn-hover-border-color: #{shade-color($bd-violet, 10%)};
  --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
  --bs-btn-active-color: var(--bs-btn-hover-color);
  --bs-btn-active-bg: #{shade-color($bd-violet, 20%)};
  --bs-btn-active-border-color: #{shade-color($bd-violet, 20%)};
}
.col-md-12 {
  padding-bottom: 10px;
}

.login-button__item {
  display: block;
  box-sizing: border-box;
  width: 100%;
  height: 50px;
  padding: 14px 16px 15px;
  border: 1px solid #000;
  border-radius: 4px;
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
  margin: 0;
  text-decoration: none;
  text-align: center;
}

.login-button__item__logo {
  display: inline-block;
  margin-top: -4px;
  margin-right: -4px;
  vertical-align: top;
}

.ani-test {
  transition: none;
}
</style>

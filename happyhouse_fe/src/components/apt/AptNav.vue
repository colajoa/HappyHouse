<template>
  <main class="d-flex flex-nowrap">
    <div
      class="d-flex flex-column flex-shrink-0 bg-light"
      style="width: 4%"
      id="sidebar-box"
    >
      <ul
        class="nav nav-pills nav-flush flex-column mb-auto text-center"
        id="sidebarmain"
      >
        <li class="nav-item">
          <a
            class="nav-link active py-3 border-bottom rounded-0"
            aria-current="page"
            title="Home"
            data-bs-toggle="collapse"
            data-bs-target="#collapseWidthExample"
            aria-expanded="false"
            aria-controls="collapseWidthExample"
          >
            <svg
              class="bi pe-none"
              width="24"
              height="24"
              role="img"
              aria-label="Home"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="m19.55 21.95-6.475-6.475q-.725.5-1.687.8-.963.3-2.088.3-2.95 0-5.012-2.063Q2.225 12.45 2.225 9.5q0-2.95 2.063-5.013Q6.35 2.425 9.3 2.425q2.95 0 5.012 2.062Q16.375 6.55 16.375 9.5q0 1.15-.3 2.087-.3.938-.8 1.638l6.5 6.525ZM9.3 13.425q1.65 0 2.788-1.138 1.137-1.137 1.137-2.787t-1.137-2.788Q10.95 5.575 9.3 5.575T6.513 6.712Q5.375 7.85 5.375 9.5t1.138 2.787Q7.65 13.425 9.3 13.425Z"
              />
            </svg>
          </a>
        </li>

        <li>
          <a
            href="#"
            class="nav-link active py-3 border-bottom rounded-0"
            aria-current="page"
            title="Home"
            data-bs-toggle="collapse"
            data-bs-target="#collapseWidthExample1"
            aria-expanded="false"
            aria-controls="collapseWidthExample"
          >
            <svg
              class="bi pe-none"
              width="24"
              height="24"
              role="img"
              aria-label="Home"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M11.975 22.15 9.95 20.325q-2.625-2.35-4.337-4.075-1.713-1.725-2.7-3.1-.988-1.375-1.388-2.55-.4-1.175-.4-2.45 0-2.725 1.813-4.55Q4.75 1.775 7.475 1.775q1.275 0 2.425.45t2.075 1.325q.925-.875 2.075-1.325 1.15-.45 2.425-.45 2.725 0 4.563 1.825 1.837 1.825 1.837 4.55 0 1.25-.387 2.425-.388 1.175-1.388 2.538-1 1.362-2.725 3.099Q16.65 17.95 14 20.325Zm0-4.225q2.35-2.15 3.863-3.625 1.512-1.475 2.374-2.575.863-1.1 1.188-1.925.325-.825.325-1.65 0-1.4-.925-2.312-.925-.913-2.325-.913-1.075 0-2.025.663-.95.662-1.325 1.687H10.85q-.375-1.025-1.337-1.687-.963-.663-2.038-.663-1.35 0-2.262.913Q4.3 6.75 4.3 8.15q0 .85.338 1.7.337.85 1.2 1.95.862 1.1 2.35 2.562 1.487 1.463 3.787 3.563Zm.05-6.5Z"
              />
            </svg>
          </a>
        </li>
      </ul>
    </div>
    <div style="min-height: 120px; z-index: 10; height: 91%">
      <div class="collapse collapse-horizontal" id="collapseWidthExample">
        <div class="card card-body" style="width: 300px; height: 91vh">
          <apt-area></apt-area>
          <apt-list></apt-list>
          <apt-info></apt-info>
        </div>
      </div>
    </div>

    <div style="min-height: 120px; z-index: 10; height: 91%">
      <div class="collapse collapse-horizontal" id="collapseWidthExample1">
        <div class="card card-body" style="width: 300px; height: 91vh">
          <interest-arae-list></interest-arae-list>
        </div>
      </div>
    </div>
    <apt-map></apt-map>
  </main>
</template>

<script>
import AptArea from "./AptArea.vue";
import AptList from "./AptList.vue";
import AptMap from "./AptMap.vue";
import AptInfo from "./AptInfo.vue";
import InterestAraeList from "../area/AraeList.vue";
export default {
  components: {
    AptMap,
    AptArea,
    AptList,
    AptInfo,
    InterestAraeList,
  },
};
</script>

<style scoped>
/* sidenavbar */
body {
  min-height: 100vh;
  min-height: -webkit-fill-available;
}

html {
  height: -webkit-fill-available;
}

main {
  height: -webkit-fill-available;
  max-height: 91vh;
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

.bd-placeholder-img {
  font-size: 1.125rem;
  text-anchor: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  user-select: none;
}

@media (min-width: 768px) {
  .bd-placeholder-img-lg {
    font-size: 3.5rem;
  }
}

.b-example-divider {
  height: 3rem;
  background-color: rgba(0, 0, 0, 0.1);
  border: solid rgba(0, 0, 0, 0.15);
  border-width: 1px 0;
  box-shadow: inset 0 0.5em 1.5em rgba(0, 0, 0, 0.1),
    inset 0 0.125em 0.5em rgba(0, 0, 0, 0.15);
}

.b-example-vr {
  flex-shrink: 0;
  width: 1.5rem;
  height: 100vh;
}

.bi {
  vertical-align: -0.125em;
  fill: currentColor;
}

.nav-scroller {
  position: relative;
  z-index: 2;
  height: 2.75rem;
  overflow-y: hidden;
}

.nav-scroller .nav {
  display: flex;
  flex-wrap: nowrap;
  padding-bottom: 1rem;
  margin-top: -1px;
  overflow-x: auto;
  text-align: center;
  white-space: nowrap;
  -webkit-overflow-scrolling: touch;
}

#sidebar-box {
  border-right: gray solid 1px;
}

.nav-pills .nav-link.active,
.nav-pills .show > .nav-link {
  color: var(--bs-nav-pills-link-active-color);
  background-color: var(--bs-nav-pills-link-active-bg);
}
/* sidenavbar */
</style>

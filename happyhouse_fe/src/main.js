import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import VueKakaoSdk from "vue-kakao-sdk";
//import axios from "./axios";

Vue.config.productionTip = false;

// KAKAO API
const apiKey = process.env.VUE_APP_KAKAO_SDK_KEY;
Vue.use(VueKakaoSdk, { apiKey });

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");

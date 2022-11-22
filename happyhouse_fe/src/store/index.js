import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";
// modules
import aptStore from "@/store/modules/AptStore.js";
import userStore from "@/store/modules/UserStore.js";
import userPageStore from "@/store/modules/UserPageStore.js";
import boardStore from "@/store/modules/BoardStore.js";
import qnaStore from "@/store/modules/QnaStore.js";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    aptStore,
    userStore,
    userPageStore,
    boardStore,
    qnaStore,
  },
  plugins: [
    createPersistedState({
      storage: sessionStorage,
    }),
  ],
});

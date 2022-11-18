import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";
// modules
import aptStore from "@/store/modules/AptStore.js";
import userStore from "@/store/modules/UserStore.js";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    aptStore,
    userStore,
  },
  plugins: [
    createPersistedState({
      storage: sessionStorage,
    }),
  ],
});

import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";
// modules
import aptStore from "@/store/modules/AptStore.vue";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    aptStore,
  },
  plugins: [
    createPersistedState({
      storage: sessionStorage,
    }),
  ],
});

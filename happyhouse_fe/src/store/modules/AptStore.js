import http from "@/api/axios.js";

const aptStore = {
  namespaced: true,
  state: {
    sidos: [{ value: null, text: "시/도" }],
    guguns: [{ value: null, text: "구/군" }],
    dongs: [{ value: null, text: "동" }],
    years: [{ value: null, text: "연도" }],
    months: [{ value: null, text: "월" }],
    apts: [],
    apt: null,
  },
  getters: {},
  mutations: {
    CLEAR_SIDO_LIST(state) {
      state.sidos = [{ value: null, text: "시/도" }];
    },
    CLEAR_GUGUN_LIST(state) {
      state.guguns = [{ value: null, text: "구/군" }];
    },
    CLEAR_DONG_LIST(state) {
      state.dongs = [{ value: null, text: "동" }];
    },
    CLEAR_YEAR_LIST(state) {
      state.years = [{ value: null, text: "연도" }];
    },
    CLEAR_MONTH_LIST(state) {
      state.months = [{ value: null, text: "월" }];
    },
    CLEAR_APT_LIST(state) {
      state.apts = [];
      state.apt = null;
    },
    SET_SIDO_LIST(state, sidos) {
      sidos.forEach((sido) => {
        state.sidos.push({ value: sido.code, text: sido.name });
      });
    },
    SET_GUGUN_LIST(state, guguns) {
      guguns.forEach((gugun) => {
        state.guguns.push({ value: gugun.code, text: gugun.name });
      });
    },
    SET_DONG_LIST(state, dongs) {
      dongs.forEach((dong) => {
        state.dongs.push({ value: dong.code, text: dong.name });
      });
    },
    SET_YEAR(state, years) {
      years.forEach((year) => {
        state.years.push({ value: year, text: year });
      });
    },
    SET_MONTH(state, months) {
      months.forEach((month) => {
        state.months.push({ value: month, text: month });
      });
    },
    SET_APTS_LIST(state, apts) {
      state.apts = apts;
    },
    SET_DETAIL_APT(state, apt) {
      state.apt = apt;
    },
  },
  actions: {
    getSido: async ({ commit }) => {
      await http
        .get("/house/apt/sido")
        .then((res) => {
          if (res.status == 200) {
            commit("SET_SIDO_LIST", res.data);
          }
        })
        .catch((e) => console.log(e));
    },
    getGugun: async ({ commit }, sidoCode) => {
      await http
        .get(`/house/apt/gugun/${sidoCode}`)
        .then((res) => {
          if (res.status == 200) {
            commit("SET_GUGUN_LIST", res.data);
          }
        })
        .catch((e) => console.log(e));
    },
    getDong: async ({ commit }, dongCode) => {
      await http
        .get(`/house/apt/dong/${dongCode}`)
        .then((res) => {
          if (res.status == 200) {
            commit("SET_DONG_LIST", res.data);
          }
        })
        .catch((e) => console.log(e));
    },
    getYear: async ({ commit }) => {
      const date = new Date();
      let year = [];
      for (let i = date.getFullYear(); i > date.getFullYear() - 20; i--) {
        year.push(i);
      }
      commit("SET_YEAR", year);
    },
    getMonth: async ({ commit }, year) => {
      const date = new Date();
      let month = date.getMonth() + 1;
      month = year == date.getFullYear() ? month : 13;

      let months = [];
      for (let i = 1; i < month; i++) {
        months.push(i);
      }
      commit("SET_MONTH", months);
    },
    getAptList: async ({ commit }, { dongCode, date }) => {
      const code = dongCode.substring(0, 5);
      await http.get(`/house/apt/aptlist/${code}/${date}`).then((res) => {
        if (res.status == 200) {
          commit("SET_APTS_LIST", res.data.response.body.items.item);
        }
      });
    },
    detailApt: ({ commit }, apt) => {
      commit("SET_DETAIL_APT", apt);
    },
  },
};

export default aptStore;

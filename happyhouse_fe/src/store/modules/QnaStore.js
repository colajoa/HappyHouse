import http from "@/api/axios.js";

const QnaStore = {
  namespaced: true,
  state: {
    qnas: null,
    qna: null,
    qnaId: null,
    isShow: false,
  },
  getters: {
    checkQnas(state) {
      return state.qnas;
    },
    checkQna(state) {
      return state.qna;
    },
    checkQnaId(state) {
      return state.qnaId;
    },
    checkIsShow(state) {
      return state.isShow;
    },
  },
  mutations: {
    SET_QNAS: (state, qnas) => {
      state.qnas = qnas;
    },
    SET_QNA: (state, qna) => {
      state.qna = qna;
    },
    SET_QNA_ID: (state, qnaId) => {
      state.qnaId = qnaId;
    },
    SET_IS_SHOW: (state, isShow) => {
      state.isShow = isShow;
    },
  },
  actions: {
    async qnaList({ commit }) {
      await http.get("/house/qna/list").then((res) => {
        if (res.status == 200) {
          commit("SET_QNAS", res.data);
        }
      });
    },
    async registerQna(state, qna) {
      await http.post("/house/qna/register", qna).then((res) => {
        if (res.status == 200) {
          return;
        }
      });
    },
    async detailQna({ commit }, idx) {
      await http.get(`/house/qna/detail/${idx}`).then((res) => {
        if (res.status == 200) {
          commit("SET_QNA", res.data);
        }
      });
    },
    async viewQna(state, idx) {
      await http.get(`/house/qna/hit/${idx}`);
    },
    async modifyQna(state, qna) {
      await http.put(`/house/qna/${qna.idx}`, qna);
    },
    async removeQna(state, idx) {
      await http.delete(`/house/qna/${idx}`);
    },
    async setQnaId({ commit }, idx) {
      commit("SET_IS_SHOW", true);
      commit("SET_QNA_ID", idx);
    },
  },
};

export default QnaStore;

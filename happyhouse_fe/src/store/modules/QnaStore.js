import http from "@/api/axios.js";

const QnaStore = {
  namespaced: true,
  state: {
    qnas: null,
    qna: null,
    reply: null,
  },
  getters: {
    checkQnas(state) {
      return state.qnas;
    },
    checkQna(state) {
      return state.qna;
    },
    checkQnaReply(state) {
      return state.reply;
    },
  },
  mutations: {
    SET_QNAS: (state, qnas) => {
      state.qnas = qnas;
    },
    SET_QNA: (state, qna) => {
      state.qna = qna;
    },
    SET_QNA_REPLY: (state, reply) => {
      state.reply = reply;
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
    async viewQna(state, idx) {
      await http.get(`/house/qna/hit/${idx}`);
    },
    async modifyQna(state, qna) {
      await http.put(`/house/qna/${qna.idx}`, qna);
    },
    async removeQna(state, idx) {
      await http.delete(`/house/qna/${idx}`);
    },
    async getQnaReply({ commit }, idx) {
      await http.get(`/house/qna/reply/detail/${idx}`).then((res) => {
        if (res.status == 200) {
          commit("SET_QNA_REPLY", res.data);
        }
      });
    },
    async modifyQnaReply(state, reply) {
      await http.put(`/house/qna/reply/${reply.qnaid}`, reply);
    },
    async removeQnaReply(state, idx) {
      await http.delete(`/house/qna/reply/${idx}`);
    },
  },
};

export default QnaStore;

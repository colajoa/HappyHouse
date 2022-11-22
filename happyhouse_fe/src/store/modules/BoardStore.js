import http from "@/api/axios.js";

const BoardStore = {
  namespaced: true,
  state: {
    boards: null,
    board: null,
  },
  getters: {
    checkBoards(state) {
      return state.boards;
    },
    checkBoard(state) {
      return state.board;
    },
  },
  mutations: {
    SET_BOARDS: (state, boards) => {
      state.boards = boards;
    },
    SET_BOARD: (state, board) => {
      state.board = board;
    },
  },
  actions: {
    async boardList({ commit }) {
      await http.get("/house/board/list").then((res) => {
        if (res.status == 200) {
          commit("SET_BOARDS", res.data);
        }
      });
    },
    async post(state, board) {
      await http.post("/house/board/register", board).then((res) => {
        if (res.status == 200) {
          return;
        }
      });
    },
    async detailBoard({ commit }, idx) {
      const param = Number.parseInt(idx);
      await http.get(`/house/board/detail/${param}`).then((res) => {
        if (res.status == 200) {
          commit("SET_BOARD", res.data);
        }
      });
    },
    async viewBoard(state, idx) {
      await http.get(`/house/board/hit/${idx}`);
    },
    async modifyBoard(state, board) {
      await http.put(`/house/board/post`, board);
    },
    async removeBoard(state, idx) {
      await http.delete(`/house/board/${idx}`);
    },
  },
};

export default BoardStore;

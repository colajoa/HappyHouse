import http from "@/api/axios.js";

const BoardStore = {
  namespaced: true,
  state: {},
  getters: {},
  mutations: {},
  actions: {
    async boardList(state) {
      return await http.get("/house/board/list");
    },
    async post(state, board) {
      await http.post("/house/board/register", board).then((res) => {
        if (res.status == 200) {
          return;
        }
      });
    },
    async detailBoard(state, idx) {
      await http.get(`/house/board/detail/${idx}`);
    },
    async viewBoard(state, idx) {
      await http.get(`/house/board/hit/{${idx}}`);
    },
    async modifyBoard(state, board) {
      await http.put(`/house/board/${board.idx}`, board);
    },
    async removeBoard(state, idx) {
      await http.delete(`/house/board/${idx}`);
    },
  },
};

export default BoardStore;

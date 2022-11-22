import http from "@/api/axios.js";

const userPageStore = {
  namespaced: true,
  state: {},
  getters: {},
  mutations: {},
  actions: {
    async changeUserInfo(state, user) {
      await http.put("/house/user/update", user);
    },
    async changePassword(state, pwds) {
      await http.post("/house/user/changepwd", pwds);
    },
  },
};

export default userPageStore;

import Vue from "vue";
import VueRouter from "vue-router";
import AppMain from "@/views/AppMain.vue";
import AppApt from "@/views/AppApt.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "main",
    component: AppMain,
  },
  {
    path: "/test",
    name: "test",
    component: () => import("@/views/AppTest"),
  },
  {
    path: "/apt",
    name: "apt",
    component: AppApt,
  },

  {
    path: "/area",
    name: "area",
    component: () => import("@/views/AppArea"),
  },
  {
    path: "/board",
    name: "board",
    redirect: "/board/list",
    component: () => import("@/views/AppBoard"),
    children: [
      {
        path: "list",
        name: "boardlist",
        component: () => import("@/components/board/BoardList"),
      },
      {
        path: "write",
        name: "boardwrite",
        component: () => import("@/components/board/BoardWrite"),
      },
    ],
  },
  {
    path: "/qna",
    name: "qna",
    redirect: "/qna/list",
    component: () => import("@/views/AppQna"),
    children: [
      {
        path: "list",
        name: "qnalist",
        component: () => import("@/components/qna/QnaList"),
      },
      {
        path: "wrtie",
        name: "qnawrite",
        component: () => import("@/components/qna/QnaWrite"),
      },
    ],
  },
  {
    path: "/user",
    name: "user",
    redirect: "/user/login",
    component: () => import("@/views/AppUser"),
    children: [
      {
        path: "login",
        name: "login",
        component: () => import("@/components/user/UserLogin"),
      },
      {
        path: "join",
        name: "join",
        component: () => import("@/components/user/UserJoin"),
      },
      {
        path: "find",
        name: "find",
        component: () => import("@/components/user/UserFind"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;

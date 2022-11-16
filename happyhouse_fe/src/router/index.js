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
    component: () => import("@/views/AppBoard"),
  },
  {
    path: "/qna",
    name: "qna",
    component: () => import("@/views/AppQna"),
  },
  {
    path: "/user",
    name: "user",
    component: () => import("@/views/AppUser"),
  },
  // {
  //   path: "/about",
  //   name: "about",
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () =>
  //     import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  // },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;

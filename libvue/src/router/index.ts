import { createRouter, createWebHashHistory, RouteRecordRaw } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import userAll from '../views/user/userAll.vue'
import login from "../views/login/login.vue"

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/userAll',
    name: 'userAll',
    component: userAll
  },
  {
    path: '/login',
    name: 'login',
    component: login
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router

import { createStore } from 'vuex'

export default createStore({
  state: {
    Authorization: localStorage.getItem('token') ? localStorage.getItem('token') : ''
  },
  getters: {
  },
  mutations: {
    // 修改token，并将token存入localStorage
    changeLogin (state, user) {
      state.Authorization = user.Authorization;
      localStorage.setItem('token', user.Authorization);
    }
  },
  actions: {
  },
  modules: {
  }
})

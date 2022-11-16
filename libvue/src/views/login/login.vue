<template>
  <div>
    <input type="text" v-model="unamw" placeholder="用户名"/>
    <input type="text" v-model="upassword" placeholder="密码"/>
    <button @click="login">登录</button>
  </div>
</template>

<script>
import { mapMutations } from 'vuex';
export default {
  name: "login",
  data () {
    return {
      uname:"",
      upassword:"",
      token: ''
    };
  },
  methods: {
    ...mapMutations(['changeLogin']),
    login () {
      let _this = this;
      if (this.uname === '' || this.upassword === '') {
        alert('账号或密码不能为空');
      }
          _this.userToken = 'Bearer ';
          // 将用户token保存到vuex中
          _this.changeLogin({ Authorization: _this.userToken });
          _this.$router.push('/home');

  }
},
}
</script>

<style scoped>

</style>
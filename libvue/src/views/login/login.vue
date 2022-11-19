<template>
  <div>
    <input type="text" v-model="uname" placeholder="用户名"/>
    <input type="text" v-model="upassword" placeholder="密码"/>
    <button @click="login">登录</button>
  </div>
</template>

<script>
import { mapMutations } from 'vuex';
import {login} from "../../api/user";
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
        return;
      }
      login(this.uname,this.upassword).then((res)=>{
        console.log(res)
        if (res.code === 200) {
          _this.userToken = res.data;
          localStorage.setItem('token', _this.userToken);
          // 将用户token保存到vuex中
          _this.changeLogin({Authorization: _this.userToken});
          _this.$router.push('/home');
        }else{
          alert("登录失败")
        }
      })


  }
},
}
</script>

<style scoped>

</style>
<template>
  <div id="userAll">
    <el-button type="primary" @click="select">{{ name }}</el-button>
    <el-table :data="userList" style="width: 100%">
      <el-table-column prop="uid" label="uid" width="180" />
      <el-table-column prop="uname" label="uname" width="180" />
      <el-table-column prop="upassword" label="upassword" />
    </el-table>
  </div>
</template>

<script>
import {getData} from "../../api/user";
export default {
  data(){
    return {
      name: "查询",
      userList:[]
    }
  },
  methods:{
    select:function () {
      getData().then((res)=>{
        console.log("ok")
        this.userList=res
      })
    }
  },
  created() {
    this.select()
  }
}
</script>


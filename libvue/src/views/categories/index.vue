<template>

  <div class="common-layout">
    <el-container>
      <el-header style="padding: 20px">
        <h3>header</h3>
      </el-header>
      <el-main>
          <div style="border: 2px solid rgb(205, 202, 209);border-radius: 15px;padding:10px 40px; ">
            <el-table :data="user" style="width: 100%">
              <el-table-column prop="uid" label="ID" />
              <el-table-column prop="username" label="Username" />
              <el-table-column label="Edit" >
                <Edit @click="editUser" style="width: 1em; height: 1em; margin-right: 8px" />
                <Delete @click="delUser" style="width: 1em; height: 1em; margin-right: 8px" />
              </el-table-column>
            </el-table>
            <el-pagination background layout="prev, pager, next" :total="1000" style="text-align:center;"/>
          </div>
      </el-main>
    </el-container>
  </div>

</template>

<script  setup>
import { userList } from '@/api/user'
// import { userEdit} from "@/api/user";
import { ref } from 'vue'
const user = ref([])
const userInit = async () => {
  user.value = await userList()
}
userInit()
// const editUser = async () => {
//   user.value = await userEdit()
// }

</script>
<style lang="scss" scoped></style>

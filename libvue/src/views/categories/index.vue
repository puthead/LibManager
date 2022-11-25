<template>
  <template>
    <el-button text @click="editVisible = true">
      click to open the Dialog
    </el-button>

    <el-dialog
      v-model="editVisible"
      title="Tips"
      width="30%"
      :before-close="handleClose"
    >
      <span>This is a message</span>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="editVisible = false">Cancel</el-button>
        <el-button type="primary" @click="editVisible = false">
          Confirm
        </el-button>
      </span>
      </template>
    </el-dialog>
  </template>
  <div class="common-layout">
    <el-container>
      <el-header style="padding: 20px">
        <h3>header</h3>
      </el-header>
      <el-main>
          <div style="border: 2px solid rgb(205, 202, 209);border-radius: 15px;padding:10px 40px; ">
              <table style="width: 100%">
                <thead ><th>ID</th><th>UserName</th><th>EDIT</th></thead>
                <tbody>
                <tr v-for="item in user" :key="item.uid" style="text-align: center"><td>{{item.uid}}</td><td>{{item.username}}</td><td><Edit @click="editVisible = true;editSubmit(item.uid,item.username)" style="width: 4em; height: 1em; margin-right: 8px" /></td></tr>
                </tbody>
              </table>
              <el-dialog v-model="editVisible" title="EditPage" width="55%" :before-close="handleClose">
                <div class="common-layout">
                  <el-container style="padding-left: 80px;margin-bottom: 40px">
                        <h1 style="font-size: 20px;margin-top: 3px">Current Username: </h1>
                        <el-input v-model="Username" disabled placeholder="{{name}}" prop="name" style="left:20px ;width: 200px"/>
                  </el-container>
                  <el-container style="padding-left: 80px;margin-bottom: 40px">
                        <h1 style="font-size: 20px;margin-top: 3px">New Username: </h1>
                        <el-input v-model="newUsername"  placeholder="Please input new username" style="left:52px ;width: 200px"/>
                  </el-container>
                  <el-container style="padding-left: 80px;margin-bottom: 40px">
                    <h1 style="font-size: 20px;margin-top: 3px">New Password: </h1>
                    <el-input v-model="newPassword" type="password" placeholder="Please input new password" style="left:53px ;width: 200px"/>
                  </el-container>
                </div>
                <template #footer>
                <span class="dialog-footer">
                  <el-button @click="editVisible = false">Cancel</el-button>
                  <el-button id="submit" type="primary" @click="editSubmit">
                    Confirm
                  </el-button>
                </span>
                </template>
              </el-dialog>
            <el-pagination background layout="prev, pager, next" :total="1000" style="text-align:center;"/>
          </div>
      </el-main>
    </el-container>
  </div>

</template>

<script  setup>
import { userList } from '@/api/user'
// import { userQuery } from '@/api/user'
import { ref } from 'vue'
import { ElMessageBox } from 'element-plus'

var id = 0
var name = ''
const editVisible = ref(false)
const handleClose = (done) => {
  ElMessageBox.confirm('真的要关闭此窗口吗？')
    .then(() => {
      done()
    })
    .catch(() => {
      // catch error
    })
}

function editSubmit(uid, username) {
  console.log(uid, username)
   id = uid
   name = username
  console.log('id=' + id + '; name=' + name)
}
const Username = ref('')
const newUsername = ref('')
const newPassword = ref('')

const user = ref([])
const userInit = async () => {
  user.value = await userList()
}
userInit()

</script>
<style lang="scss" scoped></style>

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
            <el-table :data="user" style="width: 100%">
              <el-table-column prop="uid" label="ID" />
              <el-table-column prop="username" label="Username" />
              <el-table-column label="Edit" >
                <Edit @click="editVisible = true" style="width: 4em; height: 1em; margin-right: 8px" />
<!--                <el-button type="default" @click="editVisible = true">查询</el-button>-->

                <Delete @click="delUser" style="width: 4em; height: 1em; margin-right: 8px" />
              </el-table-column>
            </el-table>
              <el-dialog v-model="editVisible" title="EditPage" width="55%" :before-close="handleClose">
                <div class="common-layout">
                  <el-container>
<!--                    <el-header style="background-color: yellowgreen">Header</el-header>-->
                    <el-container style="background-color: turquoise">
                      <h1 style="font-size: 20px">Current Username</h1>
                    </el-container>
                  </el-container>
                </div>
                <template #footer>
                <span class="dialog-footer">
                  <el-button @click="editVisible = false">Cancel</el-button>
                  <el-button type="primary" @click="editVisible = false">
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
// import { userEdit} from "@/api/user";
import { ref } from 'vue'
import { ElMessageBox } from 'element-plus'
const editVisible = ref(false)
const handleClose = (done) => {
  ElMessageBox.confirm('Are you sure to close this dialog?')
    .then(() => {
      done()
    })
    .catch(() => {
      // catch error
    })
}

const user = ref([])
const userInit = async () => {
  user.value = await userList()
}
userInit()
</script>
<style lang="scss" scoped></style>

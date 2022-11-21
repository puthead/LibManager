<template>

  <div class="common-layout">
    <el-container>
      <el-header style="padding: 20px">
        <h3>header</h3>
      </el-header>
      <el-main>
          <div style="border: 2px solid rgb(205, 202, 209);border-radius: 15px;padding:10px 40px; ">
            <el-table :data="tableData" style="width: 100%">
              <el-table-column prop="id" label="ID" />
              <el-table-column prop="username" label="Username" />
              <el-table-column prop="password" label="Password" />
              <el-table-column prop="edit" label="Edit" />
            </el-table>
            <el-pagination background layout="prev, pager, next" :total="1000" style="text-align:center;"/>
          </div>
      </el-main>
    </el-container>
  </div>

</template>

<script  setup>
// import { ref } from 'vue'
// const msg = ref(123)
const tableData = [{ id: '2022', username: '帅哥', password: '1' }]
</script>
<style lang="scss" scoped></style>

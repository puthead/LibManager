<template>
  <el-button type="primary">{{ msg }}</el-button>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="date" label="Date" width="180" />
    <el-table-column prop="name" label="Name" width="180" />
    <el-table-column prop="address" label="Address" />
  </el-table>
</template>

<script  setup>
import { ref } from 'vue'

const msg = ref(123)
const tableData = [{ date: '2022' }]
</script>
<style lang="scss" scoped></style>

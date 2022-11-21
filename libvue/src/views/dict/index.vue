<template>
  <el-button type="primary" @click="dicts">查询</el-button>
  <el-row>
    <el-col :span="11"><div class="grid-content ep-bg-purple" />
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column type="selection" width="55" />
        <el-table-column prop="date" label="ID" />
        <el-table-column prop="name" label="item" />
        <el-table-column prop="address" label="value" />
        <el-table-column prop="address" label="description" />
        <el-table-column prop="address" label="sort" />
      </el-table>
    </el-col>
    <el-col :span="1"><div class="grid-content ep-bg-purple-light" /></el-col>
    <el-col :span="11"><div class="grid-content ep-bg-purple-light" />
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column type="selection" width="55" />
        <el-table-column prop="date" label="ID"  />
        <el-table-column prop="name" label="item"  />
        <el-table-column prop="address" label="value" />
        <el-table-column prop="address" label="description" />
        <el-table-column prop="address" label="sort" />
      </el-table>
    </el-col>
  </el-row>
</template>

<script  setup>
import { dictList } from '@/api/dict'

const dicts = () => {
  dictList().then((res) => {
    console.log(res)
  })
}
</script>
<style lang="scss" scoped></style>

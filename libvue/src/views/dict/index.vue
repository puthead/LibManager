<template>
  <el-button type="primary" @click="initDictList">查询</el-button>
  <el-row>
    <el-col :span="11"><div class="grid-content ep-bg-purple" />
      <el-table :data="dict" border style="width: 100%">
        <el-table-column type="selection" width="55" />
        <el-table-column prop="id" label="ID" />
        <el-table-column prop="item" label="item" />
        <el-table-column prop="value" label="value" />
        <el-table-column prop="description" label="description" />
        <el-table-column prop="sort" label="sort" />
      </el-table>
    </el-col>
    <el-col :span="1"><div class="grid-content ep-bg-purple-light" /></el-col>
    <el-col :span="11"><div class="grid-content ep-bg-purple-light" />
      <el-table :data="dictItem" border style="width: 100%">
        <el-table-column type="selection" width="55" />
        <el-table-column prop="ID" label="ID"  />
        <el-table-column prop="item" label="item"  />
        <el-table-column prop="value" label="value" />
        <el-table-column prop="description" label="description" />
        <el-table-column prop="sort" label="sort" />
      </el-table>
    </el-col>
  </el-row>
</template>

<script  setup>
import { dictList } from '@/api/dict'
import { ref } from 'vue'
const dict = ref([])
const dictItem = ref([])

const initDictList = async () => {
  dict.value = await dictList()
  console.log(dict)
}
initDictList()
</script>
<style lang="scss" scoped></style>

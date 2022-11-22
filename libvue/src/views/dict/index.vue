<template>
  <el-button type="primary" @click="initDictList">查询</el-button>
  <el-button text @click="dialogTableVisible = true">
    open a Table nested Dialog
  </el-button>

  <el-dialog v-model="dialogTableVisible" title="Shipping address">
    123456
  </el-dialog>

  <el-row>
    <el-col :span="11"><div class="grid-content ep-bg-purple" />
      <el-table :data="dict" ref="dictTable"
                border style="width: 100%" @select="showDict">
        <el-table-column type="selection" width="55"/>
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
const dialogTableVisible = ref(false)
const dictTable = ref()

const initDictList = async () => {
  dict.value = await dictList()
  console.log(dict)
}
const showDict = async (selection) => {
  if (selection.length > 1) {
    dictTable.value.toggleRowSelection(selection.shift(), false) // 用于多选表格，切换某一行的选中状态，如果使用了第二个参数，则是设置这一行选中与否（selected 为 true 则选中）
  }
  console.log(selection.map(item => item.id))
}
initDictList()
</script>
<style lang="scss" scoped></style>

<template>
  <el-carousel :interval="4000" type="card" height="480px">
    <el-carousel-item v-for="item in carouseData" :key="item">
      <img :src="item.url" alt=""/>
    </el-carousel-item>
  </el-carousel>
<!--  <el-image src="http://193.168.25.127:8085/ProyaMESAPP/lcm.jpg"></el-image>-->
</template>

<script setup>
const carouseData = [
  { url: require('@/assets/lcm.jpg') },
  { url: require('@/assets/lcm.jpg') },
  { url: require('@/assets/lcm.jpg') },
  { url: require('@/assets/lcm.jpg') },
  { url: require('@/assets/lcm.jpg') },
  { url: require('@/assets/lcm.jpg') }
]
</script>

<style scoped>

</style>

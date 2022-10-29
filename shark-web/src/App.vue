<template>
  <el-config-provider :size="size" :z-index="zIndex">
    <BlackShark title="小鲨鱼词库" />
  </el-config-provider>
</template>

<script>
import BlackShark from './components/BlackShark.vue'

import { defineComponent } from 'vue'
import { ElConfigProvider } from 'element-plus'

export default defineComponent({
  components: {
    ElConfigProvider,
    BlackShark
  },
  setup() {
    return {
      zIndex: 3000,
      size: 'small',
    }
  },
})
</script>

<style>
  img {
    height: 80px;
  }
</style>

<template>
  <div class="page-header-index-wide">
    <a-row :gutter="[8,24]">
      <a-col>
        <StorePF></StorePF>
      </a-col>
    </a-row>

    <a-row :gutter="[8,24]">
      <a-col>
        <PackingPF></PackingPF>
      </a-col>
    </a-row>
    <a-row :gutter="[8,24]">
      <a-col>
        <StoreBill></StoreBill>
      </a-col>
    </a-row>
  </div>
</template>

<script>

import StorePF from './Store/StorePF'
import StoreBill from './Store/StoreBill'
import PackingPF from './Packing/PackingPF'

export default {
  name: 'LeftPanel',
  components:{
    StorePF,
    PackingPF,
    StoreBill,

  },
  methods:{

  }
}
</script>

<style scoped>

</style>
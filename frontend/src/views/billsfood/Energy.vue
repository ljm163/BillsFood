<template>

  <div class="page-header-index-wide">
<!--    <a-row :gutter="[12,12]">-->
<!--      <a-col :span="6">-->
<!--        <LeftPanel></LeftPanel>-->
<!--      </a-col>-->
<!--      <a-col :span="18">-->
<!--        <RightPanel></RightPanel>-->
<!--      </a-col>-->
<!--    </a-row>  -->
    <a-row>
        <RightPanel></RightPanel>
    </a-row>
  </div>
</template>

<script>

import LeftPanel from './energy/LeftPanel'
import RightPanel from './energy/RightPanel'

export default {
  name: 'Energy',
  components: {
    LeftPanel,
    RightPanel,
  }
}
</script>

<style scoped>

</style>
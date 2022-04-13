<template>
  <div class="page-header-index-wide">
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
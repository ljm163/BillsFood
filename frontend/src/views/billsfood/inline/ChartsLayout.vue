<template>
  <div class="page-header-index-wide">
    <a-card>
      <a-row>
        <a-col :span="12">
          <RealtimeHour :url="Url" style="height: 450px" :theme="theme"></RealtimeHour>
        </a-col>

        <a-col :span="12">
          <RealtimeDay :url="Url" style="height: 450px" :theme="theme"></RealtimeDay>
        </a-col>
      </a-row>
    </a-card>
  </div>
</template>

<script>

import RealtimeDay from './Charts/RealtimeDay'
import RealtimeHour from './Charts/RealtimeHour'

export default {
  name: 'ChartsLayout',
  components: { RealtimeDay, RealtimeHour },
  data() {
    return {
      theme: 'roma',
      Url: '/billsfood/inspection',
    }
  },
}
</script>

<style scoped>

</style>
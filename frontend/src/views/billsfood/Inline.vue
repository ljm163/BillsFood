<template>
  <div class="page-header-index-wide">
    <a-row>
      <ChartsLayout></ChartsLayout>
    </a-row>
  </div>
</template>

<script>

import ChartsLayout from '../billsfood/inline/ChartsLayout'

export default {
  name: 'Inline',
  components: {
    ChartsLayout

  },
  data() {
    return {
    }
  },
}
</script>

<style scoped>

</style>
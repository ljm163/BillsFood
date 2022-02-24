<template>
  <div>
    <InspecDash></InspecDash>
    <MiddleArea></MiddleArea>
    <BottomArea></BottomArea>
  </div>
</template>

<script>
import InspecDash from '../billsfood/inline/InspecDash'
import MiddleArea from '../billsfood/inline/MiddleArea'
import BottomArea from '../billsfood/inline/BottomArea'

export default {
  name: 'Inline',
  components: {
    InspecDash,
    MiddleArea,
    BottomArea,

  },
  data() {
    return {
    }
  },
}
</script>

<style scoped>

</style>
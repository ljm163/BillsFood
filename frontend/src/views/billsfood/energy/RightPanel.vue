<template>
  <div class="page-header-index-wide">
<!--    <a-row :gutter="[8,32]">-->
<!--      <a-col>-->
<!--        <TopArea></TopArea>-->
<!--      </a-col>-->
<!--    </a-row>-->
    <a-row>
        <TopTabs></TopTabs>
    </a-row>
  </div>
</template>

<script>
import TopTabs from './TopTabs'

export default {
  name: 'RightPanel',
  components: { TopTabs, },
}
</script>

<style scoped>

</style>
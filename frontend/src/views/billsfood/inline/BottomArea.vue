<template>
  <div class="page-header-index-wide">
    <a-row :gutter="[16,16]">
      <a-col :span="16">
        <a-card>
          <a-icon type="fund"/>
          <div ref="test">aaa
          </div>
        </a-card>
      </a-col>
      <a-col :span="8">
        <a-card>
          <a-icon type="fund"/>
          <div ref="test">aaa
          </div>
        </a-card>
      </a-col>
    </a-row>
  </div>
</template>

<script>
export default {
  name: 'BottomArea'
}
</script>

<style scoped>

</style>
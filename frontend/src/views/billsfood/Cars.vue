<template>
  <div class="page-header-index-wide">
    <a-row>
      <a-col :span="24">
        <a-card>
          <iframe :src="src" ref="iframe" width="100%" height="580px"></iframe>
        </a-card>
      </a-col>
    </a-row>
  </div>

</template>

<script>
export default {
  name: 'cars',
  data() {
    return {
      src: 'https://cn.bing.com'
    }
  }
}
</script>

<style scoped>

</style>
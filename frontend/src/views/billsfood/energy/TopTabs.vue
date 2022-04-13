<template>
  <a-card>
    <a-tabs defaultActiveKey="1" @change="meterNum">
      <a-tab-pane tab="庫房區" key="1">
        <a-row>
          <a-col :span="10">
            <StorePower :url="powerUrl" style="height: 450px" :theme="theme"></StorePower>
          </a-col>

          <a-col :span="14">
            <StoreVA :url="vaUrl" style="height: 450px" :theme="theme"></StoreVA>
          </a-col>
        </a-row>
      </a-tab-pane>

      <a-tab-pane tab="包裝區" key="2" forceRender:true>
        <a-row>
          <a-col :span="10">
            <PackingPower :url="powerUrl" style="height: 450px" :theme="theme"></PackingPower>
          </a-col>

          <a-col :span="14">
            <PackingVA :url="vaUrl" style="height: 450px" :theme="theme"></PackingVA>
          </a-col>
        </a-row>
      </a-tab-pane>
    </a-tabs>
  </a-card>
</template>

<script>
import PackingPower from './Packing/PackingPower'
import PackingVA from './Packing/PackingVA'
import StorePower from './Store/StorePower'
import StoreVA from './Store/StoreVA'

export default {
  name: 'TopTabs',
  components: { PackingPower, PackingVA, StorePower, StoreVA },
  data() {
    return {
      theme: 'roma',
      vaUrl: '/billsfood/energy/ecodaily',
      powerUrl: '/billsfood/energy/ecodaily',
    }
  },
  mounted() {

  },
  methods: {
    meterNum(key) {
      if (key === '1') {
        // getAction('/billsfood/energy/ecodaily').then((res) => {
        //   // res.body.point[0].measureData.dataValue
        //   // console.log(res.body.point[4].measureData.dataValue)
        //     this.power = res.body.point[4].measureData.dataValue
        // })
      } else {
        // this.tabMeter = 'packing'
        // this.initPackingChart()
        // this.getData()
      }
    },
  },
  destroyed() {
  }
}

</script>

<style scoped>

</style>
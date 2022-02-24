<template>
  <a-card>
    <a-tabs defaultActiveKey="1" @change="meterNum">
      <a-tab-pane tab="庫房區" key="1">
        <!--        <a-row>-->
        <!--          <a-col :span="16">-->
        <!--            <a-radio-group :value="dataTime" @change="statistics">-->
        <!--&lt;!&ndash;              <a-radio-button value="year">年</a-radio-button>&ndash;&gt;-->
        <!--&lt;!&ndash;              <a-radio-button value="month">月</a-radio-button>&ndash;&gt;-->
        <!--&lt;!&ndash;              <a-radio-button value="category">待定</a-radio-button>&ndash;&gt;-->
        <!--&lt;!&ndash;              <a-radio-button value="cabinet">柜号</a-radio-button>&ndash;&gt;-->
        <!--              <a-date-picker @change="dataChange"/>-->
        <!--            </a-radio-group>-->
        <!--          </a-col>-->
        <!--        </a-row>-->

        <a-row>
          <a-col :span="10">
            <!--          <a-card>-->
            <StorePower :url="powerUrl" style="height: 450px" :theme="theme"></StorePower>
            <!--          </a-card>-->
          </a-col>
          <!--        </a-row>-->
          <!--        <a-row>-->
          <a-col :span="14">
            <!--          <a-card>-->
            <StoreVA :url="vaUrl" style="height: 450px" :theme="theme"></StoreVA>
            <!--          </a-card>-->
          </a-col>
        </a-row>

      </a-tab-pane>

      <a-tab-pane tab="包裝區" key="2" forceRender:true>
        <!--        <a-row>-->
        <!--          <a-col :span="16">-->
        <!--            <a-radio-group :value="chartType" @change="statistics">-->
        <!--&lt;!&ndash;              <a-radio-button value="year">年</a-radio-button>&ndash;&gt;-->
        <!--&lt;!&ndash;              <a-radio-button value="month">月</a-radio-button>&ndash;&gt;-->
        <!--&lt;!&ndash;              <a-radio-button value="category">类别</a-radio-button>&ndash;&gt;-->
        <!--&lt;!&ndash;              <a-radio-button value="cabinet">柜号</a-radio-button>&ndash;&gt;-->
        <!--              <a-date-picker @change="onChange"/>-->
        <!--            </a-radio-group>-->
        <!--          </a-col>-->
        <!--        </a-row>-->
<!--        <div ref="meter_packing" style="height: 400px"></div>-->
        <a-row>
          <a-col :span="10">
            <!--          <a-card>-->
            <PackingPower :url="powerUrl" style="height: 450px" :theme="theme"></PackingPower>
            <!--          </a-card>-->
          </a-col>
          <!--        </a-row>-->
          <!--        <a-row>-->
          <a-col :span="14">
            <!--          <a-card>-->
            <PackingVA :url="vaUrl" style="height: 450px" :theme="theme"></PackingVA>
            <!--          </a-card>-->
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

    // updateChart() {
    //   console.log('updateChart')
    //   const dataOption = {
    //     series: [
    //       {
    //         name: 'Current',
    //         // data: [
    //         //    19,
    //         //    20,
    //         //    19,
    //         //    19,
    //         //    25,
    //         //    18,
    //         //    19,
    //         //    19,
    //         //    20,
    //         //    19,
    //         //    20,
    //         //    18,
    //         //    19,
    //         //    19,
    //         //    19,
    //         //    20,
    //         //    26,
    //         //    19,
    //         //    214,
    //         //    268,
    //         //    236,
    //         //    240,
    //         //    242,
    //         //    223,
    //         //    217,
    //         //    248,
    //         //    222,
    //         //    231,
    //         //    218,
    //         //    34,
    //         //    22,
    //         //    22,
    //         //    20,
    //         //    19,
    //         //    30,
    //         //    20,
    //         //    20,
    //         //    19,
    //         //    19,
    //         //    27,
    //         //    25,
    //         //    18,
    //         //    18,
    //         //    19,
    //         //    18,
    //         //    19,
    //         //    19,
    //         //    19
    //         //  ],
    //         data: this.voltage,
    //       }
    //     ]
    //   }
    //   this.chartPacking.setOption(dataOption)
    // },
    // dataChange(date, dateString) {
    //   console.log(date, dateString)
    // },
    // statistics(e) {
    //   if (this.tabStatus === 'store') {
    //     this.pieType = e.target.value
    //     this.queryStore()
    //   } else {
    //     this.barType = e.target.value
    //     this.queryPacking()
    //   }
    // },
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
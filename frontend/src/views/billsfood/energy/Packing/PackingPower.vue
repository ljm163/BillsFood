<template>
  <div ref="power" ></div>
</template>

<script>
import { getAction } from '../../../../api/manage'

export default {
  name: 'PackingPower',
  props: ['url', 'theme'],
  data() {
    return {
      timer: '',
      option: {
        title: {
          // subtext: 'Fake Data'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['Power']
        },
        toolbox: {
          show: true,
          feature: {
            magicType: {
              show: true,
              type: ['line', 'bar'],
              title: {
                line: 'switch to line',
                bar: 'switch to bar'
              }
            },
            restore: { show: true, title: 'restore' },
            saveAsImage: { show: true, title: 'save' },
          },
        },
        grid: {
          top: '20%',
        },
        calculable: true,
        xAxis: [
          {
            type: 'category',
            data: ['00:00', '00:30', '01:00', '01:30', '02:00', '02:30', '03:00', '03:30', '04:00', '04:30', '05:00', '05:30', '06:00', '06:30', '07:00', '07:30', '08:00', '08:30', '09:00', '09:30', '10:00', '10:30', '11:00', '11:30', '12:00', '12:30', '13:00', '13:30', '14:00', '14:30', '15:00', '15:30', '16:00', '16:30', '17:00', '17:30', '18:00', '18:30', '19:00', '19:30', '20:00', '20:30', '21:00', '21:30', '22:00', '22:30', '23:00', '23:30'],
            axisLabel: {
              rotate: 45
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: 'Power',
            min: 0,
            max: 100,
            interval: 20,
            axisLabel: {
              formatter: '{value} kWh'
            }
          },

        ],
        series: [
          {
            name: 'Power',
            type: 'bar',
            data: [9, 50, 20],
            markPoint: {
              data: [
                { type: 'max', name: 'Max' },
                { type: 'min', name: 'Min' }
              ]
            },
            markLine: {
              data: [{ type: 'average', name: 'Avg' }]
            }
          },
        ]
      },
    }
  },
  mounted() {
    // console.log(this.theme)
    this.initChart()
    this.refreshData(this.url)
  },
  methods: {
    initChart() {
      this.chart = this.$echarts.init(this.$refs.power, this.theme)
      // 对图表初始化配置的控制
      this.chart.setOption(this.option)
    },
    // 获取服务器的数据
    // async getData() {
    //   const url = '/billsfood/energy/ecodaily'
    //   await getAction(url).then((res) => {
    // this.packingData = res.body.point
    // this.option.series[0].data = res.body.point[4].measureData.dataValue
    // this.power = res.body.point[4].measureData.dataValue
    // console.log('series', this.option.series[0].data)
    // console.log('aaa', this.packingData[4].measureData.dataValue.toString())
    // console.log('bbb', typeof (this.packingData[4].measureData.dataValue))
    // })
    // this.updateChart()
    // },
    // updateChart() {
    //   this.chart.setOption(this.option)
    // },
    refreshData(url) {
      getAction(url).then((res) => {
        this.option.series[0].data = res.body.point[4].measureData.dataValue
      })

      this.timer = setTimeout(() => {
        clearTimeout(this.timer)
        this.refreshData(url)
      }, 5000)
    },

  },
  watch: {
    //观察option的变化
    option: {
      handler(newVal, oldVal) {
        console.log('giabian', newVal, oldVal)
        if (this.chart) {
          if (newVal) {
            console.log('新的')
            this.chart.setOption(newVal)
          }
        }
      },
      deep: true
    }

  },
  destroyed() {
    clearTimeout(this.timer)
  }
}
</script>

<style scoped>

</style>
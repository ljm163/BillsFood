<template>
  <div ref="va"></div>
</template>

<script>
import { getAction } from '../../../../api/manage'

export default {
  name: 'PackingVA',
  props: ['url','theme'],
  data() {
    return {
      option: {
        title: {
          // subtext: 'Fake Data'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['Voltage', 'Current L1', 'Current L2', 'Current L3',]
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
            name: 'Voltage',
            min: 0,
            max: 350,
            interval: 50,
            axisLabel: {
              formatter: '{value} V'
            }
          },
          {
            type: 'value',
            name: 'Current',
            min: 0,
            max: 350,
            interval: 50,
            axisLabel: {
              formatter: '{value} A'
            },
            yAxisIndex: 1
          },
        ],
        series: [
          {
            name: 'Voltage',
            type: 'line',
            data: [],
            markPoint: {
              data: [
                { type: 'max', name: 'Max' },
                { type: 'min', name: 'Min' }
              ]
            },
            markLine: {
              data: [{ type: 'average', name: 'Avg' }]
            },
          },
          {
            name: 'Current L1',
            type: 'line',
            data: [],
            markPoint: {
              data: [
                { type: 'max', name: 'Max' },
                { type: 'min', name: 'Min' }
              ]
            },
            markLine: {
              data: [{ type: 'average', name: 'Avg' }]
            },
            yAxisIndex: 1

          },
          {
            name: 'Current L2',
            type: 'line',
            data: [],
            markPoint: {
              data: [
                { type: 'max', name: 'Max' },
                { type: 'min', name: 'Min' }
              ]
            },
            markLine: {
              data: [{ type: 'average', name: 'Avg' }]
            },
            yAxisIndex: 1

          },
          {
            name: 'Current L3',
            type: 'line',
            data: [],
            markPoint: {
              data: [
                { type: 'max', name: 'Max' },
                { type: 'min', name: 'Min' }
              ]
            },
            markLine: {
              data: [{ type: 'average', name: 'Avg' }]
            },
            yAxisIndex: 1
          },
        ]
      }
    }
  },
  mounted() {
    // console.log(this.theme)
    this.initChart()
    this.refreshData(this.url)
  },
  methods: {
    initChart() {
      this.chart = this.$echarts.init(this.$refs.va, this.theme)
      this.chart.setOption(this.option)
    },
    refreshData(url) {
      getAction(url).then((res) => {
        this.option.series[0].data = res.body.point[0].measureData.dataValue
        this.option.series[1].data = res.body.point[1].measureData.dataValue
        this.option.series[2].data = res.body.point[2].measureData.dataValue
        this.option.series[3].data = res.body.point[3].measureData.dataValue
      })

      this.timer = setTimeout(() => {
        clearTimeout(this.timer)
        this.refreshData(url)
      }, 5000)
    },

  },
  destroyed() {
    clearTimeout(this.timer)
  },
  watch: {
    //观察option的变化
    option: {
      handler(newVal, oldVal) {
        console.log('giabianVA', newVal, oldVal)
        if (this.chart) {
          if (newVal) {
            console.log('新的VA')
            this.chart.setOption(newVal)
          }
        }
      },
      deep: true
    }
  }
}
</script>

<style scoped>

</style>
<template>
  <a-card>
    <p>庫房區功率因數</p>
    <div ref="storePF" style="height: 100px">
    </div>
  </a-card>
</template>

<script>
import { getAction } from '@/api/manage'

export default {
  name: 'StorePF',
  data() {
    return {
      chartInstance: null,
      grade: "",
      factor: 0,
    }
  },
  mounted() {
    this.initChart()
    this.updateChart()
  },
  destroyed() {
  },
  methods: {
    // 初始化echartsInstance对象
    initChart() {
      this.chartInstance = this.$echarts.init(this.$refs.storePF)
      // 对图表初始化配置的控制
      const initOption = {
        series: [
          {
            type: 'gauge',
            startAngle: 180,
            endAngle: 0,
            min: 0,
            max: 1,
            splitNumber: 8,
            axisLine: {
              lineStyle: {
                width: 10,
                color: [
                  [0.25, '#FF6E76'],
                  [0.5, '#FDDD60'],
                  [0.75, '#58D9F9'],
                  // [1, '#7CFFB2']
                  [1, '#74bd68']
                ]
              }
            },
            pointer: {
              icon: 'path://M12.8,0.7l12,40.1H0.7L12.8,0.7z',
              length: '20%',
              width: 12,
              offsetCenter: [0, '-60%'],
              itemStyle: {
                color: 'auto'
              }
            },
            axisTick: {
              length: 5,
              lineStyle: {
                color: 'auto',
                width: 0.5
              },
              show: false
            },
            splitLine: {
              length: 6,
              lineStyle: {
                color: 'auto',
                width: 1
              },
              show: false
            },
            axisLabel: {
              color: '#464646',
              fontSize: 20,
              distance: -60,
              formatter: function (value) {
                if (value === 0.875) {
                  return 'A'
                } else if (value === 0.625) {
                  return 'B'
                } else if (value === 0.375) {
                  return 'C'
                } else if (value === 0.125) {
                  return 'D'
                }
                return ''
              },
              show: false
            },
            title: {
              offsetCenter: [0, '-20%'],
              fontSize: 35,
              color: 'auto',
              fontWeight: 'bold',
            },
            detail: {
              fontSize: 20,
              offsetCenter: [0, '20%'],
              valueAnimation: true,
              formatter: function (value) {
                return value + '%'
              },
              color: 'auto'
            },
            radius: '150%',
            center: ['50%', '75%'],
            // data: [
            //   {
            //     value: 0,
            //     name: 'NaN'
            //   }
            // ],

          },
        ]
      }
      setInterval(this.updateChart, 3000)
      this.chartInstance.setOption(initOption)
    },
    // 获取服务器的数据
    async getData() {
      const url = '/billsfood/energy/powerfactor'
      await getAction(url).then((res) => {
        this.factor = res.body.point[0].measureData.dataValue
        this.grade = this.getGrade(this.factor)
      })
    },
    onChange(date, dateString) {
      console.log(date, dateString)
    },
    getGrade(factor) {
      if (factor > 0.75) {
        return 'A'
      } else if (factor > 0.5) {
        return 'B'
      } else if (factor > 0.25) {
        return 'C'
      }
      return 'D'
    },
    updateChart() {
      this.getData()
      this.chartInstance.setOption({
        series: [
          {
            data: [
              {
                value: this.factor,
                name: this.grade,
              }
            ]
          }
        ]
      })
    },
  }
}
</script>

<style scoped>

</style>
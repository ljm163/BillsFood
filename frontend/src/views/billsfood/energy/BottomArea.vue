<template>

    <a-card>
      <div ref="storePF" style="height: 400px">
      </div>
    </a-card>

</template>

<script>
export default {
  name: 'BottomArea',
  data() {
    return {
      chartInstance: null,
      allData: null,
      dataTimer: null,
    }
  },
  mounted() {
    this.initChart()
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
                width: 2,
                color: [
                  [0.25, '#FF6E76'],
                  [0.5, '#FDDD60'],
                  [0.75, '#58D9F9'],
                  [1, '#7CFFB2']
                ]
              }
            },
            pointer: {
              icon: 'path://M12.8,0.7l12,40.1H0.7L12.8,0.7z',
              length: '12%',
              width: 20,
              offsetCenter: [0, '-20%'],
              itemStyle: {
                color: 'auto'
              }
            },
            axisTick: {
              length: 5,
              lineStyle: {
                color: 'auto',
                width: 2
              }
            },
            splitLine: {
              length: 20,
              lineStyle: {
                color: 'auto',
                width: 5
              }
            },
            axisLabel: {
              color: '#464646',
              fontSize: 20,
              distance: -60,
              formatter: function (value) {
                if (value === 0.875) {
                  return 'A';
                } else if (value === 0.625) {
                  return 'B';
                } else if (value === 0.375) {
                  return 'C';
                } else if (value === 0.125) {
                  return 'D';
                }
                return '';
              }
            },
            title: {
              offsetCenter: [0, '-20%'],
              fontSize: 30
            },
            detail: {
              fontSize: 20,
              offsetCenter: [0, '0%'],
              valueAnimation: true,
              formatter: function (value) {
                return Math.round(value * 100) + '%';
              },
              color: 'auto'
            },
            data: [
              {
                value: 0.7,
                name: 'A'
              }
            ],
            radius: "100%",
            center: ['50%','80%']
          },
        ]
      };
      setInterval(this.updateChart, 2000)
      this.chartInstance.setOption(initOption)

    },
    // 获取服务器的数据
    async getData() {
      const url = '/billsfood/meter/voltage'
      await getAction(url).then((res) => {
        this.allData = res
        console.log(this.allData)
      })
    },
    onChange(date, dateString) {
      console.log(date, dateString)
    },
    statistics(e) {
      if (this.tabStatus === 'store') {
        this.pieType = e.target.value
        this.queryStore()
      } else {
        this.barType = e.target.value
        this.queryPacking()
      }
    },
    meterNum(key) {
      if (key === '1') {
        this.tabMeter = 'store'
        this.queryDatebar()
      } else {
        this.tabMeter = 'packing'
        this.queryDatepie()
      }
    },
    updateChart(){
      const random = +Math.random()
      this.chartInstance.setOption({
        series: [
          {
            data: [
              {
                value: random
              }
            ]
          },
          // {
          //   data: [
          //     {
          //       value: random
          //     }
          //   ]
          // }
        ]
      })
    }
  }
}
</script>

<style scoped>

</style>
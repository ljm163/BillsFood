<!--商家销量统计的横向柱状图-->
<template>
  <div class="com-container" ref="seller_con">
    <div class="com-chart" ref="seller_ref"></div>
  </div>
</template>

<script>
import {getAction} from '@/api/manage'

export default {
  name: "Seller",
  data() {
    return {
      chartInstance: null,
      allData: null,
      currentPage: 2,
      totalPage: 0,
      timerId: null,
    }
  },
  mounted() {
    this.initChar()
    this.getData()
    window.addEventListener('resize', this.screenAdapter)
    // window.addEventListener('resize', this.chartInstance.resize())
  },
  destroyed() {
    clearInterval(this.timerId)
    // 避免内存泄漏
    window.removeEventListener('resize', this.screenAdapter)
  },
  methods: {
    // 初始化echartsInstance对象
    initChar() {
      this.chartInstance = this.$echarts.init(this.$refs.seller_ref, 'dark-blue')
      // 对图表初始化配置的控制
      const initOption = {
        title: {
          text: '丨商家销售统计',
          left: 20,
          top: 20,
        },
        grid: {
          top: '20%',
          left: '3%',
          right: '6%',
          bottom: '3%',
          containLabel: true //距离包含坐标轴文字
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'line',
            z: 0,
            lineStyle: {
              type: 'solid',
              color: '#2D3443'
            }
          }
        },
        xAxis: {
          type: 'value',
        },
        yAxis: {
          type: 'category',
          // data: sellerNames
        },
        series: [{
          type: "bar",
          label: {
            show: true,
            position: 'right',
            textStyle: {
              color: 'white'
            }
          },
          itemStyle: {
            barBorderRadius: [0, 33, 33, 0],
            // 指明颜色渐变的方向
            // 指明不同百分比下颜色的值(x1, y1, x2, y2, [])
            color: new this.$echarts.graphic.LinearGradient(0, 0, 1, 0, [
              // 百分之0状态之下的颜色值
              {
                offset: 0,
                color: '#5052EE'
              },
              // 百分之100状态之下的颜色值
              {
                offset: 1,
                color: '#AB6EE5'
              }])
          }
        }]
      }
      this.chartInstance.setOption(initOption)
      // 对图表对象进行鼠标事件的监听
      this.chartInstance.on('mouseover', () => {
        clearInterval(this.timerId)
      })
      this.chartInstance.on('mouseout', () => {
        this.startInterval()
      })
    },
    // 获取服务器的数据
    async getData() {
      const url = '/evue/seller/list'
      await getAction(url).then((res) => {
        this.allData = res.result.records
        // 对数据排血
        this.allData.sort((a, b) => {
          return a.value - b.value
        })
        this.totalPage = Math.ceil(this.allData.length / 5)
        this.updateChart()
        this.screenAdapter()
        // 启动定时器
        this.startInterval()
      })
    },
    // 更新图表
    updateChart() {
      const start = (this.currentPage - 1) * 5
      const end = this.currentPage * 5
      const showData = this.allData.slice(start, end)
      const sellerNames = showData.map((item) => {
        return item.name
      })
      const sellerValues = showData.map((item) => {
        return item.value
      })
      const dataOption = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'line',
            z: 0,
            lineStyle: {
              type: 'solid',
              width: 66,
              color: '#2D3443'
            }
          }
        },
        yAxis: {
          data: sellerNames
        },
        series: [
          {
            data: sellerValues,
          }
        ]
      }
      this.chartInstance.setOption(dataOption)
    },
    startInterval() {
      if (this.timerId) {
        clearInterval(this.timerId)
      }
      this.timerId = setInterval(() => {
        this.currentPage < this.totalPage ? this.currentPage++ : this.currentPage = 1
        this.updateChart()
      }, 3000)
    },
    screenAdapter() {
      // console.log(this.$refs.seller_con.offsetWidth)
      const titleFontSize = this.$refs.seller_con.offsetWidth / 100 * 3.6
      // 分辨率大小相关配置项
      const adapterOption = {
        title: {
          textStyle: {
            fontSize: titleFontSize,
          }
        },
        tooltip: {
          axisPointer: {
            lineStyle: {
              width: titleFontSize,
            }
          }
        },
        series: [{
          barWidth: titleFontSize,
          itemStyle: {
            barBorderRadius: [0, titleFontSize / 2, titleFontSize / 2, 0],
          }
        }]
      }
      this.chartInstance.setOption(adapterOption)
      // 手动调用图表对象的resize,产生效果
      this.chartInstance.resize()
    }
  }
}
</script>

<style scoped>

</style>
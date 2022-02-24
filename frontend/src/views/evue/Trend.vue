<template>
  <div class="page-header-index-wide">
    <div class="title" :style="comStyle">
      <span>{{ '丨' + showTitle }}</span>
      <span class="titile-icon" @click="showChoice=!showChoice"><strong>></strong></span>
      <!--      <span class="iconfont">&#xe6eb;</span>-->
      <!--      <i class="el-icon-arrow-down"></i>-->
      <div class="select-con" v-show="showChoice" :style="marginStyle">
        <div class="select-item" v-for="item in selectTypes" :key="item.key" @click="handleSelect(item.key)">
          {{ item.text }}
        </div>
        <!--        <div class="select-item">-->
        <!--          我是选择标题2-->
        <!--        </div>-->
        <!--        <div class="select-item">-->
        <!--          我是选择标题3-->
        <!--        </div>-->
      </div>
    </div>
    <div class="com-chart" ref="trend_ref"></div>
  </div>
</template>

<script>
import {getAction} from '@/api/manage'

export default {
  name: "Trend",
  data() {
    return {
      chartInstance: null,
      allData: null,
      // 半透明的颜色值
      colorArr1: [
        'rgba(11, 168, 44, 0.5)',
        'rgba(44, 110, 255, 0.5)',
        'rgba(22, 242, 217, 0.5)',
        'rgba(254, 33, 30, 0.5)',
        'rgba(250, 105, 0, 0.5)',
      ],
      colorArr2: [
        'rgba(11, 168, 44, 0)',
        'rgba(44, 110, 255, 0)',
        'rgba(22, 242, 217, 0)',
        'rgba(254, 33, 30, 0)',
        'rgba(250, 105, 0, 0)',
      ],
      showChoice: false,
      choiceType: 'map', // 显示数据的类型
      titleFontSize: 0 // 指明标题字体大小
    }
  },
  mounted() {
    this.initChart()
    this.getData()
    window.addEventListener('resize', this.screenAdapter)
    this.screenAdapter()
  },
  destroyed() {
    window.removeEventListener('resize', this.screenAdapter)
  },
  computed: {
    selectTypes() {
      if (!this.allData) {
        return [{"key": "map", "text": "无数据"}]
        // return []
      } else {
        // console.log(this.allData.type)
        return this.allData.type.filter(item => item.key !== this.choiceType)
      }
    },
    showTitle() {
      if (!this.allData) {
        return ''
      } else {
        return this.allData[this.choiceType].title
      }
    },
    // 设置给标题样式
    comStyle() {
      return {
        fontSize: this.titleFontSize + 'px'
      }
    },
    marginStyle(){
      return{
        marginLeft: this.titleFontSize + 'px'
      }
    }
  },
  methods: {
    initChart() {
      this.chartInstance = this.$echarts.init(this.$refs.trend_ref, 'dark-blue')
      const initOption = {
        color: this.colorArr1,
        grid: {
          left: '3%',
          top: '35%',
          right: '4%',
          bottom: '1%',
          containLabel: true
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          left: 20,
          top: '15%',
          // icon: 'circle'
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
        },
        yAxis: {
          type: 'value'
        },

      }
      this.chartInstance.setOption(initOption)
    },
    async getData() {
      const url = '/evue/trend/list'
      await getAction(url).then((res) => {
        this.allData = res
        // console.log(res)
      })
      // 对allData进行赋值
      this.updateChart()
      this.screenAdapter()
    },
    updateChart() {
      // 处理数据
      // 类目轴的数据
      const timeArr = this.allData.common.month
      // y轴数据
      // const valueArr = this.allData.map.data
      const valueArr = this.allData[this.choiceType].data
      // 遍历产生新数组
      const seriesArr = valueArr.map((item, index) => {
        return {
          name: item.name,
          type: 'line',
          data: item.data,
          stack: this.choiceType,
          smooth: true,
          areaStyle: {
            color: new this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [
              {
                offset: 0,
                color: this.colorArr1[index]
              },
              {
                offset: 1,
                color: this.colorArr2[index]
              }
            ])
          }
        }
      })
      // 图例的数据遍历数组
      const legendArr = valueArr.map(item => item.name)
      const dataOption = {
        xAxis: {
          data: timeArr
        },
        legend: {
          data: legendArr
        },
        series: seriesArr
      }
      // console.log(seriesArr)
      this.chartInstance.setOption(dataOption)
    },
    screenAdapter() {
      this.titleFontSize = this.$refs.trend_ref.offsetWidth / 100 * 3.6
      const adapterOption = {
        legend: {
          itemWidth: this.titleFontSize/2,
          itemHeight: this.titleFontSize/2,
          itemGap: this.titleFontSize,
          textStyle:{
            fontSize: this.titleFontSize/2
      }
        }
      }
      this.chartInstance.setOption(adapterOption)
      this.chartInstance.resize()
    },
    handleSelect(currentType) {
      this.choiceType = currentType
      this.updateChart()
      this.showChoice = false
    }
  },
}
</script>

<style scoped>
.title {
  position: absolute;
  left: 20px;
  top: 10px;
  z-index: 10;
  color: white;
}

.titile-icon {
  margin-left: 10px;
  cursor: pointer;
}

.select-con {
  background-color: #333;
}
</style>
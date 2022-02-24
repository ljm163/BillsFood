<template>
  <div class="page-header-index-wide">
      <a-row :gutter="24">
        <a-col :sm="24" :md="12" :xl="6" :style="{ marginBottom: '24px' }">
          <chart-card :loading="loading" title="总销售额" total="￥126,560">
            <a-tooltip title="指标说明" slot="action">
              <a-icon type="info-circle-o" />
            </a-tooltip>
            <div>
              <trend flag="up" style="margin-right: 16px;">
                <span slot="term">周同比</span>
                12%
              </trend>
              <trend flag="down">
                <span slot="term">日同比</span>
                11%
              </trend>
            </div>
            <template slot="footer">日均销售额<span>￥ 234.56</span></template>
          </chart-card>
        </a-col>
        <a-col :sm="24" :md="12" :xl="6" :style="{ marginBottom: '24px' }">
          <chart-card :loading="loading" title="订单量" :total="8846 | NumberFormat">
            <a-tooltip title="指标说明" slot="action">
              <a-icon type="info-circle-o" />
            </a-tooltip>
            <div>
              <mini-area />
            </div>
            <template slot="footer">日订单量<span> {{ '1234' | NumberFormat }}</span></template>
          </chart-card>
        </a-col>
        <a-col :sm="24" :md="12" :xl="6" :style="{ marginBottom: '24px' }">
          <chart-card :loading="loading" title="支付笔数" :total="6560 | NumberFormat">
            <a-tooltip title="指标说明" slot="action">
              <a-icon type="info-circle-o" />
            </a-tooltip>
            <div>
              <mini-bar :height="40" />
            </div>
            <template slot="footer">转化率 <span>60%</span></template>
          </chart-card>
        </a-col>
        <a-col :sm="24" :md="12" :xl="6" :style="{ marginBottom: '24px' }">
          <chart-card :loading="loading" title="运营活动效果" total="78%">
            <a-tooltip title="指标说明" slot="action">
              <a-icon type="info-circle-o" />
            </a-tooltip>
            <div>
              <mini-progress color="rgb(19, 194, 194)" :target="80" :percentage="78" :height="8" />
            </div>
            <template slot="footer">
              <trend flag="down" style="margin-right: 16px;">
                <span slot="term">同周比</span>
                12%
              </trend>
              <trend flag="up">
                <span slot="term">日环比</span>
                80%
              </trend>
            </template>
          </chart-card>
        </a-col>
      </a-row>
  </div>
</template>

<script>
import ATooltip from 'ant-design-vue/lib/tooltip/Tooltip'
import ACol from "ant-design-vue/es/grid/Col"
import ChartCard from '@/components/ChartCard'
import MiniArea from '@/components/chart/MiniArea'
import MiniBar from '@/components/chart/MiniBar'
import MiniProgress from '@/components/chart/MiniProgress'
import Trend from '@/components/Trend'

export default {
  name: 'InspecDash',
  data () {
    return {

    }
  },
  components:{
    ATooltip,
    ACol,
    ChartCard,
    MiniArea,
    MiniBar,
    MiniProgress,
    Trend,
  },
  mounted() {
  },
  methods:{
  }
}
</script>

<style scoped>

</style>
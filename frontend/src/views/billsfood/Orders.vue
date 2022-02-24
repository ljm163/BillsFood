<template>
  <a-table
    :columns="columns"
    :data-source="data"
    :loading="loading">
    <span slot="JobComplete" slot-scope="status">
    <a-tag :color="status === false ? 'volcano' : 'green'"
    >
      {{ status === true ? 'Completed' : 'Pending' }}
    </a-tag>
    </span>
    <a slot="JobNum" slot-scope="job">{{ job }}</a>
    <template slot="StartDate" slot-scope="startDate">{{ startDate != null ? startDate.split('T')[0] : '' }}</template>
    <template slot="JobCompletionDate" slot-scope="endDate">{{
        endDate != null ? endDate.substr(0, 10) : ''
      }}
    </template>
  </a-table>
</template>

<script>

// import axios from 'axios'
import { getAction } from '@/api/manage'

export default {

  name: 'orders',
  data() {
    return {
      data: [],
      columns: [
        {
          key: 'JobComplete',
          title: '生產狀態',
          dataIndex: 'JobComplete',
          scopedSlots: { customRender: 'JobComplete' },
        },
        {
          key: 'JobNum',
          title: '工單號',
          dataIndex: 'JobNum',
          width: '15%',
          scopedSlots: { customRender: 'JobNum' },
          sorter: (a, b) => a.JobNum - b.JobNum,
          defaultSortOrder: 'descend'
        }, {
          key: 'PartDescription',
          title: '產品名稱',
          dataIndex: 'PartDescription',
          width: '35%',
        }, {
          key: 'ProdQty',
          title: '生產數量',
          dataIndex: 'ProdQty',
          width: '14%',
        }, {
          key: 'StartDate',
          title: '生產日期',
          dataIndex: 'StartDate',
          scopedSlots: { customRender: 'StartDate' },
          width: '18%',
          sorter: (a, b) => ('' + a.StartDate).localeCompare('' + b.StartDate),
          defaultSortOrder: 'descend'
        }, {
          title: '完成日期',
          dataIndex: 'JobCompletionDate',
          scopedSlots: { customRender: 'JobCompletionDate' },
          width: '18%',
          sorter: true,
        }],
      loading: false,

    }
  },
  mounted() {
    this.getData()
  },
  methods: {
    // handleTableChange(sorter) {
    //
    // },
    async getData() {
      const url = '/billsfood/erp/order'
      this.loading = true
      await getAction(url).then((res) => {
        this.data = res.value
        // console.log(res.value)
        // res.value.forEach(function (i){
        // console.log(i.JobNum)
        // console.log(i.PartDescription)
        // console.log(i.ProdQty)
        // console.log(i.StartDate)
        // console.log(i.JobCompletionDate)
        // console.log(i.JobComplete)
        // })
      })
      this.loading = false
    },

  },
}

</script>

<style scoped>

</style>
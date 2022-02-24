<template>
  <a-list
    itemLayout="horizontal"
    :dataSource="data"
  >
    <a-list-item slot="renderItem" slot-scope="item, index" :key="index">
      <a-list-item-meta>
        <a slot="title">{{ item.title }}</a>
        <span slot="description">
          <span class="security-list-description">{{ item.description }}</span>
          <span v-if="item.value"> : </span>
          <span class="security-list-value">{{ item.value }}</span>
        </span>
      </a-list-item-meta>
      <template v-if="item.actions">
        <a slot="actions" @click="item.actions.callback">{{ item.actions.title }}</a>
      </template>

    </a-list-item>
  </a-list>
</template>

<script>
  export default {
    data () {
      return {
        data: [
          { title: '賬戶密碼' , description: '當前密碼强度', value: '强', actions: { title: '修改', callback: () => { this.$message.info('This is a normal message'); } } },
          // { title: '密保手機' , description: '已绑定手机', value: '6**8293', actions: { title: '修改', callback: () => { this.$message.success('This is a message of success'); } }  },
          { title: '密保問題' , description: '未设置密保问题，密保问题可有效保护账户安全', value: '', actions: { title: '设置', callback: () => { this.$message.error('This is a message of error'); } }  },
          { title: '備用郵箱' , description: '已绑定邮箱', value: 'ant***sign.com', actions: { title: '修改', callback: () => { this.$message.warning('This is message of warning'); } }  },
          { title: 'MFA 設備' , description: '未绑定 MFA 设备，绑定后，可以进行二次确认', value: '', actions: { title: '绑定', callback: () => { this.$message.info('This is a normal message'); } }  },
        ]
      }
    }
  }
</script>

<style scoped>

</style>
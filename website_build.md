# 后端

## 项目结构

```markdown
项目结构
├─jeecg-boot-parent（父POM： 项目依赖、modules组织）
│  ├─jeecg-boot-base（共通模块： 工具类、config、权限、查询过滤器、注解、接口等）
│  ├─jeecg-boot-module-demo    示例代码
│  ├─jeecg-boot-module-system （系统管理权限等功能） -- 默认作为启动项目
│  ├─jeecg-boot-starter（微服务starter模块，不需要微服务可以删掉） 
│  ├─jeecg-cloud-module（微服务生态模块，不需要微服务可以删掉）
```

删除

│  ├─jeecg-boot-starter（微服务starter模块，不需要微服务可以删掉） 
│  ├─jeecg-cloud-module（微服务生态模块，不需要微服务可以删掉）

## 初始化数据库

```markdown
 手工执行Sql脚本： jeecg-boot/db/jeecgboot-mysql-5.7.sql
 会自动建库和初始化数据。
```

```sql
CREATE database if NOT EXISTS `bills_food` default character set utf8mb4 collate utf8mb4_unicode_ci;
use `bills_food`;
```

# 前端

## 执行命令下载依赖

执行命令 yarn install

## 配置后台接口

## 修改后台接口配置 .env.development

```markdown
NODE_ENV=development
VUE_APP_API_BASE_URL=http://localhost:8080/jeecg-boot
VUE_APP_CAS_BASE_URL=http://cas.example.org:8443/cas
VUE_APP_ONLINE_BASE_URL=http://fileview.jeecg.com/onlinePreview
```

### 配置文件说明

#### .env 在所有的环境中被载入

```markdown
NODE_ENV=production
VUE_APP_PLATFORM_NAME=JeecgBoot 企业级快速开发平台
#SSO单点登录开关
VUE_APP_SSO=false     
```

#### .env.development 开发环境中载入（程序启动默认走此配置）

```markdown
NODE_ENV=development
#接口地址
VUE_APP_API_BASE_URL=http://localhost:8080/jeecg-boot
#单点登录地址
VUE_APP_CAS_BASE_URL=http://cas.example.org:8443/cas
#online地址
VUE_APP_ONLINE_BASE_URL=http://fileview.jeecg.com/onlinePreview
```

#### .env.production 生产环境中加载（项目打包默认走此配置）

```markdown
NODE_ENV=production
VUE_APP_API_BASE_URL=https://bootapi.jeecg.com
VUE_APP_CAS_BASE_URL=http://localhost:8888/cas
VUE_APP_ONLINE_BASE_URL=http://fileview.jeecg.com/onlinePreview
```

#### .env.test 测试环境中加载

```markdown
NODE_ENV=production
VUE_APP_API_BASE_URL=http://boot.jeecg.com:8080/jeecg-boot
VUE_APP_CAS_BASE_URL=http://cas.example.org:8443/cas
VUE_APP_ONLINE_BASE_URL=http://fileview.jeecg.com/onlinePreview
```

如果需要用此配置打包，请点击命令

![img](D:\HKPC\BillsFood_Web\img\7ef4d90e7d7dd477ee05bc63b703bec8_255x218.png)
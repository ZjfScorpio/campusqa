

















## 更新说明

### 20-3-12（v3）

#### 页面优化

```
优化了页面布局、导航栏、用户头像等细节
```

#### 其他

```
服务器资源已修复
redis换了端口，添加了密码
mysql密码复杂化

本地使用只需要修改mysql为本地（application.properties），其他建议用远程资源，不用修改
```



### 20-3-5（v2）

#### 新增功能

```
普通用户
查看关注问题列表、查看回答列表

管理员
后台管理页面
```

#### 后台管理

```
地址：
localhost/admin

用户名:admin
密码：admin
```

#### 说明

```
1. 服务器炸了暂停使用，测试用本地资源
2. 数据库有更新，重新导入resource下的campusqa.sql
```



## 项目说明

**题目**

校园内自动应答平台

**基本功能**

符合大学生行为习惯的的网络问答社区，社区氛围友好、理性、认真，连接各个学院的的精英。分享着彼此的专业知识、经验和见解，提供一个良好的校园内知识分享系统。

注册的学生可以发送问题，同时也可以回答别人的问题。

**扩展功能**

1、匹配算法：可以通过关键字分析，自动为发送的问题匹配相应的回答内容。

2、 行为分析，根据用户提问习惯累积分析该用户所在行业，性格等信息。

## 如何开始

#### 使用服务器资源（速度慢）

- git clone 本项目
- 使用IDEA-File-Open-打开项目下的pom.xml-Open as Project
- 打开maven的Auto-import，待依赖下载完成
- 运行CampusQaApplication
- 浏览器输入localhost

#### 使用本机资源（适合调试开发）

- git clone 本项目
- 使用IDEA-File-Open-打开项目下的pom.xml-Open as Project
- 打开maven的Auto-import，待依赖下载完成
- 修改application.properties

```
#mysql改为本地信息
spring.datasource.url=jdbc:mysql://localhost:3306/campusqa?useUnicode=true&characterEncoding=utf8&useSSL=false
spring.datasource.username=root
spring.datasource.password=root
```

- 修改Constant.java

```
    //根据需要选择localIp还是remoteIp
    private static String localIp = "localhost";
    private static String remoteIp = "47.102.193.234";

    //项目运行服务器
    public static final String IP = localIp;
    public static final String PORT = "80";

    //redis服务器
    public static final String REDIS_IP = localIp;
    public static final int REDIS_PORT = 6379;

    //solr服务器
    public static final String SOLR_IP = localIp;
    public static final String SOLR_PORT = "8983";
    public static final String SOLR_CORE = "/solr/campusqa";
```

- 数据库

```
新建数据库campusqa，使用utf-8字符集
导入项目中campusqa.sql中表结构和数据
```

- redis

```
安装windows或linux版本redis，6379端口打开，非后台方式不要关闭窗口
```

- solr

```
下载、解压群里提供的solr
打开bin目录下的start.bat
浏览器输入localhost:8983，看到页面成功
```

## 功能实现

### **已经实现**

**未登录**

查看问题和回答、搜索问题、注册

**普通用户**

查看问题和回答、搜索问题、注册、

登录、提问、回答、查看删除自己提问、删除自己回答

关注、粉丝、私信、关注问题

查看关注问题列表、查看回答列表（v2）

**管理员**

后台管理页面(v2)

### **等待实现**

**普通用户**

主页推荐

## 结构说明

```
main:java代码和资源文件
	java:
		async:各种事件处理，包括评论提醒，添加问题同步solr库等（不懂没关系）
		constant:一些常量，指定各种资源ip和端口，方便更改
		controller:和前端的交互接口
		dao:操控数据库接口
		intercepter:拦截器，登录验证
		model：实体，对应数据库表
		service：业务逻辑，model和controller的中间一层
		util：工具类，辅助使用
		vo：封装给前端的value object
		CampusQaApplication.class：程序入口
	resource:
		Mapper:类似dao层
		static：静态资源,css和js
		templates：html页面
		application.properties：一些配置
		campusqa.sql：数据库表结构和数据
		mybatis-config.xml：mybatis配置
test:单元测试
pom.xml:项目依赖，jar包管理
```



## **技术栈**

**开发工具**

```
IntelliJ IDEA 2019.3
```

**前端**

```
freemarker：前端模板引擎，渲染整个前端模板
bootstrap：css样式
```

**后端**

```
java：jdk1.8
springboot：1.5.15.RELEASE
- intercepter拦截器实现登录权限控制
- javax.mali邮件服务，如有新评论时发邮件通知用户，注册时邮件验证
- maven管理整个项目依赖
mybatis
```

**数据库**

```
mysql5.7

redis：缓存数据库，实现异步队列，利用多线程实现异步事件处理，主要针对一些耗时操作，进行异步执行，如发邮件，评论后发站内私信通知等，使用 Redis 数据结构中的 set 集合实现用户对问题评论的点赞点踩功能
```

**搜索**

```
solr
```










## 简述(趁早)
趁早(quickearly)B2C早餐外卖微信小程序，理想经营范围为人口密集的小区。用户可以提前预定，选择预定时间，也可以立即下单
，查看配送进度,也可以预定好了，到店给出二维码即可取早餐,节约在人多的时候排队的时间
## 图片简介
![Image text](https://github.com/DuncanPlayer/quickearly/blob/master/imgposition/img/coupon.JPG)![Image text](https://github.com/DuncanPlayer/quickearly/blob/master/imgposition/img/detail.JPG)![Image text](https://github.com/DuncanPlayer/quickearly/blob/master/imgposition/img/coment.JPG)
## 主要技术点
- 配置三个节点的Nginx作为负载均衡器，第一个Nginx负责请求分发给后面两个Nginx，最后再把请求发送到不同的Tomcat容器
- 使用Redis Cluster作为早餐详细页面的第一级缓存
- 配置使用Ehcache作为页面的第二级缓存，并设置LRU清除策略
- 选用RabbitMQ中间件,异步保存聊天消息、记录订单的详细信息，并配置每次从队列中消费一条消息；并采用KeepAlive+Haproxy
- 使用FastDFS+Nginx的Http服务保存用户评价的图片，用户上传的头像图片
- 选用ElasticSearch作为分布式搜索引擎，早餐名(name字段)使用ik_max_word分词器
- 使用Netty+WebSocket实现聊天服务器，实现用户与店家的交流，并发送数据到mq,保存聊天消息和图片
- 使用Zookeeper作为分布式锁,保证库存扣减的一致性（本项目作用不大）
- 配置一主一从的MySQL进行读写分离、主从同步,使用ThreadLocal方式动态改变数据源
- Spring+Spring MVC+Mybatis框架整合开发，聊天、搜索和后台使用SpringBoot搭建
- 根据用户的点击率和购买记录为用户推荐
- 后台管理使用Dockerfile方式构建镜像并运行
## 使用环境
- Centos7
- JDK8
- Maven3.5
- MySQL5.6
- 微信web开发者工具
- IntelliJ IDEA2018
## 小程序端代码地址
- https://github.com/DuncanPlayer/quickearly--applet
- 备注:聊天和早餐检索已经抽取成新的项目
## 后台管理程序
- https://github.com/DuncanPlayer/earlyadmin
![Image text](https://github.com/DuncanPlayer/quickearly/blob/master/imgposition/img/log.JPG)
## 聊天和搜索

## 方便面的微信二维码
![Image text](https://github.com/DuncanPlayer/quickearly/blob/master/imgposition/img/sby.JPG)

## 简述
关于早餐配送And在线的微信小程序，理想经营范围为人口密集的小区。用户可以提前预定，选择预定时间，也可以立即下单，查看配送进度
## 图片简介
![Image text](https://github.com/DuncanPlayer/quickearly/blob/master/imgposition/early.JPG)![Image text](https://github.com/DuncanPlayer/quickearly/blob/master/imgposition/detail.JPG)![Image text](https://github.com/DuncanPlayer/quickearly/blob/master/imgposition/qrCode.JPG)
## 主要技术点
- 使用Nginx作为负载均衡器，把请求发送到不同的Tomcat容器;同时开启ngx.shared缓存，作为详细页面的第一级缓存
- 使用Redis Cluster作为早餐详细页面的第二级缓存
- 使用Ehcache做为页面的第三级缓存，并设置LRU清除策略
- 选用RabbitMq中间件,异步保存聊天消息、记录订单的详细信息，并配置每次从队列中消费一条消息；并采用KeepAlive+Haproxy高可用方案
- 使用FastDFS+Nginx的Http服务保存用户评价的图片，上传的头像图片
- 选用ElasticSearch作为分布式搜索引擎，早餐名(name字段)使用ik_max_word分词器
- 使用Netty+WebSocket实现聊天服务器，实现用户与店家的交流，并发送数据到mq,保存聊天消息和图片
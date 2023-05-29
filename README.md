# Transformer

Transformer 是可为变更数据捕获 (CDC) 提供低延迟数据流平台。您设置并配置 Transformer以监控您的数据库，然后您的应用程序会为对数据库所做的每个行级更改使用事件。只有提交的更改是可见的，因此您的应用程序不必担心回滚的事务或更改。Transformer提供所有更改事件的单一模型，因此您的应用程序不必担心每种数据库管理系统的复杂性。此外，由于 Transformer在持久的、复制的日志中记录了数据更改的历史记录，因此您的应用程序可以随时停止和重新启动，并且它将能够消耗它在未运行时错过的所有事件。

## 基本架构

Transformer是一个变更数据捕获 (CDC) 平台，它通过重用 Kafka , RocketMQ 和 Kafka Connect 来实现其耐用性、可靠性和容错质量。部署到 Kafka Connect 分布式、可扩展、容错服务的每个连接器都监视单个上游数据库服务器，捕获所有更改并将它们记录在一个或多个 Kafka 主题（通常每个数据库表一个主题）中。Kafka 确保所有这些数据更改事件都被复制和完全有序，并允许许多客户端独立使用这些相同的数据更改事件，而对上游系统的影响很小。此外，客户可以随时停止消费，当他们重新开始消费时，他们会从中断的地方继续消费。每个客户端都可以确定他们是否想要一次或至少一次交付所有数据更改事件。

![Transformer](https://github.com/regancz/Transformer/blob/main/document/img/Transformer.png)

## 快速开始

1. 使用document/docker/docker-compose-env.yml启动RocketMQ，注意配置broker.conf
2. 使用transformer-mbg模块生成使用的数据库crud操作
3. 修改transformer-core中DebeziumListener的handleChangeEvent，自定义监听的事务处理，自定义RocketMQ的producer和consumer和后续流程。xx_replicateData提供了对数据库的操作，service提供了FabricMetric的使用示例

![image-20230529113306679](https://github.com/regancz/Transformer/blob/main/document/img/image-20230529113306679.png)

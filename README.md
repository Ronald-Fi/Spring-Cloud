# Spring-Cloud

该仓库为个人学习记录Spring系列源码,包含Spring Boot、Spring Data、Spring Security、Spring Cloud、Spring Cloud Alibaba 等Spring系列,如果该系列教程对您有帮助的话，还请点个Star给予精神支持！🐤

### 目录

- [Design-Principles:设计原则]
    - 开闭原则 [Open-Closed Principle]
    - 依赖倒置原则 [Dependence Inversion Principle]
    - 单一职责原则 [Simple Responsibility Principle]
    - 接口隔离原则 [Interface Segregation Principle]
    - 迪米特法则 [Law of Demeter]
    - 里式替换原则 [Liskov Substitution Principle]
    - 合成复用原则 [Composite&Aggregate Reuse Principle]
- [Design Patterns:设计模式]
    - 工厂模式 [Factory Pattern]
    - 单例模式 [Singleton Pattern]
    - 原型模式 [Prototype Pattern]
    - 建造者模式 [Builder Pattern]
    - 代理模式 [Proxy Pattern]
    - 门面模式 [Facade Pattern]
    - 装饰器模式 [Decorator pattern]
    - 享元模式 [Flyweight Pattern]
    - 组合模式 [Combination Pattern]
    - 适配器模式 [Adapter Pattern]
    - 桥接模式 [Bridge Pattern]
    - 委派模式 [Delegation Pattern]
    - 模板方法模式 [Template method pattern]
    - 策略模式 [Strategy Pattern]
    - 责任链模式 [Chain of responsibility Pattern]
    - 迭代器模式 [Iterator Pattern]
    - 命令模式 [Command Pattern]
    - 状态模式 [State Pattern]
    - 备忘模式 [Memo Pattern]

#### 核心原理

- [分布式与高并发]
    - 分布式并发编程
    - 分布式架构
    - 分布式通信框架
    - 分布式服务治理
- [分布式与微服务]
    - [Spring Cloud Netflix]
        - [Spring Cloud Config]
        - [Eureka]
        - [Hystrix]
        - [Ribbon]
        - [Hystrix]
        - [Zuul]
        - [Spring Cloud Stream]
        - [Spring Cloud Security]
    - [Redis]
        - [基础]
        - [原理]
        - [分布式]

### Spring Cloud集成项目简介[顺序不分先后]

- [Eureka]
    - 云端服务发现，一个基于 REST 的服务，用于定位服务，以实现云端中间层服务发现和故障转移。
- [Hystrix]
    - 熔断器，容错管理工具，旨在通过熔断机制控制服务和第三方库的节点,从而对延迟和故障提供更强大的容错能力。
- [Zuul]
    - Zuul 是在云平台上提供动态路由,监控,弹性,安全等边缘服务的框架。Zuul 相当于是设备和 Netflix 流应用的 Web 网站后端所有请求的前门。
- [Archaius]
    - 配置管理API，包含一系列配置管理API，提供动态类型化属性、线程安全配置操作、轮询框架、回调机制等功能。
- [Consul]
    - 封装了Consul操作，consul是一个服务发现与配置工具，与Docker容器可以无缝集成。
- [Ribbon]
    - 提供云端负载均衡，有多种负载均衡策略可供选择，可配合服务发现和断路器使用。
- [Turbine]
    - 聚合服务器发送事件流数据的一个工具，用来监控集群下hystrix的metrics情况。
- [Feign]
    - Feign是一种声明式、模板化的HTTP客户端。
- [Spring Boot]
    - 通过Spring Boot，可以轻松地创建独立的，基于生产级别的基于Spring的应用程序。
- [Spring Framework]
    - Spring框架为任何类型的部署平台上的基于Java的现代企业应用程序提供了全面的编程和配置模型。
- [Spring Data]
    - Spring Data的任务是为数据访问提供一个熟悉且一致的，基于Spring的编程模型，同时仍保留基础数据存储的特​​殊特征。
- [Spring Cloud]
    - Spring Cloud为开发人员提供了工具，以快速构建分布式系统中的一些常见模式（例如，配置管理，服务发现，断路器，智能路由，微代理，控制总线，一次性令牌，全局锁，领导选举，分布式 会话，群集状态）。
- [Spring Cloud Config]
    - 配置管理工具包，让你可以把配置放到远程服务器，集中化管理集群配置，目前支持本地存储、Git以及Subversion。
- [Spring Cloud Bus]
    - 事件、消息总线，用于在集群（例如，配置变化事件）中传播状态变化，可与Spring Cloud Config联合实现热部署。
- [Spring Cloud for Cloud Foundry]
    - 通过Oauth2协议绑定服务到CloudFoundry，CloudFoundry是VMware推出的开源PaaS云平台。
- [Spring Cloud Sleuth]
    - 日志收集工具包，封装了Dapper和log-based追踪以及Zipkin和HTrace操作，为SpringCloud应用实现了一种分布式追踪解决方案。
- [Spring Cloud Data Flow]
    - 大数据操作工具，作为Spring XD的替代产品，它是一个混合计算模型，结合了流数据与批量数据的处理方式。
- [Spring Cloud Security]
    - 基于spring security的安全工具包，为你的应用程序添加安全控制。
- [Spring Cloud Zookeeper]
    - 操作Zookeeper的工具包，用于使用zookeeper方式的服务发现和配置管理。
- [Spring Cloud Stream]
    - 数据流操作开发包，封装了与Redis,Rabbit、Kafka等发送接收消息。
- [Spring Cloud CLI]
    - 基于 Spring Boot CLI，可以让你以命令行方式快速建立云组件。
- [Spring Cloud Task]
    - 提供云端计划任务管理、任务调度。
- [Spring Cloud Connectors]
    - 便于云端应用程序在各种PaaS平台连接到后端，如：数据库和消息代理服务。
- [Spring Cloud Cluster]
    - 提供Leadership选举，如：Zookeeper, Redis, Hazelcast, Consul等常见状态模式的抽象和实现。
- [Spring Cloud Starters]
    - Spring Boot式的启动项目，为Spring Cloud提供开箱即用的依赖管理。
- [Spring Cloud Data Flow]
    - 用于Cloud Foundry和Kubernetes的基于微服务的流式处理和批处理数据处理。
- [Spring Session]
    - Spring Session提供了用于管理用户会话信息的API和实现。
- [Spring for Apache Kafka]
    - 用于Apache Kafka的Spring（spring-kafka）项目将核心Spring概念应用于基于Kafka的消息传递解决方案的开发。
- [Spring Web Flow]
    - Spring Web Flow建立在Spring MVC的基础上，并允许实现Web应用程序的“流”。
- [Spring Web Services]
    - 创建文档驱动的Web服务。 Spring Web Services旨在促进合同优先SOAP服务的开发，从而允许使用多种处理XML有效负载的方式之一来创建灵活的Web服务。

持续更新中...
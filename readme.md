一个服务注册中心，eureka server,端口为8761
service-hi工程跑了两个实例，端口分别为8762,8763，分别向服务注册中心注册
sercvice-ribbon端口为8764,向服务注册中心注册
当sercvice-ribbon通过restTemplate调用service-hi的hi接口时，因为用ribbon进行了负载均衡，会轮流的调用service-hi：8762和8763 两个端口的hi接口；
https://blog.csdn.net/forezp/article/details/81040946

在微服务架构中，需要几个基础的服务治理组件，包括服务注册与发现、服务消费、负载均衡、断路器、智能路由、配置管理等，由这几个基础组件相互协作，共同组建了一个简单的微服务系统。一个简答的微服务系统如下图：

一、Zuul简介在上一篇文章讲述zuul的时候，已经提到过，使用配置服务来保存各个服务的配置文件。它就是Spring Cloud Config
Zuul的主要功能是路由转发和过滤器。路由功能是微服务的一部分，比如／api/user转发到到user服务，/api/shop转发到到shop服务。zuul默认和Ribbon结合实现了负载均衡的功能。



原  史上最简单的SpringCloud教程 | 第十三篇: 断路器聚合监控(Hystrix Turbine)(Finchley版本)
转载请标明出处： http://blog.csdn.net/forezp/article/details/70233227 本文出自方志朋的博客 上一篇文章讲述了如何利用Hystrix Dashboard去监控断路器的Hystrix command。当我们有很多个服务的时候...

2018-07-14 10:19:59

阅读数：5274

评论数：6

原  史上最简单的SpringCloud教程 | 第十二篇: 断路器监控(Hystrix Dashboard)(Finchley版本)
转载请标明出处： http://blog.csdn.net/forezp/article/details/70217283 本文出自方志朋的博客 在我的第四篇文章断路器讲述了如何使用断路器，并简单的介绍了下Hystrix Dashboard组件，这篇文章更加详细的介绍Hys...

2018-07-14 10:19:02

阅读数：5837

评论数：12

原  史上最简单的SpringCloud教程 | 第十篇: 高可用的服务注册中心(Finchley版本)
转载请标明出处： http://blog.csdn.net/forezp/article/details/70183572 本文出自方志朋的博客 文章 史上最简单的 SpringCloud 教程 | 第一篇: 服务的注册与发现（Eureka） 介绍了服务注册与发现，其中服务...

2018-07-14 10:18:07

阅读数：6658

评论数：19

原  史上最简单的SpringCloud教程 | 第九篇: 服务链路追踪(Spring Cloud Sleuth)(Finchley版本)
转载请标明出处： http://blog.csdn.net/forezp/article/details/70162074 本文出自方志朋的博客 这篇文章主要讲述服务追踪组件zipkin，Spring Cloud Sleuth集成了zipkin组件。 一、简介 ...

2018-07-14 10:16:13

阅读数：7287

评论数：12

原  原 史上最简单的SpringCloud教程 | 第八篇: 消息总线(Spring Cloud Bus)(Finchley版本)
转载请标明出处： http://blog.csdn.net/forezp/article/details/70148235 本文出自方志朋的博客 转载请标明出处： Spring Cloud Bus 将分布式的节点用轻量的消息代理连接起来。它可以用于广播配置文件的...

2018-07-14 10:15:06

阅读数：9177

评论数：18

原  史上最简单的SpringCloud教程 | 第七篇: 高可用的分布式配置中心(Spring Cloud Config)(Finchley版本)
转载请标明出处： http://blog.csdn.net/forezp/article/details/70037513 本文出自方志朋的博客 上一篇文章讲述了一个服务如何从配置中心读取文件，配置中心如何从远程git读取配置文件，当服务实例很多时，都从配置中心读取文件，这...

2018-07-14 10:14:06

阅读数：9088

评论数：30

原  史上最简单的SpringCloud教程 | 第六篇: 分布式配置中心(Spring Cloud Config)(Finchley版本)
转载请标明出处： http://blog.csdn.net/forezp/article/details/70037291 本文出自方志朋的博客 在上一篇文章讲述zuul的时候，已经提到过，使用配置服务来保存各个服务的配置文件。它就是Spring Cloud Config。...

2018-07-14 10:13:10

阅读数：12292

评论数：45

原  史上最简单的SpringCloud教程 | 第五篇: 路由网关(zuul)(Finchley版本)
转载请标明出处： http://blog.csdn.net/forezp/article/details/69939114 本文出自方志朋的博客 在微服务架构中，需要几个基础的服务治理组件，包括服务注册与发现、服务消费、负载均衡、断路器、智能路由、配置管理等，由这几个基础组...

2018-07-14 10:11:41

阅读数：13632

评论数：24

原  史上最简单的SpringCloud教程 | 第四篇:断路器（Hystrix）(Finchley版本)
转载请标明出处： http://blog.csdn.net/forezp/article/details/69934399 本文出自方志朋的博客 在微服务架构中，根据业务来拆分成一个个的服务，服务与服务之间可以相互调用（RPC），在Spring Cloud可以用RestTe...

2018-07-14 10:10:17

阅读数：13322

评论数：35

原  史上最简单的SpringCloud教程 | 第三篇: 服务消费者（Feign）(Finchley版本)
转载请标明出处： http://blog.csdn.net/forezp/article/details/69808079 本文出自方志朋的博客 上一篇文章，讲述了如何通过RestTemplate+Ribbon去消费服务，这篇文章主要讲述如何通过Feign去消费服务。 ...

2018-07-14 10:07:35

阅读数：16385

评论数：36

原  史上最简单的SpringCloud教程 | 第二篇: 服务消费者（rest+ribbon）(Finchley版本)
转载请标明出处： http://blog.csdn.net/forezp/article/details/69788938 本文出自方志朋的博客 在上一篇文章，讲了服务的注册和发现。在微服务架构中，业务都会被拆分成一个独立的服务，服务与服务的通讯是基于http restfu...

2018-07-14 10:05:50

阅读数：20601

评论数：29

原  史上最简单的 SpringCloud 教程 | 第一篇： 服务的注册与发现Eureka(Finchley版本)
转载请标明出处： http://blog.csdn.net/forezp/article/details/69696915 本文出自方志朋的博客 一、spring cloud简介 鉴于《史上最简单的Spring Cloud教程》很受读者欢迎，再次我特意升级了一下版本，...

2018-07-14 10:04:27

阅读数：43000

评论数：42

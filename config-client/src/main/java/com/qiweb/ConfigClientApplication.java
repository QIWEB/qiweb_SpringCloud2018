package com.qiweb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient  // 服务注册与发现
@EnableEurekaClient  //消费者
@RefreshScope //spring-cloud 实现更新配置不用重启服务 @RefreshScope作用的类，不能是final类，否则启动时会报错，类似下面这堆
@RestController
public class ConfigClientApplication {
    /**
     * http://localhost:8881/actuator/bus-refresh
     * 这时我们去代码仓库将foo的值改为“foo version 4”，即改变配置文件foo的值。如果是传统的做法，需要重启服务，才能达到配置文件的更新。此时，我们只需要发送post请求：http://localhost:8881/actuator/bus-refresh，你会发现config-client会重新读取配置文件
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${foo}")
    String foo;
    @RequestMapping(value = "/hiConfigServer")
    public String hi(){
        return foo;
    }
}
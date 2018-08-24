package com.qiweb;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@EnableHystrix //注解开启断路器
@EnableHystrixDashboard //注解，开启HystrixDashboard
@EnableCircuitBreaker
//1、Application.java 建议放到跟目录下面,主要用于做一些框架配置
//
//		2、domain目录主要用于实体（Entity）与数据访问层（Repository）
//
//		3、service 层主要是业务类代码
//
//		4、controller 负责页面访问控制
//
//
//
//		采用默认配置可以省去很多配置，当然也可以根据自己的喜欢来进行更改
//
//		最后，启动Application main方法，至此一个java项目搭建好了！
public class ServiceHiApplication {
	/**
	 * /**
	 * 访问地址 http://localhost:8762/actuator/hystrix.stream
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}
	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	@HystrixCommand(fallbackMethod = "hiError")
	public String home(@RequestParam(value = "name", defaultValue = "qiweb") String name) {
		return "hi " + name + " ,i am from port:" + port;
	}

	public String hiError(String name) {
		return "hi,"+name+",sorry,error 断路器 服务不通!";
	}
}

package com.qiweb.service;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry 这是feign自带的熔断器不用改pom需要在配置文件中开启 "+name;
    }
}
package com.qiweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by office on 2018/8/24.
 */
@RestController
public class CustomerController {
    @RequestMapping("/hi3")
    public String index() {
        return "Hello World dd噩噩3333333333333333噩硕鼠硕鼠噩点点滴滴555d";
    }
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: ${todo} {一句话描述类是干什么的}<br/>
 *
 * @author zhaofeng
 * @version 1.0
 * @date: 2020/3/13 16:50
 * @since JDK 1.8
 */
@RestController
public class GrpcController {
    @Autowired
    private FoobarService foobarService;

    @RequestMapping("/hello")
    public String hello(@RequestParam(defaultValue = "Michael") String name) {
        return foobarService.receiveGreeting(name);
    }
}

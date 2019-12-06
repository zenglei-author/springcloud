package com.soulless.service.ribbon.controller;

import com.soulless.service.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hi")
    public String hi(@RequestParam String name) {
        return this.helloService.hiService(name) + "service-ribbon";
    }

}

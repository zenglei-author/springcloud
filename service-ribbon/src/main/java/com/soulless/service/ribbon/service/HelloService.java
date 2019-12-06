package com.soulless.service.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    // 开启Hystrix断路器功能
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        // 调用service-hi服务
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    // hiService开启断路器后指定的方法 断路器方法参数必须与该接口一致
    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}

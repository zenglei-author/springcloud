package com.soulless.service.feign.remote;

import com.soulless.service.feign.remote.hystrix.ScheduleServiceHiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(value = "service-hi")
// 开启断路器，在FeignClient接口的注解中加上fallback的指定类
@FeignClient(value = "service-hi", fallback = ScheduleServiceHiHystrix.class)
public interface ScheduleServiceHi {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}

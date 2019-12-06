package com.soulless.service.feign.remote.hystrix;

import com.soulless.service.feign.remote.ScheduleServiceHi;
import org.springframework.stereotype.Component;

// 实现接口断路器
@Component
public class ScheduleServiceHiHystrix implements ScheduleServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}

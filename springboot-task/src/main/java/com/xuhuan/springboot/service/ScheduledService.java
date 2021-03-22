package com.xuhuan.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author huan.xu
 * @Time 2019-05-09 11:03
 */
@Service
public class ScheduledService {

    /**
     * 表达式：秒，分，时，日，月，周几
     */
    @Scheduled(cron = "0 * * * * *")
    public void hello(){
        System.out.println("hello...");
    }
}

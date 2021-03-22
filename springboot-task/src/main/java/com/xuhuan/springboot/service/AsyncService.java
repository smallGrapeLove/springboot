package com.xuhuan.springboot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author huan.xu
 * @Time 2019-05-09 10:52
 */
@Service
public class AsyncService {

    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("format data ....");
    }
}

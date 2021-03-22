package com.xuhuan.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAsync
@SpringBootApplication
public class Springboot4TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot4TaskApplication.class, args);
    }

}

package com.xuhuan.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableDubbo
@SpringBootApplication
public class PrividerTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrividerTicketApplication.class, args);
	}

}

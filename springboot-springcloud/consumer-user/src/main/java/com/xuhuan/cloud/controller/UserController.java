package com.xuhuan.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author huan.xu
 * @Time 2019-05-15 18:12
 */
@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/buy")
    public String byTicket(String name){
        String ticketName = restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);
        return name+"购买了："+ticketName;

    }
}

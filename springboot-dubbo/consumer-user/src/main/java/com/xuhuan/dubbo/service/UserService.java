package com.xuhuan.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @author huan.xu
 * @Time 2019-05-14 18:39
 */
@Component
public class UserService {

    @Reference
    TicketService ticketService;

    public void sayHello(){
        String ticket = ticketService.getTicket();
        System.out.println("买到票了："+ticket);
    }
}

package com.xuhuan.cloud.controller;

import com.xuhuan.cloud.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huan.xu
 * @Time 2019-05-14 20:16
 */
@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/ticket")
    public String getTicket(){
        return ticketService.getTricket();

    }
}

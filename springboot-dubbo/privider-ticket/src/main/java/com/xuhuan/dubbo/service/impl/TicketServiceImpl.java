package com.xuhuan.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xuhuan.dubbo.service.TicketService;

/**
 * @author huan.xu
 * @Time 2019-05-14 18:17
 */
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "厉害了，我的国";
    }
}

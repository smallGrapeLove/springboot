package com.xuhuan.springboot.service;

import com.xuhuan.springboot.beans.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author huan.xu
 * @Time 2019-05-06 17:36
 */
@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book) {
        System.out.println("收到消息：" + book);
    }

    @RabbitListener(queues = "atguigu")
    public void receive02(Message message) {
        System.out.println("收到消息：" + message.getBody());
        System.out.println("收到消息：" + message.getMessageProperties());
    }
}

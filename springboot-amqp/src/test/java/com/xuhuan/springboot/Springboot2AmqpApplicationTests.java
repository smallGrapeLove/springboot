package com.xuhuan.springboot;

import com.xuhuan.springboot.beans.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot2AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void contextLoads() {

    }

    @Test
    public void createExchange() {
        //amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        //amqpAdmin.declareQueue(new Queue("amqpadmin.queue"));
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.exchange", "amqp.haha", null));
        System.out.println("创建完成");

    }

    @Test
    public void sendMsg() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 123, true));

        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", new Book("name", "author"));
    }

    @Test
    public void sendMsgAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 123, true));

        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("name", "author"));
    }

    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

}

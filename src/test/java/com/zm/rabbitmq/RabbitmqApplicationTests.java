package com.zm.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;


    /**
     * 1、点对点
     */
    @Test
    public void send() {
//        rabbitTemplate.send(交换机，路由键，消息体);

//        消息体可以直接传入对象  将会自动序列化
//        rabbitTemplate.convertAndSend(交换机，路由键，消息体);

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("name","zm");
        objectObjectHashMap.put("list", Arrays.asList("1","2","3","4"));

        //对象被默认序列化
        rabbitTemplate.convertAndSend("excange.direct","zm.news",objectObjectHashMap);
    }
    /*
     * 接收消息
     * 默认是使用的java的序列化机制
     */
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("zm.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

}

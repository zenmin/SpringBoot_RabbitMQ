package com.zm.rabbitmq;

import com.zm.rabbitmq.bena.Book;
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
        Book book = new Book();
        book.setId("1");
        book.setName("书名1");
        book.setPrice("12.3");
        //对象被默认序列化
        rabbitTemplate.convertAndSend("amqp.exchange","admin.qqq",book);
    }

    /*
     * 给exchange.fanout交换机下所有队列发送消息
     */
    @Test
    public void sendAll() {
        Book book = new Book();
        book.setId("1");
        book.setName("书名1");
        book.setPrice("12.3");
        //对象被默认序列化
        rabbitTemplate.convertAndSend("exchange.fanout","zm.news",book);
    }
    /*
     * 给exchange.Topic交换机下所有队列  根据规则发送消息
     */
    @Test
    public void sendByTopic() {
        Book book = new Book();
        book.setId("1");
        book.setName("书名1");
        book.setPrice("12.3");
        //对象被默认序列化
        rabbitTemplate.convertAndSend("exchange.topic","xxx.news",book);
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

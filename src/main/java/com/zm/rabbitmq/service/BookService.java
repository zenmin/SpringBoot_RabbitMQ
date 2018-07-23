package com.zm.rabbitmq.service;

import com.zm.rabbitmq.bena.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/7/23 20:53
 */
@Service
public class BookService {

    @RabbitListener(queues = "zm.news")     //监听消息队列
    public void recevied(Book o){
        System.out.println("收到zm.news");
        System.out.println(o);
    }

    @RabbitListener(queues = "zm")     //监听消息队列
    public void receviedZM(Message message){
        System.out.println("收到zm");
        System.out.println(message);
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties().getConsumerQueue());
        System.out.println(message.getMessageProperties().getHeaders());
    }
}

package com.zm.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/7/23 21:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AMQPAdminTest {

    @Autowired
    AmqpAdmin admin;

    @Test
    public void createExchange(){
          //新建交换器                                  //名称                //是否持久化         //是否自动删除
        admin.declareExchange(new DirectExchange("amqp.exchange",true,false));
        System.out.println("amqp.exchange");

        //新建队列
        String s = admin.declareQueue(new Queue("admin.queue"));
        System.out.println(s);

        //绑定队列到交换器上
        admin.declareBinding(new Binding("admin.queue", Binding.DestinationType.QUEUE, "amqp.exchange", "admin.qqq", null));

    }



}

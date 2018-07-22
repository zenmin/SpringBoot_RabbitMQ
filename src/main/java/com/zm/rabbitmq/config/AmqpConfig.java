package com.zm.rabbitmq.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/7/22 12:11
 */
@Configuration
public class AmqpConfig {

    //改变amqp默认序列化机制
    @Bean
    public MessageConverter messageConverter(){
        return  new Jackson2JsonMessageConverter();
    }

}

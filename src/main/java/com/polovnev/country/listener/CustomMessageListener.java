package com.polovnev.country.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class CustomMessageListener {

    @RabbitListener(queues = "country create")
    public void receiveMessage(final Message message) {
        System.out.println(message.toString());
    }
}

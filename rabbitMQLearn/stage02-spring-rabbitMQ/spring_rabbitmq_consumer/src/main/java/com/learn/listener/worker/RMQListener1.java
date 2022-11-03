package com.learn.listener.worker;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RMQListener1 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("consumer1: " + new String(message.getBody()));
    }
}

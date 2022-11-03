package com.learn.listener.direct;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RMQDirectListener2 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("consumer2: " + new String(message.getBody()));
    }
}

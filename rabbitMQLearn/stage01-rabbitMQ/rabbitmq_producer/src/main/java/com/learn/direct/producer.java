package com.learn.direct;

import com.learn.utils.RabbitMQConnectionUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class producer {

    // find找到   out输出
    // 订阅模式

    // 发送消息
    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RabbitMQConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        //创建队列
        String queueName = "rabbitmq-direct-queue";
        // 多条队列
        channel.queueDeclare(queueName + 1, true, false, false, null);
        channel.queueDeclare(queueName + 2, true, false, false, null);

        // 创建交换机
        String exchangeName = "direct_exchange";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT, true, false, null);

        // 绑定交换机与队列
        channel.queueBind(queueName + 1, exchangeName, "abc");
        channel.queueBind(queueName + 2, exchangeName, "cba");

        String message = "niHao";
        channel.basicPublish(exchangeName, "abc", null, message.getBytes());

        channel.close();
        connection.close();
    }
}

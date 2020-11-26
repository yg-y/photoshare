package com.photoshare.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author young
 * @version 1.0
 * @date 2020/6/17 3:04 下午
 * @description
 */
public class ConsumerMessage {


    private final static String QUEUE_NAME = "OFFER_DOWN_LOG";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("opx.mobikok.com");
        factory.setPort(5672);
        factory.setUsername("mobikok");
        factory.setPassword("mobikok@2020");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        AtomicInteger count = new AtomicInteger();
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            count.set(count.get() + 1);
            System.out.println(" [x] Received '" + message + "'");
            System.err.println(count.get());
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
        System.err.println("final count : " + count.get());
    }
}

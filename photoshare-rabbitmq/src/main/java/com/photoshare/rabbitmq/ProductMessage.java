package com.photoshare.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author young
 * @version 1.0
 * @date 2020/6/17 2:47 下午
 * @description
 */
public class ProductMessage {

    private final static String QUEUE_NAME = "OFFER_DOWN_LOG";


    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("opx.mobikok.com");
        factory.setPort(5672);
        factory.setUsername("mobikok");
        factory.setPassword("mobikok@2020");

        Connection connection = null;
        Channel channel = null;

        connection = factory.newConnection();
        channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);


        int
                i = 0;
        do {
            StringBuilder message = new StringBuilder("Hello World");
            i++;
            message.append(i);

            channel.basicPublish("", QUEUE_NAME, null, message.toString().getBytes());
            System.err.println("message send success : " + message);
        } while (i < 10000000);

        System.err.println("send message over");


    }
}

package com.photoshare.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;


public class RocketMqProduct {
    public static void main(String[] args) throws Exception {
        RocketMqProduct rocketMqClient = new RocketMqProduct();

        System.err.println("-------------正在生产消息--------------");
        rocketMqClient.productMq();
        System.err.println("-------------生产消息结束--------------");
    }

    public void productMq() throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {

//        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("YOUNG_GROUP");
//        // Specify name server addresses.
        producer.setNamesrvAddr("localhost:9876");
//        //Launch the instance.
        producer.start();
        for (int i = 0; i < 100; i++) {
            Thread.sleep(5000);
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("YOUNG_TEST_MQ" /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
//        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}

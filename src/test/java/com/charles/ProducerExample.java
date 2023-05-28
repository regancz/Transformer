package com.charles;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import org.apache.rocketmq.common.message.Message;

/**
 * @author charles
 * @date 5/28/2023 3:58 PM
 */
public class ProducerExample {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("producer-group-1");
        // Specify name server addresses.
        producer.setNamesrvAddr("192.168.3.25:9876");
        //Launch the instance.
        producer.start();
        //Create a message instance, specifying topic, tag and message body.
        Message msg = new Message("broker-a" /* Topic */,
                "TagA" /* Tag */,
                ("Hello RocketMQ.").getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
        );
        producer.setSendMsgTimeout(10000);
        producer.setVipChannelEnabled(false);
        //Call send message to deliver message to one of brokers.
        SendResult sendResult = producer.send(msg);
        System.out.printf("%s%n", sendResult);
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}

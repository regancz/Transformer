package com.charles;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.apis.ClientConfiguration;
import org.apache.rocketmq.client.apis.ClientException;
import org.apache.rocketmq.client.apis.ClientServiceProvider;
import org.apache.rocketmq.client.apis.consumer.ConsumeResult;
import org.apache.rocketmq.client.apis.consumer.FilterExpression;
import org.apache.rocketmq.client.apis.consumer.FilterExpressionType;
import org.apache.rocketmq.client.apis.consumer.PushConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author charles
 * @date 5/28/2023 3:58 PM
 */
public class PushConsumerExample {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();

        //必须设置消费组，否则抛出异常：
        //Exception in thread "main" org.apache.rocketmq.client.exception.MQClientException: consumerGroup can not equal DEFAULT_CONSUMER, please specify another one.
        //这个校验再     at org.apache.rocketmq.client.impl.consumer.DefaultMQPushConsumerImpl.checkConfig(DefaultMQPushConsumerImpl.java:670)
        consumer.setConsumerGroup("consumer_group_3");


        //必须设置namesrv，如发送者抛出异常一致：
        //Exception in thread "main" java.lang.IllegalStateException: org.apache.rocketmq.remoting.exception.RemotingConnectException: connect to null failed
        consumer.setNamesrvAddr("192.168.3.25:9876");

        consumer.subscribe("parking-gateway-2","*");

        //必须设置消息监听器，否则抛出异常：
        //Exception in thread "main" org.apache.rocketmq.client.exception.MQClientException: messageListener is null
        //这个校验再     at org.apache.rocketmq.client.impl.consumer.DefaultMQPushConsumerImpl.checkConfig(DefaultMQPushConsumerImpl.java:716)
        //consumer.setMessageListener((MessageListenerConcurrently) ConsumerTest::consumeMessage);

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.println(msgs);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.start();
        System.out.println("启动成功");

    }

    private static ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        System.out.println(JSONObject.toJSONString(msgs));
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}

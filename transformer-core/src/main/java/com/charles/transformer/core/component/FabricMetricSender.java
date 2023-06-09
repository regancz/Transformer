package com.charles.transformer.core.component;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author charles
 * @date 5/27/2023 10:35 PM
 */
@Component
public class FabricMetricSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(FabricMetricSender.class);

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送异步消息
     *
     * @param topic     topic
     * @param payload   消息体
     */
    public void asyncSendOrderly(String topic, Map<String, Object> payload, String hashKey) {
        rocketMQTemplate.asyncSendOrderly(topic, payload, hashKey, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                LOGGER.info("FabricMetric Sender异步消息发送成功, payload = {}, SendStatus = {}", payload, sendResult.getSendStatus());
            }

            @Override
            public void onException(Throwable e) {
                LOGGER.info("异步消息发送异常, exception = {}", e.getMessage());
            }
        });
    }
}

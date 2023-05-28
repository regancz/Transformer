package com.charles.transformer.core.component;

import com.charles.transformer.core.service.impl.FabricMetricOutputService;
import io.debezium.data.Envelope;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static io.debezium.data.Envelope.FieldName.OPERATION;

/**
 * @author charles
 * @date 5/28/2023 11:48 AM
 */
@Component
@RocketMQMessageListener(topic = "charles-fabric-result", consumerGroup = "charles-fabric-result",
        consumeMode = ConsumeMode.ORDERLY)
public class FabricResultReceiver implements RocketMQListener<Map<String, Object>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FabricResultReceiver.class);

    @Autowired
    private FabricMetricOutputService fabricMetricOutputService;

    @Override
    public void onMessage(Map<String, Object> message) {
        LOGGER.info("FabricResult Receiver:{}", message);
        fabricMetricOutputService.replicateData(message, Envelope.Operation.forCode((String) message.get(OPERATION)));
    }
}
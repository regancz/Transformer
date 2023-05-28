package com.charles.transformer.core.component;

import com.charles.transformer.core.service.impl.FabricCalculateResultService;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;



/**
 * @author charles
 * @date 5/28/2023 11:35 AM
 */
@Component
@RocketMQMessageListener(topic = "charles-fabric-metric", consumerGroup = "charles-fabric-metric",
        consumeMode = ConsumeMode.ORDERLY)
public class FabricMetricReceiver implements RocketMQListener<Map<String, Object>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FabricMetricReceiver.class);

    @Autowired
    private FabricCalculateResultService fabricCalculateResultService;

    @Override
    public void onMessage(Map<String, Object> message) {
        LOGGER.info("FabricMetric Receiver:{}", message);
        fabricCalculateResultService.CalculateResult(message);
    }
}

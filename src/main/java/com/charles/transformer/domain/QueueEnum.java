package com.charles.transformer.domain;

import lombok.Getter;

/**
 * @author charles
 * @date 5/28/2023 11:26 AM
 */
@Getter
public enum QueueEnum {
    /**
     * Fabric性能指标队列
     */
    QUEUE_FABRIC_METRIC("charles-fabric-metric", "metric", "charles-fabric-metric"),
    /**
     * Fabric性能指标队列
     */
    QUEUE_FABRIC_METRICS("charles-fabric-metric", "metric", "charles-fabric-metric");


    private String topic;

    private String selectorExpression;

    private String consumerGroup;

    QueueEnum(String topic, String selectorExpression, String consumerGroup) {
        this.topic = topic;
        this.selectorExpression = selectorExpression;
        this.consumerGroup = consumerGroup;
    }
}

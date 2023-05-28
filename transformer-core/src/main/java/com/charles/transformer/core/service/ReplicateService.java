package com.charles.transformer.core.service;

import io.debezium.data.Envelope;

import java.util.Map;

/**
 * @author charles
 * @date 5/27/2023 11:12 PM
 */
public interface ReplicateService {
    void replicateData(Map<String, Object> customerData, Envelope.Operation operation);
}

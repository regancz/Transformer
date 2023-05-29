package com.charles.transformer.core.service.impl;

import com.charles.transformer.core.component.FabricMetricSender;
import com.charles.transformer.core.component.FabricResultSender;
import com.charles.transformer.core.service.CalculateResultService;
import io.debezium.data.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static io.debezium.data.Envelope.FieldName.OPERATION;

/**
 * @author charles
 * @date 5/28/2023 11:45 AM
 */
@Service
public class FabricCalculateResultService implements CalculateResultService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FabricCalculateResultService.class);

    @Autowired
    private FabricResultSender fabricResultSender;

    @Autowired
    private FabricMiddleReplicateService fabricMiddleReplicateService;

    @Override
    public Map<String, Object> CalculateResult(Map<String, Object> message) {
        try {
            if (message == null || !message.containsKey("payload")) {
                throw new IllegalArgumentException("Invalid input message.");
            }
            if (message.get("payload") instanceof Map) {
                Map<String, Object> payload = (Map<String, Object>) message.get("payload");
                Long afterTotalTx = Long.parseLong(String.valueOf(payload.get("total_tx"))) / 10;
                payload.put("total_tx", afterTotalTx);
                message.put("payload", payload);
                fabricMiddleReplicateService.replicateData(payload, Envelope.Operation.forCode((String) message.get(OPERATION)));
                fabricResultSender.asyncSendOrderly("charles-fabric-result", message, String.valueOf(payload.get("id")));
                return message;
            }
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }
}

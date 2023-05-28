package com.charles.transformer.service.impl;

import com.charles.transformer.component.FabricResultSender;
import com.charles.transformer.service.CalculateResultService;
import io.debezium.data.Envelope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static io.debezium.data.Envelope.FieldName.OPERATION;

/**
 * @author charles
 * @date 5/28/2023 11:45 AM
 */
@Service
public class FabricCalculateResultService implements CalculateResultService {
    @Autowired
    private FabricResultSender fabricResultSender;

    @Autowired
    private FabricMiddleReplicateService fabricMiddleReplicateService;

    @Override
    public Map<String, Object> CalculateResult(Map<String, Object> message) {
        Long afterTotalTx = (Long)message.get("total_tx") / 10;
        message.put("total_tx", afterTotalTx);
        fabricMiddleReplicateService.replicateData(message, Envelope.Operation.forCode((String) message.get(OPERATION)));
        fabricResultSender.asyncSendOrderly("charles-fabric-result", message, (String) message.get("id"));
        return message;
    }
}

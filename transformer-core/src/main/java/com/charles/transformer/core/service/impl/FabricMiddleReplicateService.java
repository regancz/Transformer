package com.charles.transformer.core.service.impl;

import com.charles.transformer.mbg.mapper.FabricMiddleStateMetricMapper;
import com.charles.transformer.mbg.model.FabricMiddleStateMetric;
import com.charles.transformer.core.service.ReplicateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.debezium.data.Envelope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author charles
 * @date 5/28/2023 2:47 PM
 */
@Service
public class FabricMiddleReplicateService implements ReplicateService {
    @Autowired
    private FabricMiddleStateMetricMapper fabricMiddleStateMetricMapper;

    @Override
    public void replicateData(Map<String, Object> customerData, Envelope.Operation operation) {
        final ObjectMapper mapper = new ObjectMapper();
        final FabricMiddleStateMetric fabricMiddleStateMetric = mapper.convertValue(customerData, FabricMiddleStateMetric.class);
        if (Envelope.Operation.DELETE == operation) {
            fabricMiddleStateMetricMapper.deleteByPrimaryKey(fabricMiddleStateMetric.getId());
        } else if (Envelope.Operation.UPDATE == operation) {
            fabricMiddleStateMetricMapper.updateByPrimaryKey(fabricMiddleStateMetric);
        } else if (Envelope.Operation.CREATE == operation) {
            fabricMiddleStateMetricMapper.insert(fabricMiddleStateMetric);
        }
    }
}
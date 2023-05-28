package com.charles.transformer.core.service.impl;

import com.charles.transformer.core.service.ReplicateService;
import com.charles.transformer.mbg.mapper.FabricMetricMapper;
import com.charles.transformer.mbg.model.FabricMetric;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.debezium.data.Envelope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author charles
 * @date 5/27/2023 11:18 PM
 */
@Service
public class FabricReplicateService implements ReplicateService {
    @Autowired
    private FabricMetricMapper fabricMetricMapper;

    @Override
    public void replicateData(Map<String, Object> customerData, Envelope.Operation operation) {
        final ObjectMapper mapper = new ObjectMapper();
        final FabricMetric fabricMetric = mapper.convertValue(customerData, FabricMetric.class);
        if (Envelope.Operation.DELETE == operation) {
            fabricMetricMapper.deleteByPrimaryKey(fabricMetric.getId());
        } else if (Envelope.Operation.UPDATE == operation) {
            fabricMetricMapper.updateByPrimaryKey(fabricMetric);
        } else if (Envelope.Operation.CREATE == operation) {
            fabricMetricMapper.insert(fabricMetric);
        }
    }
}

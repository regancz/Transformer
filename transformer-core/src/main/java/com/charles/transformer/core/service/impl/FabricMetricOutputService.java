package com.charles.transformer.core.service.impl;

import com.charles.transformer.mbg.mapper.FabricOutputMetricMapper;
import com.charles.transformer.mbg.model.FabricOutputMetric;
import com.charles.transformer.core.service.ReplicateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.debezium.data.Envelope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author charles
 * @date 5/28/2023 2:48 PM
 */
@Service
public class FabricMetricOutputService implements ReplicateService {
    @Autowired
    private FabricOutputMetricMapper fabricOutputMetricMapper;

    @Override
    public void replicateData(Map<String, Object> customerData, Envelope.Operation operation) {
        final ObjectMapper mapper = new ObjectMapper();
        final FabricOutputMetric fabricOutputMetric = mapper.convertValue(customerData, FabricOutputMetric.class);
        if (Envelope.Operation.DELETE == operation) {
            fabricOutputMetricMapper.deleteByPrimaryKey(fabricOutputMetric.getId());
        } else if (Envelope.Operation.UPDATE == operation) {
            fabricOutputMetricMapper.updateByPrimaryKey(fabricOutputMetric);
        } else if (Envelope.Operation.CREATE == operation) {
            fabricOutputMetricMapper.insert(fabricOutputMetric);
        }
    }
}
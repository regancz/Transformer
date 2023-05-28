package com.charles.transformer.service.impl;

import com.charles.transformer.domain.FabricMetric;
import com.charles.transformer.domain.FabricMiddleStateMetric;
import com.charles.transformer.repository.FabricMetricRepository;
import com.charles.transformer.repository.FabricMiddleStateMetricRepository;
import com.charles.transformer.service.ReplicateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.debezium.data.Envelope;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author charles
 * @date 5/28/2023 2:47 PM
 */
@Service
public class FabricMiddleReplicateService implements ReplicateService {

    private FabricMiddleStateMetricRepository fabricMiddleStateMetricRepository;

    @Override
    public void replicateData(Map<String, Object> customerData, Envelope.Operation operation) {
        final ObjectMapper mapper = new ObjectMapper();
        final FabricMiddleStateMetric fabricMiddleStateMetric = mapper.convertValue(customerData, FabricMiddleStateMetric.class);
        if (Envelope.Operation.DELETE == operation) {
            fabricMiddleStateMetricRepository.deleteById(fabricMiddleStateMetric.getId());
        } else {
            fabricMiddleStateMetricRepository.save(fabricMiddleStateMetric);
        }
    }
}
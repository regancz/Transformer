package com.charles.transformer.service.impl;

import com.charles.transformer.domain.FabricMiddleStateMetric;
import com.charles.transformer.domain.FabricOutputMetric;
import com.charles.transformer.repository.FabricMiddleStateMetricRepository;
import com.charles.transformer.repository.FabricOutputMetricRepository;
import com.charles.transformer.service.ReplicateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.debezium.data.Envelope;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author charles
 * @date 5/28/2023 2:48 PM
 */
@Service
public class FabricMetricOutputService implements ReplicateService {

    private FabricOutputMetricRepository fabricOutputMetricRepository;

    @Override
    public void replicateData(Map<String, Object> customerData, Envelope.Operation operation) {
        final ObjectMapper mapper = new ObjectMapper();
        final FabricOutputMetric fabricOutputMetric = mapper.convertValue(customerData, FabricOutputMetric.class);
        if (Envelope.Operation.DELETE == operation) {
            fabricOutputMetricRepository.deleteById(fabricOutputMetric.getId());
        } else {
            fabricOutputMetricRepository.save(fabricOutputMetric);
        }
    }
}
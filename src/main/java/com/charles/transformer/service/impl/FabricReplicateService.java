package com.charles.transformer.service.impl;

import com.charles.transformer.domain.FabricMetric;
import com.charles.transformer.repository.FabricMetricRepository;
import com.charles.transformer.service.ReplicateService;
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
    private FabricMetricRepository fabricMetricRepository;

    @Override
    public void replicateData(Map<String, Object> customerData, Envelope.Operation operation) {
        final ObjectMapper mapper = new ObjectMapper();
        final FabricMetric fabricMetric = mapper.convertValue(customerData, FabricMetric.class);
        if (Envelope.Operation.DELETE == operation) {
            fabricMetricRepository.deleteById(fabricMetric.getId());
        } else {
            fabricMetricRepository.save(fabricMetric);
        }
    }
}

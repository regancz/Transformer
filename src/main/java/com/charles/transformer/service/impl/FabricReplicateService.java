package com.charles.transformer.service.impl;

import com.charles.transformer.model.Customer;
import com.charles.transformer.model.FabricMetric;
import com.charles.transformer.repository.FabricRepository;
import com.charles.transformer.service.ReplicateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.debezium.data.Envelope;

import java.util.Map;

/**
 * @author charles
 * @date 5/27/2023 11:18 PM
 */
public class FabricReplicateService implements ReplicateService {

    private FabricRepository fabricRepository;

    @Override
    public void replicateData(Map<String, Object> customerData, Envelope.Operation operation) {
        final ObjectMapper mapper = new ObjectMapper();
        final FabricMetric fabricMetric = mapper.convertValue(customerData, FabricMetric.class);

        if (Envelope.Operation.DELETE == operation) {
            fabricRepository.deleteById(fabricMetric.getId());
        } else {
            fabricRepository.save(fabricMetric);
        }
    }
}

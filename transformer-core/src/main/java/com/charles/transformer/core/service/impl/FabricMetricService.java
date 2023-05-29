package com.charles.transformer.core.service.impl;

import com.charles.transformer.core.component.FabricMetricSender;
import com.charles.transformer.core.service.DataProcessService;
import io.debezium.data.Envelope;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.kafka.connect.data.Field;
import org.apache.kafka.connect.data.Struct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static io.debezium.data.Envelope.FieldName.*;
import static java.util.stream.Collectors.toMap;

/**
 * @author charles
 * @date 5/27/2023 10:48 PM
 */
@Service
public class FabricMetricService implements DataProcessService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FabricMetricService.class);

    @Autowired
    private FabricMiddleReplicateService fabricMiddleReplicateService;

    @Autowired
    private FabricMetricSender fabricMetricSender;

    @Override
    public Object DataProcess(Struct sourceRecordChangeValue) {
        if (sourceRecordChangeValue != null) {
            Struct source = (Struct) sourceRecordChangeValue.get(SOURCE);
            LOGGER.info("source Data: {}", source);
            LOGGER.info("source table: {}", source.get("table"));
            if (!String.valueOf(source.get("table")).equals("fabric_metric"))
                return null;

            Envelope.Operation operation = Envelope.Operation.forCode((String) sourceRecordChangeValue.get(OPERATION));
            //Envelope.Operation.READ operation events are always triggered when application initializes
            //We're only interested in CREATE operation which are triggered upon new insert registry
            if(operation != Envelope.Operation.READ) {
             //Handling Update & Insert operations.
             String record = operation == Envelope.Operation.DELETE ? BEFORE : AFTER;
             Struct struct = (Struct) sourceRecordChangeValue.get(record);
             Map<String, Object> payload = struct.schema().fields().stream()
                 .map(Field::name)
                 .filter(fieldName -> struct.get(fieldName) != null)
                 .map(fieldName -> Pair.of(fieldName, struct.get(fieldName)))
                 .collect(toMap(Pair::getKey, Pair::getValue));

             this.fabricMiddleReplicateService.replicateData(payload, operation);
             LOGGER.info("Updated Data: {} with Operation: {}", payload, operation.name());
             //data processing
             Long afterTotalTx = Long.parseLong(String.valueOf(payload.get("total_tx"))) * 10000;
             payload.put("total_tx", afterTotalTx);
             Map<String, Object> message = new HashMap<>();
             message.put("table", String.valueOf(source.get("table")));
             message.put(OPERATION, sourceRecordChangeValue.get(OPERATION));
             message.put("payload", payload);
             //send to next station
             fabricMetricSender.asyncSendOrderly("charles-fabric-metric", message, String.valueOf(payload.get("id")));
             }
        }
        return null;
    }

    @Override
    public Object Output(Object object) {
        return null;
    }
}

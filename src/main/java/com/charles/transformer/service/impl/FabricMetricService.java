package com.charles.transformer.service.impl;

import com.charles.transformer.component.FabricMetricSender;
import com.charles.transformer.service.DataProcessService;
import io.debezium.data.Envelope;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.kafka.connect.data.Field;
import org.apache.kafka.connect.data.Struct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static io.debezium.data.Envelope.FieldName.*;
import static java.util.stream.Collectors.toMap;

/**
 * @author charles
 * @date 5/27/2023 10:48 PM
 */
public class FabricMetricService implements DataProcessService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FabricMetricService.class);

    @Autowired
    private FabricReplicateService fabricReplicateService;

    @Autowired
    private FabricMetricSender fabricMetricSender;

    @Override
    public Object DataProcess(Struct sourceRecordChangeValue) {
        if (sourceRecordChangeValue != null) {
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

                 this.fabricReplicateService.replicateData(payload, operation);
                 LOGGER.info("Updated Data: {} with Operation: {}", payload, operation.name());

                 fabricMetricSender.asyncSendMessage("", payload);
             }
        }
        return null;
    }

    @Override
    public Object Output(Object object) {
        return null;
    }
}

package com.charles.transformer.listener;

import com.charles.transformer.service.DataProcessService;
import com.charles.transformer.service.impl.FabricMetricService;
import io.debezium.config.Configuration;
import io.debezium.data.Envelope;
import io.debezium.embedded.Connect;
import io.debezium.engine.DebeziumEngine;
import io.debezium.engine.RecordChangeEvent;
import io.debezium.engine.format.ChangeEventFormat;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.source.SourceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class DebeziumListener {

    private final Executor executor = Executors.newSingleThreadExecutor();

    private final DebeziumEngine<RecordChangeEvent<SourceRecord>> debeziumEngine;

    @Autowired
    private FabricMetricService fabricMetricService;

    public DebeziumListener(Configuration customerConnectorConfiguration) {
        this.debeziumEngine = DebeziumEngine.create(ChangeEventFormat.of(Connect.class))
            .using(customerConnectorConfiguration.asProperties())
            .notifying(this::handleChangeEvent)
            .build();
    }

    private void handleChangeEvent(RecordChangeEvent<SourceRecord> sourceRecordRecordChangeEvent) {
        var sourceRecord = sourceRecordRecordChangeEvent.record();
        log.info("Key = {}, Value = {}", sourceRecord.key(), sourceRecord.value());
        var sourceRecordChangeValue= (Struct) sourceRecord.value();
        log.info("SourceRecordChangeValue = '{}'", sourceRecordChangeValue);
//         if (sourceRecordChangeValue != null) {
//             Envelope.Operation operation = Envelope.Operation.forCode((String) sourceRecordChangeValue.get(OPERATION));

        // Operation.READ operation events are always triggered when application initializes
        // We're only interested in CREATE operation which are triggered upon new insert registry
        //     if(operation != Operation.READ) {
        //         String record = operation == Operation.DELETE ? BEFORE : AFTER; // Handling Update & Insert operations.

        //         Struct struct = (Struct) sourceRecordChangeValue.get(record);
        //         Map<String, Object> payload = struct.schema().fields().stream()
        //             .map(Field::name)
        //             .filter(fieldName -> struct.get(fieldName) != null)
        //             .map(fieldName -> Pair.of(fieldName, struct.get(fieldName)))
        //             .collect(toMap(Pair::getKey, Pair::getValue));

        //         // this.customerService.replicateData(payload, operation);
        //         log.info("Updated Data: {} with Operation: {}", payload, operation.name());
        //     }
        // }

        fabricMetricService.DataProcess(sourceRecordChangeValue);
    }

    @PostConstruct
    private void start() {
        this.executor.execute(debeziumEngine);
    }

    @PreDestroy
    private void stop() throws IOException {
        if (Objects.nonNull(this.debeziumEngine)) {
            this.debeziumEngine.close();
        }
    }

}
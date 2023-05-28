package com.charles.transformer.core.listener;

import com.charles.transformer.core.service.impl.FabricMetricService;
import io.debezium.config.Configuration;
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

import static io.debezium.data.Envelope.FieldName.OPERATION;

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
        Struct sourceRecordChangeValue= (Struct) sourceRecord.value();
        log.info("SourceRecordChangeValue = '{}'", sourceRecordChangeValue);
        try {
            fabricMetricService.DataProcess(sourceRecordChangeValue);
        } catch (Exception e) {
            log.warn(sourceRecord.key() + "handleChangeEvent error", e);
        }
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
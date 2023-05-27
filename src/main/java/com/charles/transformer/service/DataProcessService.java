package com.charles.transformer.service;

import org.apache.kafka.connect.data.Struct;

/**
 * @author charles
 * @date 5/27/2023 10:43 PM
 */
public interface DataProcessService {
    Object DataProcess(Struct sourceRecordChangeValue);
    Object Output(Object object);
}

package com.charles.transformer.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author charles
 * @date 5/28/2023 2:23 PM
 */
@Data
@Entity
public class FabricMiddleStateMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long TotalTx;

    private Long Latency;

    private Long TPS;

    private Long IOPS;

    private Long AvgLatency;
}

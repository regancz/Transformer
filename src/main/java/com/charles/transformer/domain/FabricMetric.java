package com.charles.transformer.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author charles
 * @date 5/27/2023 11:23 PM
 */
@Data
@Entity
public class FabricMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long total_tx;

    private Long latency;

    private Long tps;

    private Long iops;

    private Long avg_latency;

}

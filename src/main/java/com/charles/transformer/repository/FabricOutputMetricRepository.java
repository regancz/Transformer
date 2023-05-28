package com.charles.transformer.repository;

import com.charles.transformer.domain.FabricMiddleStateMetric;
import com.charles.transformer.domain.FabricOutputMetric;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author charles
 * @date 5/28/2023 2:24 PM
 */
public interface FabricOutputMetricRepository extends JpaRepository<FabricOutputMetric, Long> {
}

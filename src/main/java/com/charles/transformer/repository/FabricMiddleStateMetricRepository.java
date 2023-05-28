package com.charles.transformer.repository;

import com.charles.transformer.domain.FabricMetric;
import com.charles.transformer.domain.FabricMiddleStateMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author charles
 * @date 5/28/2023 2:23 PM
 */
@Repository
public interface FabricMiddleStateMetricRepository extends JpaRepository<FabricMiddleStateMetric, Long> {

}

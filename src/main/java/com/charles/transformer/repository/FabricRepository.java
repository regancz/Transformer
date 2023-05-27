package com.charles.transformer.repository;

import com.charles.transformer.model.Customer;
import com.charles.transformer.model.FabricMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author charles
 * @date 5/27/2023 11:24 PM
 */
@Repository
public interface FabricRepository extends JpaRepository<FabricMetric, Long> {
}

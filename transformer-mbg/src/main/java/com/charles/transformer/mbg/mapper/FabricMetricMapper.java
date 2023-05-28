package com.charles.transformer.mbg.mapper;

import com.charles.transformer.mbg.model.FabricMetric;
import com.charles.transformer.mbg.model.FabricMetricExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FabricMetricMapper {
    long countByExample(FabricMetricExample example);

    int deleteByExample(FabricMetricExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FabricMetric row);

    int insertSelective(FabricMetric row);

    List<FabricMetric> selectByExample(FabricMetricExample example);

    FabricMetric selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") FabricMetric row, @Param("example") FabricMetricExample example);

    int updateByExample(@Param("row") FabricMetric row, @Param("example") FabricMetricExample example);

    int updateByPrimaryKeySelective(FabricMetric row);

    int updateByPrimaryKey(FabricMetric row);
}
package com.charles.transformer.mbg.mapper;

import com.charles.transformer.mbg.model.FabricOutputMetric;
import com.charles.transformer.mbg.model.FabricOutputMetricExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FabricOutputMetricMapper {
    long countByExample(FabricOutputMetricExample example);

    int deleteByExample(FabricOutputMetricExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FabricOutputMetric row);

    int insertSelective(FabricOutputMetric row);

    List<FabricOutputMetric> selectByExample(FabricOutputMetricExample example);

    FabricOutputMetric selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") FabricOutputMetric row, @Param("example") FabricOutputMetricExample example);

    int updateByExample(@Param("row") FabricOutputMetric row, @Param("example") FabricOutputMetricExample example);

    int updateByPrimaryKeySelective(FabricOutputMetric row);

    int updateByPrimaryKey(FabricOutputMetric row);
}
package com.charles.transformer.mbg.mapper;

import com.charles.transformer.mbg.model.FabricMiddleStateMetric;
import com.charles.transformer.mbg.model.FabricMiddleStateMetricExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FabricMiddleStateMetricMapper {
    long countByExample(FabricMiddleStateMetricExample example);

    int deleteByExample(FabricMiddleStateMetricExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FabricMiddleStateMetric row);

    int insertSelective(FabricMiddleStateMetric row);

    List<FabricMiddleStateMetric> selectByExample(FabricMiddleStateMetricExample example);

    FabricMiddleStateMetric selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") FabricMiddleStateMetric row, @Param("example") FabricMiddleStateMetricExample example);

    int updateByExample(@Param("row") FabricMiddleStateMetric row, @Param("example") FabricMiddleStateMetricExample example);

    int updateByPrimaryKeySelective(FabricMiddleStateMetric row);

    int updateByPrimaryKey(FabricMiddleStateMetric row);
}
package com.charles.transformer.mbg.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class FabricMiddleStateMetric implements Serializable {
    private Long id;

    private Long total_tx;

    private Long latency;

    private Long tps;

    private Long iops;

    private Long avg_latency;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", totalTx=").append(total_tx);
        sb.append(", latency=").append(latency);
        sb.append(", tps=").append(tps);
        sb.append(", iops=").append(iops);
        sb.append(", avgLatency=").append(avg_latency);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
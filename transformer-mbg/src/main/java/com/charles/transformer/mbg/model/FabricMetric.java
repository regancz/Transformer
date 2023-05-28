package com.charles.transformer.mbg.model;

import java.io.Serializable;

public class FabricMetric implements Serializable {
    private Long id;

    private Long total_tx;

    private Long latency;

    private Long tps;

    private Long iops;

    private Long avg_latency;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotal_tx() {
        return total_tx;
    }

    public void setTotal_tx(Long total_tx) {
        this.total_tx = total_tx;
    }

    public Long getLatency() {
        return latency;
    }

    public void setLatency(Long latency) {
        this.latency = latency;
    }

    public Long getTps() {
        return tps;
    }

    public void setTps(Long tps) {
        this.tps = tps;
    }

    public Long getIops() {
        return iops;
    }

    public void setIops(Long iops) {
        this.iops = iops;
    }

    public Long getAvg_latency() {
        return avg_latency;
    }

    public void setAvg_latency(Long avg_latency) {
        this.avg_latency = avg_latency;
    }

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
package com.charles.transformer.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class FabricMetricExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FabricMetricExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTotalTxIsNull() {
            addCriterion("total_tx is null");
            return (Criteria) this;
        }

        public Criteria andTotalTxIsNotNull() {
            addCriterion("total_tx is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTxEqualTo(Long value) {
            addCriterion("total_tx =", value, "totalTx");
            return (Criteria) this;
        }

        public Criteria andTotalTxNotEqualTo(Long value) {
            addCriterion("total_tx <>", value, "totalTx");
            return (Criteria) this;
        }

        public Criteria andTotalTxGreaterThan(Long value) {
            addCriterion("total_tx >", value, "totalTx");
            return (Criteria) this;
        }

        public Criteria andTotalTxGreaterThanOrEqualTo(Long value) {
            addCriterion("total_tx >=", value, "totalTx");
            return (Criteria) this;
        }

        public Criteria andTotalTxLessThan(Long value) {
            addCriterion("total_tx <", value, "totalTx");
            return (Criteria) this;
        }

        public Criteria andTotalTxLessThanOrEqualTo(Long value) {
            addCriterion("total_tx <=", value, "totalTx");
            return (Criteria) this;
        }

        public Criteria andTotalTxIn(List<Long> values) {
            addCriterion("total_tx in", values, "totalTx");
            return (Criteria) this;
        }

        public Criteria andTotalTxNotIn(List<Long> values) {
            addCriterion("total_tx not in", values, "totalTx");
            return (Criteria) this;
        }

        public Criteria andTotalTxBetween(Long value1, Long value2) {
            addCriterion("total_tx between", value1, value2, "totalTx");
            return (Criteria) this;
        }

        public Criteria andTotalTxNotBetween(Long value1, Long value2) {
            addCriterion("total_tx not between", value1, value2, "totalTx");
            return (Criteria) this;
        }

        public Criteria andLatencyIsNull() {
            addCriterion("latency is null");
            return (Criteria) this;
        }

        public Criteria andLatencyIsNotNull() {
            addCriterion("latency is not null");
            return (Criteria) this;
        }

        public Criteria andLatencyEqualTo(Long value) {
            addCriterion("latency =", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyNotEqualTo(Long value) {
            addCriterion("latency <>", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyGreaterThan(Long value) {
            addCriterion("latency >", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyGreaterThanOrEqualTo(Long value) {
            addCriterion("latency >=", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyLessThan(Long value) {
            addCriterion("latency <", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyLessThanOrEqualTo(Long value) {
            addCriterion("latency <=", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyIn(List<Long> values) {
            addCriterion("latency in", values, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyNotIn(List<Long> values) {
            addCriterion("latency not in", values, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyBetween(Long value1, Long value2) {
            addCriterion("latency between", value1, value2, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyNotBetween(Long value1, Long value2) {
            addCriterion("latency not between", value1, value2, "latency");
            return (Criteria) this;
        }

        public Criteria andTpsIsNull() {
            addCriterion("tps is null");
            return (Criteria) this;
        }

        public Criteria andTpsIsNotNull() {
            addCriterion("tps is not null");
            return (Criteria) this;
        }

        public Criteria andTpsEqualTo(Long value) {
            addCriterion("tps =", value, "tps");
            return (Criteria) this;
        }

        public Criteria andTpsNotEqualTo(Long value) {
            addCriterion("tps <>", value, "tps");
            return (Criteria) this;
        }

        public Criteria andTpsGreaterThan(Long value) {
            addCriterion("tps >", value, "tps");
            return (Criteria) this;
        }

        public Criteria andTpsGreaterThanOrEqualTo(Long value) {
            addCriterion("tps >=", value, "tps");
            return (Criteria) this;
        }

        public Criteria andTpsLessThan(Long value) {
            addCriterion("tps <", value, "tps");
            return (Criteria) this;
        }

        public Criteria andTpsLessThanOrEqualTo(Long value) {
            addCriterion("tps <=", value, "tps");
            return (Criteria) this;
        }

        public Criteria andTpsIn(List<Long> values) {
            addCriterion("tps in", values, "tps");
            return (Criteria) this;
        }

        public Criteria andTpsNotIn(List<Long> values) {
            addCriterion("tps not in", values, "tps");
            return (Criteria) this;
        }

        public Criteria andTpsBetween(Long value1, Long value2) {
            addCriterion("tps between", value1, value2, "tps");
            return (Criteria) this;
        }

        public Criteria andTpsNotBetween(Long value1, Long value2) {
            addCriterion("tps not between", value1, value2, "tps");
            return (Criteria) this;
        }

        public Criteria andIopsIsNull() {
            addCriterion("iops is null");
            return (Criteria) this;
        }

        public Criteria andIopsIsNotNull() {
            addCriterion("iops is not null");
            return (Criteria) this;
        }

        public Criteria andIopsEqualTo(Long value) {
            addCriterion("iops =", value, "iops");
            return (Criteria) this;
        }

        public Criteria andIopsNotEqualTo(Long value) {
            addCriterion("iops <>", value, "iops");
            return (Criteria) this;
        }

        public Criteria andIopsGreaterThan(Long value) {
            addCriterion("iops >", value, "iops");
            return (Criteria) this;
        }

        public Criteria andIopsGreaterThanOrEqualTo(Long value) {
            addCriterion("iops >=", value, "iops");
            return (Criteria) this;
        }

        public Criteria andIopsLessThan(Long value) {
            addCriterion("iops <", value, "iops");
            return (Criteria) this;
        }

        public Criteria andIopsLessThanOrEqualTo(Long value) {
            addCriterion("iops <=", value, "iops");
            return (Criteria) this;
        }

        public Criteria andIopsIn(List<Long> values) {
            addCriterion("iops in", values, "iops");
            return (Criteria) this;
        }

        public Criteria andIopsNotIn(List<Long> values) {
            addCriterion("iops not in", values, "iops");
            return (Criteria) this;
        }

        public Criteria andIopsBetween(Long value1, Long value2) {
            addCriterion("iops between", value1, value2, "iops");
            return (Criteria) this;
        }

        public Criteria andIopsNotBetween(Long value1, Long value2) {
            addCriterion("iops not between", value1, value2, "iops");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyIsNull() {
            addCriterion("avg_latency is null");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyIsNotNull() {
            addCriterion("avg_latency is not null");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyEqualTo(Long value) {
            addCriterion("avg_latency =", value, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyNotEqualTo(Long value) {
            addCriterion("avg_latency <>", value, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyGreaterThan(Long value) {
            addCriterion("avg_latency >", value, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyGreaterThanOrEqualTo(Long value) {
            addCriterion("avg_latency >=", value, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyLessThan(Long value) {
            addCriterion("avg_latency <", value, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyLessThanOrEqualTo(Long value) {
            addCriterion("avg_latency <=", value, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyIn(List<Long> values) {
            addCriterion("avg_latency in", values, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyNotIn(List<Long> values) {
            addCriterion("avg_latency not in", values, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyBetween(Long value1, Long value2) {
            addCriterion("avg_latency between", value1, value2, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyNotBetween(Long value1, Long value2) {
            addCriterion("avg_latency not between", value1, value2, "avgLatency");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
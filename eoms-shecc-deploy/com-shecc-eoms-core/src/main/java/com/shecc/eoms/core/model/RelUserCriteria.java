package com.shecc.eoms.core.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelUserCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected Object record;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public RelUserCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected RelUserCriteria(RelUserCriteria example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
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

    public void setRecord(Object record) {
        this.record = record;
    }

    public Object getRecord() {
        return record;
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

    public void setMysqlOffset(Integer mysqlOffset) {
        this.mysqlOffset = mysqlOffset;
    }

    public Integer getMysqlOffset() {
        return mysqlOffset;
    }

    public void setMysqlLength(Integer mysqlLength) {
        this.mysqlLength = mysqlLength;
    }

    public Integer getMysqlLength() {
        return mysqlLength;
    }

    protected abstract static class GeneratedCriteria {
        protected List<String> criteriaWithoutValue;

        protected List<Map<String, Object>> criteriaWithSingleValue;

        protected List<Map<String, Object>> criteriaWithListValue;

        protected List<Map<String, Object>> criteriaWithBetweenValue;

        protected GeneratedCriteria() {
            super();
            criteriaWithoutValue = new ArrayList<String>();
            criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
            criteriaWithListValue = new ArrayList<Map<String, Object>>();
            criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List<String> getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public void setCriteriaWithoutValue(List<String> criteriaWithoutValue) {
            this.criteriaWithoutValue = criteriaWithoutValue;
        }

        public List<Map<String, Object>> getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public void setCriteriaWithSingleValue(List<Map<String, Object>> criteriaWithSingleValue) {
            this.criteriaWithSingleValue = criteriaWithSingleValue;
        }

        public List<Map<String, Object>> getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public void setCriteriaWithListValue(List<Map<String, Object>> criteriaWithListValue) {
            this.criteriaWithListValue = criteriaWithListValue;
        }

        public List<Map<String, Object>> getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        public void setCriteriaWithBetweenValue(List<Map<String, Object>> criteriaWithBetweenValue) {
            this.criteriaWithBetweenValue = criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List<? extends Object> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List<Object> list = new ArrayList<Object>();
            list.add(value1);
            list.add(value2);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andSubUidIsNull() {
            addCriterion("SUB_UID is null");
            return (Criteria) this;
        }

        public Criteria andSubUidIsNotNull() {
            addCriterion("SUB_UID is not null");
            return (Criteria) this;
        }

        public Criteria andSubUidEqualTo(Integer value) {
            addCriterion("SUB_UID =", value, "subUid");
            return (Criteria) this;
        }

        public Criteria andSubUidNotEqualTo(Integer value) {
            addCriterion("SUB_UID <>", value, "subUid");
            return (Criteria) this;
        }

        public Criteria andSubUidGreaterThan(Integer value) {
            addCriterion("SUB_UID >", value, "subUid");
            return (Criteria) this;
        }

        public Criteria andSubUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUB_UID >=", value, "subUid");
            return (Criteria) this;
        }

        public Criteria andSubUidLessThan(Integer value) {
            addCriterion("SUB_UID <", value, "subUid");
            return (Criteria) this;
        }

        public Criteria andSubUidLessThanOrEqualTo(Integer value) {
            addCriterion("SUB_UID <=", value, "subUid");
            return (Criteria) this;
        }

        public Criteria andSubUidIn(List<Integer> values) {
            addCriterion("SUB_UID in", values, "subUid");
            return (Criteria) this;
        }

        public Criteria andSubUidNotIn(List<Integer> values) {
            addCriterion("SUB_UID not in", values, "subUid");
            return (Criteria) this;
        }

        public Criteria andSubUidBetween(Integer value1, Integer value2) {
            addCriterion("SUB_UID between", value1, value2, "subUid");
            return (Criteria) this;
        }

        public Criteria andSubUidNotBetween(Integer value1, Integer value2) {
            addCriterion("SUB_UID not between", value1, value2, "subUid");
            return (Criteria) this;
        }

        public Criteria andUpUidIsNull() {
            addCriterion("UP_UID is null");
            return (Criteria) this;
        }

        public Criteria andUpUidIsNotNull() {
            addCriterion("UP_UID is not null");
            return (Criteria) this;
        }

        public Criteria andUpUidEqualTo(Integer value) {
            addCriterion("UP_UID =", value, "upUid");
            return (Criteria) this;
        }

        public Criteria andUpUidNotEqualTo(Integer value) {
            addCriterion("UP_UID <>", value, "upUid");
            return (Criteria) this;
        }

        public Criteria andUpUidGreaterThan(Integer value) {
            addCriterion("UP_UID >", value, "upUid");
            return (Criteria) this;
        }

        public Criteria andUpUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("UP_UID >=", value, "upUid");
            return (Criteria) this;
        }

        public Criteria andUpUidLessThan(Integer value) {
            addCriterion("UP_UID <", value, "upUid");
            return (Criteria) this;
        }

        public Criteria andUpUidLessThanOrEqualTo(Integer value) {
            addCriterion("UP_UID <=", value, "upUid");
            return (Criteria) this;
        }

        public Criteria andUpUidIn(List<Integer> values) {
            addCriterion("UP_UID in", values, "upUid");
            return (Criteria) this;
        }

        public Criteria andUpUidNotIn(List<Integer> values) {
            addCriterion("UP_UID not in", values, "upUid");
            return (Criteria) this;
        }

        public Criteria andUpUidBetween(Integer value1, Integer value2) {
            addCriterion("UP_UID between", value1, value2, "upUid");
            return (Criteria) this;
        }

        public Criteria andUpUidNotBetween(Integer value1, Integer value2) {
            addCriterion("UP_UID not between", value1, value2, "upUid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}
package com.shecc.eoms.core.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelModelChkCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected Object record;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public RelModelChkCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected RelModelChkCriteria(RelModelChkCriteria example) {
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

        public Criteria andChkIdIsNull() {
            addCriterion("CHK_ID is null");
            return (Criteria) this;
        }

        public Criteria andChkIdIsNotNull() {
            addCriterion("CHK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChkIdEqualTo(Integer value) {
            addCriterion("CHK_ID =", value, "chkId");
            return (Criteria) this;
        }

        public Criteria andChkIdNotEqualTo(Integer value) {
            addCriterion("CHK_ID <>", value, "chkId");
            return (Criteria) this;
        }

        public Criteria andChkIdGreaterThan(Integer value) {
            addCriterion("CHK_ID >", value, "chkId");
            return (Criteria) this;
        }

        public Criteria andChkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHK_ID >=", value, "chkId");
            return (Criteria) this;
        }

        public Criteria andChkIdLessThan(Integer value) {
            addCriterion("CHK_ID <", value, "chkId");
            return (Criteria) this;
        }

        public Criteria andChkIdLessThanOrEqualTo(Integer value) {
            addCriterion("CHK_ID <=", value, "chkId");
            return (Criteria) this;
        }

        public Criteria andChkIdIn(List<Integer> values) {
            addCriterion("CHK_ID in", values, "chkId");
            return (Criteria) this;
        }

        public Criteria andChkIdNotIn(List<Integer> values) {
            addCriterion("CHK_ID not in", values, "chkId");
            return (Criteria) this;
        }

        public Criteria andChkIdBetween(Integer value1, Integer value2) {
            addCriterion("CHK_ID between", value1, value2, "chkId");
            return (Criteria) this;
        }

        public Criteria andChkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CHK_ID not between", value1, value2, "chkId");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNull() {
            addCriterion("MODEL_ID is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("MODEL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(Integer value) {
            addCriterion("MODEL_ID =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(Integer value) {
            addCriterion("MODEL_ID <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(Integer value) {
            addCriterion("MODEL_ID >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MODEL_ID >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(Integer value) {
            addCriterion("MODEL_ID <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(Integer value) {
            addCriterion("MODEL_ID <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<Integer> values) {
            addCriterion("MODEL_ID in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<Integer> values) {
            addCriterion("MODEL_ID not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(Integer value1, Integer value2) {
            addCriterion("MODEL_ID between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MODEL_ID not between", value1, value2, "modelId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}
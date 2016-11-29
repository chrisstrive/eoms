package com.shecc.eoms.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected Object record;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public DeviceCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected DeviceCriteria(DeviceCriteria example) {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", "%"+value+"%", "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNull() {
            addCriterion("BRAND_ID is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("BRAND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Integer value) {
            addCriterion("BRAND_ID =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Integer value) {
            addCriterion("BRAND_ID <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Integer value) {
            addCriterion("BRAND_ID >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BRAND_ID >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Integer value) {
            addCriterion("BRAND_ID <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("BRAND_ID <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("BRAND_ID in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Integer> values) {
            addCriterion("BRAND_ID not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("BRAND_ID between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BRAND_ID not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("BRAND_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("BRAND_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("BRAND_NAME =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("BRAND_NAME <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("BRAND_NAME >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("BRAND_NAME >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("BRAND_NAME <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("BRAND_NAME <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("BRAND_NAME like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("BRAND_NAME not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("BRAND_NAME in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("BRAND_NAME not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("BRAND_NAME between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("BRAND_NAME not between", value1, value2, "brandName");
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

        public Criteria andModelNameIsNull() {
            addCriterion("MODEL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("MODEL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("MODEL_NAME =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("MODEL_NAME <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("MODEL_NAME >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_NAME >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("MODEL_NAME <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("MODEL_NAME <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("MODEL_NAME like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("MODEL_NAME not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("MODEL_NAME in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("MODEL_NAME not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("MODEL_NAME between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("MODEL_NAME not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNull() {
            addCriterion("SYSTEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("SYSTEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(Integer value) {
            addCriterion("SYSTEM_ID =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(Integer value) {
            addCriterion("SYSTEM_ID <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(Integer value) {
            addCriterion("SYSTEM_ID >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SYSTEM_ID >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(Integer value) {
            addCriterion("SYSTEM_ID <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(Integer value) {
            addCriterion("SYSTEM_ID <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(List<Integer> values) {
            addCriterion("SYSTEM_ID in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<Integer> values) {
            addCriterion("SYSTEM_ID not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(Integer value1, Integer value2) {
            addCriterion("SYSTEM_ID between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SYSTEM_ID not between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemNameIsNull() {
            addCriterion("SYSTEM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSystemNameIsNotNull() {
            addCriterion("SYSTEM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSystemNameEqualTo(String value) {
            addCriterion("SYSTEM_NAME =", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotEqualTo(String value) {
            addCriterion("SYSTEM_NAME <>", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameGreaterThan(String value) {
            addCriterion("SYSTEM_NAME >", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameGreaterThanOrEqualTo(String value) {
            addCriterion("SYSTEM_NAME >=", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLessThan(String value) {
            addCriterion("SYSTEM_NAME <", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLessThanOrEqualTo(String value) {
            addCriterion("SYSTEM_NAME <=", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLike(String value) {
            addCriterion("SYSTEM_NAME like", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotLike(String value) {
            addCriterion("SYSTEM_NAME not like", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameIn(List<String> values) {
            addCriterion("SYSTEM_NAME in", values, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotIn(List<String> values) {
            addCriterion("SYSTEM_NAME not in", values, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameBetween(String value1, String value2) {
            addCriterion("SYSTEM_NAME between", value1, value2, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotBetween(String value1, String value2) {
            addCriterion("SYSTEM_NAME not between", value1, value2, "systemName");
            return (Criteria) this;
        }

        public Criteria andSysTypeIdIsNull() {
            addCriterion("SYS_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSysTypeIdIsNotNull() {
            addCriterion("SYS_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSysTypeIdEqualTo(Integer value) {
            addCriterion("SYS_TYPE_ID =", value, "sysTypeId");
            return (Criteria) this;
        }

        public Criteria andSysTypeIdNotEqualTo(Integer value) {
            addCriterion("SYS_TYPE_ID <>", value, "sysTypeId");
            return (Criteria) this;
        }

        public Criteria andSysTypeIdGreaterThan(Integer value) {
            addCriterion("SYS_TYPE_ID >", value, "sysTypeId");
            return (Criteria) this;
        }

        public Criteria andSysTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SYS_TYPE_ID >=", value, "sysTypeId");
            return (Criteria) this;
        }

        public Criteria andSysTypeIdLessThan(Integer value) {
            addCriterion("SYS_TYPE_ID <", value, "sysTypeId");
            return (Criteria) this;
        }

        public Criteria andSysTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("SYS_TYPE_ID <=", value, "sysTypeId");
            return (Criteria) this;
        }

        public Criteria andSysTypeIdIn(List<Integer> values) {
            addCriterion("SYS_TYPE_ID in", values, "sysTypeId");
            return (Criteria) this;
        }

        public Criteria andSysTypeIdNotIn(List<Integer> values) {
            addCriterion("SYS_TYPE_ID not in", values, "sysTypeId");
            return (Criteria) this;
        }

        public Criteria andSysTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("SYS_TYPE_ID between", value1, value2, "sysTypeId");
            return (Criteria) this;
        }

        public Criteria andSysTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SYS_TYPE_ID not between", value1, value2, "sysTypeId");
            return (Criteria) this;
        }

        public Criteria andSysTypeNameIsNull() {
            addCriterion("SYS_TYPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSysTypeNameIsNotNull() {
            addCriterion("SYS_TYPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSysTypeNameEqualTo(String value) {
            addCriterion("SYS_TYPE_NAME =", value, "sysTypeName");
            return (Criteria) this;
        }

        public Criteria andSysTypeNameNotEqualTo(String value) {
            addCriterion("SYS_TYPE_NAME <>", value, "sysTypeName");
            return (Criteria) this;
        }

        public Criteria andSysTypeNameGreaterThan(String value) {
            addCriterion("SYS_TYPE_NAME >", value, "sysTypeName");
            return (Criteria) this;
        }

        public Criteria andSysTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_TYPE_NAME >=", value, "sysTypeName");
            return (Criteria) this;
        }

        public Criteria andSysTypeNameLessThan(String value) {
            addCriterion("SYS_TYPE_NAME <", value, "sysTypeName");
            return (Criteria) this;
        }

        public Criteria andSysTypeNameLessThanOrEqualTo(String value) {
            addCriterion("SYS_TYPE_NAME <=", value, "sysTypeName");
            return (Criteria) this;
        }

        public Criteria andSysTypeNameLike(String value) {
            addCriterion("SYS_TYPE_NAME like", value, "sysTypeName");
            return (Criteria) this;
        }

        public Criteria andSysTypeNameNotLike(String value) {
            addCriterion("SYS_TYPE_NAME not like", value, "sysTypeName");
            return (Criteria) this;
        }

        public Criteria andSysTypeNameIn(List<String> values) {
            addCriterion("SYS_TYPE_NAME in", values, "sysTypeName");
            return (Criteria) this;
        }

        public Criteria andSysTypeNameNotIn(List<String> values) {
            addCriterion("SYS_TYPE_NAME not in", values, "sysTypeName");
            return (Criteria) this;
        }

        public Criteria andSysTypeNameBetween(String value1, String value2) {
            addCriterion("SYS_TYPE_NAME between", value1, value2, "sysTypeName");
            return (Criteria) this;
        }

        public Criteria andSysTypeNameNotBetween(String value1, String value2) {
            addCriterion("SYS_TYPE_NAME not between", value1, value2, "sysTypeName");
            return (Criteria) this;
        }

        public Criteria andLocationIdIsNull() {
            addCriterion("LOCATION_ID is null");
            return (Criteria) this;
        }

        public Criteria andLocationIdIsNotNull() {
            addCriterion("LOCATION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLocationIdEqualTo(Integer value) {
            addCriterion("LOCATION_ID =", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotEqualTo(Integer value) {
            addCriterion("LOCATION_ID <>", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThan(Integer value) {
            addCriterion("LOCATION_ID >", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOCATION_ID >=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThan(Integer value) {
            addCriterion("LOCATION_ID <", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThanOrEqualTo(Integer value) {
            addCriterion("LOCATION_ID <=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdIn(List<Integer> values) {
            addCriterion("LOCATION_ID in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotIn(List<Integer> values) {
            addCriterion("LOCATION_ID not in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdBetween(Integer value1, Integer value2) {
            addCriterion("LOCATION_ID between", value1, value2, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("LOCATION_ID not between", value1, value2, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationFnameIsNull() {
            addCriterion("LOCATION_FNAME is null");
            return (Criteria) this;
        }

        public Criteria andLocationFnameIsNotNull() {
            addCriterion("LOCATION_FNAME is not null");
            return (Criteria) this;
        }

        public Criteria andLocationFnameEqualTo(String value) {
            addCriterion("LOCATION_FNAME =", value, "locationFname");
            return (Criteria) this;
        }

        public Criteria andLocationFnameNotEqualTo(String value) {
            addCriterion("LOCATION_FNAME <>", value, "locationFname");
            return (Criteria) this;
        }

        public Criteria andLocationFnameGreaterThan(String value) {
            addCriterion("LOCATION_FNAME >", value, "locationFname");
            return (Criteria) this;
        }

        public Criteria andLocationFnameGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION_FNAME >=", value, "locationFname");
            return (Criteria) this;
        }

        public Criteria andLocationFnameLessThan(String value) {
            addCriterion("LOCATION_FNAME <", value, "locationFname");
            return (Criteria) this;
        }

        public Criteria andLocationFnameLessThanOrEqualTo(String value) {
            addCriterion("LOCATION_FNAME <=", value, "locationFname");
            return (Criteria) this;
        }

        public Criteria andLocationFnameLike(String value) {
            addCriterion("LOCATION_FNAME like", value, "locationFname");
            return (Criteria) this;
        }

        public Criteria andLocationFnameNotLike(String value) {
            addCriterion("LOCATION_FNAME not like", value, "locationFname");
            return (Criteria) this;
        }

        public Criteria andLocationFnameIn(List<String> values) {
            addCriterion("LOCATION_FNAME in", values, "locationFname");
            return (Criteria) this;
        }

        public Criteria andLocationFnameNotIn(List<String> values) {
            addCriterion("LOCATION_FNAME not in", values, "locationFname");
            return (Criteria) this;
        }

        public Criteria andLocationFnameBetween(String value1, String value2) {
            addCriterion("LOCATION_FNAME between", value1, value2, "locationFname");
            return (Criteria) this;
        }

        public Criteria andLocationFnameNotBetween(String value1, String value2) {
            addCriterion("LOCATION_FNAME not between", value1, value2, "locationFname");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andConfigIsNull() {
            addCriterion("CONFIG is null");
            return (Criteria) this;
        }

        public Criteria andConfigIsNotNull() {
            addCriterion("CONFIG is not null");
            return (Criteria) this;
        }

        public Criteria andConfigEqualTo(String value) {
            addCriterion("CONFIG =", value, "config");
            return (Criteria) this;
        }

        public Criteria andConfigNotEqualTo(String value) {
            addCriterion("CONFIG <>", value, "config");
            return (Criteria) this;
        }

        public Criteria andConfigGreaterThan(String value) {
            addCriterion("CONFIG >", value, "config");
            return (Criteria) this;
        }

        public Criteria andConfigGreaterThanOrEqualTo(String value) {
            addCriterion("CONFIG >=", value, "config");
            return (Criteria) this;
        }

        public Criteria andConfigLessThan(String value) {
            addCriterion("CONFIG <", value, "config");
            return (Criteria) this;
        }

        public Criteria andConfigLessThanOrEqualTo(String value) {
            addCriterion("CONFIG <=", value, "config");
            return (Criteria) this;
        }

        public Criteria andConfigLike(String value) {
            addCriterion("CONFIG like", value, "config");
            return (Criteria) this;
        }

        public Criteria andConfigNotLike(String value) {
            addCriterion("CONFIG not like", value, "config");
            return (Criteria) this;
        }

        public Criteria andConfigIn(List<String> values) {
            addCriterion("CONFIG in", values, "config");
            return (Criteria) this;
        }

        public Criteria andConfigNotIn(List<String> values) {
            addCriterion("CONFIG not in", values, "config");
            return (Criteria) this;
        }

        public Criteria andConfigBetween(String value1, String value2) {
            addCriterion("CONFIG between", value1, value2, "config");
            return (Criteria) this;
        }

        public Criteria andConfigNotBetween(String value1, String value2) {
            addCriterion("CONFIG not between", value1, value2, "config");
            return (Criteria) this;
        }

        public Criteria andDocumentIsNull() {
            addCriterion("DOCUMENT is null");
            return (Criteria) this;
        }

        public Criteria andDocumentIsNotNull() {
            addCriterion("DOCUMENT is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentEqualTo(String value) {
            addCriterion("DOCUMENT =", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentNotEqualTo(String value) {
            addCriterion("DOCUMENT <>", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentGreaterThan(String value) {
            addCriterion("DOCUMENT >", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentGreaterThanOrEqualTo(String value) {
            addCriterion("DOCUMENT >=", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentLessThan(String value) {
            addCriterion("DOCUMENT <", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentLessThanOrEqualTo(String value) {
            addCriterion("DOCUMENT <=", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentLike(String value) {
            addCriterion("DOCUMENT like", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentNotLike(String value) {
            addCriterion("DOCUMENT not like", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentIn(List<String> values) {
            addCriterion("DOCUMENT in", values, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentNotIn(List<String> values) {
            addCriterion("DOCUMENT not in", values, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentBetween(String value1, String value2) {
            addCriterion("DOCUMENT between", value1, value2, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentNotBetween(String value1, String value2) {
            addCriterion("DOCUMENT not between", value1, value2, "document");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("PICTURE is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("PICTURE is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("PICTURE =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("PICTURE <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("PICTURE >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("PICTURE >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("PICTURE <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("PICTURE <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("PICTURE like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("PICTURE not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("PICTURE in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("PICTURE not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("PICTURE between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("PICTURE not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNull() {
            addCriterion("SUPPLIER is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("SUPPLIER is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("SUPPLIER =", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("SUPPLIER <>", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("SUPPLIER >", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("SUPPLIER >=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("SUPPLIER <", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("SUPPLIER <=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("SUPPLIER like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("SUPPLIER not like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("SUPPLIER in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("SUPPLIER not in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("SUPPLIER between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("SUPPLIER not between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIsNull() {
            addCriterion("REPAIR_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIsNotNull() {
            addCriterion("REPAIR_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRepairTimeEqualTo(Date value) {
            addCriterion("REPAIR_TIME =", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotEqualTo(Date value) {
            addCriterion("REPAIR_TIME <>", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeGreaterThan(Date value) {
            addCriterion("REPAIR_TIME >", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REPAIR_TIME >=", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLessThan(Date value) {
            addCriterion("REPAIR_TIME <", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLessThanOrEqualTo(Date value) {
            addCriterion("REPAIR_TIME <=", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIn(List<Date> values) {
            addCriterion("REPAIR_TIME in", values, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotIn(List<Date> values) {
            addCriterion("REPAIR_TIME not in", values, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeBetween(Date value1, Date value2) {
            addCriterion("REPAIR_TIME between", value1, value2, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotBetween(Date value1, Date value2) {
            addCriterion("REPAIR_TIME not between", value1, value2, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRoutingTimeIsNull() {
            addCriterion("ROUTING_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRoutingTimeIsNotNull() {
            addCriterion("ROUTING_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRoutingTimeEqualTo(Date value) {
            addCriterion("ROUTING_TIME =", value, "routingTime");
            return (Criteria) this;
        }

        public Criteria andRoutingTimeNotEqualTo(Date value) {
            addCriterion("ROUTING_TIME <>", value, "routingTime");
            return (Criteria) this;
        }

        public Criteria andRoutingTimeGreaterThan(Date value) {
            addCriterion("ROUTING_TIME >", value, "routingTime");
            return (Criteria) this;
        }

        public Criteria andRoutingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ROUTING_TIME >=", value, "routingTime");
            return (Criteria) this;
        }

        public Criteria andRoutingTimeLessThan(Date value) {
            addCriterion("ROUTING_TIME <", value, "routingTime");
            return (Criteria) this;
        }

        public Criteria andRoutingTimeLessThanOrEqualTo(Date value) {
            addCriterion("ROUTING_TIME <=", value, "routingTime");
            return (Criteria) this;
        }

        public Criteria andRoutingTimeIn(List<Date> values) {
            addCriterion("ROUTING_TIME in", values, "routingTime");
            return (Criteria) this;
        }

        public Criteria andRoutingTimeNotIn(List<Date> values) {
            addCriterion("ROUTING_TIME not in", values, "routingTime");
            return (Criteria) this;
        }

        public Criteria andRoutingTimeBetween(Date value1, Date value2) {
            addCriterion("ROUTING_TIME between", value1, value2, "routingTime");
            return (Criteria) this;
        }

        public Criteria andRoutingTimeNotBetween(Date value1, Date value2) {
            addCriterion("ROUTING_TIME not between", value1, value2, "routingTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeIsNull() {
            addCriterion("MAINTAIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeIsNotNull() {
            addCriterion("MAINTAIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeEqualTo(Date value) {
            addCriterion("MAINTAIN_TIME =", value, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeNotEqualTo(Date value) {
            addCriterion("MAINTAIN_TIME <>", value, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeGreaterThan(Date value) {
            addCriterion("MAINTAIN_TIME >", value, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MAINTAIN_TIME >=", value, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeLessThan(Date value) {
            addCriterion("MAINTAIN_TIME <", value, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeLessThanOrEqualTo(Date value) {
            addCriterion("MAINTAIN_TIME <=", value, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeIn(List<Date> values) {
            addCriterion("MAINTAIN_TIME in", values, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeNotIn(List<Date> values) {
            addCriterion("MAINTAIN_TIME not in", values, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeBetween(Date value1, Date value2) {
            addCriterion("MAINTAIN_TIME between", value1, value2, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeNotBetween(Date value1, Date value2) {
            addCriterion("MAINTAIN_TIME not between", value1, value2, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andInputUidIsNull() {
            addCriterion("INPUT_UID is null");
            return (Criteria) this;
        }

        public Criteria andInputUidIsNotNull() {
            addCriterion("INPUT_UID is not null");
            return (Criteria) this;
        }

        public Criteria andInputUidEqualTo(Integer value) {
            addCriterion("INPUT_UID =", value, "inputUid");
            return (Criteria) this;
        }

        public Criteria andInputUidNotEqualTo(Integer value) {
            addCriterion("INPUT_UID <>", value, "inputUid");
            return (Criteria) this;
        }

        public Criteria andInputUidGreaterThan(Integer value) {
            addCriterion("INPUT_UID >", value, "inputUid");
            return (Criteria) this;
        }

        public Criteria andInputUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("INPUT_UID >=", value, "inputUid");
            return (Criteria) this;
        }

        public Criteria andInputUidLessThan(Integer value) {
            addCriterion("INPUT_UID <", value, "inputUid");
            return (Criteria) this;
        }

        public Criteria andInputUidLessThanOrEqualTo(Integer value) {
            addCriterion("INPUT_UID <=", value, "inputUid");
            return (Criteria) this;
        }

        public Criteria andInputUidIn(List<Integer> values) {
            addCriterion("INPUT_UID in", values, "inputUid");
            return (Criteria) this;
        }

        public Criteria andInputUidNotIn(List<Integer> values) {
            addCriterion("INPUT_UID not in", values, "inputUid");
            return (Criteria) this;
        }

        public Criteria andInputUidBetween(Integer value1, Integer value2) {
            addCriterion("INPUT_UID between", value1, value2, "inputUid");
            return (Criteria) this;
        }

        public Criteria andInputUidNotBetween(Integer value1, Integer value2) {
            addCriterion("INPUT_UID not between", value1, value2, "inputUid");
            return (Criteria) this;
        }

        public Criteria andInputUnameIsNull() {
            addCriterion("INPUT_UNAME is null");
            return (Criteria) this;
        }

        public Criteria andInputUnameIsNotNull() {
            addCriterion("INPUT_UNAME is not null");
            return (Criteria) this;
        }

        public Criteria andInputUnameEqualTo(String value) {
            addCriterion("INPUT_UNAME =", value, "inputUname");
            return (Criteria) this;
        }

        public Criteria andInputUnameNotEqualTo(String value) {
            addCriterion("INPUT_UNAME <>", value, "inputUname");
            return (Criteria) this;
        }

        public Criteria andInputUnameGreaterThan(String value) {
            addCriterion("INPUT_UNAME >", value, "inputUname");
            return (Criteria) this;
        }

        public Criteria andInputUnameGreaterThanOrEqualTo(String value) {
            addCriterion("INPUT_UNAME >=", value, "inputUname");
            return (Criteria) this;
        }

        public Criteria andInputUnameLessThan(String value) {
            addCriterion("INPUT_UNAME <", value, "inputUname");
            return (Criteria) this;
        }

        public Criteria andInputUnameLessThanOrEqualTo(String value) {
            addCriterion("INPUT_UNAME <=", value, "inputUname");
            return (Criteria) this;
        }

        public Criteria andInputUnameLike(String value) {
            addCriterion("INPUT_UNAME like", value, "inputUname");
            return (Criteria) this;
        }

        public Criteria andInputUnameNotLike(String value) {
            addCriterion("INPUT_UNAME not like", value, "inputUname");
            return (Criteria) this;
        }

        public Criteria andInputUnameIn(List<String> values) {
            addCriterion("INPUT_UNAME in", values, "inputUname");
            return (Criteria) this;
        }

        public Criteria andInputUnameNotIn(List<String> values) {
            addCriterion("INPUT_UNAME not in", values, "inputUname");
            return (Criteria) this;
        }

        public Criteria andInputUnameBetween(String value1, String value2) {
            addCriterion("INPUT_UNAME between", value1, value2, "inputUname");
            return (Criteria) this;
        }

        public Criteria andInputUnameNotBetween(String value1, String value2) {
            addCriterion("INPUT_UNAME not between", value1, value2, "inputUname");
            return (Criteria) this;
        }

        public Criteria andInputTimeIsNull() {
            addCriterion("INPUT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andInputTimeIsNotNull() {
            addCriterion("INPUT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andInputTimeEqualTo(Date value) {
            addCriterion("INPUT_TIME =", value, "inputTime");
            return (Criteria) this;
        }

        public Criteria andInputTimeNotEqualTo(Date value) {
            addCriterion("INPUT_TIME <>", value, "inputTime");
            return (Criteria) this;
        }

        public Criteria andInputTimeGreaterThan(Date value) {
            addCriterion("INPUT_TIME >", value, "inputTime");
            return (Criteria) this;
        }

        public Criteria andInputTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("INPUT_TIME >=", value, "inputTime");
            return (Criteria) this;
        }

        public Criteria andInputTimeLessThan(Date value) {
            addCriterion("INPUT_TIME <", value, "inputTime");
            return (Criteria) this;
        }

        public Criteria andInputTimeLessThanOrEqualTo(Date value) {
            addCriterion("INPUT_TIME <=", value, "inputTime");
            return (Criteria) this;
        }

        public Criteria andInputTimeIn(List<Date> values) {
            addCriterion("INPUT_TIME in", values, "inputTime");
            return (Criteria) this;
        }

        public Criteria andInputTimeNotIn(List<Date> values) {
            addCriterion("INPUT_TIME not in", values, "inputTime");
            return (Criteria) this;
        }

        public Criteria andInputTimeBetween(Date value1, Date value2) {
            addCriterion("INPUT_TIME between", value1, value2, "inputTime");
            return (Criteria) this;
        }

        public Criteria andInputTimeNotBetween(Date value1, Date value2) {
            addCriterion("INPUT_TIME not between", value1, value2, "inputTime");
            return (Criteria) this;
        }

        public Criteria andCheckUidIsNull() {
            addCriterion("CHECK_UID is null");
            return (Criteria) this;
        }

        public Criteria andCheckUidIsNotNull() {
            addCriterion("CHECK_UID is not null");
            return (Criteria) this;
        }

        public Criteria andCheckUidEqualTo(Integer value) {
            addCriterion("CHECK_UID =", value, "checkUid");
            return (Criteria) this;
        }

        public Criteria andCheckUidNotEqualTo(Integer value) {
            addCriterion("CHECK_UID <>", value, "checkUid");
            return (Criteria) this;
        }

        public Criteria andCheckUidGreaterThan(Integer value) {
            addCriterion("CHECK_UID >", value, "checkUid");
            return (Criteria) this;
        }

        public Criteria andCheckUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHECK_UID >=", value, "checkUid");
            return (Criteria) this;
        }

        public Criteria andCheckUidLessThan(Integer value) {
            addCriterion("CHECK_UID <", value, "checkUid");
            return (Criteria) this;
        }

        public Criteria andCheckUidLessThanOrEqualTo(Integer value) {
            addCriterion("CHECK_UID <=", value, "checkUid");
            return (Criteria) this;
        }

        public Criteria andCheckUidIn(List<Integer> values) {
            addCriterion("CHECK_UID in", values, "checkUid");
            return (Criteria) this;
        }

        public Criteria andCheckUidNotIn(List<Integer> values) {
            addCriterion("CHECK_UID not in", values, "checkUid");
            return (Criteria) this;
        }

        public Criteria andCheckUidBetween(Integer value1, Integer value2) {
            addCriterion("CHECK_UID between", value1, value2, "checkUid");
            return (Criteria) this;
        }

        public Criteria andCheckUidNotBetween(Integer value1, Integer value2) {
            addCriterion("CHECK_UID not between", value1, value2, "checkUid");
            return (Criteria) this;
        }

        public Criteria andCheckUnameIsNull() {
            addCriterion("CHECK_UNAME is null");
            return (Criteria) this;
        }

        public Criteria andCheckUnameIsNotNull() {
            addCriterion("CHECK_UNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckUnameEqualTo(String value) {
            addCriterion("CHECK_UNAME =", value, "checkUname");
            return (Criteria) this;
        }

        public Criteria andCheckUnameNotEqualTo(String value) {
            addCriterion("CHECK_UNAME <>", value, "checkUname");
            return (Criteria) this;
        }

        public Criteria andCheckUnameGreaterThan(String value) {
            addCriterion("CHECK_UNAME >", value, "checkUname");
            return (Criteria) this;
        }

        public Criteria andCheckUnameGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_UNAME >=", value, "checkUname");
            return (Criteria) this;
        }

        public Criteria andCheckUnameLessThan(String value) {
            addCriterion("CHECK_UNAME <", value, "checkUname");
            return (Criteria) this;
        }

        public Criteria andCheckUnameLessThanOrEqualTo(String value) {
            addCriterion("CHECK_UNAME <=", value, "checkUname");
            return (Criteria) this;
        }

        public Criteria andCheckUnameLike(String value) {
            addCriterion("CHECK_UNAME like", value, "checkUname");
            return (Criteria) this;
        }

        public Criteria andCheckUnameNotLike(String value) {
            addCriterion("CHECK_UNAME not like", value, "checkUname");
            return (Criteria) this;
        }

        public Criteria andCheckUnameIn(List<String> values) {
            addCriterion("CHECK_UNAME in", values, "checkUname");
            return (Criteria) this;
        }

        public Criteria andCheckUnameNotIn(List<String> values) {
            addCriterion("CHECK_UNAME not in", values, "checkUname");
            return (Criteria) this;
        }

        public Criteria andCheckUnameBetween(String value1, String value2) {
            addCriterion("CHECK_UNAME between", value1, value2, "checkUname");
            return (Criteria) this;
        }

        public Criteria andCheckUnameNotBetween(String value1, String value2) {
            addCriterion("CHECK_UNAME not between", value1, value2, "checkUname");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("CHECK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("CHECK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Date value) {
            addCriterion("CHECK_TIME =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Date value) {
            addCriterion("CHECK_TIME <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Date value) {
            addCriterion("CHECK_TIME >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECK_TIME >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Date value) {
            addCriterion("CHECK_TIME <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("CHECK_TIME <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Date> values) {
            addCriterion("CHECK_TIME in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Date> values) {
            addCriterion("CHECK_TIME not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Date value1, Date value2) {
            addCriterion("CHECK_TIME between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("CHECK_TIME not between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyUidIsNull() {
            addCriterion("LAST_MODIFY_UID is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyUidIsNotNull() {
            addCriterion("LAST_MODIFY_UID is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyUidEqualTo(Integer value) {
            addCriterion("LAST_MODIFY_UID =", value, "lastModifyUid");
            return (Criteria) this;
        }

        public Criteria andLastModifyUidNotEqualTo(Integer value) {
            addCriterion("LAST_MODIFY_UID <>", value, "lastModifyUid");
            return (Criteria) this;
        }

        public Criteria andLastModifyUidGreaterThan(Integer value) {
            addCriterion("LAST_MODIFY_UID >", value, "lastModifyUid");
            return (Criteria) this;
        }

        public Criteria andLastModifyUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("LAST_MODIFY_UID >=", value, "lastModifyUid");
            return (Criteria) this;
        }

        public Criteria andLastModifyUidLessThan(Integer value) {
            addCriterion("LAST_MODIFY_UID <", value, "lastModifyUid");
            return (Criteria) this;
        }

        public Criteria andLastModifyUidLessThanOrEqualTo(Integer value) {
            addCriterion("LAST_MODIFY_UID <=", value, "lastModifyUid");
            return (Criteria) this;
        }

        public Criteria andLastModifyUidIn(List<Integer> values) {
            addCriterion("LAST_MODIFY_UID in", values, "lastModifyUid");
            return (Criteria) this;
        }

        public Criteria andLastModifyUidNotIn(List<Integer> values) {
            addCriterion("LAST_MODIFY_UID not in", values, "lastModifyUid");
            return (Criteria) this;
        }

        public Criteria andLastModifyUidBetween(Integer value1, Integer value2) {
            addCriterion("LAST_MODIFY_UID between", value1, value2, "lastModifyUid");
            return (Criteria) this;
        }

        public Criteria andLastModifyUidNotBetween(Integer value1, Integer value2) {
            addCriterion("LAST_MODIFY_UID not between", value1, value2, "lastModifyUid");
            return (Criteria) this;
        }

        public Criteria andLastModifyUnameIsNull() {
            addCriterion("LAST_MODIFY_UNAME is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyUnameIsNotNull() {
            addCriterion("LAST_MODIFY_UNAME is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyUnameEqualTo(String value) {
            addCriterion("LAST_MODIFY_UNAME =", value, "lastModifyUname");
            return (Criteria) this;
        }

        public Criteria andLastModifyUnameNotEqualTo(String value) {
            addCriterion("LAST_MODIFY_UNAME <>", value, "lastModifyUname");
            return (Criteria) this;
        }

        public Criteria andLastModifyUnameGreaterThan(String value) {
            addCriterion("LAST_MODIFY_UNAME >", value, "lastModifyUname");
            return (Criteria) this;
        }

        public Criteria andLastModifyUnameGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_MODIFY_UNAME >=", value, "lastModifyUname");
            return (Criteria) this;
        }

        public Criteria andLastModifyUnameLessThan(String value) {
            addCriterion("LAST_MODIFY_UNAME <", value, "lastModifyUname");
            return (Criteria) this;
        }

        public Criteria andLastModifyUnameLessThanOrEqualTo(String value) {
            addCriterion("LAST_MODIFY_UNAME <=", value, "lastModifyUname");
            return (Criteria) this;
        }

        public Criteria andLastModifyUnameLike(String value) {
            addCriterion("LAST_MODIFY_UNAME like", value, "lastModifyUname");
            return (Criteria) this;
        }

        public Criteria andLastModifyUnameNotLike(String value) {
            addCriterion("LAST_MODIFY_UNAME not like", value, "lastModifyUname");
            return (Criteria) this;
        }

        public Criteria andLastModifyUnameIn(List<String> values) {
            addCriterion("LAST_MODIFY_UNAME in", values, "lastModifyUname");
            return (Criteria) this;
        }

        public Criteria andLastModifyUnameNotIn(List<String> values) {
            addCriterion("LAST_MODIFY_UNAME not in", values, "lastModifyUname");
            return (Criteria) this;
        }

        public Criteria andLastModifyUnameBetween(String value1, String value2) {
            addCriterion("LAST_MODIFY_UNAME between", value1, value2, "lastModifyUname");
            return (Criteria) this;
        }

        public Criteria andLastModifyUnameNotBetween(String value1, String value2) {
            addCriterion("LAST_MODIFY_UNAME not between", value1, value2, "lastModifyUname");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNull() {
            addCriterion("LAST_MODIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNotNull() {
            addCriterion("LAST_MODIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeEqualTo(Date value) {
            addCriterion("LAST_MODIFY_TIME =", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotEqualTo(Date value) {
            addCriterion("LAST_MODIFY_TIME <>", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThan(Date value) {
            addCriterion("LAST_MODIFY_TIME >", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_MODIFY_TIME >=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThan(Date value) {
            addCriterion("LAST_MODIFY_TIME <", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_MODIFY_TIME <=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIn(List<Date> values) {
            addCriterion("LAST_MODIFY_TIME in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotIn(List<Date> values) {
            addCriterion("LAST_MODIFY_TIME not in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_MODIFY_TIME between", value1, value2, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_MODIFY_TIME not between", value1, value2, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andArchiveFlagIsNull() {
            addCriterion("ARCHIVE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andArchiveFlagIsNotNull() {
            addCriterion("ARCHIVE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andArchiveFlagEqualTo(String value) {
            addCriterion("ARCHIVE_FLAG =", value, "archiveFlag");
            return (Criteria) this;
        }

        public Criteria andArchiveFlagNotEqualTo(String value) {
            addCriterion("ARCHIVE_FLAG <>", value, "archiveFlag");
            return (Criteria) this;
        }

        public Criteria andArchiveFlagGreaterThan(String value) {
            addCriterion("ARCHIVE_FLAG >", value, "archiveFlag");
            return (Criteria) this;
        }

        public Criteria andArchiveFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ARCHIVE_FLAG >=", value, "archiveFlag");
            return (Criteria) this;
        }

        public Criteria andArchiveFlagLessThan(String value) {
            addCriterion("ARCHIVE_FLAG <", value, "archiveFlag");
            return (Criteria) this;
        }

        public Criteria andArchiveFlagLessThanOrEqualTo(String value) {
            addCriterion("ARCHIVE_FLAG <=", value, "archiveFlag");
            return (Criteria) this;
        }

        public Criteria andArchiveFlagLike(String value) {
            addCriterion("ARCHIVE_FLAG like", value, "archiveFlag");
            return (Criteria) this;
        }

        public Criteria andArchiveFlagNotLike(String value) {
            addCriterion("ARCHIVE_FLAG not like", value, "archiveFlag");
            return (Criteria) this;
        }

        public Criteria andArchiveFlagIn(List<String> values) {
            addCriterion("ARCHIVE_FLAG in", values, "archiveFlag");
            return (Criteria) this;
        }

        public Criteria andArchiveFlagNotIn(List<String> values) {
            addCriterion("ARCHIVE_FLAG not in", values, "archiveFlag");
            return (Criteria) this;
        }

        public Criteria andArchiveFlagBetween(String value1, String value2) {
            addCriterion("ARCHIVE_FLAG between", value1, value2, "archiveFlag");
            return (Criteria) this;
        }

        public Criteria andArchiveFlagNotBetween(String value1, String value2) {
            addCriterion("ARCHIVE_FLAG not between", value1, value2, "archiveFlag");
            return (Criteria) this;
        }

        public Criteria andArchiveUidIsNull() {
            addCriterion("ARCHIVE_UID is null");
            return (Criteria) this;
        }

        public Criteria andArchiveUidIsNotNull() {
            addCriterion("ARCHIVE_UID is not null");
            return (Criteria) this;
        }

        public Criteria andArchiveUidEqualTo(Integer value) {
            addCriterion("ARCHIVE_UID =", value, "archiveUid");
            return (Criteria) this;
        }

        public Criteria andArchiveUidNotEqualTo(Integer value) {
            addCriterion("ARCHIVE_UID <>", value, "archiveUid");
            return (Criteria) this;
        }

        public Criteria andArchiveUidGreaterThan(Integer value) {
            addCriterion("ARCHIVE_UID >", value, "archiveUid");
            return (Criteria) this;
        }

        public Criteria andArchiveUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ARCHIVE_UID >=", value, "archiveUid");
            return (Criteria) this;
        }

        public Criteria andArchiveUidLessThan(Integer value) {
            addCriterion("ARCHIVE_UID <", value, "archiveUid");
            return (Criteria) this;
        }

        public Criteria andArchiveUidLessThanOrEqualTo(Integer value) {
            addCriterion("ARCHIVE_UID <=", value, "archiveUid");
            return (Criteria) this;
        }

        public Criteria andArchiveUidIn(List<Integer> values) {
            addCriterion("ARCHIVE_UID in", values, "archiveUid");
            return (Criteria) this;
        }

        public Criteria andArchiveUidNotIn(List<Integer> values) {
            addCriterion("ARCHIVE_UID not in", values, "archiveUid");
            return (Criteria) this;
        }

        public Criteria andArchiveUidBetween(Integer value1, Integer value2) {
            addCriterion("ARCHIVE_UID between", value1, value2, "archiveUid");
            return (Criteria) this;
        }

        public Criteria andArchiveUidNotBetween(Integer value1, Integer value2) {
            addCriterion("ARCHIVE_UID not between", value1, value2, "archiveUid");
            return (Criteria) this;
        }

        public Criteria andArchiveUnameIsNull() {
            addCriterion("ARCHIVE_UNAME is null");
            return (Criteria) this;
        }

        public Criteria andArchiveUnameIsNotNull() {
            addCriterion("ARCHIVE_UNAME is not null");
            return (Criteria) this;
        }

        public Criteria andArchiveUnameEqualTo(String value) {
            addCriterion("ARCHIVE_UNAME =", value, "archiveUname");
            return (Criteria) this;
        }

        public Criteria andArchiveUnameNotEqualTo(String value) {
            addCriterion("ARCHIVE_UNAME <>", value, "archiveUname");
            return (Criteria) this;
        }

        public Criteria andArchiveUnameGreaterThan(String value) {
            addCriterion("ARCHIVE_UNAME >", value, "archiveUname");
            return (Criteria) this;
        }

        public Criteria andArchiveUnameGreaterThanOrEqualTo(String value) {
            addCriterion("ARCHIVE_UNAME >=", value, "archiveUname");
            return (Criteria) this;
        }

        public Criteria andArchiveUnameLessThan(String value) {
            addCriterion("ARCHIVE_UNAME <", value, "archiveUname");
            return (Criteria) this;
        }

        public Criteria andArchiveUnameLessThanOrEqualTo(String value) {
            addCriterion("ARCHIVE_UNAME <=", value, "archiveUname");
            return (Criteria) this;
        }

        public Criteria andArchiveUnameLike(String value) {
            addCriterion("ARCHIVE_UNAME like", value, "archiveUname");
            return (Criteria) this;
        }

        public Criteria andArchiveUnameNotLike(String value) {
            addCriterion("ARCHIVE_UNAME not like", value, "archiveUname");
            return (Criteria) this;
        }

        public Criteria andArchiveUnameIn(List<String> values) {
            addCriterion("ARCHIVE_UNAME in", values, "archiveUname");
            return (Criteria) this;
        }

        public Criteria andArchiveUnameNotIn(List<String> values) {
            addCriterion("ARCHIVE_UNAME not in", values, "archiveUname");
            return (Criteria) this;
        }

        public Criteria andArchiveUnameBetween(String value1, String value2) {
            addCriterion("ARCHIVE_UNAME between", value1, value2, "archiveUname");
            return (Criteria) this;
        }

        public Criteria andArchiveUnameNotBetween(String value1, String value2) {
            addCriterion("ARCHIVE_UNAME not between", value1, value2, "archiveUname");
            return (Criteria) this;
        }

        public Criteria andArchiveTimeIsNull() {
            addCriterion("ARCHIVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andArchiveTimeIsNotNull() {
            addCriterion("ARCHIVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andArchiveTimeEqualTo(Date value) {
            addCriterion("ARCHIVE_TIME =", value, "archiveTime");
            return (Criteria) this;
        }

        public Criteria andArchiveTimeNotEqualTo(Date value) {
            addCriterion("ARCHIVE_TIME <>", value, "archiveTime");
            return (Criteria) this;
        }

        public Criteria andArchiveTimeGreaterThan(Date value) {
            addCriterion("ARCHIVE_TIME >", value, "archiveTime");
            return (Criteria) this;
        }

        public Criteria andArchiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ARCHIVE_TIME >=", value, "archiveTime");
            return (Criteria) this;
        }

        public Criteria andArchiveTimeLessThan(Date value) {
            addCriterion("ARCHIVE_TIME <", value, "archiveTime");
            return (Criteria) this;
        }

        public Criteria andArchiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("ARCHIVE_TIME <=", value, "archiveTime");
            return (Criteria) this;
        }

        public Criteria andArchiveTimeIn(List<Date> values) {
            addCriterion("ARCHIVE_TIME in", values, "archiveTime");
            return (Criteria) this;
        }

        public Criteria andArchiveTimeNotIn(List<Date> values) {
            addCriterion("ARCHIVE_TIME not in", values, "archiveTime");
            return (Criteria) this;
        }

        public Criteria andArchiveTimeBetween(Date value1, Date value2) {
            addCriterion("ARCHIVE_TIME between", value1, value2, "archiveTime");
            return (Criteria) this;
        }

        public Criteria andArchiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("ARCHIVE_TIME not between", value1, value2, "archiveTime");
            return (Criteria) this;
        }

        public Criteria andLRecordNoIsNull() {
            addCriterion("L_RECORD_NO is null");
            return (Criteria) this;
        }

        public Criteria andLRecordNoIsNotNull() {
            addCriterion("L_RECORD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLRecordNoEqualTo(Integer value) {
            addCriterion("L_RECORD_NO =", value, "lRecordNo");
            return (Criteria) this;
        }

        public Criteria andLRecordNoNotEqualTo(Integer value) {
            addCriterion("L_RECORD_NO <>", value, "lRecordNo");
            return (Criteria) this;
        }

        public Criteria andLRecordNoGreaterThan(Integer value) {
            addCriterion("L_RECORD_NO >", value, "lRecordNo");
            return (Criteria) this;
        }

        public Criteria andLRecordNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("L_RECORD_NO >=", value, "lRecordNo");
            return (Criteria) this;
        }

        public Criteria andLRecordNoLessThan(Integer value) {
            addCriterion("L_RECORD_NO <", value, "lRecordNo");
            return (Criteria) this;
        }

        public Criteria andLRecordNoLessThanOrEqualTo(Integer value) {
            addCriterion("L_RECORD_NO <=", value, "lRecordNo");
            return (Criteria) this;
        }

        public Criteria andLRecordNoIn(List<Integer> values) {
            addCriterion("L_RECORD_NO in", values, "lRecordNo");
            return (Criteria) this;
        }

        public Criteria andLRecordNoNotIn(List<Integer> values) {
            addCriterion("L_RECORD_NO not in", values, "lRecordNo");
            return (Criteria) this;
        }

        public Criteria andLRecordNoBetween(Integer value1, Integer value2) {
            addCriterion("L_RECORD_NO between", value1, value2, "lRecordNo");
            return (Criteria) this;
        }

        public Criteria andLRecordNoNotBetween(Integer value1, Integer value2) {
            addCriterion("L_RECORD_NO not between", value1, value2, "lRecordNo");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andResvFld1IsNull() {
            addCriterion("RESV_FLD1 is null");
            return (Criteria) this;
        }

        public Criteria andResvFld1IsNotNull() {
            addCriterion("RESV_FLD1 is not null");
            return (Criteria) this;
        }

        public Criteria andResvFld1EqualTo(String value) {
            addCriterion("RESV_FLD1 =", value, "resvFld1");
            return (Criteria) this;
        }

        public Criteria andResvFld1NotEqualTo(String value) {
            addCriterion("RESV_FLD1 <>", value, "resvFld1");
            return (Criteria) this;
        }

        public Criteria andResvFld1GreaterThan(String value) {
            addCriterion("RESV_FLD1 >", value, "resvFld1");
            return (Criteria) this;
        }

        public Criteria andResvFld1GreaterThanOrEqualTo(String value) {
            addCriterion("RESV_FLD1 >=", value, "resvFld1");
            return (Criteria) this;
        }

        public Criteria andResvFld1LessThan(String value) {
            addCriterion("RESV_FLD1 <", value, "resvFld1");
            return (Criteria) this;
        }

        public Criteria andResvFld1LessThanOrEqualTo(String value) {
            addCriterion("RESV_FLD1 <=", value, "resvFld1");
            return (Criteria) this;
        }

        public Criteria andResvFld1Like(String value) {
            addCriterion("RESV_FLD1 like", value, "resvFld1");
            return (Criteria) this;
        }

        public Criteria andResvFld1NotLike(String value) {
            addCriterion("RESV_FLD1 not like", value, "resvFld1");
            return (Criteria) this;
        }

        public Criteria andResvFld1In(List<String> values) {
            addCriterion("RESV_FLD1 in", values, "resvFld1");
            return (Criteria) this;
        }

        public Criteria andResvFld1NotIn(List<String> values) {
            addCriterion("RESV_FLD1 not in", values, "resvFld1");
            return (Criteria) this;
        }

        public Criteria andResvFld1Between(String value1, String value2) {
            addCriterion("RESV_FLD1 between", value1, value2, "resvFld1");
            return (Criteria) this;
        }

        public Criteria andResvFld1NotBetween(String value1, String value2) {
            addCriterion("RESV_FLD1 not between", value1, value2, "resvFld1");
            return (Criteria) this;
        }

        public Criteria andResvFld2IsNull() {
            addCriterion("RESV_FLD2 is null");
            return (Criteria) this;
        }

        public Criteria andResvFld2IsNotNull() {
            addCriterion("RESV_FLD2 is not null");
            return (Criteria) this;
        }

        public Criteria andResvFld2EqualTo(String value) {
            addCriterion("RESV_FLD2 =", value, "resvFld2");
            return (Criteria) this;
        }

        public Criteria andResvFld2NotEqualTo(String value) {
            addCriterion("RESV_FLD2 <>", value, "resvFld2");
            return (Criteria) this;
        }

        public Criteria andResvFld2GreaterThan(String value) {
            addCriterion("RESV_FLD2 >", value, "resvFld2");
            return (Criteria) this;
        }

        public Criteria andResvFld2GreaterThanOrEqualTo(String value) {
            addCriterion("RESV_FLD2 >=", value, "resvFld2");
            return (Criteria) this;
        }

        public Criteria andResvFld2LessThan(String value) {
            addCriterion("RESV_FLD2 <", value, "resvFld2");
            return (Criteria) this;
        }

        public Criteria andResvFld2LessThanOrEqualTo(String value) {
            addCriterion("RESV_FLD2 <=", value, "resvFld2");
            return (Criteria) this;
        }

        public Criteria andResvFld2Like(String value) {
            addCriterion("RESV_FLD2 like", value, "resvFld2");
            return (Criteria) this;
        }

        public Criteria andResvFld2NotLike(String value) {
            addCriterion("RESV_FLD2 not like", value, "resvFld2");
            return (Criteria) this;
        }

        public Criteria andResvFld2In(List<String> values) {
            addCriterion("RESV_FLD2 in", values, "resvFld2");
            return (Criteria) this;
        }

        public Criteria andResvFld2NotIn(List<String> values) {
            addCriterion("RESV_FLD2 not in", values, "resvFld2");
            return (Criteria) this;
        }

        public Criteria andResvFld2Between(String value1, String value2) {
            addCriterion("RESV_FLD2 between", value1, value2, "resvFld2");
            return (Criteria) this;
        }

        public Criteria andResvFld2NotBetween(String value1, String value2) {
            addCriterion("RESV_FLD2 not between", value1, value2, "resvFld2");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}
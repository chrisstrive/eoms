package com.shecc.eoms.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected Object record;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public SystemCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected SystemCriteria(SystemCriteria example) {
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
            addCriterion("NAME like", value, "name");
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

        public Criteria andProjectIdIsNull() {
            addCriterion("PROJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("PROJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("PROJECT_ID =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("PROJECT_ID <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("PROJECT_ID >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROJECT_ID >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("PROJECT_ID <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("PROJECT_ID <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("PROJECT_ID in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("PROJECT_ID not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("PROJECT_ID between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PROJECT_ID not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("PROJECT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("PROJECT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("PROJECT_NAME =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("PROJECT_NAME <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("PROJECT_NAME >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_NAME >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("PROJECT_NAME <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_NAME <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("PROJECT_NAME like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("PROJECT_NAME not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("PROJECT_NAME in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("PROJECT_NAME not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("PROJECT_NAME between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("PROJECT_NAME not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andEngineerIdIsNull() {
            addCriterion("ENGINEER_ID is null");
            return (Criteria) this;
        }

        public Criteria andEngineerIdIsNotNull() {
            addCriterion("ENGINEER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEngineerIdEqualTo(Integer value) {
            addCriterion("ENGINEER_ID =", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdNotEqualTo(Integer value) {
            addCriterion("ENGINEER_ID <>", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdGreaterThan(Integer value) {
            addCriterion("ENGINEER_ID >", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ENGINEER_ID >=", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdLessThan(Integer value) {
            addCriterion("ENGINEER_ID <", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdLessThanOrEqualTo(Integer value) {
            addCriterion("ENGINEER_ID <=", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdIn(List<Integer> values) {
            addCriterion("ENGINEER_ID in", values, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdNotIn(List<Integer> values) {
            addCriterion("ENGINEER_ID not in", values, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdBetween(Integer value1, Integer value2) {
            addCriterion("ENGINEER_ID between", value1, value2, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ENGINEER_ID not between", value1, value2, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerNameIsNull() {
            addCriterion("ENGINEER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEngineerNameIsNotNull() {
            addCriterion("ENGINEER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEngineerNameEqualTo(String value) {
            addCriterion("ENGINEER_NAME =", value, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameNotEqualTo(String value) {
            addCriterion("ENGINEER_NAME <>", value, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameGreaterThan(String value) {
            addCriterion("ENGINEER_NAME >", value, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameGreaterThanOrEqualTo(String value) {
            addCriterion("ENGINEER_NAME >=", value, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameLessThan(String value) {
            addCriterion("ENGINEER_NAME <", value, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameLessThanOrEqualTo(String value) {
            addCriterion("ENGINEER_NAME <=", value, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameLike(String value) {
            addCriterion("ENGINEER_NAME like", value, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameNotLike(String value) {
            addCriterion("ENGINEER_NAME not like", value, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameIn(List<String> values) {
            addCriterion("ENGINEER_NAME in", values, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameNotIn(List<String> values) {
            addCriterion("ENGINEER_NAME not in", values, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameBetween(String value1, String value2) {
            addCriterion("ENGINEER_NAME between", value1, value2, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameNotBetween(String value1, String value2) {
            addCriterion("ENGINEER_NAME not between", value1, value2, "engineerName");
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
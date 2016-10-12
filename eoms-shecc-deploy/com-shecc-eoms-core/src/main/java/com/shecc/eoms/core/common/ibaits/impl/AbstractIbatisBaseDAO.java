package com.shecc.eoms.core.common.ibaits.impl;
/**
 * 
 * 
 * DAO基础方法集：C.R.U.D.T.Q.S
 * C is create
 * R is read
 * U is update
 * D is delete
 * T is count
 * Q is query
 * S is search
 * 
 * 子类应当尽可能重用上述方法
 */
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.shecc.eoms.core.common.IBaseDAO;
import com.shecc.eoms.core.common.Page;

@SuppressWarnings("unchecked")
public abstract class AbstractIbatisBaseDAO<T> extends SqlMapClientDaoSupport
		implements IBaseDAO<T> {

	protected String namespace;

	@Override
	public Object create(T pojo) {
		return getSqlMapClientTemplate().insert(
				namespace.concat("insertSelective"), pojo);
	}
	
	@Override
	public void create(Object pojo, String sqlId) {
		getSqlMapClientTemplate().insert(namespace.concat(sqlId), pojo);
	}

	@Override
	public boolean delete(Object id) {
		return getSqlMapClientTemplate().delete(namespace.concat("delete"), id) == 1;
	}
	
	@Override
	public boolean deleteByCriteria(Object criteria) {
		return getSqlMapClientTemplate().delete(namespace.concat("deleteByExample"), criteria) !=0;
	}

	
	@Override
	public boolean update(T pojo) {
		return getSqlMapClientTemplate().update(
				namespace.concat("updateByPrimaryKeySelective"), pojo) == 1;
	}

	@Override
	public boolean update(T pojo, Object criteria) {
		return getSqlMapClientTemplate().update(
				namespace.concat("updateByExampleSelective"), criteria) == 1;
	}

	@Override
	public int countByCriteria(Object criteria) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				namespace.concat("countByExample"), criteria);
	}

	@Override
	public T findById(Object primaryKey) {
		return (T) getSqlMapClientTemplate().queryForObject(
				namespace.concat("selectByPrimaryKey"), primaryKey);
	}

	@Override
	public List<T> findByCriteria(Object criteria) {
		return (List<T>) getSqlMapClientTemplate().queryForList(
				namespace.concat("selectByExample"), criteria);
	}
	
	@Override
	public List<T> findByCriteriaWithLobs(Object criteria) {
		return (List<T>) getSqlMapClientTemplate().queryForList(
				namespace.concat("selectByExampleWithBLOBs"), criteria);
	}
	
	
	@Override
	public List<T> findByCriteriaName() {
		return (List<T>) getSqlMapClientTemplate().queryForList(
				namespace.concat("selectCityModel"));
	}
	
	@Override
	public List<T> findByCriteriaAreaCity(Object currentCode) {
		return (List<T>) getSqlMapClientTemplate().queryForList(
				namespace.concat("selectAreaCityModel"),currentCode);
	}
	
	@Override
	public T findObjectByCriteria(Object criteria) {
		return (T) getSqlMapClientTemplate().queryForObject(
				namespace.concat("selectByExample"), criteria);
	}
	
	@Override
	public T findObjectByCriteriaWithLobs(Object criteria) {
		return (T) getSqlMapClientTemplate().queryForObject(
				namespace.concat("selectByExampleWithBLOBs"), criteria);
	}

	@Override
	public List<T> findByCriteria(Object criteria, Page page) {

		int size = page.getPageSize();
		int offset = page.currentRecordIndex();
		if (page.getTotalRecord() == 0) {
			int total = countByCriteria(criteria);
			page.setTotalRecord(total);
		}
		return getSqlMapClientTemplate().queryForList(
				namespace.concat("selectByExample"), criteria, offset, size);
	}
	
	@Override
	public void batchCreate(List<Object> pojoList, String sqlId) {
		try {
			getSqlMapClient().startBatch();
			for (Object record : pojoList) {
				getSqlMapClient().insert(namespace.concat(sqlId), record);
			}
			getSqlMapClient().executeBatch();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	@Override
	public void batchUpdate(List<Object> pojoList, String sqlId) {
		try {
			getSqlMapClient().startBatch();
			for (Object record : pojoList) {
				getSqlMapClient().update(namespace.concat(sqlId), record);
			}
			getSqlMapClient().executeBatch();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	@Override
	public boolean update(Object param, String sqlId) {
		return getSqlMapClientTemplate().update(namespace.concat(sqlId), param)==1;
	}



	@Override
	public int countByCriteriaMap(Map<String, Object> criteria, String sqlId) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				namespace.concat(sqlId), criteria);
	}

	@Override
	public Map<String, Object> findByIdAndSqlId(Object primaryKey, String sqlId) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject(
				namespace.concat(sqlId), primaryKey);
	}

	@Override
	public List<Map<String, Object>> findByCriteriaMap(
			Map<String, Object> criteria, String sqlId) {
		return (List<Map<String, Object>>) getSqlMapClientTemplate()
				.queryForList(namespace.concat(sqlId), criteria);
	}

	@Override
	public Map<String, Object> findObjectByCriteriaMap(
			Map<String, Object> criteria, String sqlId) {
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject(
				namespace.concat(sqlId), criteria);
	}

	@Override
	public List<Map<String, Object>> findByCriteriaMap(
			Map<String, Object> criteria, Page page, String sqlId) {
		int size = page.getPageSize();
		int offset = page.currentRecordIndex();

		int total = countByCriteriaMap(criteria,"count_".concat(sqlId));
		page.setTotalRecord(total);
		return getSqlMapClientTemplate().queryForList(namespace.concat(sqlId),
				criteria, offset, size);
	}
	
	@Override
	public List<T> findByCriteriaMapReturnObj(
			Map<String, Object> criteria, Page page, String sqlId) {
		int size = page.getPageSize();
		int offset = page.currentRecordIndex();

		int total = countByCriteriaMap(criteria,"count_".concat(sqlId));
		page.setTotalRecord(total);
		return getSqlMapClientTemplate().queryForList(namespace.concat(sqlId),
				criteria, offset, size);
	}
	
	@Override
	public List<T> findByCriteriaAndSqlId(Object criteria, String sqlId) {
		return getSqlMapClientTemplate()
				.queryForList(namespace.concat(sqlId), criteria);
	}


	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace.concat(".");
	}
}
package com.shecc.eoms.core.common;

import java.util.List;
import java.util.Map;

public interface IBaseDAO<T> {

	/**
	 * 创建一条数据 如果insert语句中有selectKey字句会返回主键。
	 * 
	 * @param pojo
	 * @return
	 */
	Object create(T pojo);
	
	/**
	 * 
	 * 执行sql语句，执行存储
	 * @param pojo
	 * @return
	 */
	void create(Object pojo,String sqlId);
	
	
	/**
	 * 
	 * 执行sql语句，执行存储
	 * @param pojoList
	 * @return
	 */
	void batchUpdate(List<Object> pojoList, String sqlId);
	
	/**
	 * 
	 * 执行sql语句，执行存储
	 * @param pojoList
	 * @return
	 */
	void batchCreate(List<Object> pojoList,String sqlId);

	/**
	 * 删除一条数据
	 * 
	 * @param id 主键
	 * @return
	 */
	boolean delete(Object id);
	
	/**
	 * 根据条件删除指定记录
	 * @param criteria
	 * @return
	 */
	boolean deleteByCriteria(Object criteria);

	/**
	 * 更新一条记录（按主键更新）
	 * 
	 * @param pojo 数据实体
	 * @return
	 */
	boolean update(T pojo);
	
	/**
	 * 更新一条记录（按指定条件）
	 * 
	 * @param pojo 数据实体
	 * @param criteria 条件
	 * @return
	 */
	boolean update(T pojo,Object criteria);
	
	/**
	 * 根据指定的条件查询符合的记录集数目，全匹配
	 * 
	 * @param criteria
	 * @return
	 */
	int countByCriteria(Object criteria);

	/**
	 * 根据Id查询数据明细
	 * 
	 * @param id 主键
	 * @return
	 */
	T findById(Object id);

	/**
	 * 根据指定的条件返回查询结果，全匹配
	 * 
	 * @param criteria
	 * @return
	 */
	List<T> findByCriteria(Object criteria);
	
	/**
	 * 根据指定的条件返回查询结果(包含LOB字段)，全匹配
	 * 
	 * @param criteria
	 * @return
	 */
	List<T> findByCriteriaWithLobs(Object criteria);
	
	
	/**
	 * 根据指定的条件执行指定SQL返回查询结果，全匹配
	 * 
	 * @param criteria
	 * @return
	 */
	List<T> findByCriteriaAndSqlId(Object criteria,String sqlId);

	/**
	 * 根据指定的条件返回查询结果，全匹配
	 * 
	 * @param criteria
	 * @return
	 */
	T findObjectByCriteria(Object criteria);
	
	/**
	 * 根据指定的条件返回查询结果(包含大字段)，全匹配
	 * 
	 * @param criteria
	 * @return
	 */
	T findObjectByCriteriaWithLobs(Object criteria);

	/**
	 * 翻页查询
	 * @param criteria 查询条件
	 * @param page     翻页信息
	 * @return
	 */
	List<T> findByCriteria(Object criteria, Page page);
	
	
	/**
	 * 更新一条记录（按条件更新）
	 * 
	 * @param param 数据实体
	 * @return
	 */
	boolean update(Object param,String sqlId);
	
	
	
	
	/**
	 * 根据指定的条件查询符合的记录集数目，全匹配
	 * (供自定义SQL使用)
	 * @param criteria
	 * @param sqlId
	 * @return
	 */
	int countByCriteriaMap(Map<String,Object> criteria,String sqlId);

	/**
	 * 根据Id查询数据明细
	 *  (供自定义SQL使用)
	 * @param id 主键
	 * @param sqlId
	 * @return
	 */
	Map<String,Object> findByIdAndSqlId(Object id,String sqlId);

	/**
	 * 根据指定的条件返回查询结果，全匹配
	 *  (供自定义SQL使用)
	 * @param criteria
	 * @param sqlId
	 * @return
	 */
	List<Map<String,Object>> findByCriteriaMap(Map<String,Object> criteria,String sqlId);

	/**
	 * 根据指定的条件返回查询结果，全匹配
	 *  (供自定义SQL使用)
	 * @param criteria
	 * @param sqlId
	 * @return
	 */
	Map<String,Object> findObjectByCriteriaMap(Map<String,Object> criteria,String sqlId);

	/**
	 * 翻页查询
	 *  (供自定义SQL使用)
	 * @param criteria 查询条件
	 * @param page     翻页信息
	 * @param sqlId
	 * @return
	 */
	List<Map<String,Object>> findByCriteriaMap(Map<String,Object> criteria, Page page,String sqlId);

	
	List<T> findByCriteriaName();
	
	List<T> findByCriteriaAreaCity(Object currentCode);
	/**
	 * 翻页查询对象List
	 *  (供自定义SQL使用)
	 * @param criteria 查询条件
	 * @param page     翻页信息
	 * @param sqlId
	 * @return
	 */
	public List<T> findByCriteriaMapReturnObj(Map<String, Object> criteria, Page page, String sqlId);

}
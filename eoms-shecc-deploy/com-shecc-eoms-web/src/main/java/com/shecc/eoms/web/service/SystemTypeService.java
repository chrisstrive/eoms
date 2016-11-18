/**
 * Project Name:com-shecc-eoms-web
 * File Name:SystemTypeService.java
 * Package Name:com.shecc.eoms.web.service
 * Date:2016年11月17日下午2:21:02
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.service;

import java.util.List;

import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.model.SystemType;
import com.shecc.eoms.core.model.SystemTypeCriteria;

/**
 * ClassName: SystemTypeService <br/>
 * Function: 系统类型信息管理服务接口. <br/>
 * date: 2016年11月17日 下午2:21:02 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public interface SystemTypeService {
	/**
	 * 
	 * createEntityRnTx:创建信息. <br/>
	 *
	 * @author chris
	 * @param entity
	 *            要创建的信息
	 * @return
	 * @since JDK 1.6
	 */
	Integer createRnTx(SystemType entity);

	/**
	 * 
	 * updateEntityRnTx:更新信息. <br/>
	 *
	 * @author chris
	 * @param entity
	 *            带主键和需要更新的字段的信息。
	 * @return
	 * @since JDK 1.6
	 */
	boolean updateRnTx(SystemType entity);

	/**
	 * 
	 * queryAllForPage:分页查询信息. <br/>
	 *
	 * @author chris
	 * @param criteria
	 *            查询条件
	 * @param page
	 *            分页信息
	 * @return
	 * @since JDK 1.6
	 */
	String queryAllForPage(SystemTypeCriteria criteria, Page page);

	/**
	 * 
	 * findById:查询指定的信息. <br/>
	 *
	 * @author chris
	 * @param id
	 * @return
	 * @since JDK 1.6
	 */
	SystemType findById(Integer id);

	/**
	 * 
	 * queryAll:根据条件查询所有信息. <br/>
	 *
	 * @author chris
	 * @param criteria
	 *            查询条件
	 * @return
	 * @since JDK 1.6
	 */
	List<SystemType> queryAll(SystemTypeCriteria criteria);
}


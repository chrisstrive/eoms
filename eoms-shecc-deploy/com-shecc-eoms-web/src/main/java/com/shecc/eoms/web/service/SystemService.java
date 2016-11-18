/**
 * Project Name:com-shecc-eoms-web
 * File Name:SystemService.java
 * Package Name:com.shecc.eoms.web.service
 * Date:2016年11月15日下午5:24:11
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.service;

import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.model.System;
import com.shecc.eoms.core.model.SystemCriteria;

/**
 * ClassName: SystemService <br/>
 * Function: 位置服务类. <br/>
 * date: 2016年11月15日 下午5:24:11 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public interface SystemService {
	/**
	 * 
	 * createEntityRnTx:创建信息. <br/>
	 *
	 * @author chris
	 * @param entity	要创建的信息
	 * @return
	 * @since JDK 1.6
	 */
	Integer createRnTx(System entity);
	
	/**
	 * 
	 * updateEntityRnTx:更新信息. <br/>
	 *
	 * @author chris
	 * @param entity	带主键和需要更新的字段的信息。
	 * @return
	 * @since JDK 1.6
	 */
	boolean updateRnTx(System entity);
	
	/**
	 * 
	 * queryAllForPage:分页查询信息. <br/>
	 *
	 * @author chris
	 * @param criteria	查询条件
	 * @param page	分页信息
	 * @return
	 * @since JDK 1.6
	 */
	String queryAllForPage(SystemCriteria criteria, Page page);

	/**
	 * 
	 * findById:根据主键查询信息. <br/>
	 *
	 * @author chris
	 * @param id
	 * @return
	 * @since JDK 1.6
	 */
	System findById(Integer id);
}


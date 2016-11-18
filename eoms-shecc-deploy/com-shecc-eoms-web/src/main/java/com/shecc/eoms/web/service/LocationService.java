/**
 * Project Name:com-shecc-eoms-web
 * File Name:LocationService.java
 * Package Name:com.shecc.eoms.web.service
 * Date:2016年11月15日下午5:24:11
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.service;

import java.util.List;

import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.model.Location;
import com.shecc.eoms.core.model.LocationCriteria;

/**
 * ClassName: LocationService <br/>
 * Function: 位置服务类. <br/>
 * date: 2016年11月15日 下午5:24:11 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public interface LocationService {
	/**
	 * 
	 * createEntityRnTx:创建位置信息. <br/>
	 *
	 * @author chris
	 * @param entity	位置信息
	 * @return
	 * @since JDK 1.6
	 */
	Integer createRnTx(Location entity);
	
	/**
	 * 
	 * updateEntityRnTx:更新位置信息. <br/>
	 *
	 * @author chris
	 * @param entity	带主键和需要更新的字段的位置信息。
	 * @return
	 * @since JDK 1.6
	 */
	boolean updateRnTx(Location entity);
	
	/**
	 * 
	 * queryAllForPage:分页查询位置信息. <br/>
	 *
	 * @author chris
	 * @param criteria	查询条件
	 * @param page	分页信息
	 * @return
	 * @since JDK 1.6
	 */
	String queryAllForPage(LocationCriteria criteria, Page page);

	/**
	 * 
	 * findById:查询指定的位置信息. <br/>
	 *
	 * @author chris
	 * @param id
	 * @return
	 * @since JDK 1.6
	 */
	Location findById(Integer id);
	
	/**
	 * 
	 * queryAll:根据条件查询所有位置信息. <br/>
	 *
	 * @author chris
	 * @param criteria	查询条件
	 * @return
	 * @since JDK 1.6
	 */
	List<Location> queryAll(LocationCriteria criteria);
}


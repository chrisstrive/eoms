/**
 * Project Name:com-shecc-eoms-web
 * File Name:DeviceService.java
 * Package Name:com.shecc.eoms.web.service
 * Date:2016年11月17日上午11:27:21
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.service;

import java.util.List;

import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.model.Device;
import com.shecc.eoms.core.model.DeviceCriteria;

/**
 * ClassName: DeviceService <br/>
 * Function: . <br/>
 * date: 2016年11月17日 上午11:27:21 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public interface DeviceService {
	/**
	 * 
	 * createEntityRnTx:创建位置信息. <br/>
	 *
	 * @author chris
	 * @param entity	位置信息
	 * @return
	 * @since JDK 1.6
	 */
	Integer createRnTx(Device entity);
	
	/**
	 * 
	 * updateEntityRnTx:更新位置信息. <br/>
	 *
	 * @author chris
	 * @param entity	带主键和需要更新的字段的位置信息。
	 * @return
	 * @since JDK 1.6
	 */
	boolean updateRnTx(Device entity);
	
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
	String queryAllForPage(DeviceCriteria criteria, Page page);

	/**
	 * 
	 * findById:查询指定的位置信息. <br/>
	 *
	 * @author chris
	 * @param id
	 * @return
	 * @since JDK 1.6
	 */
	Device findById(Integer id);
	
	/**
	 * 
	 * queryAll:根据条件查询所有位置信息. <br/>
	 *
	 * @author chris
	 * @param criteria	查询条件
	 * @return
	 * @since JDK 1.6
	 */
	List<Device> queryAll(DeviceCriteria criteria);
}
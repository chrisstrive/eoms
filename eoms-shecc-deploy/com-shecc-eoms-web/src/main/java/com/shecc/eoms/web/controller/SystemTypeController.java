/**
 * Project Name:com-shecc-eoms-web
 * File Name:SystemTypeController.java
 * Package Name:com.shecc.eoms.web.controller
 * Date:2016年11月17日下午7:04:12
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shecc.eoms.web.service.SystemTypeService;

/**
 * ClassName: SystemTypeController <br/>
 * Function: 系统类型信息控制器. <br/>
 * date: 2016年11月17日 下午7:04:12 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public class SystemTypeController extends BaseController {
	private static final Logger log = LoggerFactory
			.getLogger(SystemTypeController.class);

	private String listPage;
	private String addPage;
	private String updatePage;

	private SystemTypeService entityService;

	public void setEntityService(SystemTypeService entityService) {
		this.entityService = entityService;
	}
	
	public void setAddPage(String addPage) {
		this.addPage = addPage;
	}

	public void setUpdatePage(String updatePage) {
		this.updatePage = updatePage;
	}

	public void setListPage(String listPage) {
		this.listPage = listPage;
	}
}


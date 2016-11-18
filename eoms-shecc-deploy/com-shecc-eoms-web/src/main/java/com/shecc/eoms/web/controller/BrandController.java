/**
 * Project Name:com-shecc-eoms-web
 * File Name:BrandController.java
 * Package Name:com.shecc.eoms.web.controller
 * Date:2016年11月17日下午7:02:54
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shecc.eoms.web.service.BrandService;

/**
 * ClassName: BrandController <br/>
 * Function: 品牌管理控制器. <br/>
 * date: 2016年11月17日 下午7:02:54 <br/>
 *
 * @author chris
 * @version
 * @since JDK 1.6
 */
public class BrandController extends BaseController {
	private static final Logger log = LoggerFactory
			.getLogger(BrandController.class);

	private String listPage;
	private String addPage;
	private String updatePage;

	private BrandService entityService;

	public void setEntityService(BrandService entityService) {
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

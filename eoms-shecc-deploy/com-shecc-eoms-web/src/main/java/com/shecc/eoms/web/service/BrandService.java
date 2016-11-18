/**
 * Project Name:com-shecc-eoms-web
 * File Name:BrandService.java
 * Package Name:com.shecc.eoms.web.service
 * Date:2016年11月17日下午1:57:34
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.service;

import java.util.List;

import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.model.Brand;
import com.shecc.eoms.core.model.BrandCriteria;

/**
 * ClassName: BrandService <br/>
 * Function: 品牌信息管理服务类. <br/>
 * date: 2016年11月17日 下午1:57:34 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public interface BrandService {
	/**
	 * 
	 * createEntityRnTx:创建信息. <br/>
	 *
	 * @author chris
	 * @param entity	要创建的信息
	 * @return
	 * @since JDK 1.6
	 */
	Integer createRnTx(Brand entity);
	
	/**
	 * 
	 * updateEntityRnTx:更新信息. <br/>
	 *
	 * @author chris
	 * @param entity	带主键和需要更新的字段的信息。
	 * @return
	 * @since JDK 1.6
	 */
	boolean updateRnTx(Brand entity);
	
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
	String queryAllForPage(BrandCriteria criteria, Page page);

	/**
	 * 
	 * findById:查询指定的信息. <br/>
	 *
	 * @author chris
	 * @param id
	 * @return
	 * @since JDK 1.6
	 */
	Brand findById(Integer id);
	
	/**
	 * 
	 * queryAll:根据条件查询所有信息. <br/>
	 *
	 * @author chris
	 * @param criteria	查询条件
	 * @return
	 * @since JDK 1.6
	 */
	List<Brand> queryAll(BrandCriteria criteria);
}


/**
 * Project Name:com-shecc-eoms-web
 * File Name:BrandServiceImpl.java
 * Package Name:com.shecc.eoms.web.service.impl
 * Date:2016年11月17日下午2:22:20
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shecc.eoms.core.common.IBaseDAO;
import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.enums.ArchiveFlagEnum;
import com.shecc.eoms.core.model.Brand;
import com.shecc.eoms.core.model.BrandCriteria;
import com.shecc.eoms.web.common.utils.JSONUtil;
import com.shecc.eoms.web.service.BrandService;

/**
 * ClassName: BrandServiceImpl <br/>
 * date: 2016年11月17日 下午2:22:20 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public class BrandServiceImpl implements BrandService {

	private IBaseDAO<Brand> entityDao;
	
	public void setEntityDao(IBaseDAO<Brand> entityDao) {
		this.entityDao = entityDao;
	}


	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.BrandService#createRnTx(com.shecc.eoms.core.model.Brand)
	 */
	@Override
	public Integer createRnTx(Brand entity) {
		return (Integer) entityDao.create(entity);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.BrandService#updateRnTx(com.shecc.eoms.core.model.Brand)
	 */
	@Override
	public boolean updateRnTx(Brand entity) {
		return entityDao.update(entity);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.BrandService#queryAllForPage(com.shecc.eoms.core.model.BrandCriteria, com.shecc.eoms.core.common.Page)
	 */
	@Override
	public String queryAllForPage(BrandCriteria criteria, Page page) {
		criteria.setOrderByClause("LAST_MODIFY_TIME desc");
		List<Brand> dataList = null;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (page != null) {
			dataList = entityDao.findByCriteria(criteria, page);
			dataMap.put("pageCount", page.getTotalRecord());
		} else {
			dataList = entityDao.findByCriteria(criteria);
			dataMap.put("pageCount", 1);
		}
		dataMap.put("pageData", dataList);
		String result = JSONUtil.toJSonString(dataMap);
		return result;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.BrandService#findById(java.lang.Integer)
	 */
	@Override
	public Brand findById(Integer id) {
		BrandCriteria criteria = new BrandCriteria();
		criteria.createCriteria().andIdEqualTo(id)
				.andArchiveFlagEqualTo(ArchiveFlagEnum.NO_ARCHIVE.getCode());
		return entityDao.findObjectByCriteria(criteria);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.BrandService#queryAll(com.shecc.eoms.core.model.BrandCriteria)
	 */
	@Override
	public List<Brand> queryAll(BrandCriteria criteria) {
		return entityDao.findByCriteria(criteria);
	}

}


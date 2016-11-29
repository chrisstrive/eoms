/**
 * Project Name:com-shecc-eoms-web
 * File Name:SystemServiceImpl.java
 * Package Name:com.shecc.eoms.web.service.impl
 * Date:2016年11月17日上午10:30:39
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
import com.shecc.eoms.core.model.System;
import com.shecc.eoms.core.model.SystemCriteria;
import com.shecc.eoms.web.common.utils.JSONUtil;
import com.shecc.eoms.web.service.SystemService;

/**
 * ClassName: SystemServiceImpl <br/>
 * Function: 系统信息管理实现类. <br/>
 * date: 2016年11月17日 上午10:30:39 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public class SystemServiceImpl implements SystemService {

	private IBaseDAO<System> entityDao;
	
	public void setEntityDao(IBaseDAO<System> entityDao) {
		this.entityDao = entityDao;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.SystemService#createRnTx(com.shecc.eoms.core.model.System)
	 */
	@Override
	public Integer createRnTx(System entity) {
		return (Integer) entityDao.create(entity);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.SystemService#updateRnTx(com.shecc.eoms.core.model.System)
	 */
	@Override
	public boolean updateRnTx(System entity) {
		return entityDao.update(entity);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.SystemService#queryAllForPage(com.shecc.eoms.core.model.SystemCriteria, com.shecc.eoms.core.common.Page)
	 */
	@Override
	public String queryAllForPage(SystemCriteria criteria, Page page) {
		criteria.setOrderByClause("LAST_MODIFY_TIME desc");
		List<System> dataList = null;
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
	 * @see com.shecc.eoms.web.service.SystemService#findById(java.lang.Integer)
	 */
	@Override
	public System findById(Integer id) {
		SystemCriteria criteria = new SystemCriteria();
		criteria.createCriteria().andIdEqualTo(id)
				.andArchiveFlagEqualTo(ArchiveFlagEnum.NO_ARCHIVE.getCode());
		return entityDao.findObjectByCriteria(criteria);
	}

	@Override
	public List<System> queryAll(SystemCriteria criteria) {
		return entityDao.findByCriteria(criteria);
	}
}
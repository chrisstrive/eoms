/**
 * Project Name:com-shecc-eoms-web
 * File Name:SystemTypeServiceImpl.java
 * Package Name:com.shecc.eoms.web.service.impl
 * Date:2016年11月17日下午2:24:55
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
import com.shecc.eoms.core.model.SystemType;
import com.shecc.eoms.core.model.SystemTypeCriteria;
import com.shecc.eoms.web.common.utils.JSONUtil;
import com.shecc.eoms.web.service.SystemTypeService;

/**
 * ClassName: SystemTypeServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年11月17日 下午2:24:55 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public class SystemTypeServiceImpl implements SystemTypeService {

	private IBaseDAO<SystemType> entityDao;
	
	public void setEntityDao(IBaseDAO<SystemType> entityDao) {
		this.entityDao = entityDao;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.SystemTypeService#createRnTx(com.shecc.eoms.core.model.SystemType)
	 */
	@Override
	public Integer createRnTx(SystemType entity) {
		return (Integer) entityDao.create(entity);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.SystemTypeService#updateRnTx(com.shecc.eoms.core.model.SystemType)
	 */
	@Override
	public boolean updateRnTx(SystemType entity) {
		return entityDao.update(entity);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.SystemTypeService#queryAllForPage(com.shecc.eoms.core.model.SystemTypeCriteria, com.shecc.eoms.core.common.Page)
	 */
	@Override
	public String queryAllForPage(SystemTypeCriteria criteria, Page page) {
		criteria.setOrderByClause("LAST_MODIFY_TIME desc");
		List<SystemType> dataList = null;
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
	 * @see com.shecc.eoms.web.service.SystemTypeService#findById(java.lang.Integer)
	 */
	@Override
	public SystemType findById(Integer id) {
		SystemTypeCriteria criteria = new SystemTypeCriteria();
		criteria.createCriteria().andIdEqualTo(id)
				.andArchiveFlagEqualTo(ArchiveFlagEnum.NO_ARCHIVE.getCode());
		return entityDao.findObjectByCriteria(criteria);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.SystemTypeService#queryAll(com.shecc.eoms.core.model.SystemTypeCriteria)
	 */
	@Override
	public List<SystemType> queryAll(SystemTypeCriteria criteria) {
		return entityDao.findByCriteria(criteria);
	}

}


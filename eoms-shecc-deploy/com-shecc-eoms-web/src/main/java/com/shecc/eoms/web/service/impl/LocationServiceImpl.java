/**
 * Project Name:com-shecc-eoms-web
 * File Name:LocationServiceImpl.java
 * Package Name:com.shecc.eoms.web.service.impl
 * Date:2016年11月15日下午5:35:42
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
import com.shecc.eoms.core.model.Location;
import com.shecc.eoms.core.model.LocationCriteria;
import com.shecc.eoms.web.common.utils.JSONUtil;
import com.shecc.eoms.web.service.LocationService;

/**
 * ClassName: LocationServiceImpl <br/>
 * date: 2016年11月15日 下午5:35:42 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public class LocationServiceImpl implements LocationService {

	private IBaseDAO<Location> entityDao;
	
	public void setEntityDao(IBaseDAO<Location> entityDao) {
		this.entityDao = entityDao;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.LocationService#createRnTx(com.shecc.eoms.core.model.Location)
	 */
	@Override
	public Integer createRnTx(Location entity) {
		return (Integer) entityDao.create(entity);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.LocationService#updateRnTx(com.shecc.eoms.core.model.Location)
	 */
	@Override
	public boolean updateRnTx(Location entity) {
		return entityDao.update(entity);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.LocationService#queryAllForPage(com.shecc.eoms.core.model.LocationCriteria, com.shecc.eoms.core.common.Page)
	 */
	@Override
	public String queryAllForPage(LocationCriteria criteria, Page page) {
		criteria.setOrderByClause("LAST_MODIFY_TIME desc");
		List<Location> dataList = null;
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
	 * @see com.shecc.eoms.web.service.LocationService#findById(java.lang.Integer)
	 */
	@Override
	public Location findById(Integer id) {
		LocationCriteria criteria = new LocationCriteria();
		criteria.createCriteria().andIdEqualTo(id)
				.andArchiveFlagEqualTo(ArchiveFlagEnum.NO_ARCHIVE.getCode());
		return entityDao.findObjectByCriteria(criteria);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.LocationService#queryAll(om.shecc.eoms.core.model.LocationCriteria)
	 */
	@Override
	public List<Location> queryAll(LocationCriteria criteria) {
		return entityDao.findByCriteria(criteria);
	}

}


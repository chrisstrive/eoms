/**
 * Project Name:com-shecc-eoms-web
 * File Name:DeviceServiceImpl.java
 * Package Name:com.shecc.eoms.web.service.impl
 * Date:2016年11月17日下午2:23:55
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
import com.shecc.eoms.core.model.Device;
import com.shecc.eoms.core.model.DeviceCriteria;
import com.shecc.eoms.web.common.utils.JSONUtil;
import com.shecc.eoms.web.service.DeviceService;

/**
 * ClassName: DeviceServiceImpl <br/>
 * date: 2016年11月17日 下午2:23:55 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public class DeviceServiceImpl implements DeviceService {

	private IBaseDAO<Device> entityDao;
	
	public void setEntityDao(IBaseDAO<Device> entityDao) {
		this.entityDao = entityDao;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.DeviceService#createRnTx(com.shecc.eoms.core.model.Device)
	 */
	@Override
	public Integer createRnTx(Device entity) {
		return (Integer) entityDao.create(entity);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.DeviceService#updateRnTx(com.shecc.eoms.core.model.Device)
	 */
	@Override
	public boolean updateRnTx(Device entity) {
		return entityDao.update(entity);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.DeviceService#queryAllForPage(com.shecc.eoms.core.model.DeviceCriteria, com.shecc.eoms.core.common.Page)
	 */
	@Override
	public String queryAllForPage(DeviceCriteria criteria, Page page) {
		criteria.setOrderByClause("LAST_MODIFY_TIME desc");
		List<Device> dataList = null;
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
	 * @see com.shecc.eoms.web.service.DeviceService#findById(java.lang.Integer)
	 */
	@Override
	public Device findById(Integer id) {
		DeviceCriteria criteria = new DeviceCriteria();
		criteria.createCriteria().andIdEqualTo(id)
				.andArchiveFlagEqualTo(ArchiveFlagEnum.NO_ARCHIVE.getCode());
		return entityDao.findObjectByCriteria(criteria);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.DeviceService#queryAll(com.shecc.eoms.core.model.DeviceCriteria)
	 */
	@Override
	public List<Device> queryAll(DeviceCriteria criteria) {
		return entityDao.findByCriteria(criteria);
	}

}


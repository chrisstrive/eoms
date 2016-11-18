/**
 * Project Name:com-shecc-eoms-web
 * File Name:CheckItemServiceImpl.java
 * Package Name:com.shecc.eoms.web.service.impl
 * Date:2016年11月17日下午2:23:25
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
import com.shecc.eoms.core.model.CheckItem;
import com.shecc.eoms.core.model.CheckItemCriteria;
import com.shecc.eoms.web.common.utils.JSONUtil;
import com.shecc.eoms.web.service.CheckItemService;

/**
 * ClassName: CheckItemServiceImpl <br/>
 * date: 2016年11月17日 下午2:23:25 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public class CheckItemServiceImpl implements CheckItemService {

	private IBaseDAO<CheckItem> entityDao;
	
	public void setEntityDao(IBaseDAO<CheckItem> entityDao) {
		this.entityDao = entityDao;
	}


	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.CheckItemService#createRnTx(com.shecc.eoms.core.model.CheckItem)
	 */
	@Override
	public Integer createRnTx(CheckItem entity) {
		return (Integer) entityDao.create(entity);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.CheckItemService#updateRnTx(com.shecc.eoms.core.model.CheckItem)
	 */
	@Override
	public boolean updateRnTx(CheckItem entity) {
		return entityDao.update(entity);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.CheckItemService#queryAllForPage(com.shecc.eoms.core.model.CheckItemCriteria, com.shecc.eoms.core.common.Page)
	 */
	@Override
	public String queryAllForPage(CheckItemCriteria criteria, Page page) {
		criteria.setOrderByClause("LAST_MODIFY_TIME desc");
		List<CheckItem> dataList = null;
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
	 * @see com.shecc.eoms.web.service.CheckItemService#findById(java.lang.Integer)
	 */
	@Override
	public CheckItem findById(Integer id) {
		CheckItemCriteria criteria = new CheckItemCriteria();
		criteria.createCriteria().andIdEqualTo(id)
				.andArchiveFlagEqualTo(ArchiveFlagEnum.NO_ARCHIVE.getCode());
		return entityDao.findObjectByCriteria(criteria);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.CheckItemService#queryAll(com.shecc.eoms.core.model.CheckItemCriteria)
	 */
	@Override
	public List<CheckItem> queryAll(CheckItemCriteria criteria) {
		return entityDao.findByCriteria(criteria);
	}

}


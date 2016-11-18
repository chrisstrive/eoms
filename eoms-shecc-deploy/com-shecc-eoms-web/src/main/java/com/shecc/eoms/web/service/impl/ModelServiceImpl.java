/**
 * Project Name:com-shecc-eoms-web
 * File Name:ModelServiceImpl.java
 * Package Name:com.shecc.eoms.web.service.impl
 * Date:2016年11月17日下午2:24:28
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
import com.shecc.eoms.core.model.Model;
import com.shecc.eoms.core.model.ModelCriteria;
import com.shecc.eoms.web.common.utils.JSONUtil;
import com.shecc.eoms.web.service.ModelService;

/**
 * ClassName: ModelServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年11月17日 下午2:24:28 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public class ModelServiceImpl implements ModelService {

	private IBaseDAO<Model> entityDao;
	
	public void setEntityDao(IBaseDAO<Model> entityDao) {
		this.entityDao = entityDao;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.ModelService#createRnTx(com.shecc.eoms.core.model.Model)
	 */
	@Override
	public Integer createRnTx(Model entity) {
		return (Integer) entityDao.create(entity);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.ModelService#updateRnTx(com.shecc.eoms.core.model.Model)
	 */
	@Override
	public boolean updateRnTx(Model entity) {
		return entityDao.update(entity);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.ModelService#queryAllForPage(com.shecc.eoms.core.model.ModelCriteria, com.shecc.eoms.core.common.Page)
	 */
	@Override
	public String queryAllForPage(ModelCriteria criteria, Page page) {
		criteria.setOrderByClause("LAST_MODIFY_TIME desc");
		List<Model> dataList = null;
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
	 * @see com.shecc.eoms.web.service.ModelService#findById(java.lang.Integer)
	 */
	@Override
	public Model findById(Integer id) {
		ModelCriteria criteria = new ModelCriteria();
		criteria.createCriteria().andIdEqualTo(id)
				.andArchiveFlagEqualTo(ArchiveFlagEnum.NO_ARCHIVE.getCode());
		return entityDao.findObjectByCriteria(criteria);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.shecc.eoms.web.service.ModelService#queryAll(com.shecc.eoms.core.model.ModelCriteria)
	 */
	@Override
	public List<Model> queryAll(ModelCriteria criteria) {
		return entityDao.findByCriteria(criteria);
	}

}


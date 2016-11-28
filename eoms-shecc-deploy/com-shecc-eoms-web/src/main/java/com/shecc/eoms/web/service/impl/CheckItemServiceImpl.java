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

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;

import com.google.common.collect.Lists;
import com.shecc.eoms.core.common.IBaseDAO;
import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.enums.ArchiveFlagEnum;
import com.shecc.eoms.core.model.CheckItem;
import com.shecc.eoms.core.model.CheckItemCriteria;
import com.shecc.eoms.core.model.RelModelChkCriteria;
import com.shecc.eoms.core.model.RelModelChkKey;
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

	private IBaseDAO<RelModelChkKey> relModelChkKeyDao;

	public void setEntityDao(IBaseDAO<CheckItem> entityDao) {
		this.entityDao = entityDao;
	}

	public void setRelModelChkKeyDao(IBaseDAO<RelModelChkKey> relModelChkKeyDao) {
		this.relModelChkKeyDao = relModelChkKeyDao;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.shecc.eoms.web.service.CheckItemService#createRnTx(com.shecc.eoms.core.model.CheckItem)
	 */
	@Override
	public Integer createRnTx(CheckItem entity) {
		return (Integer) entityDao.create(entity);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.shecc.eoms.web.service.CheckItemService#updateRnTx(com.shecc.eoms.core.model.CheckItem)
	 */
	@Override
	public boolean updateRnTx(CheckItem entity) {
		return entityDao.update(entity);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.shecc.eoms.web.service.CheckItemService#queryAllForPage(com.shecc.eoms.core.model.CheckItemCriteria,
	 *      com.shecc.eoms.core.common.Page)
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
	 * 
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
	 * 
	 * @see com.shecc.eoms.web.service.CheckItemService#queryAll(com.shecc.eoms.core.model.CheckItemCriteria)
	 */
	@Override
	public List<CheckItem> queryAll(CheckItemCriteria criteria) {
		return entityDao.findByCriteria(criteria);
	}

	@Override
	public List<List<CheckItem>> queryByModelId(int modelId) {
		List<List<CheckItem>> resultList = Lists.newArrayList();
		List<CheckItem> relCheckItem = Lists.newArrayList(); // 关联的检查项
		List<CheckItem> notRelCheckItem = Lists.newArrayList(); // 没有关联的检查项

		RelModelChkCriteria relModelChkCriteria = new RelModelChkCriteria();
		relModelChkCriteria.createCriteria().andModelIdEqualTo(modelId);
		List<RelModelChkKey> relModelChkKeyList = relModelChkKeyDao
				.findByCriteria(relModelChkCriteria);
		List<Integer> chkIdList = Lists.newArrayList();

		// 如果有关联的检查项则根据id获取关联和没有关联的检查项
		CheckItemCriteria inCheckItemCriteria = new CheckItemCriteria();
		CheckItemCriteria notInCheckItemCriteria = new CheckItemCriteria();
		if (CollectionUtils.isNotEmpty(relModelChkKeyList)) {
			for (RelModelChkKey relModelChkKey : relModelChkKeyList) {
				chkIdList.add(relModelChkKey.getChkId());
			}
			inCheckItemCriteria
					.createCriteria()
					.andArchiveFlagEqualTo(ArchiveFlagEnum.NO_ARCHIVE.getCode())
					.andIdIn(chkIdList);
			relCheckItem = entityDao.findByCriteria(inCheckItemCriteria);

			notInCheckItemCriteria
					.createCriteria()
					.andArchiveFlagEqualTo(ArchiveFlagEnum.NO_ARCHIVE.getCode())
					.andIdNotIn(chkIdList);
			notRelCheckItem = entityDao.findByCriteria(notInCheckItemCriteria);

		} else { // 没有则获取全部检查项
			notInCheckItemCriteria.createCriteria().andArchiveFlagEqualTo(
					ArchiveFlagEnum.NO_ARCHIVE.getCode());
			notRelCheckItem = entityDao.findByCriteria(notInCheckItemCriteria);
		}
		resultList.add(relCheckItem);
		resultList.add(notRelCheckItem);
		return resultList;
	}

	@Override
	public void addRelModelChkRnTx(String[] checkItemIds, Integer modelId) {
		// 删除原有的关联检查项
		if (modelId!=null&&modelId>0) {
			RelModelChkCriteria criteria = new RelModelChkCriteria();
			criteria.createCriteria().andModelIdEqualTo(modelId);
			relModelChkKeyDao.deleteByCriteria(criteria);
		}
		
		// 插入新的关联检查项
		if (ArrayUtils.isNotEmpty(checkItemIds)&&modelId!=null&&modelId>0) {
			List<RelModelChkKey> relModelChkKeys =Lists.newArrayList();
			for (String item : checkItemIds) {
				RelModelChkKey relModelChkKey = new RelModelChkKey();
				relModelChkKey.setModelId(modelId);
				relModelChkKey.setChkId(Integer.parseInt(item));
				relModelChkKeys.add(relModelChkKey);
			}
			relModelChkKeyDao.batchCreate(relModelChkKeys);
		}
	}
}

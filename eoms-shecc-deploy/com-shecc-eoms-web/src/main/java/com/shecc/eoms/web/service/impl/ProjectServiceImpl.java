/**
 * Project Name:com-shecc-eoms-web
 * File Name:ProjectServiceImpl.java
 * Package Name:com.shecc.eoms.web.service.impl
 * Date:2016年10月20日下午3:38:06
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
import com.shecc.eoms.core.model.Project;
import com.shecc.eoms.core.model.ProjectCriteria;
import com.shecc.eoms.web.common.utils.JSONUtil;
import com.shecc.eoms.web.service.ProjectService;

/**
 * ClassName: ProjectServiceImpl <br/>
 * Function: 项目管理服务实现类. <br/>
 * date: 2016年10月20日 下午3:38:06 <br/>
 *
 * @author chris
 * @version
 * @since JDK 1.6
 */
public class ProjectServiceImpl implements ProjectService {

	private IBaseDAO<Project> projectDao;

	public void setProjectDao(IBaseDAO<Project> projectDao) {
		this.projectDao = projectDao;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.shecc.eoms.web.service.ProjectService#createProjectRnTx(com.shecc.eoms.core.model.Project)
	 */
	@Override
	public Integer createProjectRnTx(Project project) {
		return (Integer) projectDao.create(project);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.shecc.eoms.web.service.ProjectService#updateProjectRnTx(com.shecc.eoms.core.model.Project)
	 */
	@Override
	public boolean updateProjectRnTx(Project project) {
		return projectDao.update(project);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.shecc.eoms.web.service.ProjectService#deleteProjectRnTx(java.lang.Integer)
	 */
	@Override
	public boolean deleteProjectRnTx(Integer id) {
		return projectDao.delete(id);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.shecc.eoms.web.service.ProjectService#queryProjectForPage(com.shecc.eoms.core.model.ProjectCriteria,
	 *      com.shecc.eoms.core.common.Page)
	 */
	@Override
	public String queryProjectForPage(ProjectCriteria criteria, Page page) {
		criteria.setOrderByClause("LAST_MODIFY_TIME desc");
		List<Project> dataList = null;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (page != null) {
			dataList = projectDao.findByCriteria(criteria, page);
			dataMap.put("pageCount", page.getTotalRecord());
		} else {
			dataList = projectDao.findByCriteria(criteria);
			dataMap.put("pageCount", 1);
		}
		dataMap.put("pageData", dataList);
		String result = JSONUtil.toJSonString(dataMap);
		return result;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.shecc.eoms.web.service.ProjectService#findById(java.lang.Integer)
	 */
	@Override
	public Project findById(Integer id) {
		ProjectCriteria criteria = new ProjectCriteria();
		criteria.createCriteria().andIdEqualTo(id)
				.andArchiveFlagEqualTo(ArchiveFlagEnum.NO_ARCHIVE.getCode());
		return projectDao.findObjectByCriteria(criteria);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.shecc.eoms.web.service.ProjectService#queryAll()
	 */
	@Override
	public List<Project> queryAll() {

		// TODO Auto-generated method stub
		return null;
	}

}

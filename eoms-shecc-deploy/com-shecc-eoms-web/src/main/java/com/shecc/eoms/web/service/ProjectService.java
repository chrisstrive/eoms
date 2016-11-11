/**
 * Project Name:com-shecc-eoms-web
 * File Name:ProjectService.java
 * Package Name:com.shecc.eoms.web.service
 * Date:2016年10月20日下午3:35:34
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.service;

import java.util.List;

import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.model.Project;
import com.shecc.eoms.core.model.ProjectCriteria;

/**
 * ClassName: ProjectService <br/>
 * Function: 项目管理服务接口. <br/>
 * date: 2016年10月20日 下午3:35:34 <br/>
 *
 * @author chris
 * @version
 * @since JDK 1.6
 */
public interface ProjectService {
	
	public Integer createProjectRnTx(Project project);

	public boolean updateProjectRnTx(Project project);

	public boolean deleteProjectRnTx(Integer id);

	public String queryProjectForPage(ProjectCriteria criteria, Page page);

	public Project findById(Integer id);

	public List<Project> queryAll();
}

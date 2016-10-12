package com.shecc.eoms.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.shecc.eoms.web.common.utils.JSONUtil;
import com.shecc.eoms.web.service.RoleService;
import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.dao.RoleDAOImpl;
import com.shecc.eoms.core.model.Role;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-13 下午05:50:30
 * INFO com.shecc.eoms.web.service.impl RoleServiceImpl.java
 * REMARK 
 *
 */
public class RoleServiceImpl implements RoleService {
	
	RoleDAOImpl roleDao;
	
	public void setRoleDao(RoleDAOImpl roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public boolean checkRoleByRoleName(String roleName, Integer id) {
		boolean retVal = false;
		Role role = roleDao.checkRoleByRoleName(roleName);
		if(role == null){//无此用户即可创建
			retVal = true;
		}else{
			if(id != null
					&& role.getId().compareTo(id) == 0){
				retVal = true;
			}else{
				retVal = false;
			}
		}
		
		return retVal;
	}

	@Override
	public void createRoleRnTx(Role role) {
		// 查询id编码最大的
		Integer maxId = roleDao.countByCriteriaMap(null, "getMaxId");
		role.setRoleCode("sys_" + ((maxId == null ? 0 : maxId) +1));
		roleDao.create(role);
	}

	@Override
	public void forbiddenRoleByIdRnTx(Integer id) {
		roleDao.forbiddenRoleById(id);
	}
	
	@Override
	public void reUseRoleByRoleIdRnTx(Integer id) {
		roleDao.reUseRoleByRoleId(id);
	}

	@Override
	public List<Role> queryRole() {
		return roleDao.queryRole();
	}

	@Override
	public String queryForPage(Map<String, Object> queryMap, Page page) {
		List<Role> dataList = this.roleDao.findByCriteriaMapReturnObj(queryMap, page, "queryRoleForPage");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("pageData", dataList);
		dataMap.put("pageCount", page.getTotalRecord());
		String result = JSONUtil.toJSonString(dataMap);
		return result;
	}
	
	@Override
	public List<Role> queryForList(Map<String, Object> queryMap){
		List<Role> dataList = this.roleDao.findByCriteriaAndSqlId(queryMap, "queryRoleForPage");
		return dataList;
	}

	@Override
	public Role findRoleByRoleId(Integer id) {
		return this.roleDao.findRoleByRoleId(id);
	}

	@Override
	public boolean updateRoleByRoleCodeRnTx(Role role, Integer id) {
		return roleDao.update(role);
	}

}


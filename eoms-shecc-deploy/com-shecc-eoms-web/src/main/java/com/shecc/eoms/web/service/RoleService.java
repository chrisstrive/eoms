package com.shecc.eoms.web.service;

import java.util.List;
import java.util.Map;

import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.model.Role;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-13 下午05:28:46
 * INFO com.shecc.eoms.web.service RoleService.java
 * REMARK 
 *
 */
public interface RoleService {
	/**
	 * 创建角色
	 * @param user
	 */
	public void createRoleRnTx(Role role);
	
	/**
	 * 查询角色
	 * @return
	 */
	public List<Role> queryRole();
	
	
	/**
	 * 根据用户ID禁用用户
	 * @param userId
	 */
	public void forbiddenRoleByIdRnTx(Integer id);
	
	/**
	 * 启用角色
	 * @param roleCode
	 */
	public void reUseRoleByRoleIdRnTx(Integer id);
	
	
	/**
	 * 根据角色名检查角色
	 * @param username
	 * @return
	 */
	public boolean checkRoleByRoleName(String roleName, Integer id);
	
	/**
	 * 查询角色分页
	 * @param queryMap
	 * @param page
	 * @return
	 */
	public String queryForPage(Map<String, Object> queryMap, Page page);
	
	/**
	 * 查询角色列表信息
	 * @param queryMap
	 * @return
	 */
	public List<Role> queryForList(Map<String, Object> queryMap);
	
	/**
	 * 根据角色Code查询角色信息
	 * @param roleCode
	 * @return
	 */
	public Role findRoleByRoleId(Integer id);
	
	/**
	 * 更新角色信息
	 * @param role
	 * @param roleCode
	 * @return
	 */
	public boolean updateRoleByRoleCodeRnTx(Role role, Integer id);
}


package com.shecc.eoms.web.service;

import java.util.List;

import com.shecc.eoms.core.model.Menu;
import com.shecc.eoms.core.model.Role;
import com.shecc.eoms.core.model.RoleMenu;
import com.shecc.eoms.core.model.UserRole;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-13 下午10:07:02
 * INFO com.shecc.eoms.web.service AuthService.java
 * REMARK 
 *
 */
public interface AuthService {
	
	
	/**
	 * 查询角色可配置的菜单
	 * @return
	 */
	public List<Menu> queryMenu();
	
	/**
	 * 根据角色ID查询角色所有菜单
	 * @param roleId
	 * @return
	 */
	public List<RoleMenu> queryRoleMenuByRoleId(String roleId);
	
	/**
	 * 批量创建角色菜单
	 * @param list
	 */
	public void batchCreateRnTx(List<RoleMenu>list);
	
	/**
	 * 批量删除角色菜单
	 * @param list
	 */
	public void batchDelRnTx(List<RoleMenu>list);
	
	
	public void createUserRoleRnTx(UserRole userRole);
	
	
	public List<UserRole> queryUserRole(Integer tUserId);
	
	public boolean bachDelByRoleCodeRnTx(Integer roleId);
	
	public boolean addRoleMenuRnTx(String[] menuIds, Integer roleId);
	
	public List<Role> queryAuthRole(Integer id);
	
	public List<Role> queryNonAuthRole(Integer id);
	
	public boolean bachDelRoleByLoginIdRnTx(Integer tUserId);
	
	public boolean addUserRoleRnTx(String[] roleIds, Integer tUserId);
	
	public List<Menu> queryMenuByParentId(Integer parent);
}


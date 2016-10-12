package com.shecc.eoms.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shecc.eoms.core.dao.MenuDAOImpl;
import com.shecc.eoms.core.dao.RoleDAOImpl;
import com.shecc.eoms.core.dao.RoleMenuDAOImpl;
import com.shecc.eoms.core.dao.UserRoleDAOImpl;
import com.shecc.eoms.core.model.Menu;
import com.shecc.eoms.core.model.Role;
import com.shecc.eoms.core.model.RoleMenu;
import com.shecc.eoms.core.model.UserRole;
import com.shecc.eoms.web.service.AuthService;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-13 下午10:08:15
 * INFO com.shecc.eoms.web.service.impl AuthServiceImpl.java
 * REMARK 
 *
 */
public class AuthServiceImpl implements AuthService {
	
	private MenuDAOImpl menuDao;
	private RoleMenuDAOImpl roleMenuDao;
	private UserRoleDAOImpl userRoleDao;
	private RoleDAOImpl roleDao;
	
	public void setUserRoleDao(UserRoleDAOImpl userRoleDao) {
		this.userRoleDao = userRoleDao;
	}


	public void setRoleMenuDao(RoleMenuDAOImpl roleMenuDao) {
		this.roleMenuDao = roleMenuDao;
	}


	public void setMenuDao(MenuDAOImpl menuDao) {
		this.menuDao = menuDao;
	}


	public void setRoleDao(RoleDAOImpl roleDao) {
		this.roleDao = roleDao;
	}
	
	@Override
	public List<Menu> queryMenu() {
		// 查询根菜单
		List<Menu> menuList = menuDao.queryMenu();
		// 查询子菜单
		setSubMenu(menuList);
		return menuList;
	}
	
	private void setSubMenu(List<Menu> menuList){
		for(Menu menu : menuList){
			// 查询子菜单
			List<Menu> subMenuList = this.queryMenuByParentId(menu.getId());
			if(subMenuList != null 
					&& subMenuList.size() > 0){
				menu.setSubMenuList(subMenuList);
				menu.setIsParent("1");
				//递归设置子菜单
				setSubMenu(subMenuList);
			}
		}
	}
	
	@Override
	public List<Menu> queryMenuByParentId(Integer parent) {
		return menuDao.queryMenuByParentId(parent);
	}


	@Override
	public List<RoleMenu> queryRoleMenuByRoleId(String roleId) {
		return roleMenuDao.queryRoleMenuByRoleId(roleId);
	}


	@Override
	public void batchCreateRnTx(List<RoleMenu> list) {
		roleMenuDao.batchCreate(list);
	}


	@Override
	public void batchDelRnTx(List<RoleMenu>list) {
		roleMenuDao.batchDel(list);
	}


	@Override
	public void createUserRoleRnTx(UserRole userRole) {
		userRoleDao.create(userRole);
		
	}
	
	@Override
	public List<UserRole> queryUserRole(Integer tUserId){
		return userRoleDao.queryUserRole(tUserId);
	}
	
	@Override
	public boolean bachDelByRoleCodeRnTx(Integer roleId) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("roleId", roleId);
		roleMenuDao.update(queryMap, "deleteByRoleCode");
		return true;
	}
	
	@Override
	public boolean addRoleMenuRnTx(String[] menuIds, Integer roleId) {
		// 删除系统菜单
		this.bachDelByRoleCodeRnTx(roleId);
		// 添加角色菜单
		if(menuIds != null
				&& menuIds.length != 0){
			RoleMenu roleMenu;
			for(String menuId : menuIds){
				roleMenu = new RoleMenu();
				roleMenu.settMenuId(new Integer(menuId));
				roleMenu.settRoleId(roleId);
				roleMenuDao.create(roleMenu);
			}
		}
		return true;
	}


	@Override
	public List<Role> queryAuthRole(Integer tUserId) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("tUserId", tUserId);
		queryMap.put("auth", "auth");
		return this.roleDao.findByCriteriaAndSqlId(queryMap, "queryUserRoleByLoginId");
	}


	@Override
	public List<Role> queryNonAuthRole(Integer tUserId) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("tUserId", tUserId);
		queryMap.put("notAuth", "notAuth");
		return this.roleDao.findByCriteriaAndSqlId(queryMap, "queryUserRoleByLoginId");
	}

	@Override
	public boolean bachDelRoleByLoginIdRnTx(Integer tUserId){
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("tUserId", tUserId);
		userRoleDao.update(queryMap, "bachDelRoleByLoginId");
		return true;
	}

	@Override
	public boolean addUserRoleRnTx(String[] roleIds, Integer tUserId) {
		// 删除系统菜单
		this.bachDelRoleByLoginIdRnTx(tUserId);
		// 添加角色菜单
		if(roleIds != null
				&& roleIds.length != 0){
			UserRole userRole;
			for(String roleId : roleIds){
				userRole = new UserRole();
				userRole.settRoleId(new Integer(roleId));
				userRole.settUserId(tUserId);
				this.userRoleDao.create(userRole);
			}
		}
		return true;
	}
}


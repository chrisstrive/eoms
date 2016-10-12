package com.shecc.eoms.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.shecc.eoms.web.service.MenuService;
import com.shecc.eoms.core.dao.MenuDAOImpl;
import com.shecc.eoms.core.model.Menu;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-10 下午09:21:15
 * INFO com.shecc.eoms.web.service.impl MenuServiceImpl.java
 * REMARK 
 *
 */
public class MenuServiceImpl implements MenuService {
	
	private static final String DEFAULT_INDEX = "/htm/index.html";
	
	private MenuDAOImpl menuDao;
	
	public void setMenuDao(MenuDAOImpl menuDao) {
		this.menuDao = menuDao;
	}
	
	/**
	 * 根据用户Id查找菜单权限
	 * @param userId
	 * @return
	 */
	@Override
	public List<Map<String, Object>> queryMenuByUser(Integer userId) {
		List<Map<String, Object>> menuList = new ArrayList<Map<String, Object>>();
		// 查询根菜单
		List<Menu> menuListTmp = menuDao.queryMenuByUserId(userId);
		Map<String, Object> menuMap = null;
		for(Menu menu : menuListTmp){
			menuMap = new HashMap<String, Object>();
			menuMap.put("id", menu.getId());
			menuMap.put("menuName", menu.getMenuName());
			menuMap.put("menuCode", menu.getMenuCode());
			menuMap.put("icon", "icon-nav");
			
			List<Map<String, Object>> subMenuList = getSubMenuList(menuMap, userId);
			if(subMenuList != null
					&& subMenuList.size() > 0){
				menuMap.put("subMenuList", subMenuList);
				menuMap.put("isParent",1);
			}else{
				menuMap.put("url", StringUtils.isNotBlank(menu.getUrl())?menu.getUrl():DEFAULT_INDEX);
				menuMap.put("isParent",0);
			}
			menuList.add(menuMap);
		}
		// 设置子菜单
		return menuList;
	}
	
	private List<Map<String, Object>> getSubMenuList(Map<String, Object> menuMap, Integer userId){
			List<Menu> menuListTmp = this.querySubMenuByParentIdAndUserId((Integer)menuMap.get("id"), userId);
			// 查询子菜单
			if(menuListTmp != null
					&& menuListTmp.size() > 0){
				List<Map<String, Object>> subMenuList = new ArrayList<Map<String, Object>>();
				Map<String, Object> menuMapTmp = null;
				for(Menu menu : menuListTmp){
					menuMapTmp = new HashMap<String, Object>();
					menuMapTmp.put("id", menu.getId());
					menuMapTmp.put("menuName", menu.getMenuName());
					menuMapTmp.put("menuCode", menu.getMenuCode());
					menuMapTmp.put("icon", "icon-nav");
					//menuMapTmp.put("isParent", menu.getIsParent()==null?1:0);
					List<Map<String, Object>> subMenuListTmp = getSubMenuList(menuMapTmp, userId);
					if(subMenuListTmp != null
							&& subMenuListTmp.size() > 0){
						menuMapTmp.put("subMenuList", subMenuListTmp);
						menuMapTmp.put("isParent",1);
					}else{
						menuMapTmp.put("url", StringUtils.isNotBlank(menu.getUrl())?menu.getUrl():DEFAULT_INDEX);
						menuMapTmp.put("isParent",0);
					}
					subMenuList.add(menuMapTmp);
				}
				return subMenuList;
			}else{
				return null;
			}
	}

	@Override
	public List<Menu> queryMenuByUserId(Integer userId) {
		// 查询根菜单
		List<Menu> menuList = menuDao.queryMenuByUserId(userId);
		// 查询子菜单
		setSubMenu(menuList);
		return menuList;
	}
	
	public Menu queryApproveMenuByUserId(Integer userId,String menuCode){
		 return menuDao.queryApproveMenuByUserId(userId, menuCode);
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
			}else{
				menu.setIsParent("0");
			}
		}
	}
	
	@Override
	public List<Menu> queryRoleMenulist(Integer roleId){
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("roleId", roleId);
		return menuDao.findByCriteriaAndSqlId(queryMap, "queryRoleMenu");
	}

	@Override
	public List<Menu> queryMenuByParentId(Integer parent) {
		return menuDao.queryMenuByParentId(parent);
	}

	@Override
	public List<Menu> querySubMenuByParentIdAndUserId(Integer parent,
			Integer userId) {
		return menuDao.querySubMenuByParentId(parent, userId);
	}
}


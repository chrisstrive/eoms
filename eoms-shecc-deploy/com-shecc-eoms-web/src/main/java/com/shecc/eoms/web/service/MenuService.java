package com.shecc.eoms.web.service;

import java.util.List;
import java.util.Map;

import com.shecc.eoms.core.model.Menu;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-10 下午09:20:18
 * INFO com.shecc.eoms.web.service.impl MenuService.java
 * REMARK 
 *
 */
public interface MenuService {
	
	/**
	 * 根据用户Id查找菜单权限
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> queryMenuByUser(Integer userId);

	public List<Menu> queryMenuByUserId(Integer userId);
	
	public List<Menu> queryRoleMenulist(Integer id);
	
	public List<Menu> queryMenuByParentId(Integer parent);
	
	public List<Menu> querySubMenuByParentIdAndUserId(Integer parent, Integer userId);
	
	public Menu queryApproveMenuByUserId(Integer userId,String menuCode);
}


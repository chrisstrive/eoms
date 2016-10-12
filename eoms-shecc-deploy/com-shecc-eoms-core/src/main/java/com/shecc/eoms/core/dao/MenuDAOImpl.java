package com.shecc.eoms.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shecc.eoms.core.common.ibaits.impl.DefaultBaseDAOImpl;
import com.shecc.eoms.core.model.Menu;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-10 下午09:13:02
 * INFO com.scorpio.dao.impl MenuDAOImpl.java
 * REMARK 
 *
 */
public class MenuDAOImpl  extends DefaultBaseDAOImpl<Menu>{

	/**
	 * 根据 用户ID查找菜单
	 * @param loginId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Menu> queryMenuByUserId(Integer userId){

		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("userId", userId);
	
	    return (List<Menu>)this.getSqlMapClientTemplate().queryForList(this.namespace.concat("queryMenuByUserId"),map);
	    
	}
	
	@SuppressWarnings("unchecked")
	public Menu queryApproveMenuByUserId(Integer userId,String menuCode){
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("userId", userId);
	    map.put("menucode", menuCode);
	
	    return (Menu)this.getSqlMapClientTemplate().queryForObject(this.namespace.concat("queryApproveMenuByUserId"),map);	    
	}
	
	/**
	 * 根据父菜单拉取子菜单
	 * @param parent
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Menu> queryMenuByParentId(Integer parent){
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("parent", parent);
	    return (List<Menu>)this.getSqlMapClientTemplate().queryForList(this.namespace.concat("queryMenuByParentId"),map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Menu> querySubMenuByParentId(Integer parent, Integer userId){
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("parent", parent);
	    map.put("userId", userId);
	    return (List<Menu>)this.getSqlMapClientTemplate().queryForList(this.namespace.concat("querySubMenuByUserId"),map);
	}
	
	public List<Menu> queryMenu(){
	    return (List<Menu>)this.getSqlMapClientTemplate().queryForList(this.namespace.concat("queryMenu"));
	    
	}
}


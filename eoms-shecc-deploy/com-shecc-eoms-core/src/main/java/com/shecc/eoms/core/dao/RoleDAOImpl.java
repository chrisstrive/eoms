package com.shecc.eoms.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shecc.eoms.core.common.ibaits.impl.DefaultBaseDAOImpl;
import com.shecc.eoms.core.model.Role;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-10 下午09:36:03
 * INFO com.scorpio.dao.impl RoleDAOImpl.java
 * REMARK 
 *
 */
public class RoleDAOImpl extends DefaultBaseDAOImpl<Role>{
	
	
	
	/**
	 * 根据角色名检查角色
	 * @param roleName
	 * @return
	 */
	public Role checkRoleByRoleName(String roleName) {
		
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("roleName", roleName);
		
		return (Role)this.getSqlMapClientTemplate().queryForObject(this.namespace.concat("checkRoleByRoleName"),map);
	}
	
	
	/**
	 * 查询角色,用于选择禁用
	 * @return
	 */
	public List<Role> queryRole(){
		
		
		return (List<Role>)this.getSqlMapClientTemplate().queryForList(this.namespace.concat("queryRole"));
	}
	
	/**
	 * 禁用角色
	 * @param roleId
	 */
	public void forbiddenRoleById(Integer id) {

		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("id", id);
		this.getSqlMapClientTemplate().update(this.namespace.concat("forbiddenRoleById"),map);
	}
	
	/**
	 * 禁用角色
	 * @param roleId
	 */
	public void reUseRoleByRoleId(Integer id) {

		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("id", id);
		this.getSqlMapClientTemplate().update(this.namespace.concat("reUseRoleByRoleId"),map);
	}
	
	
	public Role findRoleByRoleId(Integer id) {
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("id", id);
		return (Role)this.getSqlMapClientTemplate().queryForObject(this.namespace.concat("findRoleByRoleId"), map);
	}

}


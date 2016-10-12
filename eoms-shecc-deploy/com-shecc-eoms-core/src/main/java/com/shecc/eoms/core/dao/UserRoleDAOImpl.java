package com.shecc.eoms.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shecc.eoms.core.common.ibaits.impl.DefaultBaseDAOImpl;
import com.shecc.eoms.core.model.UserRole;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-10 下午09:37:44
 * INFO com.scorpio.dao.impl UserRoleDAOImpl.java
 * REMARK 
 *
 */
public class UserRoleDAOImpl extends DefaultBaseDAOImpl<UserRole>{
	
	public List<UserRole> queryUserRole(Integer tUserId){
		
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("tUserId", tUserId);
		return (List<UserRole>)this.getSqlMapClientTemplate().queryForList(this.namespace.concat("queryUserRole"),map);
	}
}


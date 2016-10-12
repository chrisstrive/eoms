package com.shecc.eoms.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shecc.eoms.core.common.ibaits.impl.DefaultBaseDAOImpl;
import com.shecc.eoms.core.model.User;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-10 下午09:37:22
 * INFO com.scorpio.dao.impl UserDAOImpl.java
 * REMARK 
 *
 */
public class UserDAOImpl extends DefaultBaseDAOImpl<User>{

	
	/**
	 * 根据 用户名 以及 密码 查找用户
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	public User queryUserByNameAndPwd(String userName,String userPwd){
		
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("userName", userName);
	    map.put("userPwd", userPwd);
	
	    return (User)this.getSqlMapClientTemplate().queryForObject(this.namespace.concat("queryUserByNameAndPwd"),map);
	}
	
	/**
	 * 根据用户名检查用户
	 * @param username
	 * @return
	 */
	public User checkUserByUserName(String username) {
		
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("userName", username);
	    
		
		return (User)this.getSqlMapClientTemplate().queryForObject(this.namespace.concat("checkUserByUserName"),map);
	}
	
	
	/**
	 * 查询用户,用于选择禁用
	 * @return
	 */
	public List<User> queryUser(){
		
		
		return (List<User>)this.getSqlMapClientTemplate().queryForList(this.namespace.concat("queryUser"));
	}
	
	/**
	 * 根据USERID禁用用户
	 * @param userId
	 */
	public void forbiddenUserById(Integer id) {
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("id", id);
		this.getSqlMapClientTemplate().update(this.namespace.concat("forbiddenUserById"),map);
	}
	
	/**
	 * 根据USERID禁用用户
	 * @param userId
	 */
	public void reOpenUser(Integer id) {
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("id", id);
		this.getSqlMapClientTemplate().update(this.namespace.concat("reOpenUser"),map);
	}
	
	public void updateUser(Integer id,String userPwd ){
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("id", id);
	    map.put("userPwd", userPwd);
	    this.getSqlMapClientTemplate().update(this.namespace.concat("updateUser"),map);
	    
	}
	
	public User findById(Integer id) {
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("id", id);
		return (User)this.getSqlMapClientTemplate().queryForObject(this.namespace.concat("findById"), map);
	}

	
}


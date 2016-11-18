package com.shecc.eoms.web.service;

import java.util.List;
import java.util.Map;

import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.model.User;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-11 下午02:42:41
 * INFO com.shecc.eoms.web.service UserService.java
 * REMARK 
 *
 */
public interface UserService {
	
	/**
	 * 根据 用户名 以及 密码 查找用户
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	public User queryUserByNameAndPwd(String userName,String userPwd);
	
	/**
	 * 创建用户
	 * @param user
	 */
	public void createUserRnTx(User user);
	
	/**
	 * 根据用户名检查用户
	 * @param username
	 * @return
	 */
	public boolean checkUserByUserName(String username, Integer userId);
	
	/**
	 * 查询用户
	 * @return
	 */
	public List<User> queryUser();
	
	
	/**
	 * 根据用户ID禁用用户
	 * @param userId
	 */
	public void forbiddenUserByIdRnTx(Integer id);
	
	/**
	 * 启用用户
	 * @param loginId
	 */
	public void reOpenUserRnTx(Integer id);
	
	
	public void updateUserRnTx(Integer id,String userPwd);
	
	public boolean updateUserRnTx(User user);
	
	public String queryForPage(Map<String, Object> queryMap, Page page);
	
	public User findById(Integer id);
	
	public User findApproveUser(String approveType);
	
	/**
	 * 
	 * findAll:根据条件查找用户. <br/>
	 * 注意此处SQLMAP只提供了status和identity两个条件，如果要用到其它条件，请自行添加
	 *
	 * @author chris
	 * @param queryMap
	 * @return
	 * @since JDK 1.6
	 */
	public List<User> findAll(User user);
	
}


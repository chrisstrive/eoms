package com.shecc.eoms.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.dao.UserDAOImpl;
import com.shecc.eoms.core.model.Menu;
import com.shecc.eoms.core.model.User;
import com.shecc.eoms.web.common.utils.JSONUtil;
import com.shecc.eoms.web.service.MenuService;
import com.shecc.eoms.web.service.UserService;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-11 下午02:43:00
 * INFO com.shecc.eoms.web.service.impl UserServiceImpl.java
 * REMARK 
 *
 */
public class UserServiceImpl implements UserService{
	
	
	private UserDAOImpl userDao;
	
	private MenuService menuService;
	
	public void setUserDao(UserDAOImpl userDao) {
		this.userDao = userDao;
	}
	
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	@Override
	public User queryUserByNameAndPwd(String userName, String userPwd) {
		
		return userDao.queryUserByNameAndPwd(userName, userPwd);
	}

	@Override
	public void createUserRnTx(User user) {
		userDao.create(user);
	}

	@Override
	public boolean checkUserByUserName(String username, Integer userId) {
		
		boolean retVal = false;
		User user = null;
		
		user = userDao.checkUserByUserName(username);
		
		if(user == null){//无此用户即可创建
			retVal = true;
		}else{
			if(userId != null 
					&& user.getId().compareTo(userId) == 0){
				retVal = true;
			}else{
				retVal = false;
			}
		}
		return retVal;
	}

	@Override
	public List<User> queryUser() {
		return userDao.queryUser();
	}

	@Override
	public void forbiddenUserByIdRnTx(Integer id) {
		userDao.forbiddenUserById(id);
	}
	
	@Override
	public void reOpenUserRnTx(Integer id) {
		userDao.reOpenUser(id);
	}
	
	@Override
	public void updateUserRnTx(Integer id, String userPwd){
		userDao.updateUser(id,userPwd);
	}
	
	public boolean updateUserRnTx(User user){
		return userDao.update(user);
	}

	@Override
	public String queryForPage(Map<String, Object> queryMap, Page page) {
		List<User> dataList = this.userDao.findByCriteriaMapReturnObj(queryMap, page, "queryUserForPage");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("pageData", dataList);
		dataMap.put("pageCount", page.getTotalRecord());
		String result = JSONUtil.toJSonString(dataMap);
		return result;
	}

	@Override
	public User findById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public User findApproveUser(String approveType) {
//		// mock
//		User user = new User();
//		user.setId(1);
//		user.setUserName("ADMIN");
//		user.setRealName("系统管理员");
//		return user;
		if(approveType == null){
			return null;
		}
		List<User> users = this.queryUser();
		
		if(users != null && users.size() >0){
			for(User user : users){
				if(approveType.equals("1")){
					Menu menu = menuService.queryApproveMenuByUserId(user.getId(),"HYSPGL");
					if(menu != null){
						return user;
					}
				}else if(approveType.equals("2")){
					Menu menu = menuService.queryApproveMenuByUserId(user.getId(),"HYXXSPGL");
					if(menu != null){
						return user;
					}
				}
				
		}
		
    	}
		return null;
	}

	@Override
	public List<User> findAll(User user) {
		return userDao.findByCriteria(user);
	}

}


package com.shecc.eoms.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.common.utils.JSONUtil;
import com.shecc.eoms.core.model.User;
import com.shecc.eoms.web.common.ValTemplate;
import com.shecc.eoms.web.common.md5.MD5;
import com.shecc.eoms.web.dto.UserDTO;
import com.shecc.eoms.web.service.UserService;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-12 下午12:45:30
 * INFO com.shecc.eoms.web.controller UserConntroller.java
 * REMARK 
 *
 */
public class UserConntroller extends MultiActionController {

	
	private static final Log log = LogFactory.getLog(UserConntroller.class);
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private String userDefaultPage;

	public void setUserDefaultPage(String userDefaultPage) {
		this.userDefaultPage = userDefaultPage;
	}
	
	private String addPage;
	private String updatePage;
	private String reSetPage;
	private String changePage;
	private String userSelectPage;
	private String showPage;
	
	public void setShowPage(String showPage) {
		this.showPage = showPage;
	}

	public void setAddPage(String addPage) {
		this.addPage = addPage;
	}

	public void setUpdatePage(String updatePage) {
		this.updatePage = updatePage;
	}

	public void setReSetPage(String reSetPage) {
		this.reSetPage = reSetPage;
	}

	public void setChangePage(String changePage) {
		this.changePage = changePage;
	}
	
	public void setUserSelectPage(String userSelectPage) {
		this.userSelectPage = userSelectPage;
	}

	/**
	 * 用户管理
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView userDefault(HttpServletRequest request,HttpServletResponse response) {
		
		//定义响应model
		ModelAndView mv = new ModelAndView(userDefaultPage);
		return mv;
	}
	
	/**
	 * 分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView queryForPage(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		String userName = request.getParameter("userName");
		if(StringUtils.isNotBlank(userName)){
			queryMap.put("userName", userName);
		}
		String realName = request.getParameter("realName");
		if(StringUtils.isNotBlank(realName)){
			queryMap.put("realName", realName);
		}
		String status = request.getParameter("status");
		if(StringUtils.isNotBlank(status)){
			queryMap.put("status", status);
		}
		Page page = new Page();
		String targetPage = request.getParameter("targetPage");
		page.setTargetPage(new Integer(targetPage));
		String pageSize = request.getParameter("pageSize");
		page.setPageSize(new Integer(pageSize));
		String result = this.userService.queryForPage(queryMap, page);

		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
		} catch (IOException e) {
			logger.error("分页查询失败!",e);	
		}
		return null;
	}
	
	/**
	 * 新增跳转
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView addDispth(HttpServletRequest request,HttpServletResponse response) {
		//定义响应model
		ModelAndView mv = new ModelAndView(addPage);
		
		Map<String, Object> modelMap = new HashMap<String, Object>();

		mv.addObject("modelMap", modelMap);
		
		return mv;
	}
	
	/**
	 * 创建用户
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView createUser(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try{
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			
			String userName = request.getParameter("userName");
			String realName = request.getParameter("realName");
			String passWd = request.getParameter("passWd");
			String mobileNo = request.getParameter("mobileNo");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");

			//设置
			User user = new User();
			user.setUserName(userName);
			user.setRealName(realName);
			user.setPassWd(MD5.getMD5Str(passWd));
			user.setStatus("1");
			user.setMobileNo(mobileNo);
			user.setPhone(phone);
			user.setEmail(email);
			
			log.info("[box系统]-[创建用户]-[创建用户参数完整]");
			String result = "";
			if(userService.checkUserByUserName(user.getUserName(), null)){
				userService.createUserRnTx(user);
				returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0000);
				returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0000);
				result = JSONUtil.toJSonString(returnMap);
			}else{
				log.info("[box系统]-[创建用户]-[创建失败，当前用户已存在。]");
				returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0002);
				returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0002);
				result = JSONUtil.toJSonString(returnMap);
			}
			pw.write(result);
			pw.flush();
		}catch(Exception ex){
			logger.error("创建用户失败!!!r",ex);	
		}
		return null;
	}
	
	/**
	 * 用户信息跳转
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showDispth(HttpServletRequest request,HttpServletResponse response) {
		//定义响应model
		ModelAndView mv = new ModelAndView(showPage);
		String id = request.getParameter("id");
		User user = this.userService.findById(new Integer(id));
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		//定义响应model

		mv.addObject("modelMap", modelMap);
		mv.addObject("user", user);
		
		return mv;
	}
	
	/**
	 * 更新跳转
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView updateDispth(HttpServletRequest request,HttpServletResponse response) {
		//定义响应model
		ModelAndView mv = new ModelAndView(updatePage);
		String id = request.getParameter("id");
		User user = this.userService.findById(new Integer(id));
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		//定义响应model

		mv.addObject("modelMap", modelMap);
		mv.addObject("user", user);
		
		return mv;
	}
	
	/**
	 * 更新角色
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView updateUser(HttpServletRequest request,HttpServletResponse response) {
		try{
			Map<String, Object> returnMap = new HashMap<String, Object>();
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			String result = "";
			
			String id = request.getParameter("id");
			String userName = request.getParameter("userName");
			String realName = request.getParameter("realName");
			String mobileNo = request.getParameter("mobileNo");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");

			//设置
			User user = new User();
			user.setId(new Integer(id));
			user.setUserName(userName);
			user.setRealName(realName);
			user.setMobileNo(mobileNo);
			user.setPhone(phone);
			user.setEmail(email);

			
			if(userService.checkUserByUserName(user.getUserName(), user.getId())){
				userService.updateUserRnTx(user);
				returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0000);
				returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0000);
				result = JSONUtil.toJSonString(returnMap);
			}else{
				log.info("[box系统]-[更新用户]-[更新失败，当前用户已存在。]");
				returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0003);
				returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0003);
				result = JSONUtil.toJSonString(returnMap);
			}
			
			pw.write(result);
			pw.flush();
		}catch(Exception ex){
			logger.error("更新用户失败!!!r",ex);	
		}
		return null;
	}
	
	/**
	 * 禁用用户
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView forbiddenUser(HttpServletRequest request,HttpServletResponse response){
		
		try{
			Map<String, Object> returnMap = new HashMap<String, Object>();
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			String result = "";
			
			String id = request.getParameter("id");
			userService.forbiddenUserByIdRnTx(new Integer(id));
			returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0000);
			returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0000);
			result = JSONUtil.toJSonString(returnMap);
			
			pw.write(result);
			pw.flush();
		}catch(Exception ex){
			logger.error("禁用角色失败!!!",ex);	
		}
		
		return null;
	}
	
	/**
	 * 启用用户
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView reOpenUser(HttpServletRequest request,HttpServletResponse response){
		try{
			Map<String, Object> returnMap = new HashMap<String, Object>();
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			String result = "";
			
			String id = request.getParameter("id");
			userService.reOpenUserRnTx(new Integer(id));
			returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0000);
			returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0000);
			result = JSONUtil.toJSonString(returnMap);
			
			pw.write(result);
			pw.flush();
		}catch(Exception ex){
			logger.error("禁用角色失败!!!",ex);	
		}
		
		return null;
	}
	
	/**
	 * 更新跳转
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView reSetDispth(HttpServletRequest request,HttpServletResponse response) {
		//定义响应model
		ModelAndView mv = new ModelAndView(this.reSetPage);
		String id = request.getParameter("id");
		User user = this.userService.findById(new Integer(id));
		return mv.addObject("user", user);
	}
	
	/**
	 * 重置密码
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView reSetPwd(HttpServletRequest request,HttpServletResponse response){
		try{
			Map<String, Object> returnMap = new HashMap<String, Object>();
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			String result = "";
			
			String id = request.getParameter("id");
			String passWd = request.getParameter("passWd");
			
			userService.updateUserRnTx(new Integer(id), MD5.getMD5Str(passWd.trim()));
			returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0000);
			returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0000);
			result = JSONUtil.toJSonString(returnMap);
			
			pw.write(result);
			pw.flush();
		}catch(Exception ex){
			logger.error("重置密码失败!!!r",ex);	
		}
		
		return null;
	}
	
	/**
	 * 更新跳转
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView changePwdDispth(HttpServletRequest request,HttpServletResponse response) {
		//定义响应model
		ModelAndView mv = new ModelAndView(this.changePage);
		UserDTO ud = (UserDTO) request.getSession().getAttribute("user");
		User user = this.userService.findById(ud.getId());
		return mv.addObject("user", user);
	}
	
	/**
	 * 更改密码
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView changePwd(HttpServletRequest request,HttpServletResponse response){
		try{
			Map<String, Object> returnMap = new HashMap<String, Object>();
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			String result = "";
			
			String id = request.getParameter("id");
			String oldPwd = request.getParameter("oldPwd");
			String passWd = request.getParameter("passWd");
			
			// 根据loginId 查找用户信息
			User user = this.userService.findById(new Integer(id));
			if(user != null){
				// 校验系统原始密码输入是否一致
				if(MD5.getMD5Str(oldPwd).equals(user.getPassWd())){
					userService.updateUserRnTx(new Integer(id), MD5.getMD5Str(passWd.trim()));
					returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0000);
					returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0000);
				}else{
					returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0011);
					returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0011);
				}
			}else{
				returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0010);
				returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0010);
			}
			
			
			result = JSONUtil.toJSonString(returnMap);
			pw.write(result);
			pw.flush();
		}catch(Exception ex){
			logger.error("更改密码失败!!!r",ex);	
		}
		return null;
	}
	/**
	 * 产品录入用用户选择页面
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView userSelect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView(userSelectPage);
		return mv;
	}
	
	
}


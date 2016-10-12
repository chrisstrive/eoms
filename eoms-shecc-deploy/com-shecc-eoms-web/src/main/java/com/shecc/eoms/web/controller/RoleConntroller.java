package com.shecc.eoms.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.shecc.eoms.web.common.ValTemplate;
import com.shecc.eoms.web.service.RoleService;
import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.common.utils.JSONUtil;
import com.shecc.eoms.core.model.Role;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-13 下午04:53:05
 * INFO com.shecc.eoms.web.controller RoleConntroller.java
 * REMARK 
 *
 */
public class RoleConntroller extends MultiActionController {
	
private static final Log log = LogFactory.getLog(RoleConntroller.class);
	private RoleService roleService;
	
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	private String roleDefaultPage;
	private String addPage;
	private String updatePage;

	public void setRoleDefaultPage(String roleDefaultPage) {
		this.roleDefaultPage = roleDefaultPage;
	}

	public void setAddPage(String addPage) {
		this.addPage = addPage;
	}

	public void setUpdatePage(String updatePage) {
		this.updatePage = updatePage;
	}

	/**
	 * 角色管理
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView roleDefault(HttpServletRequest request,HttpServletResponse response) {
		//定义响应model
		ModelAndView mv = null;
		
		mv = new ModelAndView(roleDefaultPage);
		
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
		// 角色ID
		String roleCode = request.getParameter("roleCode");
		if(StringUtils.isNotBlank(roleCode)){
			queryMap.put("roleCode", roleCode);
		}
		// 角色名
		String roleName = request.getParameter("roleName");
		if(StringUtils.isNotBlank(roleName)){
			queryMap.put("roleName", roleName);
		}
		// 是否有效
		String status = request.getParameter("status");
		if(StringUtils.isNotBlank(status)){
			queryMap.put("status", status);
		}
		Page page = new Page();
		String targetPage = request.getParameter("targetPage");
		page.setTargetPage(new Integer(targetPage));
		String pageSize = request.getParameter("pageSize");
		page.setPageSize(new Integer(pageSize));
		String result = this.roleService.queryForPage(queryMap, page);

		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
		} catch (IOException e) {
			logger.error("PpActConntroller.queryForPage throws error",e);	
		}
		return null;
	}
	
	/**
	 * 查询
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView queryForList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		// 角色ID
		String roleCode = request.getParameter("roleCode");
		if(StringUtils.isNotBlank(roleCode)){
			queryMap.put("roleCode", roleCode);
		}
		// 角色名
		String roleName = request.getParameter("roleName");
		if(StringUtils.isNotBlank(roleName)){
			queryMap.put("roleName", roleName);
		}
		// 是否有效
		String status = request.getParameter("status");
		if(StringUtils.isNotBlank(status)){
			queryMap.put("status", status);
		}
		try {
			List<Role> roleList = this.roleService.queryForList(queryMap);
			String result = JSONUtil.toJSonString(roleList);
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
		} catch (IOException e) {
			logger.error("查询角色列表失败!",e);	
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
		return mv;
	}
	
	/**
	 * 创建角色
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView createRole(HttpServletRequest request,HttpServletResponse response) {
		String s1 = request.getParameter("rolename");//*
		String s2 = request.getParameter("rolest");//*
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			
			//设置
			Role role = new Role();
			role.setRoleName(s1);
			role.setStatus(s2);
			role.setRemark("");
			log.info("[运营支撑系统]-[创建角色]-[创建角色参数完整]");
			String result = "";
			if(roleService.checkRoleByRoleName(role.getRoleName(), null)){
				roleService.createRoleRnTx(role);
				returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0000);
				returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0000);
				result = JSONUtil.toJSonString(returnMap);
			}else{
				log.info("[财富CRM系统]-[创建角色]-[创建失败，当前角色已存在。]");
				returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0003);
				returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0003);
				result = JSONUtil.toJSonString(returnMap);
			}
			pw.write(result);
			pw.flush();
		} catch (IOException e) {
			logger.error("创建角色失败!!!r",e);	
		}
		return null;
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
		Role role = this.roleService.findRoleByRoleId(new Integer(id));
		return mv.addObject("role", role);
	}
	
	/**
	 * 更新角色
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView updateRole(HttpServletRequest request,HttpServletResponse response) {
		try{
			Map<String, Object> returnMap = new HashMap<String, Object>();
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			String result = "";
			
			Role role = new Role();
			Integer id = new Integer(request.getParameter("id"));
			role.setId(id);
			String roleCode = request.getParameter("roleCode");
			role.setRoleCode(roleCode);
			String roleName = request.getParameter("roleName");
			role.setRoleName(roleName);
			String status = request.getParameter("status");
			role.setStatus(status);
			if(roleService.checkRoleByRoleName(role.getRoleName(), id)){
				roleService.updateRoleByRoleCodeRnTx(role, id);
				returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0000);
				returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0000);
				result = JSONUtil.toJSonString(returnMap);
			}else{
				log.info("[财富CRM系统]-[更新角色]-[更新失败，当前角色已存在。]");
				returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0003);
				returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0003);
				result = JSONUtil.toJSonString(returnMap);
			}
			
			pw.write(result);
			pw.flush();
		}catch(Exception ex){
			logger.error("更新角色失败!!!r",ex);	
		}
		return null;
	}
	
	/**
	 * 禁用角色
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView forbiddenRole(HttpServletRequest request,HttpServletResponse response) {
		try{
			Map<String, Object> returnMap = new HashMap<String, Object>();
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			String result = "";
			
			String id = request.getParameter("id");
			roleService.forbiddenRoleByIdRnTx(new Integer(id));
			returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0000);
			returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0000);
			result = JSONUtil.toJSonString(returnMap);
			
			pw.write(result);
			pw.flush();
		}catch(Exception ex){
			logger.error("禁用角色失败!!!r",ex);	
		}
		
		return null;
	}

	/**
	 * 禁用角色
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView reUseRole(HttpServletRequest request,HttpServletResponse response) {
		try{
			Map<String, Object> returnMap = new HashMap<String, Object>();
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			String result = "";
			
			String id = request.getParameter("id");
			roleService.reUseRoleByRoleIdRnTx(new Integer(id));
			returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0000);
			returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0000);
			result = JSONUtil.toJSonString(returnMap);
			
			pw.write(result);
			pw.flush();
		}catch(Exception ex){
			logger.error("禁用角色失败!!!r",ex);	
		}
		
		return null;
	}
	
}

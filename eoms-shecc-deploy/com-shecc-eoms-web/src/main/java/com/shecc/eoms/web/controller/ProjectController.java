package com.shecc.eoms.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.enums.ArchiveFlagEnum;
import com.shecc.eoms.core.model.Project;
import com.shecc.eoms.core.model.ProjectCriteria;
import com.shecc.eoms.web.common.utils.JSONUtil;
import com.shecc.eoms.web.dto.UserDTO;
import com.shecc.eoms.web.exception.AppException;
import com.shecc.eoms.web.service.ProjectService;

/**
 * 
 * ClassName: ProjectController <br/>
 * Function: 项目管理控制器. <br/>
 * date: 2016年10月20日 下午3:31:56 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public class ProjectController extends BaseController {
	
	private static final Logger log = LoggerFactory.getLogger(ProjectController.class);
	
	private String listPage;
	private String addPage;
	private String updatePage;
	
	private ProjectService projectService;
		
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	/**
	 * 
	 * list:默认页面. <br/>
	 *
	 * @author chris
	 * @param request
	 * @param response
	 * @return
	 * @since JDK 1.6
	 */
	public ModelAndView queryView(HttpServletRequest request,
			HttpServletResponse response) {
		// 定义响应model
		ModelAndView mv = new ModelAndView(this.listPage);
		return mv;
	}
	
	/**
	 * 分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView queryForPage(HttpServletRequest request,HttpServletResponse response) {
		ProjectCriteria criteria = new ProjectCriteria();
		ProjectCriteria.Criteria cc = criteria.createCriteria();
		cc.andArchiveFlagEqualTo(ArchiveFlagEnum.NO_ARCHIVE.getCode());
		
		String name = request.getParameter("name");
		if (StringUtils.isNotBlank(name)) {
			cc.andNameLike(name);
		} 
		
		Page page = new Page();
		String targetPage = request.getParameter("targetPage");
		page.setTargetPage(new Integer(targetPage));
		String pageSize = request.getParameter("pageSize");
		page.setPageSize(new Integer(pageSize));
		
		String result = this.projectService.queryProjectForPage(criteria, page);

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
	public ModelAndView addView(HttpServletRequest request,HttpServletResponse response) {
		//定义响应model
		ModelAndView mv = new ModelAndView(addPage);		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		mv.addObject("modelMap", modelMap);		
		return mv;
	}
	
	/**
	 * 新增
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try{
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			
			String address = request.getParameter("address");
			String name = request.getParameter("name");
			String longitude = request.getParameter("longitude");
			String latitude = request.getParameter("latitude");
			String picture = request.getParameter("picture");
			
			//设置
			Project entity = new Project();
			entity.setName(name);
			entity.setAddress(address);
			if(!StringUtils.isEmpty(longitude)){
				entity.setLongitude(Integer.valueOf(longitude));
			}	
			if(!StringUtils.isEmpty(latitude)){
				entity.setLatitude(Integer.valueOf(latitude));
			}
			if(!StringUtils.isEmpty(picture)){
				entity.setPicture(picture);
			}
            
			// 设置操作信息
			HttpSession session = request.getSession();
			UserDTO user = (UserDTO)session.getAttribute("user");
            entity.setInputUid(user.getId());
            entity.setInputUname(user.getRealName());
            entity.setInputTime(new Date());
            entity.setCheckUid(user.getId());
            entity.setCheckUname(user.getRealName());
            entity.setCheckTime(new Date());
            entity.setLastModifyUid(user.getId());
            entity.setLastModifyUname(user.getRealName());
            entity.setLastModifyTime(new Date());
            entity.setArchiveFlag(ArchiveFlagEnum.NO_ARCHIVE.getCode());
			
			log.info("[EOMS]-[新增项目]");

			Integer res = projectService.createProjectRnTx(entity);
			if (res<0) {
				throw new Exception("数据库插入失败");
			}
			
			returnMap.put("returnCode", "0000");
			returnMap.put("description", "新增成功");
			String result = JSONUtil.toJSonString(returnMap);
			pw.write(result);
			pw.flush();
		}catch(Exception ex){
			logger.error("创建项目失败!",ex);	
			super.out(response, "0099", "创建项目信息失败");
		}
		return null;
	}
	
	
	/**
	 * 更新跳转
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException 
	 */
	public ModelAndView updateView(HttpServletRequest request,HttpServletResponse response) throws AppException {
		//定义响应model
		ModelAndView mv = new ModelAndView(updatePage);
		String id = request.getParameter("id");
		if(StringUtils.isEmpty(id)){
			throw new AppException("要更新的数据Id为空");
		}
		Project entity = this.projectService.findById(new Integer(id));
		
		mv.addObject("entity", entity);
		
		return mv;
	}
	
	/**
	 * 更新
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response) {
		try{
			Map<String, Object> returnMap = new HashMap<String, Object>();
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			
			String id = request.getParameter("id");
			
			//设置
            if(StringUtils.isEmpty(id)){
            	returnMap.put("returnCode", "0001");
    			returnMap.put("description", "项目ID为空");
    			String result = JSONUtil.toJSonString(returnMap);
    			pw.write(result);
    			pw.flush();
    			return null;
            }
            
            String address = request.getParameter("address");
			String name = request.getParameter("name");
			String longitude = request.getParameter("longitude");
			String latitude = request.getParameter("latitude");
			String picture = request.getParameter("picture");
			
			//设置
			Project entity = new Project();
			entity.setId(Integer.valueOf(id));
			entity.setName(name);
			entity.setAddress(address);
			if(!StringUtils.isEmpty(longitude)){
				entity.setLongitude(Integer.valueOf(longitude));
			}	
			if(!StringUtils.isEmpty(latitude)){
				entity.setLatitude(Integer.valueOf(latitude));
			}
			if(!StringUtils.isEmpty(picture)){
				entity.setPicture(picture);
			}
            
			// 设置操作信息
			HttpSession session = request.getSession();
			UserDTO user = (UserDTO)session.getAttribute("user");
            entity.setLastModifyUid(user.getId());
            entity.setLastModifyUname(user.getRealName());
            entity.setLastModifyTime(new Date());
					
		
            if (!projectService.updateProjectRnTx(entity)) {
				throw new Exception("数据库更新失败");
			}
            
			returnMap.put("returnCode", "0000");
			returnMap.put("description", "更新项目成功");
			String result = JSONUtil.toJSonString(returnMap);
			
			pw.write(result);
			pw.flush();
		}catch(Exception ex){
			logger.error("修改项目信息失败!!!r",ex);	
			super.out(response, "0099", "修改项目信息失败");
		}
		return null;
	}
	
	public void setAddPage(String addPage) {
		this.addPage = addPage;
	}

	public void setUpdatePage(String updatePage) {
		this.updatePage = updatePage;
	}

	public void setListPage(String listPage) {
		this.listPage = listPage;
	}
	
}

/**
 * Project Name:com-shecc-eoms-web
 * File Name:ModelController.java
 * Package Name:com.shecc.eoms.web.controller
 * Date:2016年11月17日下午7:04:44
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.shecc.eoms.core.model.Brand;
import com.shecc.eoms.core.model.BrandCriteria;
import com.shecc.eoms.core.model.Model;
import com.shecc.eoms.core.model.ModelCriteria;
import com.shecc.eoms.web.common.utils.JSONUtil;
import com.shecc.eoms.web.dto.UserDTO;
import com.shecc.eoms.web.exception.AppException;
import com.shecc.eoms.web.service.BrandService;
import com.shecc.eoms.web.service.ModelService;

/**
 * ClassName: ModelController <br/>
 * Function: 型号信息控制器. <br/>
 * date: 2016年11月17日 下午7:04:44 <br/>
 *
 * @author chris
 * @version
 * @since JDK 1.6
 */
public class ModelController extends BaseController {
	private static final Logger log = LoggerFactory
			.getLogger(ModelController.class);

	private String listPage;
	private String addPage;
	private String updatePage;

	private ModelService entityService;
	private BrandService brandService;

	public void setEntityService(ModelService entityService) {
		this.entityService = entityService;
	}

	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
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
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView queryForPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelCriteria criteria = new ModelCriteria();
		ModelCriteria.Criteria cc = criteria.createCriteria();
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

		String result = this.entityService.queryAllForPage(criteria, page);

		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
		} catch (IOException e) {
			logger.error("分页查询失败!", e);
		}
		return null;
	}

	/**
	 * 新增跳转
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView addView(HttpServletRequest request,
			HttpServletResponse response) {
		// 定义响应model
		ModelAndView mv = new ModelAndView(addPage);

		// 查询所有品牌
		BrandCriteria brandCriteria = new BrandCriteria();
		brandCriteria.createCriteria().andArchiveFlagEqualTo(
				ArchiveFlagEnum.NO_ARCHIVE.getCode());
		List<Brand> brandtList = brandService.queryAll(brandCriteria);
		mv.addObject("brandtList", brandtList);

		return mv;
	}

	/**
	 * 新增
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();

			String name = request.getParameter("name");
			String refDocument = request.getParameter("refDocument");
			String brandInfo = request.getParameter("brandInfo");
			// 设置
			Model entity = new Model();
			entity.setName(name);
			if (!StringUtils.isEmpty(brandInfo)) {
				String[] brandInfoArr = StringUtils.split(brandInfo, "|");
				int brandId = Integer.valueOf(brandInfoArr[0]);
				String brandName = brandInfoArr[1];
				if (brandId != 0) {
					entity.setBrandId(brandId);
					entity.setBrandName(brandName);
				}
			}
			if (!StringUtils.isEmpty(refDocument)) {
				entity.setRefDocument(refDocument);
			}
			// 设置操作信息
			HttpSession session = request.getSession();
			UserDTO user = (UserDTO) session.getAttribute("user");
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

			log.info("[EOMS]-[新增信息]");

			Integer res = entityService.createRnTx(entity);
			if (res < 0) {
				throw new Exception("数据库插入失败");
			}

			returnMap.put("returnCode", "0000");
			returnMap.put("description", "新增成功");
			String result = JSONUtil.toJSonString(returnMap);
			pw.write(result);
			pw.flush();
		} catch (Exception ex) {
			logger.error("创建信息失败!", ex);
			super.out(response, "0099", "创建信息失败");
		}
		return null;
	}

	/**
	 * 更新跳转
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 */
	public ModelAndView updateView(HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		// 定义响应model
		ModelAndView mv = new ModelAndView(updatePage);

		String id = request.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			throw new AppException("要更新的数据Id为空");
		}
		Model entity = entityService.findById(new Integer(id));
		mv.addObject("entity", entity);

		// 查询所有品牌
		BrandCriteria brandCriteria = new BrandCriteria();
		brandCriteria.createCriteria().andArchiveFlagEqualTo(
				ArchiveFlagEnum.NO_ARCHIVE.getCode());
		List<Brand> brandtList = brandService.queryAll(brandCriteria);
		mv.addObject("brandtList", brandtList);

		return mv;
	}

	/**
	 * 更新
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView update(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();

			String id = request.getParameter("id");

			// 设置
			if (StringUtils.isEmpty(id)) {
				returnMap.put("returnCode", "0001");
				returnMap.put("description", "ID为空");
				String result = JSONUtil.toJSonString(returnMap);
				pw.write(result);
				pw.flush();
				return null;
			}

			Model entity = new Model();
			entity.setId(Integer.parseInt(id));
			
			String name = request.getParameter("name");
			String refDocument = request.getParameter("refDocument");
			String brandInfo = request.getParameter("brandInfo");
			// 设置
			entity.setName(name);
			if (!StringUtils.isEmpty(brandInfo)) {
				String[] brandInfoArr = StringUtils.split(brandInfo, "|");
				int brandId = Integer.valueOf(brandInfoArr[0]);
				String brandName = brandInfoArr[1];
				if (brandId != 0) {
					entity.setBrandId(brandId);
					entity.setBrandName(brandName);
				}
			}
			if (!StringUtils.isEmpty(refDocument)) {
				entity.setRefDocument(refDocument);
			}

			// 设置操作信息
			HttpSession session = request.getSession();
			UserDTO user = (UserDTO) session.getAttribute("user");
			entity.setLastModifyUid(user.getId());
			entity.setLastModifyUname(user.getRealName());
			entity.setLastModifyTime(new Date());

			if (!entityService.updateRnTx(entity)) {
				throw new Exception("数据库更新失败");
			}

			returnMap.put("returnCode", "0000");
			returnMap.put("description", "更新成功");
			String result = JSONUtil.toJSonString(returnMap);

			pw.write(result);
			pw.flush();
		} catch (Exception ex) {
			logger.error("修改信息失败!!!r", ex);
			super.out(response, "0099", "修改信息失败");
		}
		return null;
	}
}

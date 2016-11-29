/**
 * Device Name:com-shecc-eoms-web
 * File Name:DeviceController.java
 * Package Name:com.shecc.eoms.web.controller
 * Date:2016年11月17日下午7:05:05
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.enums.ArchiveFlagEnum;
import com.shecc.eoms.core.model.BaseInfo;
import com.shecc.eoms.core.model.Brand;
import com.shecc.eoms.core.model.BrandCriteria;
import com.shecc.eoms.core.model.Device;
import com.shecc.eoms.core.model.DeviceCriteria;
import com.shecc.eoms.core.model.Location;
import com.shecc.eoms.core.model.LocationCriteria;
import com.shecc.eoms.core.model.Model;
import com.shecc.eoms.core.model.ModelCriteria;
import com.shecc.eoms.core.model.System;
import com.shecc.eoms.core.model.SystemCriteria;
import com.shecc.eoms.core.model.SystemType;
import com.shecc.eoms.core.model.SystemTypeCriteria;
import com.shecc.eoms.web.common.utils.JSONUtil;
import com.shecc.eoms.web.dto.UserDTO;
import com.shecc.eoms.web.exception.AppException;
import com.shecc.eoms.web.service.BrandService;
import com.shecc.eoms.web.service.DeviceService;
import com.shecc.eoms.web.service.LocationService;
import com.shecc.eoms.web.service.ModelService;
import com.shecc.eoms.web.service.SystemService;
import com.shecc.eoms.web.service.SystemTypeService;

/**
 * ClassName: DeviceController <br/>
 * Function: 设备信息管理控制器. <br/>
 * date: 2016年11月17日 下午7:05:05 <br/>
 *
 * @author chris
 * @version
 * @since JDK 1.6
 */
public class DeviceController extends BaseController {
	private static final Logger log = LoggerFactory
			.getLogger(DeviceController.class);

	private String listPage;
	private String addPage;
	private String updatePage;
	private String viewDetailPage;

	private DeviceService entityService;
	private BrandService brandService;
	private ModelService modelService;
	private SystemService systemService;
	private SystemTypeService systemTypeService;
	private LocationService locationService;

	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	public void setModelService(ModelService modelService) {
		this.modelService = modelService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public void setSystemTypeService(SystemTypeService systemTypeService) {
		this.systemTypeService = systemTypeService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	public void setEntityService(DeviceService entityService) {
		this.entityService = entityService;
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

	public void setViewDetailPage(String viewDetailPage) {
		this.viewDetailPage = viewDetailPage;
	}

    @InitBinder  
    protected void initBinder(HttpServletRequest request,  
                ServletRequestDataBinder binder) throws Exception {   
          DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  
          CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);  
          binder.registerCustomEditor(Date.class, dateEditor);  
          super.initBinder(request, binder);   
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

		// 获取品牌、型号、系统、系统类型、位置信息
		fillBrand(mv);
		fillModel(mv);
		fillSystem(mv);
		fillSystemType(mv);
		fillLocation(mv);

		return mv;
	}

	private void fillLocation(ModelAndView mv) {
		LocationCriteria criteria = new LocationCriteria();
		criteria.createCriteria().andArchiveFlagEqualTo(
				ArchiveFlagEnum.NO_ARCHIVE.getCode());
		List<Location> locationList = locationService.queryAll(criteria);
		mv.addObject("locationList", locationList);
	}

	private void fillSystemType(ModelAndView mv) {

		SystemTypeCriteria criteria = new SystemTypeCriteria();
		criteria.createCriteria().andArchiveFlagEqualTo(
				ArchiveFlagEnum.NO_ARCHIVE.getCode());
		List<SystemType> sysTypeList = systemTypeService.queryAll(criteria);
		mv.addObject("sysTypeList", sysTypeList);
	}

	private void fillSystem(ModelAndView mv) {
		SystemCriteria criteria = new SystemCriteria();
		criteria.createCriteria().andArchiveFlagEqualTo(
				ArchiveFlagEnum.NO_ARCHIVE.getCode());
		List<System> systemList = systemService.queryAll(criteria);
		mv.addObject("systemList", systemList);
	}

	private void fillModel(ModelAndView mv) {
		ModelCriteria criteria = new ModelCriteria();
		criteria.createCriteria().andArchiveFlagEqualTo(
				ArchiveFlagEnum.NO_ARCHIVE.getCode());
		List<Model> modelList = modelService.queryAll(criteria);
		mv.addObject("modelList", modelList);
	}

	private void fillBrand(ModelAndView mv) {
		BrandCriteria criteria = new BrandCriteria();
		criteria.createCriteria().andArchiveFlagEqualTo(
				ArchiveFlagEnum.NO_ARCHIVE.getCode());
		List<Brand> brandList = brandService.queryAll(criteria);
		mv.addObject("brandList", brandList);
	}

	/**
	 * 分页查询
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView queryForPage(HttpServletRequest request,
			HttpServletResponse response, Device entity) {
		DeviceCriteria criteria = new DeviceCriteria();
		DeviceCriteria.Criteria cc = criteria.createCriteria();
		cc.andArchiveFlagEqualTo(ArchiveFlagEnum.NO_ARCHIVE.getCode());

		// 获取并组装查询条件
		if (entity != null) {
			if (StringUtils.isNotBlank(entity.getName())) {
				cc.andNameLike(entity.getName());
			}
			if (entity.getBrandId() != null) {
				cc.andBrandIdEqualTo(entity.getBrandId());
			}
			if (entity.getModelId() != null) {
				cc.andModelIdEqualTo(entity.getModelId());
			}
			if (entity.getSystemId() != null) {
				cc.andSystemIdEqualTo(entity.getSystemId());
			}
			if (entity.getSysTypeId() != null) {
				cc.andSysTypeIdEqualTo(entity.getSysTypeId());
			}
			if (entity.getLocationId() != null) {
				cc.andLocationIdEqualTo(entity.getLocationId());
			}
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

		// 获取型号、系统、系统类型、位置信息
		fillModel(mv);
		fillSystem(mv);
		fillSystemType(mv);
		fillLocation(mv);

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
			HttpServletResponse response, Device entity) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			
			// 填充选择的相关属性
			buildBelongInfo(entity);

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

			log.info("[EOMS]-[新增数据]");

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
			logger.error("创建失败!", ex);
			super.out(response, "0099", "创建信息失败");
		}
		return null;
	}

	private void buildBelongInfo(Device entity) {
		if (entity.getModelId()!=null) {
			Model model = modelService.findById(entity.getModelId());
			if (model!=null) {
				entity.setModelName(model.getName());
				entity.setBrandId(model.getBrandId());
				entity.setBrandName(model.getBrandName());
			}
		}
		
		BaseInfo baseInfo = null;
		if (StringUtils.isNotBlank(entity.getSystemInfo())) {
			baseInfo=buildBaseInfo(entity.getSystemInfo());
			entity.setSystemId(baseInfo.getId());
			entity.setSystemName(baseInfo.getName());
		}
		if (StringUtils.isNotBlank(entity.getSystemTypeInfo())) {
			baseInfo=buildBaseInfo(entity.getSystemTypeInfo());
			entity.setSysTypeId(baseInfo.getId());
			entity.setSysTypeName(baseInfo.getName());
		}
		if (StringUtils.isNotBlank(entity.getLocationInfo())) {
			baseInfo=buildBaseInfo(entity.getLocationInfo());
			entity.setLocationId(baseInfo.getId());
			entity.setLocationFname(baseInfo.getName());
		}
	}

	// 对id|name形式的字符串进行拆解
	private BaseInfo buildBaseInfo(String baseInfo) {
		String[] baseInfoArr = StringUtils.split(baseInfo, "|");
		int id = Integer.valueOf(baseInfoArr[0]);
		String name = baseInfoArr[1];
		return new BaseInfo(id, name);
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
		Device entity = this.entityService.findById(new Integer(id));

		mv.addObject("entity", entity);

		// 获取型号、系统、系统类型、位置信息
		fillModel(mv);
		fillSystem(mv);
		fillSystemType(mv);
		fillLocation(mv);

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
			HttpServletResponse response, Device entity) {
		try {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();

			String id = request.getParameter("id");

			// 设置
			if (StringUtils.isEmpty(id)) {
				returnMap.put("returnCode", "0001");
				returnMap.put("description", "项目ID为空");
				String result = JSONUtil.toJSonString(returnMap);
				pw.write(result);
				pw.flush();
				return null;
			}
			
			buildBelongInfo(entity);

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
			returnMap.put("description", "更新项目成功");
			String result = JSONUtil.toJSonString(returnMap);

			pw.write(result);
			pw.flush();
		} catch (Exception ex) {
			logger.error("修改信息失败!!!r", ex);
			super.out(response, "0099", "修改信息失败");
		}
		return null;
	}

	/**
	 * 
	 * viewDetail:查看详情. <br/>
	 *
	 * @author chris
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 * @since JDK 1.6
	 */
	public ModelAndView viewDetail(HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		// 定义响应model
		ModelAndView mv = new ModelAndView(this.viewDetailPage);

		String id = request.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			throw new AppException("要查看的数据Id为空");
		}
		Device entity = this.entityService.findById(new Integer(id));

		mv.addObject("entity", entity);

		return mv;
	}
}
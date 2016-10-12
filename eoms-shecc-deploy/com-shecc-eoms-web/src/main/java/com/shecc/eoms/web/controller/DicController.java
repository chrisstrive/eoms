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

import com.shecc.eoms.web.common.AuthFilter;
import com.shecc.eoms.web.common.ValTemplate;
import com.shecc.eoms.web.common.WebUtil;
import com.shecc.eoms.web.service.DicService;
import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.common.utils.JSONUtil;
import com.shecc.eoms.core.model.Dic;

/**
 * 
 * USER ray ray1192@163.com DATE 2014-2-12 下午12:45:30 INFO
 * com.shecc.eoms.web.controller UserConntroller.java REMARK
 * 
 */
public class DicController extends MultiActionController {

	private static final Log log = LogFactory.getLog(DicController.class);
	private DicService dicService;

	public DicService getDicService() {
		return dicService;
	}

	public void setDicService(DicService dicService) {
		this.dicService = dicService;
	}

	private String dicDefaultPage;

	public String getDicDefaultPage() {
		return dicDefaultPage;
	}

	public void setDicDefaultPage(String dicDefaultPage) {
		this.dicDefaultPage = dicDefaultPage;
	}

	private String addPage;
	private String updatePage;
	private String reSetPage;
	private String changePage;

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

	public ModelAndView dicDefault(HttpServletRequest request,
			HttpServletResponse response) {
		// 定义响应model
		ModelAndView mv = new ModelAndView(this.dicDefaultPage);
		// 查询数据字典
		List<Dic> dicTypeList = this.dicService.queryDicType();
		mv.addObject("dicTypeList", dicTypeList);
		return mv;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ModelAndView addDic(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		ModelAndView mv = new ModelAndView(this.addPage);
		Map map = new HashMap();
		Dic dic = new Dic();

		// 查询数据字典
		List<Dic> dicTypeList = this.dicService.queryDicType();

		if (StringUtils.isNumeric(id)) {
			dic = this.dicService.findById(Integer.parseInt(id));
		}

		map.put("dic", dic);
		mv.addAllObjects(map);
		mv.addObject("dicTypeList", dicTypeList);
		return mv;
	}

	public ModelAndView deleteDic(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter pw = response.getWriter();
			Dic dic = WebUtil.request2Bean(request, Dic.class);
			String result = "";
			if (dic.getId() != null && dic.getId() > 0) {
				this.dicService.deleteDicRnTx(dic);
				returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0000);
				returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0000);
				result = JSONUtil.toJSonString(returnMap);
			} else {
				returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0002);
				returnMap.put("description", ValTemplate.V_T_VAL_MSG_CODE_0002);
				result = JSONUtil.toJSonString(returnMap);
			}
			try {
				// 数据字典重构
				dicService.reBuildDic(request.getSession().getServletContext());
			} catch (Exception ex) {
				logger.error("重构数据字典失败!!!r", ex);
			}
			pw.write(result);
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView createDic(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();

			// 设置
			Dic dic = WebUtil.request2Bean(request, Dic.class);
			log.info("[系统]-[创建字典]");
			String result = "";
			Integer id = null;
			if (dic.getId() == null || dic.getId() < 1) {
				id = dicService.createDicRnTx(dic);
			} else {
				dicService.updateDicRnTx(dic);
				id = dic.getId();
			}

			if (id != null) {
				returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0000);
				returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0000);
				result = JSONUtil.toJSonString(returnMap);
			} else {
				returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0002);
				returnMap.put("description", ValTemplate.V_T_VAL_MSG_CODE_0002);
				result = JSONUtil.toJSonString(returnMap);
			}

			try {
				// 数据字典重构
				dicService.reBuildDic(request.getSession().getServletContext());
			} catch (Exception ex) {
				logger.error("重构数据字典失败!!!r", ex);
			}

			pw.write(result);
			pw.flush();
		} catch (Exception ex) {
			logger.error("创建用户失败!!!r", ex);
		}
		return null;
	}

	public ModelAndView queryForPage(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		String typeStr = request.getParameter("type");
		Page page = WebUtil.request2Bean(request, Page.class);
		Integer type = -1;
		try {
			type = Integer.parseInt(typeStr);
		} catch (Exception e) {

		}
		if (type != -1) {
			queryMap.put("type", type);
		}

		String dicTxt = request.getParameter("dicTxt");
		if (StringUtils.isNotEmpty(dicTxt)) {
			queryMap.put("dicTxt", dicTxt);
		}

		String result = this.dicService.queryDic(queryMap, page);
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
	
	public ModelAndView refreshCache(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			dicService.reBuildDic(request.getSession().getServletContext());
			
			returnMap.put("returnCode", ValTemplate.V_T_VAL_MSG_CODE_0000);
			returnMap.put("description", ValTemplate.V_T_VAL_MSG_RMK_0000);
			String result = JSONUtil.toJSonString(returnMap);
		
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
		} catch (IOException e) {
			logger.error("分页查询失败!", e);
		}
		return null;
	}

}

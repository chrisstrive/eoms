/**
 * Project Name:com-shecc-eoms-web
 * File Name:FileController.java
 * Package Name:com.shecc.eoms.web.controller
 * Date:2016年11月29日上午11:36:25
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.shecc.eoms.web.common.utils.JSONUtil;
import com.shecc.eoms.web.dto.FileBean;
import com.shecc.eoms.web.dto.ResultDto;
import com.shecc.eoms.web.exception.AppException;
import com.shecc.eoms.web.utils.HTTPProtocolHandleUtil;
import com.shecc.eoms.web.utils.UnifiedFileSystem;


/**
 * ClassName: FileController <br/>
 * Function: 文件上传控制器. <br/>
 * date: 2016年11月29日 上午11:36:25 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public class FileController extends BaseController {
	private String uploadView;
	private String viewPicPage;

	public void setUploadView(String uploadView) {
		this.uploadView = uploadView;
	}

	public void setViewPicPage(String viewPicPage) {
		this.viewPicPage = viewPicPage;
	}

	public ModelAndView fileUpload(HttpServletRequest request,
			HttpServletResponse response, FileBean file) throws AppException {
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		ResultDto result = new ResultDto();
		try {
			out = response.getWriter();
			String fileNo = "";
			if (file.getFile() != null) {
				String fileName = file.getFile().getOriginalFilename();
				if (StringUtils.isBlank(fileName)) {
					result.setErrResultDto("错误信息", "文件名不能为空");
				} else {
					fileNo=UnifiedFileSystem.upload(file);
					logger.info("文件上传  fileNo=" + fileNo);
					if (StringUtils.isBlank(fileNo)) {
						result.setErrResultDto("错误信息", "文件服务器上传出错,请稍后重试");
					} else {
						result.setSuccessResultDto(fileName.substring(0,
								fileName.lastIndexOf("."))
								+ "||" + fileNo);
					}
				}
			} else {
				result.setErrResultDto("错误信息", "上传文件出错,请重试");
			}
		} catch (IOException e) {
			logger.error("文件上传失败 throws error", e);
			result.setErrResultDto("错误信息", e.getMessage());
		} finally {
			String jsonResult = JSONUtil.toJSonString(result);
			logger.info("文件上传  jsonResult=" + jsonResult);
			out.write(jsonResult);
			out.flush();
		}
		return null;
	}

	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws ServletException {

		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());

	}

	public ModelAndView uploadView(HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		HTTPProtocolHandleUtil.setAll(request, response);
		ModelAndView mv = new ModelAndView(uploadView);
		String fileType = request.getParameter("fileType");
		if (StringUtils.isBlank(fileType)) {
			throw new AppException("上传文件类型未指定。");
		}
		mv.addObject("fileType", fileType);
		return mv;
	}
	
	public ModelAndView viewPic(HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		HTTPProtocolHandleUtil.setAll(request, response);
		ModelAndView mv = new ModelAndView(viewPicPage);
		String picName = request.getParameter("picName");
		String picPath = request.getParameter("picPath");
		mv.addObject("picName", picName);
		mv.addObject("picPath", picPath);
		return mv;
	}
}
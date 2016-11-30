/**
 * Project Name:com-shecc-eoms-web
 * File Name:HTTPProtocolHandleUtil.java
 * Package Name:com.shecc.eoms.web.utils
 * Date:2016年11月29日下午12:02:18
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: HTTPProtocolHandleUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年11月29日 下午12:02:18 <br/>
 *
 * @author chris
 * @version
 * @since JDK 1.6
 */
public class HTTPProtocolHandleUtil {
	public static void setAll(HttpServletRequest request,
			HttpServletResponse response) {
		HTTPProtocolHandleUtil.setNoCache(request, response);
		HTTPProtocolHandleUtil.setUTF8(request, response);
	}

	/**
	 * 设置字符集为UTF-8
	 * 
	 * @param request
	 * @param response
	 */
	public static void setUTF8(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
	}

	/**
	 * 设置字符集为GBK
	 * 
	 * @param request
	 * @param response
	 */
	public static void setGBK(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("GBK");
	}

	/**
	 * 设置字符集为GB2312
	 * 
	 * @param request
	 * @param response
	 */
	public static void setGB2312(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("GB2312");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("GB2312");
	}

	/**
	 * 设置不缓存
	 * 
	 * @param request
	 * @param response
	 */
	public static void setNoCache(HttpServletRequest request,
			HttpServletResponse response) {
		if (request.getProtocol().compareTo("HTTP/1.0") == 0) {

			response.setHeader("Pragma", "no-cache");

		} else if (request.getProtocol().compareTo("HTTP/1.1") == 0) {

			response.setHeader("Cache-Control", "no-cache");

		}
		response.setDateHeader("Expires", 0);
	}

	public static String encodeDownFilename(String fileName,
			HttpServletRequest request) throws UnsupportedEncodingException {
		String agent = request.getHeader("USER-AGENT");

		if (null != agent && -1 != agent.indexOf("MSIE")) {// IE
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// Firefox
			fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
		} else {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		}
		return fileName;
	}

	/**
	 * 导出结果至Excel文件时的设置
	 * 
	 * @param response
	 * @param outputFileName
	 *            输出时使用的文件名，请以xls作为文件扩展名
	 * @throws UnsupportedEncodingException
	 */
	public static void prepareExcelOutput(HttpServletResponse response,
			String outputFileName) throws UnsupportedEncodingException {
		response.setHeader("Expires", "0");
		response.setHeader("Pragma", "public");
		response.setHeader(ConstantUtil.HTTP_HEADER_CACHE_CONTROL,
				"must-revalidate, post-check=0, pre-check=0");
		response.setHeader(ConstantUtil.HTTP_HEADER_CACHE_CONTROL, "public");
		response.setContentType("application/vnd.ms-excel;charset="
				+ ConstantUtil.ENCODING_UTF_8);
		response.setHeader(
				"Content-Disposition",
				"attachment;filename="
						+ new String((outputFileName)
								.getBytes(ConstantUtil.ENCODING_UTF_8),
								ConstantUtil.ENCODING_ISO_8859_1));
	}
}

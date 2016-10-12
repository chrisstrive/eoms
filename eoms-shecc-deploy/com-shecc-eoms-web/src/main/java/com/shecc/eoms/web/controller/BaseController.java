package com.shecc.eoms.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.shecc.eoms.core.common.utils.JSONUtil;

public class BaseController extends MultiActionController{
	
	private static final Log log = LogFactory.getLog(BaseController.class);
	
	public void out(HttpServletResponse response,String returnCode,String desc){
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter pw = null;
		try {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			returnMap.put("returnCode", returnCode);
			returnMap.put("description", desc);
			String result = JSONUtil.toJSonString(returnMap);
			pw = response.getWriter();
			pw.write(result);
			pw.flush();
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}
	
		
	}

}

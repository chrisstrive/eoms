package com.shecc.eoms.web.common;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shecc.eoms.web.service.DicService;
import com.shecc.eoms.core.dao.DicDAOImpl;
import com.shecc.eoms.core.model.Dic;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-11 上午09:55:46
 * INFO com.shecc.eoms.web.common AuthFilter.java
 * REMARK 登录权限认证
 *
 */
public class AuthFilter implements Filter{
	
	private static final String indexUrl="/htm/index.html";//未登录使用
	private static final String homeUrl="/login.htm?method=login";//已登录使用
	
	private static DicService dicService;
	
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession(true);
		
		String userName = (String) session.getAttribute(ValTemplate.V_T_USER_NAME); 
		
		String url = request.getContextPath() + request.getServletPath();
		
		if(url.endsWith("phoneTest.html")){
			chain.doFilter(req, resp);
			return;
		}
		
		
		//未登录处理
		if(null == userName || userName == "" || userName == "null"){
			//未登录访问登录页面处理
			if(url.endsWith("index.html") || url.endsWith("login.html") || url.endsWith("login.htm")){
				chain.doFilter(req, resp);
				return;
			}
			//访问其他页面处理
			else{
				response.sendRedirect(request.getContextPath()+indexUrl);
				return;	
			}

		}
		//已登录处理
		else if(null != userName && userName != "" && userName != "null"){
			
			//已登录访问登录页面处理
			if(url.endsWith("index.html") || url.endsWith("login.html")){
				response.sendRedirect(request.getContextPath()+homeUrl);
				return;	
			}
			//访问其他页面处理
			else{
				chain.doFilter(req, resp);
				return;
			}
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.reBuildDic(filterConfig.getServletContext());
	}

	/*
	 * 数据字典重新加载
	 */
	public void reBuildDic(ServletContext context){
		if(dicService==null){
			dicService=(DicService)SpringContextUtil.getBean("ser-dicService");
		}
		dicService.reBuildDic(context);
	}
	
}


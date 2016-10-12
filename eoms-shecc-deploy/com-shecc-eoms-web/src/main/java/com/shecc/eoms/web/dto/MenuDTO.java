package com.shecc.eoms.web.dto;

import java.io.Serializable;


/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-10 下午08:28:41
 * INFO com.shecc.eoms.web.dto MenuDTO.java
 * REMARK 菜单
 *
 */
public class MenuDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private String menuCode;
	private String menuName;
	private String url;
	private String parent;
	private String status;
	
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}


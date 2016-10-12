package com.shecc.eoms.core.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-10 下午08:28:41
 * INFO com.scorpio.model Menu.java
 * REMARK 菜单
 *
 */
public class Menu implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer	id;
	private String menuCode;
	private String menuName;
	private String icon;
	private String url;
	private Integer parent;
	private String status;
	
	private String isParent;
	
	private String isCheck;
	
	private Integer orderRum;
	
	/**
	 * 子菜单
	 */
	List<Menu> subMenuList;

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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsCheck() {
		return isCheck;
	}
	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}
	public Integer getOrderRum() {
		return orderRum;
	}
	public void setOrderRum(Integer orderRum) {
		this.orderRum = orderRum;
	}
	public List<Menu> getSubMenuList() {
		return subMenuList;
	}
	public void setSubMenuList(List<Menu> subMenuList) {
		this.subMenuList = subMenuList;
	}
	public String getIsParent() {
		return isParent;
	}
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
	public String getIcon() {
		return "icon-nav";
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
}


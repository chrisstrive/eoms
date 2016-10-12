package com.shecc.eoms.core.model;

import java.io.Serializable;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-10 下午08:39:57
 * INFO com.scorpio.model RoleMenu.java
 * REMARK 角色所拥有的菜单
 *
 */
public class RoleMenu implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer tRoleId;
	private Integer tMenuId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer gettRoleId() {
		return tRoleId;
	}
	public void settRoleId(Integer tRoleId) {
		this.tRoleId = tRoleId;
	}
	public Integer gettMenuId() {
		return tMenuId;
	}
	public void settMenuId(Integer tMenuId) {
		this.tMenuId = tMenuId;
	}
}


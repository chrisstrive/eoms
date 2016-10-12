package com.shecc.eoms.core.model;

import java.io.Serializable;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-10 下午08:49:05
 * INFO com.scorpio.model UserRole.java
 * REMARK 用户所属角色
 *
 */
public class UserRole implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer tUserId;
	private Integer tRoleId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer gettUserId() {
		return tUserId;
	}
	public void settUserId(Integer tUserId) {
		this.tUserId = tUserId;
	}
	public Integer gettRoleId() {
		return tRoleId;
	}
	public void settRoleId(Integer tRoleId) {
		this.tRoleId = tRoleId;
	}
}


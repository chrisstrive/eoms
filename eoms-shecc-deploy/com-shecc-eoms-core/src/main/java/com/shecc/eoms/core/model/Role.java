package com.shecc.eoms.core.model;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-10 下午08:36:39
 * INFO com.scorpio.model Role.java
 * REMARK 角色
 *
 */
public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String roleCode;
	private String roleName;
	private String status;
	private String remark;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return StringUtils.isNotBlank(roleName) ? roleName : "";
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}


package com.shecc.eoms.core.model;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

/**
 *
 * USER ray ray1192@163.com DATE 2014-2-10 下午08:44:05 INFO com.scorpio.model
 * User.java REMARK 用户
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String userName;
	private String realName;
	private String passWd;
	private String status;
	private String mobileNo;
	private String phone;
	private String email;
	private String photo;
	private Integer upUid;
	private String upUname;
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWd() {
		return passWd;
	}

	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMobileNo() {
		return StringUtils.isNotBlank(mobileNo) ? mobileNo : "";
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return StringUtils.isNotBlank(email) ? email : "";
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return StringUtils.isNotBlank(phone) ? phone : "";
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getUpUid() {
		return upUid;
	}

	public void setUpUid(Integer upUid) {
		this.upUid = upUid;
	}

	public String getUpUname() {
		return upUname;
	}

	public void setUpUname(String upUname) {
		this.upUname = upUname;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
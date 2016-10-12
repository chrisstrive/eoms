package com.shecc.eoms.web.dto;

import java.io.Serializable;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-10 下午08:44:05
 * INFO com.shecc.eoms.web.model User.java
 * REMARK 用户
 *
 */
public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String userName;
	private String realName;
	private String passWd;
	private String status;
	private String mobileNo;
	private Integer destAgentId;
	private String destAgentName;

	
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
		return mobileNo;
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
    public Integer getDestAgentId() {
		return destAgentId;
	}
	public void setDestAgentId(Integer destAgentId) {
		this.destAgentId = destAgentId;
	}
	public String getDestAgentName() {
        return destAgentName;
    }
    public void setDestAgentName(String destAgentName) {
        this.destAgentName = destAgentName;
    }
}


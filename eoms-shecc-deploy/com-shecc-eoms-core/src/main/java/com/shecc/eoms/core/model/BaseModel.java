package com.shecc.eoms.core.model;

import java.io.Serializable;
import java.util.Date;

import com.shecc.eoms.core.common.utils.DateUtil;


public class BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Date	createTime;
	public Integer createBy;
	public Date lastUpdateTime;
	public Integer lastUpdateBy;
	
	public String createTimeStr;
	public String lastUpdateTimeStr;
	
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public Integer getLastUpdateBy() {
		return lastUpdateBy;
	}
	public void setLastUpdateBy(Integer lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	public String getCreateTimeStr() {
		return createTime != null ? DateUtil.formatDateTime(createTime) : "";
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	public String getLastUpdateTimeStr() {
		return lastUpdateTime != null ? DateUtil.formatDateTime(lastUpdateTime) : "";
	}
	public void setLastUpdateTimeStr(String lastUpdateTimeStr) {
		this.lastUpdateTimeStr = lastUpdateTimeStr;
	}
}

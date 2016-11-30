/**
 * Project Name:com-shecc-eoms-core
 * File Name:BaseInfo.java
 * Package Name:com.shecc.eoms.core.model
 * Date:2016年11月28日下午9:27:22
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.core.model;

/**
 * ClassName: BaseInfo <br/>
 * Function: 基础信息模型. <br/>
 * Reason: 用来构建包含ID和NAME的对象模型. <br/>
 * date: 2016年11月28日 下午9:27:22 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public class BaseInfo {
	public BaseInfo() {
		super();
	}
	public BaseInfo(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}


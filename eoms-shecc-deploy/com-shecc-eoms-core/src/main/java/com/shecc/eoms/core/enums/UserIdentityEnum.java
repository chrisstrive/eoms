/**
 * Project Name:com-shecc-eoms-core
 * File Name:UserIdentityEnum.java
 * Package Name:com.shecc.eoms.core.enums
 * Date:2016年10月20日下午5:13:53
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.core.enums;

/**
 * ClassName: UserIdentityEnum <br/>
 * Function: 用户身份枚举类. <br/>
 * date: 2016年10月20日 下午5:13:53 <br/>
 *
 * @author chris
 * @version
 * @since JDK 1.6
 */
public enum UserIdentityEnum {
	ADMIN("1", "系统管理员"), LEADER("2", "负责人"), PROJECT_MANAGER("3", "项目经理"), SUB_CONTRACTOR(
			"4", "分包商"), ENGINEER("5", "工程师"), CUSTOMER("6", "客户");

	private String code;
	private String des;

	UserIdentityEnum(String code, String des) {
		this.code = code;
		this.des = des;
	}

	public String getCode() {
		return code;
	}

	public String getDes() {
		return des;
	}

	public static UserIdentityEnum getUserIdentityEnum(String value) {
		if (value != null) {
			for (UserIdentityEnum nameEnum : values()) {
				if (nameEnum.getCode().equals(value)) {
					return nameEnum;
				}
			}
		}
		return null;
	}

	public static boolean isUserIdentityEnum(String value) {
		if (value != null) {
			for (UserIdentityEnum nameEnum : values()) {
				if (nameEnum.getCode().equals(value)) {
					return true;
				}
			}
		}
		return false;
	}
}

/**
 * Project Name:com-shecc-eoms-core
 * File Name:UserStatusEnum.java
 * Package Name:com.shecc.eoms.core.enums
 * Date:2016年11月17日下午4:13:37
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.core.enums;

/**
 * ClassName: UserStatusEnum <br/>
 * Function: 用户状态枚举. <br/>
 * date: 2016年11月17日 下午4:13:37 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public enum UserStatusEnum {
	NORMAL("1", "启用"), FROZEN("2", "冻结");

	private String code;
	private String des;

	UserStatusEnum(String code, String des) {
		this.code = code;
		this.des = des;
	}

	public String getCode() {
		return code;
	}

	public String getDes() {
		return des;
	}

	public static UserStatusEnum getUserStatusEnum(String value) {
		if (value != null) {
			for (UserStatusEnum nameEnum : values()) {
				if (nameEnum.getCode().equals(value)) {
					return nameEnum;
				}
			}
		}
		return null;
	}

	public static boolean isUserStatusEnum(String value) {
		if (value != null) {
			for (UserStatusEnum nameEnum : values()) {
				if (nameEnum.getCode().equals(value)) {
					return true;
				}
			}
		}
		return false;
	}
}


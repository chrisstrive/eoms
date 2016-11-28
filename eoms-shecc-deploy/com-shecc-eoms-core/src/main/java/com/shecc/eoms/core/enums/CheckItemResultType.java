/**
 * Project Name:com-shecc-eoms-core
 * File Name:CheckItemResultType.java
 * Package Name:com.shecc.eoms.core.enums
 * Date:2016年11月25日上午11:21:59
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.core.enums;

/**
 * ClassName: CheckItemResultType <br/>
 * Function: 检查项结果类型枚举. <br/>
 * date: 2016年11月25日 上午11:21:59 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public enum CheckItemResultType {
	NO_ARCHIVE("1", "布尔值"), ALEADY_ARCHIVE("2", "文本");

	private String code;
	private String des;

	CheckItemResultType(String code, String des) {
		this.code = code;
		this.des = des;
	}

	public String getCode() {
		return code;
	}

	public String getDes() {
		return des;
	}

	public static CheckItemResultType getCheckItemResultType(String value) {
		if (value != null) {
			for (CheckItemResultType nameEnum : values()) {
				if (nameEnum.getCode().equals(value)) {
					return nameEnum;
				}
			}
		}
		return null;
	}

	public static boolean isCheckItemResultType(String value) {
		if (value != null) {
			for (CheckItemResultType nameEnum : values()) {
				if (nameEnum.getCode().equals(value)) {
					return true;
				}
			}
		}
		return false;
	}
}


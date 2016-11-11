/**
 * Project Name:com-shecc-eoms-core
 * File Name:ArchiveFlagEnum.java
 * Package Name:com.shecc.eoms.core.enums
 * Date:2016年10月20日下午5:13:53
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.core.enums;

/**
 * ClassName: ArchiveFlagEnum <br/>
 * Function: 归档标识枚举类. <br/>
 * date: 2016年10月20日 下午5:13:53 <br/>
 *
 * @author chris
 * @version
 * @since JDK 1.6
 */
public enum ArchiveFlagEnum {
	NO_ARCHIVE("1", "未归档"), ALEADY_ARCHIVE("2", "已归档");

	private String code;
	private String des;

	ArchiveFlagEnum(String code, String des) {
		this.code = code;
		this.des = des;
	}

	public String getCode() {
		return code;
	}

	public String getDes() {
		return des;
	}

	public static ArchiveFlagEnum getArchiveFlagEnum(String value) {
		if (value != null) {
			for (ArchiveFlagEnum nameEnum : values()) {
				if (nameEnum.getCode().equals(value)) {
					return nameEnum;
				}
			}
		}
		return null;
	}

	public static boolean isArchiveFlagEnum(String value) {
		if (value != null) {
			for (ArchiveFlagEnum nameEnum : values()) {
				if (nameEnum.getCode().equals(value)) {
					return true;
				}
			}
		}
		return false;
	}
}

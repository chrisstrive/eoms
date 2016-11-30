/**
 * Project Name:com-shecc-eoms-core
 * File Name:FileTypeEnum.java
 * Package Name:com.shecc.eoms.core.enums
 * Date:2016年11月29日下午1:41:34
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.core.enums;

/**
 * ClassName: FileTypeEnum <br/>
 * Function: 文件分类枚举. <br/>
 * date: 2016年11月29日 下午1:41:34 <br/>
 *
 * @author chris
 * @version
 * @since JDK 1.6
 */
public enum FileTypeEnum {
	PROJECT_PIC("I01", "projectPic","项目图片"), BRAND_LOGO("I02", "brandLogo","品牌LOGO"),MODEL_PIC("I03", "modelPic","型号图片"),;

	private String code;
	private String dir;
	private String des;

	FileTypeEnum(String code,String dir, String des) {
		this.code = code;
		this.dir=dir;
		this.des = des;
	}

	public String getCode() {
		return code;
	}
	
	public String getDir() {
		return dir;
	}

	public String getDes() {
		return des;
	}

	public static FileTypeEnum getFileTypeEnum(String value) {
		if (value != null) {
			for (FileTypeEnum nameEnum : values()) {
				if (nameEnum.getCode().equals(value)) {
					return nameEnum;
				}
			}
		}
		return null;
	}

	public static boolean isFileTypeEnum(String value) {
		if (value != null) {
			for (FileTypeEnum nameEnum : values()) {
				if (nameEnum.getCode().equals(value)) {
					return true;
				}
			}
		}
		return false;
	}
}

package com.shecc.eoms.web.enums;

public enum DicEnum {
	_DIC_TYPE_1("1","所属渠道"),
	_DIC_TYPE_2("2", "所属分公司"),
	_DIC_TYPE_3("3", "虚拟标示"),
	_DIC_TYPE_4("4", "当前职级"),
	_DIC_TYPE_5("5", "证件类型"),
	_DIC_TYPE_6("6", "待办类型"),
	_DIC_TYPE_7("7", "待办大类"),
	_DIC_TYPE_8("8", "代办事项状态"),
	_DIC_TYPE_9("9", "提醒类型"),
	_DIC_TYPE_10("10", "通用状态")
	;
	
    private String code;
	private String desc;
	
	
	DicEnum(String code,String desc) {
		this.code = code;
		this.desc = desc;
	}

	
	public String getCode() {
		return code;
	}


	public String getDesc() {
		return desc;
	}



	public static DicEnum getCode(String value) {
		if (value != null) {
			for (DicEnum nameEnum : values()) {
				if (nameEnum.getCode().equals(value)) {
					return nameEnum;
				}
			}
		}
		return null;
	}
	
	
	public static boolean isgetCode(String value) {
		if (value != null) {
			for (DicEnum nameEnum : values()) {
				if (nameEnum.getCode().equals(value)) {
					return true;
				}
			}
		}
		return false;
	}
}

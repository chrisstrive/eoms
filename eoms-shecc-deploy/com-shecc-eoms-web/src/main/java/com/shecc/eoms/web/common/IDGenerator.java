package com.shecc.eoms.web.common;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.shecc.eoms.core.common.utils.DateUtil;

public class IDGenerator {

	public static String generateCustomerCode(String lxdh) {
		String lxdhWh = "";
		if (StringUtils.isNotEmpty(lxdh) && lxdh.length() > 4) {
			lxdhWh = lxdh.substring(lxdh.length() - 5);
		}
		return DateUtil.formatDateTime(DateUtil.TAMPSTAMP_DATE_FORMAT, new Date()) + lxdhWh;
	}
	
	public static String generateReserveCode(){
		return DateUtil.formatDateTime(DateUtil.TAMPSTAMP_DATE_FORMAT, new Date());
	}
	
	public static String generateTransactionCode(String htbh) {
		String htbhWh = "";
		if (StringUtils.isNotEmpty(htbh)) {
			htbhWh = htbh.substring(htbh.length());
		}
		return DateUtil.formatDateTime(DateUtil.TAMPSTAMP_DATE_FORMAT, new Date()) + htbhWh;
	}

}

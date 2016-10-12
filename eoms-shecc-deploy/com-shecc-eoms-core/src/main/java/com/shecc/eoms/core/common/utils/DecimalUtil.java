package com.shecc.eoms.core.common.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 数字工具集
 * 
 * @author Administrator
 * 
 */
public class DecimalUtil {
	/**
	 * 金额格式化
	 * @param s 金额
	 * @param len 小数位数
	 * @return 格式后的金额
	 */
	public static String formatMoney(Double amt, int len) {
		if(amt == null){
			return "";
		}
		NumberFormat formater = null;
		if (len == 0) {
			formater = new DecimalFormat("###,###");
		} else {
			StringBuffer buff = new StringBuffer();
			buff.append("###,###.");
			for (int i = 0; i < len; i++) {
				buff.append("#");
			}
			formater = new DecimalFormat(buff.toString());
		}
		return formater.format(amt);
	}
	
	/**
	 * 金额去掉“,”
	 * @param s 金额
	 * @return 去掉“,”后的金额
	 */
	public static String delComma(String s) {
	    String formatString = "";
	    if (s != null && s.length() >= 1) {
	        formatString = s.replaceAll(",", "");
	    }
	    return formatString;
	}
	
	public static void main(String[] args){
		String s = formatMoney(1111.563564455d, 2);
		System.out.println(s);
	}
}

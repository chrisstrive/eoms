package com.shecc.eoms.web.utils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 金钱处理
 * @author yc.gao
 *
 */
public class MoneyUtil {
	
	/**
	 * 转成数据库储存,乘以100
	 * @param money
	 * @return
	 */
	public static Integer transInteger(String money){
		
		BigDecimal m = new BigDecimal(money);
		BigDecimal result = m.multiply(new BigDecimal(100));
		return result.intValue();
	}
	
	/**
	 * 转换成页面显示，除以100，保留2位小数
	 * @param money
	 * @return
	 */
	public static String transString(Integer money){
		BigDecimal m = new BigDecimal(money);		
		BigDecimal result = m.divide(new BigDecimal(100));
		result = result.setScale(2, BigDecimal.ROUND_HALF_UP); //四舍五入
		return result.toString();
	}
	
	/**
	 * 计算滞箱费（流转时间-免租天数）x按柜型的费用
	 * @param entryYardDate
	 * @param returnDate
	 * @param freeDate
	 * @param demurrageStand
	 */
	public static Integer setDemurrage(Date entryYardDate,Date returnDate,Integer freeDate,Integer demurrageStand){
		if(returnDate == null){
			returnDate = new Date();
		}
		if(entryYardDate == null){
			return null;
		}
		Long temp = (returnDate.getTime() - entryYardDate.getTime());
		temp = temp/(1000 * 60 * 60 * 24); 
		
		
		if(freeDate == null){
			freeDate = 0;
		}
		if(demurrageStand == null){
			demurrageStand = 0;
		}
		
		if(temp-freeDate<0){
			return 0;
		}
		
		temp = temp-freeDate;
		
		BigDecimal dat = new BigDecimal(temp);	
		BigDecimal de = new BigDecimal(demurrageStand);	
		
		return dat.multiply(de).intValue();
	}
	
	
	/**
	 * 获取堆存费
	 * @param entryYardDate
	 * @param outYardDate
	 * @param freePeriod
	 * @param storageChargeStandard
	 * @return
	 */
	public static Integer setStorageCharge(Date entryYardDate,Date outYardDate,Integer freePeriod,Integer storageChargeStandard){
		if(outYardDate == null){
			outYardDate = new Date();
		}
		if(entryYardDate == null){
			return null;
		}
		Long temp = (outYardDate.getTime() - entryYardDate.getTime());
		temp = temp/(1000 * 60 * 60 * 24); 
		
		if(freePeriod == null){
			freePeriod = 0;
		}
		if(storageChargeStandard == null){
			storageChargeStandard = 0;
		}
		if(temp-freePeriod<0){
			return 0;
		}
		
		temp = temp-freePeriod;
		
		BigDecimal dat = new BigDecimal(temp);	
		BigDecimal de = new BigDecimal(storageChargeStandard);	
		
		return dat.multiply(de).intValue();
	}

}

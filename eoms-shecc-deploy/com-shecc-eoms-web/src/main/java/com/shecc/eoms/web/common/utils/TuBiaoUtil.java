/**
 * 
 */
package com.shecc.eoms.web.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * @author zxc
 *
 */
public class TuBiaoUtil {

	public static String tranferTuBiao(List<Map<String, Object>> list) {
		List<Double> lStr=new ArrayList<Double>(12);
		for(int i=0;i<12;i++){
			lStr.add(0d);
		}
		if(list!=null&&list.size()>0){
			for(Map<String,Object> m:list){
				String month=(String)m.get("qyrq");
				Integer i=TuBiaoUtil.qyrqForMonth(month);
				if(i==null){
					
				}else{
					Object o=m.get("jyje");
					lStr.set(i, (Double)o);
				}
				
			}
			
			
		}
		StringBuffer sb=new StringBuffer("");
		for(Double d:lStr){
			sb.append(d).append(",");
		}
		if(sb.toString().endsWith(",")){
			sb.setLength(sb.length()-1);
		}
		
		return sb.toString();
	}

	public static Integer qyrqForMonth(String month){
		Integer i=null;
		if(StringUtils.isNotEmpty(month)){
			String m=month.substring(month.indexOf("-")+1);
			i=Integer.parseInt(m)-1;
		}else{
			
			
		}
		
		return i;
	}

	public static String tranferInteger(List<Map<String, Object>> list) {
		List<Integer> lStr=new ArrayList<Integer>(12);
		for(int i=0;i<12;i++){
			lStr.add(0);
		}
		if(list!=null&&list.size()>0){
			for(Map<String,Object> m:list){
				String month=(String)m.get("spsj");
				Integer i=TuBiaoUtil.qyrqForMonth(month);
				if(i==null){
					
				}else{
					Object o=m.get("count");
					lStr.set(i, ((Long)o).intValue());
				}
				
			}
			
			
		}
		StringBuffer sb=new StringBuffer("");
		for(Integer d:lStr){
			sb.append(d).append(",");
		}
		if(sb.toString().endsWith(",")){
			sb.setLength(sb.length()-1);
		}
		
		return sb.toString();
	
	}

	public static String [] tranferProduct(List<Map<String, Object>> list) {
		String [] returnStr=new String[3];
		List<Double> lStr=new ArrayList<Double>(8);
		for(int i=0;i<8;i++){
			lStr.add(0d);
		}
		
		List<Double> lStr1=new ArrayList<Double>(8);
		for(int i=0;i<8;i++){
			lStr1.add(0d);
		}
		
		List<String> lStr2=new ArrayList<String>(8);
		for(int i=0;i<8;i++){
			lStr2.add("");
		}
		
		if(list!=null&&list.size()>0){
			int i=0;
			for(Map<String,Object> m:list){
				String month=(String)m.get("cpjc");
				
				
					Object o=m.get("jiaoyi");
					Object o1=m.get("yuyue");
					lStr.set(i, (Double)o);
					lStr1.set(i, (Double)o1);
					lStr2.set(i,month);				
			}
			
			
		}
		
		StringBuffer sb=new StringBuffer("");
		for(Double d:lStr){
			sb.append(d).append(",");
		}
		if(sb.toString().endsWith(",")){
			sb.setLength(sb.length()-1);
		}
		
		returnStr[0]=sb.toString();
		sb=new StringBuffer("");
		for(Double d:lStr1){
			sb.append(d).append(",");
		}
		if(sb.toString().endsWith(",")){
			sb.setLength(sb.length()-1);
		}
		returnStr[1]=sb.toString();
		sb=new StringBuffer("");
		for(String d:lStr2){
			sb.append("'").append(d).append("'").append(",");
		}
		if(sb.toString().endsWith(",")){
			sb.setLength(sb.length()-1);
		}
		returnStr[2]=sb.toString();
		
		return returnStr;
	}
}

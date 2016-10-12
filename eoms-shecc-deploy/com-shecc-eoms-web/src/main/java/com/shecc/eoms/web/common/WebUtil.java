/**
 * 
 */
package com.shecc.eoms.web.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.shecc.eoms.core.common.utils.DateConverter;

/**
 * @author user
 *
 */
public class WebUtil {
	
	static int i;
	private static final Log log = LogFactory.getLog(WebUtil.class);
	
	public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass) {
		try {
		/**创建封装数据的bean**/
		ConvertUtils.register(new DateConverter(), java.util.Date.class);
		
		T bean = beanClass.newInstance();
		Map map = request.getParameterMap();
		BeanUtils.populate(bean, map);
		ConvertUtils.deregister(DateConverter.class);
		return bean;
		} catch (Exception e) {
		throw new RuntimeException(e);
		}
		} 
		
	public static Integer strToInteger(String str){
		if(str==null){
			return null;
		}
		
		try{
			return Integer.parseInt(str);
			
		}catch(Exception e){
			return null;
		}
		
		
	}
	
	
	public static String StrToHour(String str,Boolean flag){
		if(str==null||str.length()<1){
			return null;
		}
		
		if(flag==null){
			return null;
		}else
		if(flag){
			return str+"  00:00:00";
		}else{
			return str+"  23:59:59";
		}
		
		
		
	}
	
	public static String isNotNull(String str){
		if(str==null||str.length()<1){
			return null;
		}
		else{
			return str;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		
	}

}

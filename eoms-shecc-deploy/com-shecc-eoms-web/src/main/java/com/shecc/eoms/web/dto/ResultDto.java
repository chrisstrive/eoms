/**
 * Project Name:com-shecc-eoms-web
 * File Name:ResultDto.java
 * Package Name:com.shecc.eoms.web.dto
 * Date:2016年11月29日上午11:40:44
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.dto;

/**
 * ClassName: ResultDto <br/>
 * Function: AJAX调用返回结果DTO. <br/>
 * date: 2016年11月29日 上午11:40:44 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public class ResultDto {
	private String errCode;
	private String errMsg;
	private boolean resultBool;
	private Object resultObj;
	
	public ResultDto(){
		this.resultBool=false;
	}
	
	public ResultDto(String errCode,String errMsg){
		this.resultBool=false;
		this.errCode=errCode;
		this.errMsg=errMsg;
	}
	
	public ResultDto(Object resultObj){
		this.resultObj=resultObj;
		this.resultBool=true;
	}
	
	public void setErrResultDto(String errCode,String errMsg){
		this.resultBool=false;
		this.errCode=errCode;
		this.errMsg=errMsg;
	}
	
	public void setSuccessResultDto(Object resultObj){
		this.resultObj=resultObj;
		this.resultBool=true;
	}
	
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public boolean isResultBool() {
		return resultBool;
	}
	public void setResultBool(boolean resultBool) {
		this.resultBool = resultBool;
	}

	public Object getResultObj() {
		return resultObj;
	}

	public void setResultObj(Object resultObj) {
		this.resultObj = resultObj;
	}
}


/**
 * Project Name:com-shecc-eoms-web
 * File Name:FileBean.java
 * Package Name:com.shecc.eoms.web.dto
 * Date:2016年11月29日上午11:38:52
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName: FileBean <br/>
 * Function: 文件传输DTO。 <br/>
 * date: 2016年11月29日 上午11:38:52 <br/>
 *
 * @author chris
 * @version
 * @since JDK 1.6
 */
public class FileBean {
	private String fName;

	private MultipartFile file;

	private String attachment;
	
	private String fileType;

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public MultipartFile getFile() {
		return file;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}

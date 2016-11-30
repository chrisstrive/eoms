/**
 * Project Name:com-shecc-eoms-web
 * File Name:UnifiedFileSystem.java
 * Package Name:com.shecc.eoms.web.utils
 * Date:2016年11月29日下午1:27:49
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

import com.shecc.eoms.core.enums.FileTypeEnum;
import com.shecc.eoms.web.dto.FileBean;
import com.shecc.eoms.web.exception.AppException;

/**
 * ClassName: UnifiedFileSystem <br/>
 * Function: 统一文件管理系统. <br/>
 * date: 2016年11月29日 下午1:27:49 <br/>
 *
 * @author chris
 * @version
 * @since JDK 1.6
 */
public class UnifiedFileSystem {
	private final static String FILE_PATH_PREFIX = "/data/eoms/upload/";

	/**
	 * 
	 * upload:上传文件并返回文件保存路径.目前规则为/data/eoms/upload/$文件分类/$上传日期/uuid.$文件扩展名 <br/>
	 *
	 * @author chris
	 * @param fileBean
	 * @return
	 * @throws AppException
	 * @throws IOException
	 * @since JDK 1.6
	 */
	public static String upload(FileBean fileBean) throws AppException, IOException {
		String filePath = buildFilePath(fileBean);
		FileUtils.writeByteArrayToFile(new File(filePath), fileBean.getFile()
				.getBytes());
		return filePath;
	}

	private static String buildFilePath(FileBean fileBean) throws AppException {
		String fileName = fileBean.getFile().getOriginalFilename();
		if (StringUtils.isBlank(fileName)) {
			throw new AppException("文件名不能为空");
		}
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		String middle = FileTypeEnum.getFileTypeEnum(fileBean.getFileType())
				.getDir()
				+ "/"
				+ new DateTime().toString("yyyyMMdd")
				+ "/"
				+ UUID.randomUUID().toString();
		String filePath = FILE_PATH_PREFIX + middle + suffix;
		return filePath;
	}
}
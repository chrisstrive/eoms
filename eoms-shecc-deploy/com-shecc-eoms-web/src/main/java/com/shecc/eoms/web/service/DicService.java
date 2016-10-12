package com.shecc.eoms.web.service;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.model.Dic;


/**
 *
 * USER zxc
 * DATE 2014-7-31 下午02:42:41
 * INFO com.shecc.eoms.web.service UserService.java
 * REMARK 
 *
 */
public interface DicService {
	
	
	/**
	 * 创建字典
	 * @param user
	 * @return TODO
	 */
	public Integer createDicRnTx(Dic dic);
	
	
	
	/**
	 * 查询字典
	 * @param map TODO
	 * @return
	 */
	public String queryDic(Map map,Page page);
	
	/**
	 * 查询数据字典类型
	 * @return
	 */
	public List<Dic> queryDicType();
	
	

	/**
	 * 通过主键查字典信息
	 * @param map TODO
	 * @return
	 */
	public Dic findById(Integer id);
	
	public  void init();
	
	public void updateDicRnTx(Dic dic);
	
	public void deleteDicRnTx(Dic dic);
	
	/*
	 * 数据字典重新加载
	 */
	public void reBuildDic(ServletContext context);
	
}


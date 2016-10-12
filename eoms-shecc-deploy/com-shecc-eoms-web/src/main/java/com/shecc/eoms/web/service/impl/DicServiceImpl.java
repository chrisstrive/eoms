package com.shecc.eoms.web.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletContext;

import com.shecc.eoms.web.common.SpringContextUtil;
import com.shecc.eoms.web.common.utils.JSONUtil;
import com.shecc.eoms.web.service.DicService;
import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.dao.DicDAOImpl;
import com.shecc.eoms.core.model.Dic;

/**
 *
 * USER ray ray1192@163.com
 * DATE 2014-2-11 下午02:43:00
 * INFO com.shecc.eoms.web.service.impl UserServiceImpl.java
 * REMARK 
 *
 */
public class DicServiceImpl implements DicService{
	
	
	private DicDAOImpl dicDao;

	

	public DicDAOImpl getDicDao() {
		return dicDao;
	}

	public void setDicDao(DicDAOImpl dicDao) {
		this.dicDao = dicDao;
	}

	@Override
	public Integer createDicRnTx(Dic dic) {
		Integer id=	dicDao.add(dic);
		return id;
	}

	@Override
	public void updateDicRnTx(Dic dic){
		dicDao.updateById(dic);
	}
	
	@Override
	public void deleteDicRnTx(Dic dic){
		dicDao.delete(dic.getId());
	}
	
	@Override
	public String queryDic(Map map,Page page) {
		List<Dic> dataList = this.dicDao.findByCriteriaMapReturnObj(map, page, "queryDicForPage");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("pageData", dataList);
		dataMap.put("pageCount", page.getTotalRecord());
		String result = JSONUtil.toJSonString(dataMap);
		return result;
	}

	@Override
	public Dic findById(Integer id) {
		Dic dic=dicDao.findById(id);
		return dic;
	}
	
	
	@Override
	public  void init(){
		dicDao.initDic();
	}

	@Override
	public List<Dic> queryDicType() {
		List<Dic> dataList = this.dicDao.findByCriteriaAndSqlId(null, "queryDicType");
		return dataList;
	}
	
	/*
	 * 数据字典重新加载
	 */
	public void reBuildDic(ServletContext context){	
		this.init();
		Set<Entry<Integer, List<Dic>>> set=	DicDAOImpl.DICCOMM.entrySet();
		Iterator<Entry<Integer, List<Dic>>> iteerator= set.iterator();
		while(iteerator.hasNext()){
			Entry<Integer, List<Dic>>  entry=	iteerator.next();
			if(entry!=null){
				context.setAttribute("dic"+String.valueOf(entry.getKey()), entry.getValue());
			}
		}
		
		DicDAOImpl.DICCOMM.clear();
	}
}


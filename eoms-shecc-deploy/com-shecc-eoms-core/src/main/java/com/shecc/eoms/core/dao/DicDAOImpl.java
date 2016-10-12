package com.shecc.eoms.core.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.common.ibaits.impl.DefaultBaseDAOImpl;
import com.shecc.eoms.core.model.Dic;


/**
 *
 * USER  zxc
 * DATE 2014-7-31 上午09:13:02
 * INFO com.shecc.eoms.core.dao.DaibanshixiangDAOImpl.java
 * REMARK 
 *
 */
public class DicDAOImpl  extends DefaultBaseDAOImpl<Dic>{
	public static Map<Integer,List<Dic>> DICCOMM=new HashMap<Integer,List<Dic>>();

	public int add(Dic dic ) {  
		  
	    int result = 0;  	   
	        result = Integer.parseInt(this.getSqlMapClientTemplate().insert(this.namespace.concat("insertSelective"), dic)+"");  
	  
	    return result;  
	}
	
	public Dic findById(Integer id){
		Dic dic=	(Dic)this.getSqlMapClientTemplate().queryForObject(this.namespace.concat("findById"),id);
		return dic;
	}
	
	public List<Dic> findByType(Integer type){
		List<Dic> list=(List<Dic>)this.getSqlMapClientTemplate().queryForList(this.namespace.concat("findByType"), type);
		return list;
	}
	
	
	public List<Dic> query(Map map){
		List<Dic> list=(List<Dic>)this.getSqlMapClientTemplate().queryForList(this.namespace.concat("findByType"), map);
		return list;
	}
	
	public void updateById(Dic dic){
		this.getSqlMapClientTemplate().update(this.namespace.concat("updateByid"), dic);
		
	}
	
	public void delete(Integer id){
		this.getSqlMapClientTemplate().update(this.namespace.concat("deleteStatus"), id);
	}
	
	public  void initDic(){
		Map map=new HashMap();
		Page page=new Page();
		page.setPageSize(100000);
		List<Dic> list=(List<Dic>)this.findByCriteriaMapReturnObj(map, page, "queryDicForPage");
		if(list!=null&&list.size()>0){
		synchronized(DICCOMM){
			List<Dic> dicList=new ArrayList<Dic>();
			Integer type=0;
			for(Dic dic:list){
				if(type==0){
					type=dic.getType();
					dicList.add(dic);
				}else{
					if(type.equals(dic.getType())){
						dicList.add(dic);
					}else{
						DicDAOImpl.DICCOMM.put(type, dicList);
						type=dic.getType();
						dicList=new ArrayList<Dic>();
						dicList.add(dic);
					}
				}
				
				
			}
			if(dicList.size()>0){
				DicDAOImpl.DICCOMM.put(type, dicList);
			}
			
			
		}
		}
		
	}
	

}


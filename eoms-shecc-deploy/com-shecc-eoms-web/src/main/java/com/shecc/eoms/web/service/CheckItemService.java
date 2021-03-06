/**
 * Project Name:com-shecc-eoms-web
 * File Name:CheckItemService.java
 * Package Name:com.shecc.eoms.web.service
 * Date:2016年11月17日下午2:19:43
 * Copyright (c) 2016, www.hnapay.com All Rights Reserved.
 *
 */

package com.shecc.eoms.web.service;

import java.util.List;

import com.shecc.eoms.core.common.Page;
import com.shecc.eoms.core.model.CheckItem;
import com.shecc.eoms.core.model.CheckItemCriteria;

/**
 * ClassName: CheckItemService <br/>
 * Function: 检查项信息管理服务接口. <br/>
 * date: 2016年11月17日 下午2:19:43 <br/>
 *
 * @author chris
 * @version 
 * @since JDK 1.6
 */
public interface CheckItemService {
	/**
	 * 
	 * createEntityRnTx:创建信息. <br/>
	 *
	 * @author chris
	 * @param entity
	 *            要创建的信息
	 * @return
	 * @since JDK 1.6
	 */
	Integer createRnTx(CheckItem entity);

	/**
	 * 
	 * updateEntityRnTx:更新信息. <br/>
	 *
	 * @author chris
	 * @param entity
	 *            带主键和需要更新的字段的信息。
	 * @return
	 * @since JDK 1.6
	 */
	boolean updateRnTx(CheckItem entity);

	/**
	 * 
	 * queryAllForPage:分页查询信息. <br/>
	 *
	 * @author chris
	 * @param criteria
	 *            查询条件
	 * @param page
	 *            分页信息
	 * @return
	 * @since JDK 1.6
	 */
	String queryAllForPage(CheckItemCriteria criteria, Page page);

	/**
	 * 
	 * findById:查询指定的信息. <br/>
	 *
	 * @author chris
	 * @param id
	 * @return
	 * @since JDK 1.6
	 */
	CheckItem findById(Integer id);

	/**
	 * 
	 * queryAll:根据条件查询所有信息. <br/>
	 *
	 * @author chris
	 * @param criteria
	 *            查询条件
	 * @return
	 * @since JDK 1.6
	 */
	List<CheckItem> queryAll(CheckItemCriteria criteria);
	
	/**
	 * 
	 * queryByModelId:根据型号编号查询对应的检查项. <br/>
	 *
	 * @author chris
	 * @param modelId	要查询的型号编号
	 * @return	2个list的集合，第一个为属于此型号的检查项集合，第二个为不属于此型号的检查项集合。
	 * @since JDK 1.6
	 */
	List<List<CheckItem>> queryByModelId(int modelId);

	/**
	 * 
	 * addRelModelChkRnTx:关联型号对应的检查项. <br/>
	 * 先删除已绑定的关联，然后新建关联.<br/>
	 *
	 * @author chris
	 * @param checkItemIds
	 * @param modelId
	 * @since JDK 1.6
	 */
	void addRelModelChkRnTx(String[] checkItemIds, Integer modelId);
}


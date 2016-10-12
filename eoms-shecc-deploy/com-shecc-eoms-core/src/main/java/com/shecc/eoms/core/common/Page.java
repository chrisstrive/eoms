package com.shecc.eoms.core.common;

import java.io.Serializable;

public class Page implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8007944048337473098L;

	// 记录总数
	private Integer totalRecord = new Integer(0);

	// 页码
	private Integer targetPage = new Integer(1);

	// 默认每页显示记录数
	private Integer pageSize = new Integer(10);
	
	public Page(){
	}
	
	/**
	 * 构造翻页对象
	 * @param totalRecord  总记录数
	 * @param targetPage   页码
	 * @param pageSize     每页记录数
	 */
	public Page(int totalRecord,int targetPage,int pageSize){
		this.totalRecord = totalRecord;
		this.targetPage = targetPage;
		this.pageSize = pageSize;
	}
	
	/**
	 * 构造翻页对象
	 * @param targetPage   目标页码
	 * @param pageSize     每页记录数
	 */
	public Page(int targetPage,int pageSize){
		this.targetPage = targetPage;
		this.pageSize = pageSize;
	}

	/**
	 * @return Returns the page_size.
	 */
	public int getPageSize() {
		return pageSize.intValue();
	}

	/**
	 * @param pageSize
	 *            The pageSize to set.
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = new Integer(pageSize);
	}

	/**
	 * @return Returns the targetPage.
	 */
	public int getTargetPage() {
		return targetPage.intValue();
	}

	/**
	 * @param targetPage
	 *            The targetPage to set.
	 */
	public void setTargetPage(int targetPage) {
		this.targetPage = new Integer(targetPage);
	}

	/**
	 * @return Returns the totalPage.
	 */
	public int getTotalPage() {
		if (totalRecord.intValue() <= 0) {
			return 0;
		} else {
			return ((totalRecord.intValue() - 1) / pageSize.intValue()) + 1;
		}
	}

	/**
	 * @return Returns the totalRecord.
	 */
	public int getTotalRecord() {
		return totalRecord.intValue();
	}

	/**
	 * @param totalRecord
	 *            The totalRecord to set.
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = new Integer(totalRecord);
	}

	/**
	 * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从0开始.
	 */
	public int getFirst() {
		return ((targetPage - 1) * pageSize);
	}

	/**
	 * 是否还有下一页.
	 */
	public boolean isHasNext() {
		return (targetPage + 1 <= getTotalPage());
	}

	/**
	 * 取得下页的页号,序号从1开始.
	 */
	public int getNextPage() {
		if (isHasNext())
			return targetPage + 1;
		else
			return targetPage;
	}

	/**
	 * 是否还有上一页.
	 */
	public boolean isHasPre() {
		return (targetPage - 1 >= 1);
	}

	/**
	 * 取得上页的页号,序号从1开始.
	 */
	public int getPrePage() {
		if (isHasPre())
			return targetPage - 1;
		else
			return targetPage;
	}

	/**
	 * 取得当前记录索引.
	 */
	public int currentRecordIndex() {
		return pageSize * (targetPage - 1);
	}
	
	/**
	 * 取得最大记录索引
	 * @return
	 */
	public int getMaxRecordIndex(){
		return pageSize * targetPage;
	}
}

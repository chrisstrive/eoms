/**
 * 
 */
package com.shecc.eoms.web.enums;

/**
 * <p>注释</p>
 * @author yc.gao
 * @version $Id: EntryBoxPlanStatusEnum.java, v 0.1 2015年1月11日 下午1:58:59 K555 Exp $
 */
public enum delStatusEnum {
	DELETED("0"), // 1-已删除
	NORMAL("1"); // 2-正常
    
    private String status;
    
    public String getStatus() {
        return status;
    }
    
    private delStatusEnum(String status) {
        this.status = status;
    }
}

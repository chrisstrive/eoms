package com.shecc.eoms.core.model;

import java.io.Serializable;

public class RelSYstemCustomerKey implements Serializable {
    /**
     * 客户编号
     */
    private Integer customerId;

    /**
     * 系统编号
     */
    private Integer systemId;

    private static final long serialVersionUID = 1L;

    /**
     * <b>获取</b> 客户编号
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * <b>设置</b> 客户编号
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * <b>获取</b> 系统编号
     */
    public Integer getSystemId() {
        return systemId;
    }

    /**
     * <b>设置</b> 系统编号
     */
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }
}
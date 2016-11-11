package com.shecc.eoms.core.model;

import java.io.Serializable;

public class RelUserKey implements Serializable {
    /**
     * 下级用户编号
     */
    private Integer subUid;

    /**
     * 上级用户编号
     */
    private Integer upUid;

    private static final long serialVersionUID = 1L;

    /**
     * <b>获取</b> 下级用户编号
     */
    public Integer getSubUid() {
        return subUid;
    }

    /**
     * <b>设置</b> 下级用户编号
     */
    public void setSubUid(Integer subUid) {
        this.subUid = subUid;
    }

    /**
     * <b>获取</b> 上级用户编号
     */
    public Integer getUpUid() {
        return upUid;
    }

    /**
     * <b>设置</b> 上级用户编号
     */
    public void setUpUid(Integer upUid) {
        this.upUid = upUid;
    }
}
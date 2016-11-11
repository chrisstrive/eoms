package com.shecc.eoms.core.model;

import java.io.Serializable;

public class AreaCity extends AreaCityKey implements Serializable {
    /**
     * 电信区号
     */
    private String teleCode;

    /**
     * 当前名字
     */
    private String currentName;

    /**
     * 父亲代码
     */
    private String parentCode;

    private static final long serialVersionUID = 1L;

    /**
     * <b>获取</b> 电信区号
     */
    public String getTeleCode() {
        return teleCode;
    }

    /**
     * <b>设置</b> 电信区号
     */
    public void setTeleCode(String teleCode) {
        this.teleCode = teleCode;
    }

    /**
     * <b>获取</b> 当前名字
     */
    public String getCurrentName() {
        return currentName;
    }

    /**
     * <b>设置</b> 当前名字
     */
    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    /**
     * <b>获取</b> 父亲代码
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * <b>设置</b> 父亲代码
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
}
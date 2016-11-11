package com.shecc.eoms.core.model;

import java.io.Serializable;

public class AreaCityKey implements Serializable {
    /**
     * 代码标识<br>
	 *             1-省<br>
	 *             2-城市
     */
    private String codeFlag;

    /**
     * 当前代码
     */
    private String currentCode;

    private static final long serialVersionUID = 1L;

    /**
     * <b>获取</b> 代码标识<br>
	 *             1-省<br>
	 *             2-城市
     */
    public String getCodeFlag() {
        return codeFlag;
    }

    /**
     * <b>设置</b> 代码标识<br>
	 *             1-省<br>
	 *             2-城市
     */
    public void setCodeFlag(String codeFlag) {
        this.codeFlag = codeFlag;
    }

    /**
     * <b>获取</b> 当前代码
     */
    public String getCurrentCode() {
        return currentCode;
    }

    /**
     * <b>设置</b> 当前代码
     */
    public void setCurrentCode(String currentCode) {
        this.currentCode = currentCode;
    }
}
package com.shecc.eoms.core.model;

import java.io.Serializable;

public class RelModelChkKey implements Serializable {
    /**
     * 检查项编号
     */
    private Integer chkId;

    /**
     * 型号编号
     */
    private Integer modelId;

    private static final long serialVersionUID = 1L;

    /**
     * <b>获取</b> 检查项编号
     */
    public Integer getChkId() {
        return chkId;
    }

    /**
     * <b>设置</b> 检查项编号
     */
    public void setChkId(Integer chkId) {
        this.chkId = chkId;
    }

    /**
     * <b>获取</b> 型号编号
     */
    public Integer getModelId() {
        return modelId;
    }

    /**
     * <b>设置</b> 型号编号
     */
    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }
}
package com.shecc.eoms.core.model;

import java.io.Serializable;

public class RelProjectManagerKey implements Serializable {
    /**
     * 项目经理编号
     */
    private Integer managerId;

    /**
     * 项目编号
     */
    private Integer projectId;

    private static final long serialVersionUID = 1L;

    /**
     * <b>获取</b> 项目经理编号
     */
    public Integer getManagerId() {
        return managerId;
    }

    /**
     * <b>设置</b> 项目经理编号
     */
    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    /**
     * <b>获取</b> 项目编号
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * <b>设置</b> 项目编号
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
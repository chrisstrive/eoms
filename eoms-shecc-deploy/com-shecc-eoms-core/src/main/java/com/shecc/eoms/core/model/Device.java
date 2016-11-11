package com.shecc.eoms.core.model;

import java.io.Serializable;
import java.util.Date;

public class Device implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 所属品牌编号
     */
    private Integer brandId;

    /**
     * 所属品牌名称
     */
    private String brandName;

    /**
     * 所属项目编号
     */
    private Integer modelId;

    /**
     * 所属项目名称
     */
    private String modelName;

    /**
     * 所属项目编号
     */
    private Integer systemId;

    /**
     * 所属项目名称
     */
    private String systemName;

    /**
     * 所属系统类型编号
     */
    private Integer sysTypeId;

    /**
     * 所属系统类型名称
     */
    private String sysTypeName;

    /**
     * 位置编号
     */
    private Integer locationId;

    /**
     * 启用时间
     */
    private Date startTime;

    /**
     * 配置信息
     */
    private String config;

    /**
     * 文档
     */
    private String document;

    /**
     * 图片
     */
    private String picture;

    /**
     * 供应商
     */
    private String supplier;

    /**
     * 维修时间
     */
    private Date repairTime;

    /**
     * 巡检时间
     */
    private Date routingTime;

    /**
     * 维护时间
     */
    private Date maintainTime;

    /**
     * 录入人编号
     */
    private Integer inputUid;

    /**
     * 录入人姓名
     */
    private String inputUname;

    /**
     * 录入时间
     */
    private Date inputTime;

    /**
     * 审核人编号
     */
    private Integer checkUid;

    /**
     * 审核人姓名
     */
    private String checkUname;

    /**
     * 审核时间
     */
    private Date checkTime;

    /**
     * 最后修改人编号
     */
    private Integer lastModifyUid;

    /**
     * 最后修改人姓名
     */
    private String lastModifyUname;

    /**
     * 最后修改时间
     */
    private Date lastModifyTime;

    /**
     * 归档标志。1-未归档；2-已归档。
     */
    private String archiveFlag;

    /**
     * 归档人编号
     */
    private Integer archiveUid;

    /**
     * 归档人姓名
     */
    private String archiveUname;

    /**
     * 归档时间
     */
    private Date archiveTime;

    /**
     * 原记录编号
     */
    private Integer lRecordNo;

    /**
     * 备注
     */
    private String remark;

    /**
     * 保留域1
     */
    private String resvFld1;

    /**
     * 保留域2
     */
    private String resvFld2;

    private static final long serialVersionUID = 1L;

    /**
     * <b>获取</b> 编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * <b>设置</b> 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <b>获取</b> 设备名称
     */
    public String getName() {
        return name;
    }

    /**
     * <b>设置</b> 设备名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <b>获取</b> 所属品牌编号
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * <b>设置</b> 所属品牌编号
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * <b>获取</b> 所属品牌名称
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * <b>设置</b> 所属品牌名称
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * <b>获取</b> 所属项目编号
     */
    public Integer getModelId() {
        return modelId;
    }

    /**
     * <b>设置</b> 所属项目编号
     */
    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    /**
     * <b>获取</b> 所属项目名称
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * <b>设置</b> 所属项目名称
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * <b>获取</b> 所属项目编号
     */
    public Integer getSystemId() {
        return systemId;
    }

    /**
     * <b>设置</b> 所属项目编号
     */
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    /**
     * <b>获取</b> 所属项目名称
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * <b>设置</b> 所属项目名称
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    /**
     * <b>获取</b> 所属系统类型编号
     */
    public Integer getSysTypeId() {
        return sysTypeId;
    }

    /**
     * <b>设置</b> 所属系统类型编号
     */
    public void setSysTypeId(Integer sysTypeId) {
        this.sysTypeId = sysTypeId;
    }

    /**
     * <b>获取</b> 所属系统类型名称
     */
    public String getSysTypeName() {
        return sysTypeName;
    }

    /**
     * <b>设置</b> 所属系统类型名称
     */
    public void setSysTypeName(String sysTypeName) {
        this.sysTypeName = sysTypeName;
    }

    /**
     * <b>获取</b> 位置编号
     */
    public Integer getLocationId() {
        return locationId;
    }

    /**
     * <b>设置</b> 位置编号
     */
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    /**
     * <b>获取</b> 启用时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * <b>设置</b> 启用时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * <b>获取</b> 配置信息
     */
    public String getConfig() {
        return config;
    }

    /**
     * <b>设置</b> 配置信息
     */
    public void setConfig(String config) {
        this.config = config;
    }

    /**
     * <b>获取</b> 文档
     */
    public String getDocument() {
        return document;
    }

    /**
     * <b>设置</b> 文档
     */
    public void setDocument(String document) {
        this.document = document;
    }

    /**
     * <b>获取</b> 图片
     */
    public String getPicture() {
        return picture;
    }

    /**
     * <b>设置</b> 图片
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * <b>获取</b> 供应商
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * <b>设置</b> 供应商
     */
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    /**
     * <b>获取</b> 维修时间
     */
    public Date getRepairTime() {
        return repairTime;
    }

    /**
     * <b>设置</b> 维修时间
     */
    public void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }

    /**
     * <b>获取</b> 巡检时间
     */
    public Date getRoutingTime() {
        return routingTime;
    }

    /**
     * <b>设置</b> 巡检时间
     */
    public void setRoutingTime(Date routingTime) {
        this.routingTime = routingTime;
    }

    /**
     * <b>获取</b> 维护时间
     */
    public Date getMaintainTime() {
        return maintainTime;
    }

    /**
     * <b>设置</b> 维护时间
     */
    public void setMaintainTime(Date maintainTime) {
        this.maintainTime = maintainTime;
    }

    /**
     * <b>获取</b> 录入人编号
     */
    public Integer getInputUid() {
        return inputUid;
    }

    /**
     * <b>设置</b> 录入人编号
     */
    public void setInputUid(Integer inputUid) {
        this.inputUid = inputUid;
    }

    /**
     * <b>获取</b> 录入人姓名
     */
    public String getInputUname() {
        return inputUname;
    }

    /**
     * <b>设置</b> 录入人姓名
     */
    public void setInputUname(String inputUname) {
        this.inputUname = inputUname;
    }

    /**
     * <b>获取</b> 录入时间
     */
    public Date getInputTime() {
        return inputTime;
    }

    /**
     * <b>设置</b> 录入时间
     */
    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    /**
     * <b>获取</b> 审核人编号
     */
    public Integer getCheckUid() {
        return checkUid;
    }

    /**
     * <b>设置</b> 审核人编号
     */
    public void setCheckUid(Integer checkUid) {
        this.checkUid = checkUid;
    }

    /**
     * <b>获取</b> 审核人姓名
     */
    public String getCheckUname() {
        return checkUname;
    }

    /**
     * <b>设置</b> 审核人姓名
     */
    public void setCheckUname(String checkUname) {
        this.checkUname = checkUname;
    }

    /**
     * <b>获取</b> 审核时间
     */
    public Date getCheckTime() {
        return checkTime;
    }

    /**
     * <b>设置</b> 审核时间
     */
    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    /**
     * <b>获取</b> 最后修改人编号
     */
    public Integer getLastModifyUid() {
        return lastModifyUid;
    }

    /**
     * <b>设置</b> 最后修改人编号
     */
    public void setLastModifyUid(Integer lastModifyUid) {
        this.lastModifyUid = lastModifyUid;
    }

    /**
     * <b>获取</b> 最后修改人姓名
     */
    public String getLastModifyUname() {
        return lastModifyUname;
    }

    /**
     * <b>设置</b> 最后修改人姓名
     */
    public void setLastModifyUname(String lastModifyUname) {
        this.lastModifyUname = lastModifyUname;
    }

    /**
     * <b>获取</b> 最后修改时间
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * <b>设置</b> 最后修改时间
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * <b>获取</b> 归档标志。1-未归档；2-已归档。
     */
    public String getArchiveFlag() {
        return archiveFlag;
    }

    /**
     * <b>设置</b> 归档标志。1-未归档；2-已归档。
     */
    public void setArchiveFlag(String archiveFlag) {
        this.archiveFlag = archiveFlag;
    }

    /**
     * <b>获取</b> 归档人编号
     */
    public Integer getArchiveUid() {
        return archiveUid;
    }

    /**
     * <b>设置</b> 归档人编号
     */
    public void setArchiveUid(Integer archiveUid) {
        this.archiveUid = archiveUid;
    }

    /**
     * <b>获取</b> 归档人姓名
     */
    public String getArchiveUname() {
        return archiveUname;
    }

    /**
     * <b>设置</b> 归档人姓名
     */
    public void setArchiveUname(String archiveUname) {
        this.archiveUname = archiveUname;
    }

    /**
     * <b>获取</b> 归档时间
     */
    public Date getArchiveTime() {
        return archiveTime;
    }

    /**
     * <b>设置</b> 归档时间
     */
    public void setArchiveTime(Date archiveTime) {
        this.archiveTime = archiveTime;
    }

    /**
     * <b>获取</b> 原记录编号
     */
    public Integer getlRecordNo() {
        return lRecordNo;
    }

    /**
     * <b>设置</b> 原记录编号
     */
    public void setlRecordNo(Integer lRecordNo) {
        this.lRecordNo = lRecordNo;
    }

    /**
     * <b>获取</b> 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <b>设置</b> 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * <b>获取</b> 保留域1
     */
    public String getResvFld1() {
        return resvFld1;
    }

    /**
     * <b>设置</b> 保留域1
     */
    public void setResvFld1(String resvFld1) {
        this.resvFld1 = resvFld1;
    }

    /**
     * <b>获取</b> 保留域2
     */
    public String getResvFld2() {
        return resvFld2;
    }

    /**
     * <b>设置</b> 保留域2
     */
    public void setResvFld2(String resvFld2) {
        this.resvFld2 = resvFld2;
    }
}
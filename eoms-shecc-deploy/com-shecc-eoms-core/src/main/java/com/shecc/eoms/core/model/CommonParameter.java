package com.shecc.eoms.core.model;

import java.io.Serializable;
import java.util.Date;

public class CommonParameter implements Serializable {
    /**
     * 记录编号
     */
    private Integer recordNo;

    /**
     * 参数代码
     */
    private String paraCode;

    /**
     * 参数名称
     */
    private String paraName;

    /**
     * 参数值
     */
    private String paraValue;

    /**
     * 状态<br>
	 *             A-新建待审核<br>
	 *             B-停用待审核<br>
	 *             C-启用待审核<br>
	 *             Z-作废待审核<br>
	 *             0-审核未通过<br>
	 *             1-正常<br>
	 *             2-停用<br>
	 *             9-作废
     */
    private String status;

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
     * <b>获取</b> 记录编号
     */
    public Integer getRecordNo() {
        return recordNo;
    }

    /**
     * <b>设置</b> 记录编号
     */
    public void setRecordNo(Integer recordNo) {
        this.recordNo = recordNo;
    }

    /**
     * <b>获取</b> 参数代码
     */
    public String getParaCode() {
        return paraCode;
    }

    /**
     * <b>设置</b> 参数代码
     */
    public void setParaCode(String paraCode) {
        this.paraCode = paraCode;
    }

    /**
     * <b>获取</b> 参数名称
     */
    public String getParaName() {
        return paraName;
    }

    /**
     * <b>设置</b> 参数名称
     */
    public void setParaName(String paraName) {
        this.paraName = paraName;
    }

    /**
     * <b>获取</b> 参数值
     */
    public String getParaValue() {
        return paraValue;
    }

    /**
     * <b>设置</b> 参数值
     */
    public void setParaValue(String paraValue) {
        this.paraValue = paraValue;
    }

    /**
     * <b>获取</b> 状态<br>
	 *             A-新建待审核<br>
	 *             B-停用待审核<br>
	 *             C-启用待审核<br>
	 *             Z-作废待审核<br>
	 *             0-审核未通过<br>
	 *             1-正常<br>
	 *             2-停用<br>
	 *             9-作废
     */
    public String getStatus() {
        return status;
    }

    /**
     * <b>设置</b> 状态<br>
	 *             A-新建待审核<br>
	 *             B-停用待审核<br>
	 *             C-启用待审核<br>
	 *             Z-作废待审核<br>
	 *             0-审核未通过<br>
	 *             1-正常<br>
	 *             2-停用<br>
	 *             9-作废
     */
    public void setStatus(String status) {
        this.status = status;
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
package com.zlst.activiti.extension.cpsbpmprocess.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.zlst.common.enums.EnableStateType;

@Entity
public class CpsBpmProcessVo {
	@Id
	private String bpmProcessNo; // BPM模板编码
	private String bpmProcessVer ; // BPM模板版本号
	private String processName; // 模板名称(modelName)
	private String  pfsEventId; // PFS事件id
	private String  pfsEventName; // PFS事件名称
	private String  tpltNo; // 定单模板编号
	private String  notes; // 备注
	private Date  createDate; //创建时间 
	private Date  modifyDate; // 更新时间
	private String  createdBy; // 创建人
	private String  modifiedBy; // 修改人
	private String  enableState; //启动状态（A：启动，X未启动）
	private String  enableStateName; //启动状态名称（A：启动，X未启动）
	private Integer modelType; // 模板类型
	private String processKey; // modelKey
	
	public CpsBpmProcessVo() { }

	public CpsBpmProcessVo(String bpmProcessNo, String processName, String pfsEventId, String pfsEventName,
			String tpltNo, String notes, Date createDate, Date modifyDate, String enableState,
			Integer modelType, String processKey) {
		this.bpmProcessNo = bpmProcessNo;
		this.processName = processName;
		this.pfsEventId = pfsEventId;
		this.pfsEventName = pfsEventName;
		this.tpltNo = tpltNo;
		this.notes = notes;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.enableState = enableState;
		this.modelType = modelType;
		this.processKey = processKey;
	}

	public String getBpmProcessNo() {
		return bpmProcessNo;
	}

	public void setBpmProcessNo(String bpmProcessNo) {
		this.bpmProcessNo = bpmProcessNo;
	}

	public String getBpmProcessVer() {
		return bpmProcessVer;
	}

	public void setBpmProcessVer(String bpmProcessVer) {
		this.bpmProcessVer = bpmProcessVer;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getPfsEventId() {
		return pfsEventId;
	}

	public void setPfsEventId(String pfsEventId) {
		this.pfsEventId = pfsEventId;
	}

	public String getPfsEventName() {
		return pfsEventName;
	}

	public void setPfsEventName(String pfsEventName) {
		this.pfsEventName = pfsEventName;
	}

	public String getTpltNo() {
		return tpltNo;
	}

	public void setTpltNo(String tpltNo) {
		this.tpltNo = tpltNo;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getEnableState() {
		return enableState;
	}

	public void setEnableState(String enableState) {
		this.enableState = enableState;
	}

	public String getEnableStateName() {
		return enableStateName;
	}

	public void setEnableStateName(String enableStateName) {
		this.enableStateName = enableStateName;
	}

	public Integer getModelType() {
		return modelType;
	}

	public void setModelType(Integer modelType) {
		this.modelType = modelType;
	}

	public String getProcessKey() {
		return processKey;
	}

	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}

}

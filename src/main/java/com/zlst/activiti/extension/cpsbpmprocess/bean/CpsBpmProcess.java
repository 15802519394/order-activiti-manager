package com.zlst.activiti.extension.cpsbpmprocess.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/**
 * PFS事件与工作流模板的关联对象表
 * @author 170285
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "CPS_BPM_PROCESS")
@IdClass(CpsBpmProcessKey.class) // 联合主键
public class CpsBpmProcess {
	
	@Id
	@Column(name="BPM_PROCESS_NO",length=32)
	private String bpmProcessNo; // BPM模板编码
	
	@Column(name="BPM_PROCESS_VER",length=32)
	private String bpmProcessVer ; // BPM模板版本号
	
	@Column(name="PROCESS_NAME",length=32)
	private String  processName; // 模板名称
	
	@Id
	@Column(name="PFS_EVENT_ID",length=32)
	private String  pfsEventId; // PFS事件id
	
	@Column(name="TPLT_NO",length=32)
	private String  tpltNo; // 定单模板编号
	
	@Column(name="NOTES",length=32)
	private String  notes; // 备注
	
	@Column(name="CREATE_DATE",length=32)
	private Date createDate; //创建时间 
	
	@Column(name="MODIFY_DATE",length=32)
	private Date modifyDate; // 更新时间
	
	@Column(name="CREATED_BY",length=32)
	private String  createdBy; // 创建人
	
	@Column(name="MODIFIED_BY",length=32)
	private String  modifiedBy; // 修改人
	
	@Column(name="ENABLE_STATE",length=32)
	private String  enableState; //启动状态（A：启动，X未启动）

	public CpsBpmProcess() {
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

	public String getEnableState() {
		return enableState;
	}

	public void setEnableState(String enableState) {
		this.enableState = enableState;
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
	
	
}

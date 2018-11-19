package com.zlst.activiti.extension.cpsbpmprocess.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * PFS事件与工作流模板的关联对象表
 * @author 170285
 *
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "CPS_BPM_PROCESS")
public class CpsBpmProcess {

	@Column(name="BPM_PROCESS_NO",length=32)
	private String bpmProcessNo; // BPM模板编码
	
	@Column(name="BPM_PROCESS_VER",length=32)
	private String bpmProcessVer ; // BPM模板版本号
	
	@Column(name="PROCESS_NAME",length=32)
	private String  processName; // 模板名称
	
	@Column(name="PFS_EVENT_ID",length=32)
	private String  pfsEventId; // PFS事件id
	
	@Column(name="TPLT_NO",length=32)
	private String  tpltNo; //定单模板
	
	@Column(name="NOTES",length=32)
	private String  notes; // 备注
	
	@Column(name="CR_DATE",length=32)
	private String  crDate; //创建时间 
	
	@Column(name="MODI_DATE",length=32)
	private String  modiDate; // 更新时间
	
	@Column(name="cr_staff_no",length=32)
	private String  crStaffNo; // 创建人
	
	@Column(name="MODI_STAFF_NO",length=32)
	private String  modiStaffNo; // 修改人
	
	@Column(name="ENABLE_STATE",length=32)
	private String  enableState; //启动状态（A：启动，X未启动）

	public CpsBpmProcess() {
		super();
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

	public String getCrDate() {
		return crDate;
	}

	public void setCrDate(String crDate) {
		this.crDate = crDate;
	}

	public String getModiDate() {
		return modiDate;
	}

	public void setModiDate(String modiDate) {
		this.modiDate = modiDate;
	}

	public String getCrStaffNo() {
		return crStaffNo;
	}

	public void setCrStaffNo(String crStaffNo) {
		this.crStaffNo = crStaffNo;
	}

	public String getModiStaffNo() {
		return modiStaffNo;
	}

	public void setModiStaffNo(String modiStaffNo) {
		this.modiStaffNo = modiStaffNo;
	}

	public String getEnableState() {
		return enableState;
	}

	public void setEnableState(String enableState) {
		this.enableState = enableState;
	}
	
	
}

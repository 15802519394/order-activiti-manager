package com.zlst.activiti.extension.cpsbpmprocess.bean;

import java.io.Serializable;


public class CpsBpmProcessKey implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String bpmProcessNo; // BPM模板编码
	
	private String  pfsEventId; // PFS事件id

	public CpsBpmProcessKey() {
		super();
	}

	public String getBpmProcessNo() {
		return bpmProcessNo;
	}

	public void setBpmProcessNo(String bpmProcessNo) {
		this.bpmProcessNo = bpmProcessNo;
	}

	public String getPfsEventId() {
		return pfsEventId;
	}

	public void setPfsEventId(String pfsEventId) {
		this.pfsEventId = pfsEventId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bpmProcessNo == null) ? 0 : bpmProcessNo.hashCode());
		result = prime * result + ((pfsEventId == null) ? 0 : pfsEventId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CpsBpmProcessKey other = (CpsBpmProcessKey) obj;
		if (bpmProcessNo == null) {
			if (other.bpmProcessNo != null)
				return false;
		} else if (!bpmProcessNo.equals(other.bpmProcessNo))
			return false;
		if (pfsEventId == null) {
			if (other.pfsEventId != null)
				return false;
		} else if (!pfsEventId.equals(other.pfsEventId))
			return false;
		return true;
	}
	
}

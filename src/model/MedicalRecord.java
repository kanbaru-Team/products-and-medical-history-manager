package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MedicalRecord implements Serializable{
	
	private String generalInfo;
	private String detailInfo;
	
	public MedicalRecord(String generalInfo, String detailInfo) {
		this.generalInfo = generalInfo;
		this.detailInfo = detailInfo;
	}
	public String getGeneralInfo() {
		return generalInfo;
	}
	public void setGeneralInfo(String generalInfo) {
		this.generalInfo = generalInfo;
	}
	public String getDetailInfo() {
		return detailInfo;
	}
	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}
	
	
	
}

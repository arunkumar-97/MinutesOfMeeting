package com.example.minutesofmeeting.api.modelmessage;

import com.example.minutesofmeeting.api.model.MOM;

public class ContentRequest {
	
	private Integer contentId;
	private String contentTitle;
	private MOM mom;
	
	
	public Integer getContentId() {
		return contentId;
	}
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}
	public String getContentTitle() {
		return contentTitle;
	}
	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}
	public MOM getMom() {
		return mom;
	}
	public void setMom(MOM mom) {
		this.mom = mom;
	}
	
	
	
	

}

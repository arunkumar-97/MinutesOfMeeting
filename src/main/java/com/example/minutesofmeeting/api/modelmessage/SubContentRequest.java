package com.example.minutesofmeeting.api.modelmessage;

import com.example.minutesofmeeting.api.model.Content;

public class SubContentRequest {
	
	private Integer subContentId;
	private String subContentTitle;
	private Content content;
	
	
	
	public Integer getSubContentId() {
		return subContentId;
	}
	public void setSubContentId(Integer subContentId) {
		this.subContentId = subContentId;
	}
	public String getSubContentTitle() {
		return subContentTitle;
	}
	public void setSubContentTitle(String subContentTitle) {
		this.subContentTitle = subContentTitle;
	}
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	
	
	
	
	

}

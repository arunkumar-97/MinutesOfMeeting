package com.example.minutesofmeeting.api.modelmessage;

import com.example.minutesofmeeting.api.model.Content;
import com.example.minutesofmeeting.api.model.MOM;

public class ContentResponse extends BaseResponse{
	
	
	private Integer contentId;
	private String contentTitle;
	private MOM mom;
	
	
	public ContentResponse() {
		
	}
	
	
	public ContentResponse(int i, String string) {
		super(i,string);
	}
	
	public ContentResponse(Content content) {
		this.contentId=content.getContentId();
		this.contentTitle=content.getContentTitle();
		this.mom=content.getMom();
		
	}
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

package com.example.minutesofmeeting.api.modelmessage;

import com.example.minutesofmeeting.api.model.Content;
import com.example.minutesofmeeting.api.model.SubContent;

public class SubContentResponse extends BaseResponse {
	
	
	private Integer subContentId;
	private String subContentTitle;
	private Content content;
	
	public SubContentResponse() {
		
	}
	
	
	public SubContentResponse(int i, String string) {
		super(i,string);
	}
	

	public SubContentResponse(SubContent subcontent) {
		// TODO Auto-generated constructor stub
		this.subContentId=subcontent.getSubContentId();
		this.subContentTitle=subcontent.getSubContentTitle();
		this.content=subcontent.getContent();
	}
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

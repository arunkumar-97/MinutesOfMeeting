package com.example.minutesofmeeting.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.example.minutesofmeeting.api.modelmessage.SubContentRequest;

@Entity
public class SubContent {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer subContentId;
	
	@Lob
	private String subContentTitle;
	
	
	@ManyToOne
	@JoinColumn(name="contentId", referencedColumnName="contentId")
	private Content content;
	
	public SubContent() {
		
	}
	
	public SubContent(SubContentRequest subcontentRequestEntity) {
		this.subContentId=subcontentRequestEntity.getSubContentId();
		this.subContentTitle=subcontentRequestEntity.getSubContentTitle();
		this.content=subcontentRequestEntity.getContent();
	}
	public SubContent(SubContent eachsubcontent) {
		this.subContentId=eachsubcontent.getSubContentId();
		this.subContentTitle=eachsubcontent.getSubContentTitle();
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

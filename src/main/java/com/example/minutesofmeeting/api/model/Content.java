package com.example.minutesofmeeting.api.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.minutesofmeeting.api.modelmessage.ContentRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Content {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer contentId;
	@Lob
	private String contentTitle;
	
	@ManyToOne
	@JoinColumn(name="momId", referencedColumnName="momId")
	private MOM mom;
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="content")
	private Set<SubContent> subContent;
	
	public Content() {
		
	}
	
	public Content(ContentRequest contentRequestEntity) {
		this.contentId=contentRequestEntity.getContentId();
		this.contentTitle=contentRequestEntity.getContentTitle();
		this.mom=contentRequestEntity.getMom();
	}
	public Content(Content each) {
		this.contentId=each.getContentId();
		this.contentTitle=each.getContentTitle();
		this.subContent=each.getSubContent();
		this.mom=each.getMom();
	}

	public Content(Integer contentId2) {
		this.contentId=contentId2;
	}

	public Content(Content eachContent, Content eachContent2) {
		this.contentId=eachContent.getContentId();
		this.contentTitle=eachContent.getContentTitle();
		this.subContent=eachContent.getSubContent();
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

	public Set<SubContent> getSubContent() {
		return subContent;
	}

	public void setSubContent(Set<SubContent> subContent) {
		this.subContent = subContent;
	}

	
	
	
	
	
}

package com.example.minutesofmeeting.api.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.minutesofmeeting.api.modelmessage.ActionItemRequest;

@Entity
public class ActionItem {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer actionItemId;
	private String actionItemName;
	private Date actionItemTargetDate;
	private String actionItemOwner;
	
	
	@ManyToOne
	@JoinColumn(name="momId", referencedColumnName="momId")
	private MOM mom;
	
	public ActionItem() {
		
	}
	
	public ActionItem(ActionItemRequest actionItemRequestEntity) {
		// TODO Auto-generated constructor stub
		this.actionItemId=actionItemRequestEntity.getActionItemId();
		this.actionItemName=actionItemRequestEntity.getActionItemName();
		this.actionItemTargetDate=actionItemRequestEntity.getActionItemTargetDate();
		this.actionItemOwner=actionItemRequestEntity.getActionItemOwner();
		this.mom=actionItemRequestEntity.getMom();
	}
	public ActionItem(ActionItem eachAt, ActionItem eachAt2) {
		this.actionItemId=eachAt.getActionItemId();
		this.actionItemName=eachAt.getActionItemName();
		this.actionItemTargetDate=eachAt.getActionItemTargetDate();
		this.actionItemOwner=eachAt.getActionItemOwner();
	}

	public Integer getActionItemId() {
		return actionItemId;
	}
	public void setActionItemId(Integer actionItemId) {
		this.actionItemId = actionItemId;
	}
	public String getActionItemName() {
		return actionItemName;
	}
	public void setActionItemName(String actionItemName) {
		this.actionItemName = actionItemName;
	}
	public Date getActionItemTargetDate() {
		return actionItemTargetDate;
	}
	public void setActionItemTargetDate(Date actionItemTargetDate) {
		this.actionItemTargetDate = actionItemTargetDate;
	}
	public String getActionItemOwner() {
		return actionItemOwner;
	}
	public void setActionItemOwner(String actionItemOwner) {
		this.actionItemOwner = actionItemOwner;
	}

	public MOM getMom() {
		return mom;
	}

	public void setMom(MOM mom) {
		this.mom = mom;
	}
	
	
	
	
	
	
	
	
}

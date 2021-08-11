package com.example.minutesofmeeting.api.modelmessage;

import java.sql.Date;

import com.example.minutesofmeeting.api.model.MOM;

public class ActionItemRequest {
	
	private Integer actionItemId;
	private String actionItemName;
	private Date actionItemTargetDate;
	private String actionItemOwner;
	private MOM mom;
	
	
	
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

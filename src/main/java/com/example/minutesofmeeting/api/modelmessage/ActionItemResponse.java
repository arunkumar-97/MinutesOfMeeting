package com.example.minutesofmeeting.api.modelmessage;

import java.sql.Date;

import com.example.minutesofmeeting.api.model.ActionItem;
import com.example.minutesofmeeting.api.model.MOM;

public class ActionItemResponse extends BaseResponse{
	
	private Integer actionItemId;
	private String actionItemName;
	private Date actionItemTargetDate;
	private String actionItemOwner;
	private MOM mom;
	
	public ActionItemResponse() {
		
	}
	
	public ActionItemResponse(int i, String string) {
	super(i,string);	
	}
	
	
	public ActionItemResponse(ActionItem actionItem) {
		this.actionItemId=actionItem.getActionItemId();
		this.actionItemName=actionItem.getActionItemName();
		this.actionItemTargetDate=actionItem.getActionItemTargetDate();
		this.actionItemOwner=actionItem.getActionItemOwner();
		this.mom=actionItem.getMom();
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

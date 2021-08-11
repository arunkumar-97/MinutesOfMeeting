package com.example.minutesofmeeting.api.modelmessage;

import java.sql.Date;
import java.util.List;

import com.example.minutesofmeeting.api.model.ActionItem;
import com.example.minutesofmeeting.api.model.Content;
import com.example.minutesofmeeting.api.model.Project;

public class NewMOMRequest {
	
	private Integer momId;
	private String momName;
	private String momAttendees;
	private String client;
	private String meetingPlace;
	private Date momDate;
	private Project project;
	private List<Content> content;
	private List<ActionItem> actionItem;
	
	
	public Integer getMomId() {
		return momId;
	}
	public void setMomId(Integer momId) {
		this.momId = momId;
	}
	public String getMomName() {
		return momName;
	}
	public void setMomName(String momName) {
		this.momName = momName;
	}
	public String getMomAttendees() {
		return momAttendees;
	}
	public void setMomAttendees(String momAttendees) {
		this.momAttendees = momAttendees;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getMeetingPlace() {
		return meetingPlace;
	}
	public void setMeetingPlace(String meetingPlace) {
		this.meetingPlace = meetingPlace;
	}
	public Date getMomDate() {
		return momDate;
	}
	public void setMomDate(Date momDate) {
		this.momDate = momDate;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	public List<Content> getContent() {
		return content;
	}
	public void setContent(List<Content> content) {
		this.content = content;
	}
	public List<ActionItem> getActionItem() {
		return actionItem;
	}
	public void setActionItem(List<ActionItem> actionItem) {
		this.actionItem = actionItem;
	}
	
	
	
	
	
	

}

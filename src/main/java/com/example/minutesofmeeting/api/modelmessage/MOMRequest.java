package com.example.minutesofmeeting.api.modelmessage;

import java.sql.Date;

import com.example.minutesofmeeting.api.model.Project;

public class MOMRequest {
	
	private Integer momId;
	private String momName;
	private String momAttendees;
	private String client;
	private String meetingPlace;
	private Date momDate;
	private Project project;
	
	
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
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Date getMomDate() {
		return momDate;
	}
	public void setMomDate(Date momDate) {
		this.momDate = momDate;
	}
	
	
	
	
	


}

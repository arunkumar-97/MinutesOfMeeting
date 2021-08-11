package com.example.minutesofmeeting.api.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.minutesofmeeting.api.modelmessage.MOMRequest;
import com.example.minutesofmeeting.api.modelmessage.NewMOMRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class MOM {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer momId;
	private String momName;
	private String momAttendees;
	private String client;
	private String meetingPlace;
	private Date momDate;
	
	@ManyToOne
	@JoinColumn(name="projectId", referencedColumnName="projectId")
	private Project project;
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="mom")
	private List<Content> content;
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="mom")
	private List<ActionItem> actionItem;
	
	
	public MOM() {
		
	}
	
	public MOM(MOMRequest momRequestEntity) {
		this.momId=momRequestEntity.getMomId();
		this.momName=momRequestEntity.getMomName();		
		this.momAttendees=momRequestEntity.getMomAttendees();
		this.client=momRequestEntity.getClient();
		this.meetingPlace=momRequestEntity.getMeetingPlace();
		this.momDate=momRequestEntity.getMomDate();
		this.project=momRequestEntity.getProject();
	}
	public MOM(NewMOMRequest momRequest) {
		this.momId=momRequest.getMomId();
		this.momName=momRequest.getMomName();		
		this.momAttendees=momRequest.getMomAttendees();
		this.client=momRequest.getClient();
		this.meetingPlace=momRequest.getMeetingPlace();
		this.momDate=momRequest.getMomDate();
		this.project=momRequest.getProject();
	}

	public MOM(Integer momId2) {
		this.momId=momId2;
	}

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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

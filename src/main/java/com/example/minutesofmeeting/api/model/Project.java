package com.example.minutesofmeeting.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.example.minutesofmeeting.api.modelmessage.ProjectRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer projectId;
	private String projectName;
	private String projectCode;
	@Lob
	private String projectDescription;
	
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="project")
	private List<MOM> mom;
	
	
	public Project() {
		
	}
	
	
	public Project(String projectName2, String projectCode2, String projectDescription2) {
		this.projectName=projectName2;
		this.projectCode=projectCode2;
		this.projectDescription=projectDescription2;
	}
	public Project(ProjectRequest projectRequest) {
		this.projectId=projectRequest.getProjectId();
		this.projectName=projectRequest.getProjectName();
		this.projectCode=projectRequest.getProjectCode();
		this.projectDescription=projectRequest.getProjectDescription();
	}


	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}


	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectCode=" + projectCode
				+ ", projectDescription=" + projectDescription + "]";
	}
	
	
	
	
	
}

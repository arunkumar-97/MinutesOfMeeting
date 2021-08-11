package com.example.minutesofmeeting.api.modelmessage;

import javax.persistence.Lob;

import com.example.minutesofmeeting.api.model.Project;

public class ProjectResponse extends BaseResponse{
	
	private Integer projectId;
	private String projectName;
	private String projectCode;
	
	private String projectDescription;
	
	public ProjectResponse() {
		
	}
	
	public ProjectResponse(int i, String string) {
		super(i,string);
	}
	public ProjectResponse(Project project) {
		this.projectId=project.getProjectId();
		this.projectName=project.getProjectName();
		this.projectCode=project.getProjectCode();
		this.projectDescription=project.getProjectDescription();
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
	
	
	
	
	
	

}

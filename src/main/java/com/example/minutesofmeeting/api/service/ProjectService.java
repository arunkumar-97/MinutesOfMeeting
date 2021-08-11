package com.example.minutesofmeeting.api.service;

import java.util.List;

import com.example.minutesofmeeting.api.model.Project;


public interface ProjectService {

	Project checkProject(String projectName);

	Project createnewProject(String projectName, String projectCode, String projectDescription);

	List<Project> findAll();

	Project findById(Integer projectId);

	Project saveProject(Project project);

}

package com.example.minutesofmeeting.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minutesofmeeting.api.model.Project;
import com.example.minutesofmeeting.api.repository.ProjectRepository;

@Service
public class ProjectImplementationService implements ProjectService {
	
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project checkProject(String projectName) {
		// TODO Auto-generated method stub
		return projectRepository.findByProjectName(projectName);
	}

	@Override
	public Project createnewProject(String projectName, String projectCode, String projectDescription) {
		// TODO Auto-generated method stub
		Project project=new Project(projectName,projectCode,projectDescription);
		projectRepository.save(project);
		return project;
	}

	@Override
	public List<Project> findAll() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

	@Override
	public Project findById(Integer projectId) {
		// TODO Auto-generated method stub
		return projectRepository.findByProjectId(projectId);
	}

	@Override
	public Project saveProject(Project project) {
		// TODO Auto-generated method stub
		return projectRepository.save(project);
	}

}

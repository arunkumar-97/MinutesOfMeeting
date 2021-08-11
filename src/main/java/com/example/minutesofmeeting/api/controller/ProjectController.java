package com.example.minutesofmeeting.api.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.minutesofmeeting.api.model.Project;
import com.example.minutesofmeeting.api.modelmessage.ProjectRequest;
import com.example.minutesofmeeting.api.modelmessage.ProjectResponse;
import com.example.minutesofmeeting.api.service.ProjectService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProjectController {

	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/project")
	private ProjectResponse createProject(@RequestBody ProjectRequest projectRequest) {
		ProjectResponse response=new ProjectResponse(409,"Project Already Exists");
		ProjectResponse projectResponse=new ProjectResponse();
		Project projectName=projectService.checkProject(projectRequest.getProjectName());
		if(projectName == null) {
			Project newProject=projectService.createnewProject(projectRequest.getProjectName(),projectRequest.getProjectCode(),projectRequest.getProjectDescription());
			projectResponse.setProjectName(newProject.getProjectName());
			projectResponse.setProjectCode(newProject.getProjectCode());
			projectResponse.setProjectDescription(newProject.getProjectDescription());
			response.setProjectId(newProject.getProjectId());
			response.setProjectName(newProject.getProjectName());
			response.setProjectCode(newProject.getProjectCode());
			response.setProjectDescription(newProject.getProjectDescription());
			response.setStatusCode(200);
			response.setDescription("Project Created Successfully");
			
		}
		return response;
	}
	
	
	@PutMapping("/project/{projectId}")
	public ProjectResponse updateProject(@PathVariable Integer projectId,@RequestBody ProjectRequest projectRequest)
	{
		ProjectResponse response=new ProjectResponse(409, "no such id found");
		
		if(projectId != null)
		{
	
		
		 Project projectFromDB=projectService.findById(projectId);
		 if(projectFromDB!=null) {
			 Project project=new Project(projectRequest);
			 
			
			projectService.saveProject(project);
			response.setStatusCode(200);
			response.setDescription("successfully updated");
			
			
		 }else {
			 response.setStatusCode(404);
			 response.setDescription("Project with the Id:" + projectId + " not Found");
			 return response;
		 }
		
		}
		return response;
	}
	
	@GetMapping("/project")
	private List<ProjectResponse> getAllProjects() {
		
		List<ProjectResponse> response=new ArrayList<>();
		projectService.findAll().forEach(project ->{
				response.add(new ProjectResponse(project));
			});
			return response;
	}
	
	@GetMapping("/project/{projectId}")
	private ProjectResponse getProjectById(@PathVariable Integer projectId)  {
		Project projectFromDb=projectService.findById(projectId);
		System.out.println("ProjectFromDb :" +  projectFromDb);
		ProjectResponse response;
		if(projectFromDb != null) {
	 response =new ProjectResponse(projectFromDb);
			response.setProjectId(projectFromDb.getProjectId());
			response.setProjectName(projectFromDb.getProjectName());
			
		}else{
			response =new ProjectResponse(404,"Project with the Id:" + projectId + " not Found");
				
			}
		return response;
}
}

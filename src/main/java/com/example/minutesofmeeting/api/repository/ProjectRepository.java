package com.example.minutesofmeeting.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minutesofmeeting.api.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

	Project findByProjectName(String projectName);

	Project findByProjectId(Integer projectId);



}

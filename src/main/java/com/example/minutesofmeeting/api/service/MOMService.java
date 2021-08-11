package com.example.minutesofmeeting.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.minutesofmeeting.api.model.MOM;
import com.example.minutesofmeeting.api.model.Project;
import com.example.minutesofmeeting.api.modelmessage.NewMOMRequest;
import com.example.minutesofmeeting.api.modelmessage.NewMOMResponse;



public interface MOMService {

	MOM createmom(MOM mom);

	MOM findByMomName(String momName);

	List<MOM> findAll();

	MOM findById(Integer momId);

	List<MOM> findByProject(Project projectFromDb);

	MOM saveMOM(MOM mom);

	ResponseEntity createNewMOM(NewMOMRequest momRequest);

	NewMOMResponse updateNewMOM(NewMOMRequest momRequest);

}

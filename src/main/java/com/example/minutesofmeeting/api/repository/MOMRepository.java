package com.example.minutesofmeeting.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minutesofmeeting.api.model.MOM;
import com.example.minutesofmeeting.api.model.Project;

public interface MOMRepository extends JpaRepository<MOM, Integer>{

	MOM findByMomName(String momName);

	MOM findByMomId(Integer momId);

	List<MOM> findByProject(Project projectFromDb);

}

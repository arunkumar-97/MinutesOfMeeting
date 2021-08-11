package com.example.minutesofmeeting.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minutesofmeeting.api.model.SubContent;

public interface SubContentRepository extends JpaRepository<SubContent, Integer>{

	SubContent findBySubContentId(Integer subContentId);

}

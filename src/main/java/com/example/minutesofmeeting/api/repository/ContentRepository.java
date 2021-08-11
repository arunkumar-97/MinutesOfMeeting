package com.example.minutesofmeeting.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minutesofmeeting.api.model.Content;

public interface ContentRepository extends JpaRepository<Content, Integer>{

	Content findByContentId(Integer contentId);

}

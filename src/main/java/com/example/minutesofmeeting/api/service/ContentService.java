package com.example.minutesofmeeting.api.service;

import java.util.List;

import com.example.minutesofmeeting.api.model.Content;


public interface ContentService {

	Content createContent(Content content);

	List<Content> findAll();

	Content findById(Integer contentId);

	Content saveContent(Content content);

	

}

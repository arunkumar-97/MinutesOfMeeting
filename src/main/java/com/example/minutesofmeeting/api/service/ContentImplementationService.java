package com.example.minutesofmeeting.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minutesofmeeting.api.model.Content;
import com.example.minutesofmeeting.api.repository.ContentRepository;

@Service
public class ContentImplementationService implements ContentService{
	
	
	@Autowired
	private ContentRepository contentRepository;

	@Override
	public Content createContent(Content content) {
		// TODO Auto-generated method stub
		return contentRepository.save(content);
	}

	@Override
	public List<Content> findAll() {
		// TODO Auto-generated method stub
		return contentRepository.findAll();
	}

	@Override
	public Content findById(Integer contentId) {
		// TODO Auto-generated method stub
		return contentRepository.findByContentId(contentId);
	}

	@Override
	public Content saveContent(Content content) {
		// TODO Auto-generated method stub
		return contentRepository.save(content);
	} 

}

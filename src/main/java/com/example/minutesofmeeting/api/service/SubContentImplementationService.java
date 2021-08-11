package com.example.minutesofmeeting.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minutesofmeeting.api.model.SubContent;
import com.example.minutesofmeeting.api.repository.SubContentRepository;

@Service
public class SubContentImplementationService implements SubContentService {
	
	
	
	@Autowired
	private SubContentRepository subContentRepository;

	@Override
	public SubContent createSubContent(SubContent subcontent) {
		// TODO Auto-generated method stub
		return subContentRepository.save(subcontent);
	}

	@Override
	public List<SubContent> findAll() {
		// TODO Auto-generated method stub
		return subContentRepository.findAll();
	}

	@Override
	public SubContent findById(Integer subContentId) {
		// TODO Auto-generated method stub
		return subContentRepository.findBySubContentId(subContentId);
	}

	@Override
	public SubContent saveSubContent(SubContent subcontent) {
		// TODO Auto-generated method stub
		return subContentRepository.save(subcontent);
	}
	
	
	

}

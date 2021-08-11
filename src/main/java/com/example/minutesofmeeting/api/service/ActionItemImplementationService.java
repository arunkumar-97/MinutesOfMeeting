package com.example.minutesofmeeting.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minutesofmeeting.api.model.ActionItem;
import com.example.minutesofmeeting.api.repository.ActionItemRepository;

@Service
public class ActionItemImplementationService implements ActionItemService{
	
	@Autowired
	private ActionItemRepository actionItemRepository;

	@Override
	public ActionItem createActionItem(ActionItem actionItem) {
		// TODO Auto-generated method stub
		return actionItemRepository.save(actionItem);
	}

	@Override
	public List<ActionItem> findAll() {
		// TODO Auto-generated method stub
		return actionItemRepository.findAll();
	}

	@Override
	public ActionItem findById(Integer actionItemId) {
		// TODO Auto-generated method stub
		return actionItemRepository.findByActionItemId(actionItemId);
	}

	@Override
	public ActionItem saveActionItem(ActionItem actionItem) {
		// TODO Auto-generated method stub
		return actionItemRepository.save(actionItem);
	}
	
	
	
	

}

package com.example.minutesofmeeting.api.service;

import java.util.List;

import com.example.minutesofmeeting.api.model.ActionItem;

public interface ActionItemService {

	ActionItem createActionItem(ActionItem actionItem);

	List<ActionItem> findAll();

	ActionItem findById(Integer actionItemId);

	ActionItem saveActionItem(ActionItem actionItem);

}

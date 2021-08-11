package com.example.minutesofmeeting.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minutesofmeeting.api.model.ActionItem;

public interface ActionItemRepository extends JpaRepository<ActionItem, Integer>{

	ActionItem findByActionItemId(Integer actionItemId);

}

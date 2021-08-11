package com.example.minutesofmeeting.api.service;

import java.util.List;

import com.example.minutesofmeeting.api.model.SubContent;


public interface SubContentService {

	SubContent createSubContent(SubContent subcontent);

	List<SubContent> findAll();

	SubContent findById(Integer subContentId);

	SubContent saveSubContent(SubContent subcontent);

}

package com.example.minutesofmeeting.api.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.minutesofmeeting.api.model.ActionItem;
import com.example.minutesofmeeting.api.model.Content;
import com.example.minutesofmeeting.api.model.MOM;
import com.example.minutesofmeeting.api.model.Project;
import com.example.minutesofmeeting.api.model.SubContent;
import com.example.minutesofmeeting.api.modelmessage.NewMOMRequest;
import com.example.minutesofmeeting.api.modelmessage.NewMOMResponse;
import com.example.minutesofmeeting.api.repository.MOMRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class MOMImplementationService implements MOMService{

	@Autowired
	private MOMRepository momRepository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private SubContentService subContentService;
	
	
	@Autowired
	private ActionItemService actionItemService;
	
	
	NewMOMResponse res=new NewMOMResponse();

	@Override
	public MOM createmom(MOM mom) {
		
		return momRepository.save(mom);
	}

	@Override
	public MOM findByMomName(String momName) {
		// TODO Auto-generated method stub
		return momRepository.findByMomName(momName);
	}

	@Override
	public List<MOM> findAll() {
		// TODO Auto-generated method stub
		return momRepository.findAll();
	}

	@Override
	public MOM findById(Integer momId) {
		// TODO Auto-generated method stub
		return momRepository.findByMomId(momId);
	}

	@Override
	public List<MOM> findByProject(Project projectFromDb) {
		// TODO Auto-generated method stub
		return momRepository.findByProject(projectFromDb);
	}

	@Override
	public MOM saveMOM(MOM mom) {
		// TODO Auto-generated method stub
		return momRepository.save(mom);
	}

	
	@Override
	public ResponseEntity createNewMOM(NewMOMRequest momRequest) {
		MOM mom = new MOM();
	
		MOM momNew=new MOM(momRequest);
		MOM momdb=momRepository.save(momNew);
		List<Content> newcontent=momRequest.getContent();
		
		List<ActionItem> actionItem=momRequest.getActionItem();
		if(actionItem.size() != 0) {
			MOM momDB=new MOM(momdb.getMomId());
			for(ActionItem each:actionItem) {
				ActionItem item=new ActionItem();
				item.setActionItemId(each.getActionItemId());
				item.setActionItemName(each.getActionItemName());
				item.setActionItemOwner(each.getActionItemOwner());
				item.setActionItemTargetDate(each.getActionItemTargetDate());
				item.setMom(momDB);
				actionItemService.saveActionItem(item);
			}
		}
		
		if(newcontent != null) {
			
			for(Content each:newcontent) {
				MOM momDB=new MOM(momdb.getMomId());
				each.setMom(momDB);
				Content cont=new Content(each);
				Content createdContent=contentService.saveContent(cont);
				Set<SubContent> subContent=each.getSubContent();
			System.out.println("SubContent" + subContent);
				if(subContent.size() != 0) {
				
					Content contentId=new Content(createdContent.getContentId());
					for(SubContent eachsc:subContent) {
						SubContent sc=new SubContent();
						sc.setSubContentId(eachsc.getSubContentId());
						sc.setSubContentTitle(eachsc.getSubContentTitle());
						sc.setContent(contentId);
						subContentService.saveSubContent(sc);
						
					}
				}
			}
			
		}
	
		ObjectNode jsonObject = objectMapper.createObjectNode();
		jsonObject.put("statusCode", res.SUCCESS);
		jsonObject.put("description", res.setDescription("Minutes Of Meeting Created Successfully"));
		return new ResponseEntity(jsonObject, HttpStatus.OK);
	}
	
	@Override
	public NewMOMResponse updateNewMOM(NewMOMRequest momRequest) {
		MOM mom = new MOM();
	
		MOM momNew=new MOM(momRequest);
		MOM momdb=momRepository.save(momNew);
		List<Content> newcontent=momRequest.getContent();
		
		List<ActionItem> actionItem=momRequest.getActionItem();
		if(actionItem.size() != 0) {
			MOM momDB=new MOM(momdb.getMomId());
			for(ActionItem each:actionItem) {
				ActionItem item=new ActionItem();
				item.setActionItemId(each.getActionItemId());
				item.setActionItemName(each.getActionItemName());
				item.setActionItemOwner(each.getActionItemOwner());
				item.setActionItemTargetDate(each.getActionItemTargetDate());
				item.setMom(momDB);
				actionItemService.saveActionItem(item);
			}
		}
		
		if(newcontent != null) {
			
			for(Content each:newcontent) {
				MOM momDB=new MOM(momdb.getMomId());
				each.setMom(momDB);
				Content cont=new Content(each);
				Content createdContent=contentService.saveContent(cont);
				Set<SubContent> subContent=each.getSubContent();
			System.out.println("SubContent" + subContent);
				if(subContent.size() != 0) {
				
					Content contentId=new Content(createdContent.getContentId());
					for(SubContent eachsc:subContent) {
						SubContent sc=new SubContent();
						sc.setSubContentId(eachsc.getSubContentId());
						sc.setSubContentTitle(eachsc.getSubContentTitle());
						sc.setContent(contentId);
						subContentService.saveSubContent(sc);
						
					}
				}
			}
			
		}
		res.setStatusCode(200);
		res.setDescription("Minutes Of Meeting Updated Successfully");
		return res;
	
//		ObjectNode jsonObject = objectMapper.createObjectNode();
//		jsonObject.put("statusCode", res.SUCCESS);
//		jsonObject.put("description", res.setDescription("Minutes Of Meeting Updated Successfully"));
//		return new ResponseEntity(jsonObject, HttpStatus.OK);
	}
	
}

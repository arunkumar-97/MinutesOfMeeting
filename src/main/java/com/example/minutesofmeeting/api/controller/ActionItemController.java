package com.example.minutesofmeeting.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.minutesofmeeting.api.model.ActionItem;
import com.example.minutesofmeeting.api.modelmessage.ActionItemRequest;
import com.example.minutesofmeeting.api.modelmessage.ActionItemResponse;
import com.example.minutesofmeeting.api.service.ActionItemService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ActionItemController {
	
	
	@Autowired
	private ActionItemService actionItemService;
	
	
	@PostMapping("/action-item")
	public ResponseEntity addActionItem(@RequestBody ActionItemRequest actionItemRequestEntity) {

			ActionItem actionItem = new ActionItem(actionItemRequestEntity);
			ActionItem createdActionItem = actionItemService.createActionItem(actionItem);
			if (createdActionItem != null) {
				ActionItemResponse actionItemResponse = new ActionItemResponse();
				actionItemResponse.setStatusCode(200);
				actionItemResponse.setDescription("ActionItem Created Sucessfully");
				return new ResponseEntity(actionItemResponse, HttpStatus.OK);
			} else {
				ActionItemResponse contentResponseEntity = new ActionItemResponse();
				contentResponseEntity.setStatusCode(409);
				contentResponseEntity.setDescription(" Unable to Create ActionItem");
				return new ResponseEntity(contentResponseEntity, HttpStatus.CONFLICT);
			}
		
		
	}
	
	
	@PutMapping("/action-item/{actionItemId}")
	public ActionItemResponse updateActionItem(@PathVariable Integer actionItemId,@RequestBody ActionItemRequest actionItemRequest)
	{
		ActionItemResponse response=new ActionItemResponse(409, "no such id found");
		
		if(actionItemId != null)
		{
	
		
			ActionItem actionItemFromDB=actionItemService.findById(actionItemId);
		 if(actionItemFromDB!=null) {
			 ActionItem actionItem=new ActionItem(actionItemRequest);
			 
			
			 actionItemService.saveActionItem(actionItem);
			response.setStatusCode(200);
			response.setDescription("successfully updated");
			
			
		 }else {
			 response.setStatusCode(404);
			 response.setDescription("Project with the Id:" + actionItemId + " not Found");
			 return response;	
		 }
		
		}
		return response;
	}
	
	@GetMapping("/action-item")
	public List<ActionItemResponse> listAllActionItem() {
		List<ActionItemResponse> res = new ArrayList<>();

		actionItemService.findAll().forEach(actionItem -> {
			res.add(new ActionItemResponse(actionItem));
		});
		return res;
	}
	
	
	@GetMapping("/action-item/{actionItemId}")
	private ActionItemResponse getActionItemById(@PathVariable Integer actionItemId)  {
		ActionItem actionItemFromDb=actionItemService.findById(actionItemId);
		
		ActionItemResponse response;
		if(actionItemFromDb != null) {
	 response =new ActionItemResponse(actionItemFromDb);
			response.setActionItemId(actionItemFromDb.getActionItemId());
			response.setActionItemName(actionItemFromDb.getActionItemName());
			response.setActionItemOwner(actionItemFromDb.getActionItemOwner());
			response.setActionItemTargetDate(actionItemFromDb.getActionItemTargetDate());
			response.setMom(actionItemFromDb.getMom());
			
		}else{
			response =new ActionItemResponse(404,"Project with the Id:" + actionItemId + " not Found");
				
			}
		return response;
}
	

}

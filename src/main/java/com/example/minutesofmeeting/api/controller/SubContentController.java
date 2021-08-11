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

import com.example.minutesofmeeting.api.model.Content;
import com.example.minutesofmeeting.api.model.SubContent;
import com.example.minutesofmeeting.api.modelmessage.ContentRequest;
import com.example.minutesofmeeting.api.modelmessage.ContentResponse;
import com.example.minutesofmeeting.api.modelmessage.SubContentRequest;
import com.example.minutesofmeeting.api.modelmessage.SubContentResponse;
import com.example.minutesofmeeting.api.service.SubContentService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SubContentController {
	
	
	@Autowired
	private SubContentService subContentService; 
	
	@PostMapping("/sub-content")
	public ResponseEntity addSubContent(@RequestBody SubContentRequest subcontentRequestEntity) {

			SubContent subcontent = new SubContent(subcontentRequestEntity);
			SubContent createdSubContent = subContentService.createSubContent(subcontent);
			if (createdSubContent != null) {
				SubContentResponse subcontentResponse = new SubContentResponse();
				subcontentResponse.setStatusCode(200);
				subcontentResponse.setDescription("SubContent Created Sucessfully for the Content");
				return new ResponseEntity(subcontentResponse, HttpStatus.OK);
			} else {
				SubContentResponse subcontentResponseEntity = new SubContentResponse();
				subcontentResponseEntity.setStatusCode(409);
				subcontentResponseEntity.setDescription(" Unable to Create Content for the MOM");
				return new ResponseEntity(subcontentResponseEntity, HttpStatus.CONFLICT);
			}
		
		
	}
	
	
	@PutMapping("/sub-content/{subContentId}")
	public SubContentResponse updateSubContent(@PathVariable Integer subContentId,@RequestBody SubContentRequest subcontentRequestEntity)
	{
		SubContentResponse response=new SubContentResponse(409, "no such id found");
		
		if(subContentId != null)
		{
	
		
			SubContent subContentFromDB=subContentService.findById(subContentId);
		 if(subContentFromDB!=null) {
			 SubContent subcontent=new SubContent(subcontentRequestEntity);
			 
			
			 subContentService.saveSubContent(subcontent);
			response.setStatusCode(200);
			response.setDescription("Sub-Content for the MOM successfully updated");
			
			
		 }else {
			 response.setStatusCode(404);
			 response.setDescription("MOM with the Id:" + subContentId + " not Found");
			 return response;
		 }
		
		}
		return response;
	}
	
	
	@GetMapping("/sub-content")
	public List<SubContentResponse> listAllSubContent() {
		List<SubContentResponse> res = new ArrayList<>();

		subContentService.findAll().forEach(subcontent -> {
			res.add(new SubContentResponse(subcontent));
		});
		return res;
	}

	
	
	@GetMapping("/sub-content/{subContentId}")
	public ResponseEntity viewSubContentById(@PathVariable Integer subContentId) {
		SubContent subcontent = subContentService.findById(subContentId);
		 
		if (subcontent != null) {
			SubContentResponse	subcontentResponse=new SubContentResponse(subcontent);
			
			return new ResponseEntity(subcontentResponse, HttpStatus.OK);
		}else{
			SubContentResponse subcontentResponseEntity = new SubContentResponse();
			subcontentResponseEntity.setStatusCode(409);
			subcontentResponseEntity.setDescription("Content with ID not found");
			return new ResponseEntity(subcontentResponseEntity, HttpStatus.CONFLICT);
			}
		

	}
}

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
import com.example.minutesofmeeting.api.model.MOM;
import com.example.minutesofmeeting.api.modelmessage.ContentRequest;
import com.example.minutesofmeeting.api.modelmessage.ContentResponse;
import com.example.minutesofmeeting.api.modelmessage.MOMRequest;
import com.example.minutesofmeeting.api.modelmessage.MOMResponse;
import com.example.minutesofmeeting.api.service.ContentService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	
	@PostMapping("/content")
	public ResponseEntity addContent(@RequestBody ContentRequest contentRequestEntity) {

			Content content = new Content(contentRequestEntity);
			Content createdContent = contentService.createContent(content);
			if (createdContent != null) {
				ContentResponse contentResponse = new ContentResponse();
				contentResponse.setStatusCode(200);
				contentResponse.setDescription("Content Created Sucessfully for MOM");
				return new ResponseEntity(contentResponse, HttpStatus.OK);
			} else {
				ContentResponse contentResponseEntity = new ContentResponse();
				contentResponseEntity.setStatusCode(409);
				contentResponseEntity.setDescription(" Unable to Create Content for the MOM");
				return new ResponseEntity(contentResponseEntity, HttpStatus.CONFLICT);
			}
		
		
	}
	
	
	@PutMapping("/content/{contentId}")
	public ContentResponse updateContent(@PathVariable Integer contentId,@RequestBody ContentRequest contentRequestEntity)
	{
		ContentResponse response=new ContentResponse(409, "no such id found");
		
		if(contentId != null)
		{
	
		
		Content contentFromDB=contentService.findById(contentId);
		 if(contentFromDB!=null) {
			 Content content=new Content(contentRequestEntity);
			 
			
			 contentService.saveContent(content);
			response.setStatusCode(200);
			response.setDescription("Content for the MOM successfully updated");
			
			
		 }else {
			 response.setStatusCode(404);
			 response.setDescription("MOM with the Id:" + contentId + " not Found");
			 return response;
		 }
		
		}
		return response;
	}
	
	@GetMapping("/content")
	public List<ContentResponse> listAllContent() {
		List<ContentResponse> res = new ArrayList<>();

		contentService.findAll().forEach(content -> {
			res.add(new ContentResponse(content));
		});
		return res;
	}
	
	@GetMapping("/content/{contentId}")
	public ResponseEntity viewcontentById(@PathVariable Integer contentId) {
		Content content = contentService.findById(contentId);
		 
		if (content != null) {
			ContentResponse	contentResponse=new ContentResponse(content);
			
			return new ResponseEntity(contentResponse, HttpStatus.OK);
		}else{
			ContentResponse contentResponseEntity = new ContentResponse();
			contentResponseEntity.setStatusCode(409);
			contentResponseEntity.setDescription("Content with ID not found");
			return new ResponseEntity(contentResponseEntity, HttpStatus.CONFLICT);
			}
		

	}

}

package com.example.minutesofmeeting.api.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import com.example.minutesofmeeting.api.model.Content;
import com.example.minutesofmeeting.api.model.MOM;
import com.example.minutesofmeeting.api.model.Project;
import com.example.minutesofmeeting.api.model.SubContent;
import com.example.minutesofmeeting.api.modelmessage.MOMRequest;
import com.example.minutesofmeeting.api.modelmessage.MOMResponse;
import com.example.minutesofmeeting.api.modelmessage.NewMOMRequest;
import com.example.minutesofmeeting.api.modelmessage.NewMOMResponse;
import com.example.minutesofmeeting.api.modelmessage.ProjectRequest;
import com.example.minutesofmeeting.api.modelmessage.ProjectResponse;
import com.example.minutesofmeeting.api.service.MOMService;
import com.example.minutesofmeeting.api.service.ProjectService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MOMController {

	
	
	@Autowired
	private MOMService momService;
	
	@Autowired
	private ProjectService projectService;
	
	
	
	@PostMapping("/mom")
	public ResponseEntity addMOM(@RequestBody MOMRequest momRequestEntity) {
		MOM momFromDb=momService.findByMomName(momRequestEntity.getMomName());
		if(momFromDb == null) {
			MOM mom = new MOM(momRequestEntity);
			MOM createdMom = momService.createmom(mom);
			if (createdMom != null) {
				MOMResponse MOMResponseEntity = new MOMResponse();
				MOMResponseEntity.setStatusCode(200);
				MOMResponseEntity.setDescription("Minutes Of Meeting Created Sucessfully");
				return new ResponseEntity(MOMResponseEntity, HttpStatus.OK);
			} else {
				MOMResponse bookmarkResponseEntity = new MOMResponse();
				bookmarkResponseEntity.setStatusCode(409);
				bookmarkResponseEntity.setDescription(" Unable to Create Minutes Of Meeting");
				return new ResponseEntity(bookmarkResponseEntity, HttpStatus.CONFLICT);
			}
		}else {
			MOMResponse bookmarkResponseEntity = new MOMResponse();
			bookmarkResponseEntity.setStatusCode(409);
			bookmarkResponseEntity.setDescription("Minutes Of Meeting Name Already Exists");
			return new ResponseEntity(bookmarkResponseEntity, HttpStatus.CONFLICT);
		}
		
	}
	
	@PostMapping("/create/mom")
	public ResponseEntity createMom(@RequestBody NewMOMRequest momRequest) {
		MOM momFromDb=momService.findByMomName(momRequest.getMomName());
		if(momFromDb == null) {
			ResponseEntity createdMom=momService.createNewMOM(momRequest);
			return createdMom;
		}else {
			MOMResponse bookmarkResponseEntity = new MOMResponse();
			bookmarkResponseEntity.setStatusCode(409);
			bookmarkResponseEntity.setDescription("Minutes Of Meeting Name Already Exists");
			return new ResponseEntity(bookmarkResponseEntity, HttpStatus.CONFLICT);
		}
	}
	
	
	@PutMapping("/update/mom/{momId}")
	public ResponseEntity UpdateCreatedMom(@PathVariable Integer momId,@RequestBody NewMOMRequest momRequest) {
		NewMOMResponse response=new NewMOMResponse(409, "No such id found");
		if(momId  != null) {
			MOM momFromDB=momService.findById(momId);
			if(momFromDB != null) {
				NewMOMResponse createdMom=momService.updateNewMOM(momRequest);
				
				return new ResponseEntity(createdMom, HttpStatus.OK);
			}else {
				MOMResponse momResponseEntity = new MOMResponse();
				momResponseEntity.setStatusCode(409);
				momResponseEntity.setDescription("No such id found");
				return new ResponseEntity(momResponseEntity, HttpStatus.CONFLICT);
			}
		}
		return new ResponseEntity(response, HttpStatus.CONFLICT);
		
	}
	
	
	
	@PutMapping("/mom/{momId}")
	public MOMResponse updateMOM(@PathVariable Integer momId,@RequestBody MOMRequest momRequestEntity)
	{
		MOMResponse response=new MOMResponse(409, "no such id found");
		
		if(momId != null)
		{
	
		
		 MOM momFromDB=momService.findById(momId);
		 if(momFromDB!=null) {
			 MOM mom=new MOM(momRequestEntity);
			 
			
			 momService.saveMOM(mom);
			response.setStatusCode(200);
			response.setDescription("MOM successfully updated");
			
			
		 }else {
			 response.setStatusCode(404);
			 response.setDescription("MOM with the Id:" + momId + " not Found");
			 return response;
		 }
		
		}
		return response;
	}
	
	
	
	@GetMapping("/mom")
	public List<MOMResponse> listAllMOM() {
		List<MOMResponse> res = new ArrayList<>();

		momService.findAll().forEach(mom -> {
			List<Content> listContent=new ArrayList<>();
			List<Content> content=mom.getContent();
			for(Content eachContent:content) {
				Content content1=new Content(eachContent,eachContent);
				
				Set<SubContent> subcontent=content1.getSubContent();
				Set<SubContent> sb1=new HashSet<>();
				System.out.println("SubContent :" + subcontent.size());
				for(SubContent eachsubcontent:subcontent) {
					SubContent sb=new SubContent(eachsubcontent);
					sb1.add(sb);
					  System.out.println("for");
				}
				  content1.setSubContent(sb1);
				  listContent.add(content1);
				
			
			
			}
			
			mom.setContent(listContent);
			List<ActionItem> actionItem=mom.getActionItem();
			List<ActionItem> at=new ArrayList<>();
			for(ActionItem eachAt:actionItem) {
				ActionItem ActionItem=new ActionItem(eachAt,eachAt);
				at.add(ActionItem);
			}
			mom.setActionItem(at);
			res.add(new MOMResponse(mom));
			
		});
		return res;
	}
	
	
	

	@GetMapping("/mom/{momId}")
	public ResponseEntity viewMoMById(@PathVariable Integer momId) {
		MOM mom = momService.findById(momId);
		 
		if (mom != null) {
			MOMResponse	momResponse=new MOMResponse(mom);
			List<Content> listContent=new ArrayList<>();
			List<Content> content=momResponse.getContent();
			
//			 Iterator<Content> iter
//	            = content.iterator();
//			 while(iter.hasNext()) {
//				 System.out.println("next :" + iter.next());
//				 Content content1=new Content(iter.next());
//				 Content cont=new Content(content1,content1);
//				 
//				 Set<SubContent> subcontent=cont.getSubContent();
//					System.out.println("SubContent :" + subcontent.size());
//					for(SubContent eachsubcontent:subcontent) {
//						SubContent sb=new SubContent(eachsubcontent);
//						subcontent.add(sb);
//						  System.out.println("for");
//					}
//					  content1.setSubContent(subcontent);
//					  listContent.add(content1);
//			 }
			for(Content eachContent:content) {
				Content content1=new Content(eachContent,eachContent);
				
				Set<SubContent> subcontent=content1.getSubContent();
				Set<SubContent> sb1=new HashSet<>();
				System.out.println("SubContent :" + subcontent.size());
				for(SubContent eachsubcontent:subcontent) {
					SubContent sb=new SubContent(eachsubcontent);
					sb1.add(sb);
					  System.out.println("for");
				}
				  content1.setSubContent(sb1);
				  listContent.add(content1);
				
			
			
			}
			
			momResponse.setContent(listContent);
			List<ActionItem> actionItem=momResponse.getActionItem();
			List<ActionItem> at=new ArrayList<>();
			for(ActionItem eachAt:actionItem) {
				ActionItem ActionItem=new ActionItem(eachAt,eachAt);
				at.add(ActionItem);
			}
			momResponse.setActionItem(at);
			
			return new ResponseEntity(momResponse, HttpStatus.OK);
		}else{
			MOMResponse momResponseEntity = new MOMResponse();
			momResponseEntity.setStatusCode(409);
			momResponseEntity.setDescription("Minutes Of Meeting with ID not found");
			return new ResponseEntity(momResponseEntity, HttpStatus.CONFLICT);
			}
		

	}
	
	@GetMapping("/mom/project/{projectId}")
	private ResponseEntity getAllMoMForProject(@PathVariable Integer projectId) {

		List<MOMResponse> response = new ArrayList<>();
		Project projectFromDb = projectService.findById(projectId);
		if (projectFromDb != null) {

			momService.findByProject(projectFromDb).forEach(mom -> {

				MOMResponse	momResponse=new MOMResponse(mom);
				List<Content> listContent=new ArrayList<>();
				List<Content> content=momResponse.getContent();
				

				for(Content eachContent:content) {
					Content content1=new Content(eachContent,eachContent);
					
					Set<SubContent> subcontent=content1.getSubContent();
					Set<SubContent> sb1=new HashSet<>();
					System.out.println("SubContent :" + subcontent.size());
					for(SubContent eachsubcontent:subcontent) {
						SubContent sb=new SubContent(eachsubcontent);
						sb1.add(sb);
						  System.out.println("for");
					}
					  content1.setSubContent(sb1);
					  listContent.add(content1);
					
				
				
				}
				
				momResponse.setContent(listContent);
				List<ActionItem> actionItem=momResponse.getActionItem();
				List<ActionItem> at=new ArrayList<>();
				for(ActionItem eachAt:actionItem) {
					ActionItem ActionItem=new ActionItem(eachAt,eachAt);
					at.add(ActionItem);
				}
				momResponse.setActionItem(at);
				response.add(momResponse);
			});
			
			if (response.isEmpty()) {
				MOMResponse momResponse = new MOMResponse();
				momResponse.setStatusCode(201);
				momResponse.setDescription("No Data is Available");
				return new ResponseEntity(momResponse, HttpStatus.NOT_FOUND);
			}

		} else {
			MOMResponse res = new MOMResponse();
			res.setStatusCode(201);
			res.setDescription("No Data Available");
			return new ResponseEntity(res, HttpStatus.CONFLICT);
		}
		return new ResponseEntity(response, HttpStatus.ACCEPTED);

	}

}

package com.nepal.controller;


import java.sql.Blob;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nepal.beans.Consultant;
import com.nepal.dto.ConsultantDto;
import com.nepal.service.ConsultantService;
import com.nepal.service.EducationDetailService;
import com.nepal.service.PersistenceService;
import com.nepal.service.ResumeService;
import com.nepal.service.UserService;

@Controller
public class ConsultantController {

	private static Logger logger = Logger.getLogger(ConsultantController.class);

	@Autowired
	PersistenceService persistenceService;

	@Autowired
	ConsultantService consultantService;

	@Autowired
	UserService userService;

	@Autowired
	ResumeService resumeService;

	@RequestMapping(value = "/consultants", method = RequestMethod.GET)
	public @ResponseBody List<ConsultantDto> getAllConsultants(){
		List<ConsultantDto> consultants = consultantService.getAllConsultants();
		System.out.println(consultants);
		return consultants;
	}
	@RequestMapping(value = "/editConsultant", method = RequestMethod.POST)
	public @ResponseBody String editConsultant(@RequestBody Consultant consultant){
		System.out.println("inside edit consultant" +  consultant);
		return null;
	}
	@RequestMapping(value = "/addConsultant", method = RequestMethod.POST)
	public String addConsultant (@RequestBody ConsultantDto consultant){
		System.out.println("/addConsultant" + consultant);
		consultantService.addConsultant(consultant);
		return ("New Conusltant Added");
		}

	@RequestMapping(value = "/getResume", method = RequestMethod.POST)
	@JsonIgnore
	public ResponseEntity<byte[]> getResumeById(@RequestBody Long id){
		System.out.println("inside get Resume" +  id);
		ResponseEntity<byte[]> resumeByte = null;
		byte[] resume = resumeService.getResumeById(id, true);
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		if (resume.length > 0) {
			resumeByte = new ResponseEntity<byte[]>(resume, headers, HttpStatus.OK);
		}
		return resumeByte;
	}

}




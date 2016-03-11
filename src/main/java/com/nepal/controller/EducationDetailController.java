package com.nepal.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nepal.beans.Consultant;
import com.nepal.beans.EducationDetail;
import com.nepal.dto.EducationDetailDto;
import com.nepal.service.EducationDetailService;

@Controller
public class EducationDetailController {

	private static Logger logger = Logger.getLogger(EducationDetailController.class);

	@Autowired
	EducationDetailService educationDetailService;

	@RequestMapping(value = "/getEducationDetail", method = RequestMethod.POST)
	public @ResponseBody EducationDetailDto getEducationDetailById(@RequestBody Long id){
		System.out.println(id);
		System.out.println(educationDetailService.getEducationDetailById(id));	
		return educationDetailService.getEducationDetailById(id);

	}
	/*@RequestMapping(value = "/editConsultant", method = RequestMethod.POST)
	public @ResponseBody String editConsultant(@RequestBody Consultant consultant){
		System.out.println("inside edit consultant" +  consultant);
		return null;
	}*/

}
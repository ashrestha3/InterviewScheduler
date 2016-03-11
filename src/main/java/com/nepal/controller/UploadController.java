package com.nepal.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UploadController {

	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public @ResponseBody String saveResume(){
		System.out.println("Inside Upload Controller.");
		return null;

	}
}
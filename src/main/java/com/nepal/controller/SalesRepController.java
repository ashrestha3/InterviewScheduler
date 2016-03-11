package com.nepal.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nepal.beans.SalesRepresentative;
import com.nepal.dto.SalesRepDto;
import com.nepal.service.SalesRepService;

@Controller
public class SalesRepController {

	private static Logger logger = Logger.getLogger(SalesRepController.class);

	@Autowired
	SalesRepService salesRepService;

	@RequestMapping(value = "/allSalesRep", method = RequestMethod.GET)
	public @ResponseBody List<SalesRepDto> getSalesReps(){
		List<SalesRepDto> salesReps = salesRepService.getAllSalesReps();
		System.out.println("getting"+ salesReps);
		return salesReps;

	}
}
package com.nepal.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nepal.beans.Vendor;
import com.nepal.dto.VendorDto;
import com.nepal.service.VendorContactService;
import com.nepal.service.VendorService;
import com.nepal.util.ReturnDesiredString;

@Controller
public class VendorController {

	private static Logger logger = Logger.getLogger(VendorController.class);
	
	@Autowired
	VendorService vendorService;
	
	@Autowired
	VendorContactService vendorContactService;
	
	@RequestMapping(value = "/vendors", method = RequestMethod.GET)
	public @ResponseBody List<VendorDto> getVendors(){
		List<VendorDto> vendors = vendorService.getAllVendors();
		System.out.println(vendors);
		System.out.println("returned string \n" + ReturnDesiredString.GetThoseMofos(vendorContactService));
		return vendors;

	}
	
	/*@RequestMapping(value = "/editConsultant", method = RequestMethod.POST)
	public @ResponseBody String editConsultant(@RequestBody Consultant consultant){
		System.out.println("inside edit consultant" +  consultant);
		return null;
	}*/
	
}


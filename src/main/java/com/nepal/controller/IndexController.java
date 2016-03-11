package com.nepal.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nepal.beans.User;
import com.nepal.beans.Vendor;
import com.nepal.dao.VendorDao;
import com.nepal.service.ConsultantService;
import com.nepal.service.UserService;

@Controller
public class IndexController {
	private static Logger logger = Logger.getLogger(IndexController.class);

	@RequestMapping("/")
	public String getIndexPage() {
		return "index";
	}

	
}

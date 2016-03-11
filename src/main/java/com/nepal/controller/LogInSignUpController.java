package com.nepal.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nepal.beans.User;
import com.nepal.service.PersistenceService;
import com.nepal.service.UserService;
import com.nepal.util.Role;

@Controller
public class LogInSignUpController {
private static Logger logger = Logger.getLogger(LogInSignUpController.class);
	
	@Autowired
	PersistenceService persistenceService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody User authenticateUser(){
		System.out.println("Inside User Controller");
		User user = userService.getUserByNameAndPwd("srijan", "kathmandu");
		System.out.println(user != null ? user.getId() : "No user with such un and pwd");
		return user;
		
	
	}
	
	@RequestMapping(value = "/signUpNewUser", method = RequestMethod.POST)
	public @ResponseBody User signUpNewUser(@RequestBody User user){
		
		System.out.println("Inside sign up new User Controller: " + user.getName());
		userService.addNewUser(user);
		return null;
		
	
	}
	@RequestMapping(value = "/fetchRole", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> fetchUserRole(){
		Map<String, String> roleMap = new HashMap<String, String>();
		for (Role role : Role.values()) {
			roleMap.put(role.name(), role.getRole());
		}
		return roleMap;
	}
}

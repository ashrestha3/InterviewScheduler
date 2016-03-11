package com.nepal.service;

import java.util.List;

import com.nepal.beans.User;

public interface UserService {
	List <User> getAllUsers();
	User getUserByNameAndPwd(String userName, String password);
	void addNewUser(User user);
}

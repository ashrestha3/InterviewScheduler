package com.nepal.dao;

import java.util.List;

import com.nepal.beans.User;


public interface UserDao {
	List <User> getAllUsers();
	void addUser(User user);
	void deleteUser(User user);
	User getUserByNameAndPwd(String userName, String password);
}

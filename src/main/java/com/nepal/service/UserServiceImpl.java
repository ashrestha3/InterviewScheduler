package com.nepal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.User;
import com.nepal.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	PersistenceService persistenceService;
	
	@Autowired
	UserDao userDao;
	
	
	@Transactional
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public User getUserByNameAndPwd(String userName, String password) {
		User user = userDao.getUserByNameAndPwd(userName, password);
		return user;
	}

	@Transactional
	public void addNewUser(User user) {
		persistenceService.addEntity(user);
	}

}

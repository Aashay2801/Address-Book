package com.yash.addressbook.serviceimpl;

import com.yash.addressbook.dao.ContactDAO;
import java.util.List;

import com.yash.addressbook.daoimpl.UserDAOImpl;
import com.yash.addressbook.model.User;
import com.yash.addressbook.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDAOImpl userDao ;
	
	public UserServiceImpl() {
		userDao = new UserDAOImpl();
	}
	
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(int userId) {
		
		return userDao.getUser(userId);
	}

	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user) {
		userDao.updateUser(user);

	}

	@Override
	public User authenticateUser(String userName, String password) throws Exception {
		return userDao.authenticateUser(userName, password);
	
	}

}

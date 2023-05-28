package com.services;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.beans.Tweet;
import com.beans.User;
import com.dao.UserDao;
import com.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	UserDao userDao =new UserDaoImpl();
	@Override
	public boolean createUser(User user) {
		// TODO Auto-generated method stub		
		return userDao.createUser(user);		
	}

	@Override
	public boolean isAlreadyAvailable(User user) {
		// TODO Auto-generated method stub	
		return userDao.isAlreadyAvailable(user);
	}

	@Override
	public User selectUser(String email, String password) {
		// TODO Auto-generated method stub
		
		return userDao.selectUser(email, password);
	}

	@Override
	public User selectUser(String email) {
		// TODO Auto-generated method stub
		
		return userDao.selectUser(email);
	}

	@Override
	public boolean updateUSer(String oldPassword, String newPassword,
			String email) {
		// TODO Auto-generated method stub
		
		return userDao.updateUser(oldPassword,newPassword,email);
	}

	@Override
	public ResultSet selectUser() {
		// TODO Auto-generated method stub
		return userDao.selectUser();
	}

	@Override
	public boolean updateUser(int userId, String status) {
		// TODO Auto-generated method stub
		return userDao.updateUser(userId, status);
	}

	@Override
	public User selectUser(int userId) {
		// TODO Auto-generated method stub
		return userDao.selectUser(userId);
	}

	@Override
	public boolean createTweet(Tweet twit) {
		// TODO Auto-generated method stub
		return userDao.createTweet(twit);
	}

	@Override
	public ResultSet selectTweet() {
		// TODO Auto-generated method stub
		return userDao.selectTweet();
	}

	@Override
	public ArrayList<User> searchUser(String name, int userId) {
		// TODO Auto-generated method stub
		return userDao.searchUser(name,userId);
	}
	
}

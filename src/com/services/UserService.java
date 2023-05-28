package com.services;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.beans.Tweet;
import com.beans.User;

public interface UserService {
	boolean createUser(User user);
	boolean isAlreadyAvailable(User user);
	boolean updateUSer(String oldPassword,String newPassword,String email);
	User selectUser(String email, String Password);
	User selectUser(String email);
	ResultSet selectUser();
	boolean updateUser(int userId, String status);
	User selectUser(int userId);
	boolean createTweet(Tweet twit);
	ResultSet selectTweet();
	ArrayList<User> searchUser(String name, int userId);
	
}

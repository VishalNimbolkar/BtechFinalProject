package com.services;

import java.util.ArrayList;

import com.beans.Admin;
import com.beans.RealTweetStream;
import com.beans.Tweet;
import com.beans.TweetStream;
import com.dao.AdminDao;
import com.dao.AdminDaoImpl;

public class AdminServiceImpl implements AdminService{
	AdminDao adminDao = new AdminDaoImpl();
	@Override
	public Admin selectAdmin(String email, String password) {
		// TODO Auto-generated method stub
		
		return adminDao.selectAdmin(email, password);
	}

	@Override
	public boolean updateAdmin(String oldPassword, String newPassword,String email) {
		// TODO Auto-generated method stub
		
		return adminDao.updateAdmin(oldPassword, newPassword, email);
	}

	@Override
	public ArrayList<Tweet> selectTweet() {
		// TODO Auto-generated method stub
		return adminDao.selectTweet();
	}

	@Override
	public boolean addStreamDataset(ArrayList<TweetStream> tweetStreamList) {
		// TODO Auto-generated method stub
		return adminDao.addStreamDataset(tweetStreamList);
	}

	@Override
	public boolean addRealStreamDataset(ArrayList<RealTweetStream> realTweetList) {
		// TODO Auto-generated method stub
		return adminDao.addRealStreamDataset(realTweetList);
	}
	
}

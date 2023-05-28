package com.dao;

import java.util.ArrayList;

import com.beans.Admin;
import com.beans.RealTweetStream;
import com.beans.Tweet;
import com.beans.TweetStream;

public interface AdminDao {
	Admin selectAdmin(String email, String password);

	boolean updateAdmin(String oldPassword, String newPassword, String email);

	ArrayList<Tweet> selectTweet();

	boolean addStreamDataset(ArrayList<TweetStream> tweetStreamList);

	boolean addRealStreamDataset(ArrayList<RealTweetStream> realTweetList);
}

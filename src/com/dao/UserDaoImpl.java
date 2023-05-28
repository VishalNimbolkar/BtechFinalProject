package com.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.beans.Tweet;
import com.beans.User;
import com.connection.ConnectionUtils;

public class UserDaoImpl implements UserDao{
	
	@Override
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql = "Insert into tblUser values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = ConnectionUtils.getConnection().prepareStatement(sql);
			pstmt.setInt(1, 0);
			pstmt.setString(2, user.getFname());
			pstmt.setString(3, user.getLname());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPassword());
			pstmt.setString(6, user.getDob());
			pstmt.setString(7, user.getGender());
			pstmt.setString(8, user.getAddress());
			pstmt.setString(9, user.getContact());
			pstmt.setBlob(10, user.getProfilePic());
			pstmt.setString(11, user.getProfileName());
			pstmt.setString(12, user.getStatus());
			int index = pstmt.executeUpdate();
			if(index>0){
				flag=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean isAlreadyAvailable(User user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql = "Select * from tblUser where emailid ='"+user.getEmail()+"'";
		try {
			Statement stmt = ConnectionUtils.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public User selectUser(String email, String password) {
		// TODO Auto-generated method stub
		User user = new User();
		String sql = "Select * from tblUser where emailid ='"+email.toLowerCase()+"' and password='"+password+"'";
		try {
			Statement stmt = ConnectionUtils.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				user.setUserId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setDob(rs.getString(6));
				user.setGender(rs.getString(7));
				user.setAddress(rs.getString(8));
				user.setContact(rs.getString(9));
				user.setProfilePic(rs.getBinaryStream(10));
				user.setProfileName(rs.getString(11));
				user.setStatus(rs.getString(12));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User selectUser(String email) {
		// TODO Auto-generated method stub
		User user = new User();
		String sql = "Select * from tblUser where emailid ='"+email.toLowerCase()+"'";
		try {
			Statement stmt = ConnectionUtils.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				user.setUserId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setDob(rs.getString(6));
				user.setGender(rs.getString(7));
				user.setAddress(rs.getString(8));
				user.setContact(rs.getString(9));
				user.setProfilePic(rs.getBinaryStream(10));
				user.setProfileName(rs.getString(11));
				user.setStatus(rs.getString(12));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean updateUser(String oldPassword, String newPassword, String email) {
		// TODO Auto-generated method stub
		boolean flag=false;
		
		String sql = "Update tblUser set password=? where password=? and emailid=?";
		try {
			PreparedStatement pstmt = ConnectionUtils.getConnection().prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setString(2, oldPassword);
			pstmt.setString(3, email);
			int index = pstmt.executeUpdate();
			if(index>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public ResultSet selectUser() {
		// TODO Auto-generated method stub
		ResultSet rs= null;
		String sql ="Select * from tblUser";
		try {
			PreparedStatement pstmt = ConnectionUtils.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

	@Override
	public boolean updateUser(int userId, String status) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(status.equalsIgnoreCase("Inactive"))
			status="Active";
		else
			status = "Inactive";
		
		String sql = "Update tblUser Set status=? Where userid=?";
		try {
			PreparedStatement pstmt = ConnectionUtils.getConnection().prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setInt(2, userId);
			int index=pstmt.executeUpdate();
			if(index>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public User selectUser(int userId) {
		// TODO Auto-generated method stub
		String sql ="Select * from tblUser Where userid=?";
		User user = new User();
		try {
			PreparedStatement pstmt = ConnectionUtils.getConnection().prepareStatement(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				user.setUserId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setDob(rs.getString(6));
				user.setGender(rs.getString(7));
				user.setAddress(rs.getString(8));
				user.setContact(rs.getString(9));
				user.setProfilePic(rs.getBinaryStream(10));
				user.setProfileName(rs.getString(11));
				user.setStatus(rs.getString(12));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
	}

	@Override
	public boolean createTweet(Tweet twit) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql = "Insert into tblTweet values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = ConnectionUtils.getConnection().prepareStatement(sql);
			pstmt.setInt(1, 0);
			pstmt.setString(2, twit.getMessage());
			pstmt.setBlob(3, twit.getUploadImg());
			pstmt.setString(4, twit.getUploadName());
			pstmt.setTimestamp(5, (Timestamp) twit.getTweetdate());
			pstmt.setInt(6, twit.getUser().getUserId());
			int index = pstmt.executeUpdate();
			if(index>0){
				flag=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public ResultSet selectTweet() {
		// TODO Auto-generated method stub
		ResultSet rs= null;
		String sql ="SELECT t.tweetid, t.message, t.uploadimg, t.uploadname, t.datetime, u.firstname, u.lastname, u.profilepic,u.userid"
				+" From tbltweet t, tbluser u Where t.userid=u.userid order by t.datetime desc";
		try {
			PreparedStatement pstmt = ConnectionUtils.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ArrayList<User> searchUser(String name, int userId) {
		// TODO Auto-generated method stub
		ArrayList<User> listUser = new ArrayList<User>();
		String sql="Select userid, firstname, lastname, profilepic, address From tblUser Where userid <> ? AND firstname like ? or lastname like ?";
		try {
			PreparedStatement pstmt = ConnectionUtils.getConnection().prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setString(2, name +"%");
			pstmt.setString(3, name +"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setProfilePic(rs.getBinaryStream(4));
				user.setAddress(rs.getString(5));
				listUser.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listUser;
	}

	
}

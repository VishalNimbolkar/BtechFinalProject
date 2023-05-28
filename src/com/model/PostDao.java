package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import com.beans.UserBean;
import com.connection.ConnectionUtils;



public class PostDao {
	
	public int insertTokenData(UserBean bean) throws SQLException 
	{
		String sql="insert into tbl_token values(?,?,?,?)";
		
			System.out.println("in  insert data dao..");
			Connection con=ConnectionUtils.getConnection();
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setInt(1,bean.getId());
			pst.setString(2,bean.getName());
			pst.setString(3,bean.getEmail());
			pst.setString(4,bean.getToken());
		
			
			int i=pst.executeUpdate();
			
			return i;
	}
	
	 

}


<%@ page import="java.sql.*,java.io.*,java.util.*" %> 
<%@ page import="com.beans.User" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
		User user = (User)session.getAttribute("UserData");
		int id= user.getUserId();
		InputStream is = user.getProfilePic();
	//int id=Integer.parseInt(id1);
		byte[] profilePic = null;
   			//OutputStream out = response.getOutputStream();
   		byte[] buffer = new byte[1024*1024*50];
		int bytesRead;		
		if(is!=null){
			while ((bytesRead =is.read(buffer)) != -1)
			{
			    	response.reset();
					response.setContentType("image/jpg");
					response.setHeader("Content-disposition","attachment; filename=" );
			        response.getOutputStream().write(buffer, 0, bytesRead);
			        response.getOutputStream().flush(); 

			 }
		}		

%>
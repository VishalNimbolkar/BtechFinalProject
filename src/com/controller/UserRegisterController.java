package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.beans.User;
import com.services.UserService;
import com.services.UserServiceImpl;

/**
 * Servlet implementation class UserRegisterController
 */
@WebServlet("/UserRegisterController")
@MultipartConfig(maxFileSize=1024*1024*50)

public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password1");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String status = "Inactive";
		Part part=request.getPart("profilePic");
		InputStream profilePic=null;		
		String profileName="";
		File upload=null;
		
		if(part!=null)
		{
			profilePic=part.getInputStream();
			System.out.println("is size:"+profilePic.available());
			profileName=extractFileName(part);
			System.out.println("name:"+profileName);
		}
		
		User user = new User();
		user.setFname(fname);
		user.setLname(lname);
		user.setEmail(email);
		user.setPassword(password);
		user.setDob(dob);
		user.setGender(gender);
		user.setAddress(address);
		user.setContact(contact);
		user.setProfilePic(profilePic);
		user.setProfileName(profileName);
		user.setStatus(status);
		
		UserService userService = new UserServiceImpl();
		if(userService.isAlreadyAvailable(user)){
			request.setAttribute("ErrMsg", "Your account is already registered...");
			RequestDispatcher rd = request.getRequestDispatcher("user_register.jsp");
			rd.include(request, response);
		}else{
			if(userService.createUser(user))
			{
				RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
				request.setAttribute("SucMsg", "Your account is registered successfully. Wait for activation.");
				rd.forward(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("user_register.jsp");
				request.setAttribute("ErrMsg", "Your account is not registered. Please try again!...");
				rd.include(request, response);
			}			
		}		
	}
		private String extractFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        System.out.println("contentDisp:"+contentDisp);
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return s.substring(s.indexOf("=") + 2, s.length()-1);
	            }
	        }
	        return "";
	    }


}

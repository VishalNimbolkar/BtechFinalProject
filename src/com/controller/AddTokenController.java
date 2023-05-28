package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.algorithms.Main;
import com.beans.UserBean;
import com.model.PostDao;



@WebServlet("/AddTokenController")
public class AddTokenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddTokenController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in token submit button");
		PrintWriter out=response.getWriter();
		String token=request.getParameter("token");

		HttpSession session=request.getSession();
		String Name=(String) session.getAttribute("emailMsg");
		System.out.println("Email ID>>>>>>>>"+Name);
		
		
	   UserBean bean=new UserBean();
	   PostDao dao=new PostDao();
	  
		try {
			
		
	bean.setName(Name);
	   bean.setEmail(Name);
	   bean.setToken(token);



	   int i=dao.insertTokenData(bean);
	  

	if(token!=" " || token!=null)
	{
		Main ma=new Main();
		
			ma.getdata(token, Name);
		
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Token Entered Successfully')");
			out.println("location='RealtimeData.jsp';");
			out.println("</script>");
	}
	else {
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Invalid Token')");
		out.println("location='FacebookToken.jsp';");
		out.println("</script>");
	}} catch (SQLException e) {
		
		e.printStackTrace();
	}
}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

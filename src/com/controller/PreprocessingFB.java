package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algorithms.Porter;
import com.algorithms.RemoveDup;

@WebServlet("/PreprocessingFB")
public class PreprocessingFB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PreprocessingFB() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action").equalsIgnoreCase("stemming"))
		{
			RemoveDup rmvd=new RemoveDup();
			int count=0;
			String word[] = null;
			String sentence="";
			
			System.out.println("-------------------------------");
			HttpSession stem=request.getSession();
			ArrayList<String> stopwordresult = new ArrayList<String>();
			stopwordresult=(ArrayList<String>) stem.getAttribute("msg_stopwordresult");
			stopwordresult.removeAll(Collections.singleton(null));
			System.out.println(stopwordresult);
			System.out.println("-------------------------------");
			
			String[] stockArr = new String[stopwordresult.size()];
			stockArr = stopwordresult.toArray(stockArr);

				
			for(int j=0;j<stockArr.length;j++)
			{
				stockArr[j]=rmvd.removeDup(stockArr[j]);
			}
			for(int j=0;j<stockArr.length;j++)
			{
				Porter porter = new Porter();
				stockArr[j]=porter.stripSuffixes(stockArr[j]);
				sentence = sentence + stockArr[j]+" ";
			}
			stem.setAttribute("stemmingResult", sentence);
						
			int count1=0;
			String word1[] = null;
			String sentence1="";
			
			System.out.println("-------------------------------");
			ArrayList<String> stopwordresult1 = new ArrayList<String>();
			stopwordresult1=(ArrayList<String>) stem.getAttribute("reply_stopwordresult");
			stopwordresult1.removeAll(Collections.singleton(null));
			System.out.println(stopwordresult1);
			System.out.println("-------------------------------");
			
			String[] stockArr1 = new String[stopwordresult1.size()];
			stockArr1 = stopwordresult1.toArray(stockArr1);

				
			for(int j=0;j<stockArr1.length;j++)
			{
				stockArr1[j]=rmvd.removeDup(stockArr1[j]);
			}
			for(int j=0;j<stockArr1.length;j++)
			{
				Porter porter = new Porter();
				stockArr1[j]=porter.stripSuffixes(stockArr1[j]);
				sentence1 = sentence1 + stockArr1[j]+" ";
			}
			stem.setAttribute("stemmingReply", sentence1);
			response.sendRedirect("StemmingFB.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

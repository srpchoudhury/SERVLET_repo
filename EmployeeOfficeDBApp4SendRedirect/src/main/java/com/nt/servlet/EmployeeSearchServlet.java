package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class EmployeeSearchServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		 //get print writer
		 PrintWriter pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 //read form data
		String ss=req.getParameter("ss");
		String engine=req.getParameter("engine");
		
		//send hyperlinks to browser having url to complete sendRedirection
		if(engine.equalsIgnoreCase("google"))
			   pw.println("<h1 style='color:red;text-align:center'><a href='https://www.google.com/search?q="+ss+"'>click her for google search</a></h1>");
		else if(engine.equalsIgnoreCase("bing"))
			 pw.println("<h1 style='color:red;text-align:center'><a href='https://www.bing.com/search?q="+ss+"'>click her for bing search</a></h1>");
		else
			 pw.println("<h1 style='color:red;text-align:center'><a href='https://in.search.yahoo.com/search?q="+ss+"'>click her for yahoo search</a></h1>");
		
		//close stream
		pw.close();
	}//doGet(-,-)
	 
	 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
           
}//class
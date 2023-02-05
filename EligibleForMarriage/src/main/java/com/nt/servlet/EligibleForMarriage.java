package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EligibleForMarriage extends HttpServlet {
	
      @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	  System.out.println("EligibleForMarriage.doGet(-,-)");
    	  //get print writer
    	  
    	PrintWriter pw=res.getWriter();
      //set response type
    	res.setContentType("text/html");
    	
    	//read form data
    	String pname=req.getParameter("name");
    	int page=Integer.parseInt(req.getParameter("age"));
    	
		String pgender=req.getParameter("gender");
    	
		//write bussiness logic 
    	if(page<21)
    		pw.println("<h1 style='color:yellow;text-align:center'>Mr/Miss"+pname+"you are not Elligible for Marriage</h1>");
    	else
    	   pw.println("<h1 style='color:blue;text-align:center'>Mr/Miss"+pname+"you are Elligible for Marriage</h1>");
    	
   	 //add home hyperlink(graphical hyperlink)
   	 pw.println("<a href='http://localhost:3030/EligibleForMarrige/index.html'>HOME</a>");
    		//close stream
    	pw.close();
      }// deGet(-,-)
}//class

package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
           @Override
        public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        	//get print writer
        	   PrintWriter pw=res.getWriter();
        	   //set response content type
        	   res.setContentType("text/html");
        	   //read special request param value
        	   String s1Val=req.getParameter("s1");
        	   //read form data (text box value)
        	   int val1=0;
        	   int val2=0;
        	   
        	 //read text box values only when the req is not comming from hyperlinks
        	   if(!s1Val.equalsIgnoreCase("link1") && !s1Val.equalsIgnoreCase("link2")) { 
        		   val1=Integer.parseInt(req.getParameter("t1"));
        		   val2=Integer.parseInt(req.getParameter("t2"));
        	   }
        	   //differentiate logic for submit buttons and hyperlinks
        	   if(s1Val.equalsIgnoreCase("add")) 
        		   pw.println("<h1 style='color:green'>Sum of "+val1+" and "+val2+"is :: "+(val1+val2)+"</h1>");
        	   else if(s1Val.equalsIgnoreCase("sub"))
        			   pw.println("<h1 style='color:red'>Sub of "+val1+" and "+val2+"is :: "+(val1-val2)+"</h1>");
        	   else if(s1Val.equalsIgnoreCase("mul"))
        			   pw.println("<h1 style='color:pink'>Mul of "+val1+" and "+val2+"is :: "+(val1*val2)+"</h1>");
        	   else if(s1Val.equalsIgnoreCase("div"))
    			   pw.println("<h1 style='color:yellow'>Div of "+val1+" and "+val2+"is :: "+((float)val1/val2)+"</h1>");
        	   else if(s1Val.equalsIgnoreCase("link1")) {
        		   pw.println("<h1 style='color:blue'>System Properties are </h1>");
        		   pw.println("<b>"+System.getProperties()+"</b>");
        	   }
        	   else {
        		   pw.println("<h1 style='color:purple'>system date and time :: "+LocalDateTime.now()+"</h1>");
        	   }
        	   
        	   //add home hyperlink
        	   pw.println("<br><a href='form.html'>home</a>");
        	   
        	   //close stream
        	   pw.close();
        	   
        }
           
           @Override
       public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                doGet(req,res);
        }
}

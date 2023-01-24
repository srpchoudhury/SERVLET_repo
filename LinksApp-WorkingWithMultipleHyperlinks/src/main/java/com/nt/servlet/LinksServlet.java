package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
   
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      
      //get printWriter
      PrintWriter pw=res.getWriter();
      
      //set response content type
      res.setContentType("text/html");
      
      //read additional req param value(p1)
      String pval=req.getParameter("p1");
      
      //get all available locales
      Locale locales[]=Locale.getAvailableLocales();
      
      //differentiate logics for hyperlinks
      if(pval.equalsIgnoreCase("link1")) {
    	 pw.println("<h1>All Languages are </h1>") ;
           for(Locale l:locales) {
    	       pw.println(l.getDisplayLanguage()+" ");
          }//for
      }//if
      
      else if(pval.equalsIgnoreCase("link2")) {
    	  pw.println("<h1>All Conutries are</h1>");
    	  for(Locale l:locales) {
    		  pw.println(l.getDisplayCountry()+" ");
    	  }
      }
      else {
    	  pw.print("<h1>Sytem date and Time ::: "+LocalDateTime.now()+"<h1>");
      }
      
      //add home hyperlink
      pw.println("<br><a href='links.html'>home</h1>");
      
      //close stream
      pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class

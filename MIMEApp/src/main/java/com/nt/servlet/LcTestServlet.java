package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LcTestServlet extends HttpServlet {
	
	static {
		System.out.println("LcTestServlet :: static block");
	}
        
	  public LcTestServlet() {
		System.out.println("LcTestServlet.LcTestServlet() :: 0-param constructor");
	  }
	  
	  @Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LcTestServlet.init() :: init (ServlettConfig cg");
	}
	  
	  @Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LcTestServlet.service()::service(res,req)");
		//get print writer
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//write messages to response object using printWriter
		pw.println("<h1 style='color:red;text-align:center'>Date and  time :: "+new java.util.Date()+ "</h1>");
		//close stream
		pw.close();
		
	}
	  
	  @Override
	public void destroy() {
		System.out.println("LcTestServlet.destroy()");
	}
}//class

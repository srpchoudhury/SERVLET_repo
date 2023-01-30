package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DBTestServlet extends HttpServlet {
	
	static {
		System.out.println("DBTestServlet :: static block");
	}
        
	  public DBTestServlet() {
		System.out.println("DBTestServlet.LcTestServlet() :: 0-param constructor");
	  }
	  
	 @Override
	public void init(ServletConfig cg) throws ServletException {
		System.out.println("DBTestServlet.init() :: init (ServlettConfig cg)");
		//read from servlet config object
		System.out.println("driver class name :: "+cg.getInitParameter("driverClass"));
		System.out.println("jdbc url :: "+cg.getInitParameter("url"));
		System.out.println("db user name :: "+cg.getInitParameter("dbuser"));
		System.out.println("db user password :: "+cg.getInitParameter("dbpwd"));
		
		//write jdbc code here using the jdbc properties available in servlet config obj
		
	}
	  
	  @Override
	public void init() throws ServletException {
		System.out.println("DBTestServlet.init()");
	}
	  
	  
	  @Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("DBTestServlet.service()::service(res,req)");
		//destroy();
		//get print writer
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//write messages to response object using printWriter
		pw.println("<h1 style='color:red;text-align:center'>Date and  time :: "+new java.util.Date()+ "</h1>");
		//close stream
		pw.close();
		
	}
	  public static void main(String[] args) {
		System.out.println("DBTestServlet.main()");
	}
	  
	  @Override
	public void destroy() {
		System.out.println("DBTestServlet.destroy()");
	}
}//class

package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printWritter
		PrintWriter pw=res.getWriter();
		//get access to servletcontext obj
		ServletContext sc=getServletContext();
		pw.println("<br> <b>server info :: "+sc.getServerInfo());
		pw.println("<br> <b>servlet api version major  :: "+sc.getMajorVersion()+" minor  :: "+sc.getMinorVersion()+"</b>");
		pw.println("<br><b>MIME type of search.html file :: "+sc.getMimeType("/search.html")+"</b>");
		pw.println("<br><b>path of web application :: "+sc.getRealPath("/")+"</b>");
		pw.println("<br><b>path of search.html :: "+sc.getRealPath("/search.html")+"</b>");
		pw.println("<br><b> name of the web application :: "+sc.getContextPath()+"</b>");
		pw.println("<br><b> virtual host name :: "+sc.getVirtualServerName()+"</b>");
		
		System.out.println("TestServlet servlet context hash code :: "+sc.hashCode());
		//read init parameter
		pw.println("<br><b>db user init param values :: "+sc.getInitParameter("dbuser")+"</b>");
		pw.println("<br><b>servelt config obj class name :: "+sc.getClass()+"</b>");
		
		//close stream
		pw.close();
	}

}

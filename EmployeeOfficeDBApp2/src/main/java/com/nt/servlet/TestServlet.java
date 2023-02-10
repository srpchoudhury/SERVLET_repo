package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printWritter
		PrintWriter pw=res.getWriter();
		//get access to servletconfig obj
		ServletConfig cg=getServletConfig();
		pw.println("<b>servlet name :: "+cg.getServletName()+"</b>");
		System.out.println("TestServlet servlet config obj :: "+cg.hashCode());
		//read init parameter
		pw.println("<br><b>db user init param values :: "+cg.getInitParameter("dbuser")+"</b>");
		pw.println("<br><b>servelt config obj class name :: "+cg.getClass()+"</b>");
		//close stream
		pw.close();
	}

}

package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeaderServlet
 */
@WebServlet("/headurl")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html");
	  pw.println("<marquee><h1 style='color:blue'>Naresh IT Technology</h1></marquee>");
	}

	
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}

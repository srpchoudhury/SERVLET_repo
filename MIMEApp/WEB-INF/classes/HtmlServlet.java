package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HtmlServlet extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		//set response content type
	  res.setContentType("text/html");

	  //get PrintWriter stream
	  PrintWriter pw=res.getWriter();

	  //enable auto refresh on the web page
	  res.setHeader("refesh","10");

	  //write output content to browser
	  pw.println("<table border='1',align='cente'> ");
	  pw.println("<tr><th>Player Name</th> <th>Madel</th> <th>Category</th> </tr>");
	  pw.println("<tr><td>Neeraj Chopra</td> <td>Gold</td> <td>Javeline Throw</td> </tr>");
	  pw.println("<tr><td>Meera Bhai Chanu</td> <td>Silver</td> <td>Weight Lifting</td> </tr>");
	  pw.println("<tr><td>RaviKumar Dhaia</td> <td>Silver</td> <td>Wrestling</td> </tr>");
	  pw.println("<tr><td>P.V Sindhu</td> <td>Silver</td> <td>Bandminton</td> </tr>");
	  pw.println("<tr><td>Lovlina</td> <td>Bronze</td> <td>Boxing</td> </tr>");
	  pw.println("<tr><td>Hockey</td> <td>Bronze</td> <td>Mens Hockey</td> </tr>");
	  pw.println("<tr><td>Bajarang Punia</td> <td>Bronze</td> <td>Wrestling</td> </tr>");
	  pw.println("</table>");

	  pw.println("<br><h1 style='color:red;text-align:center'> Date and Time is :: "+new java.util.Date()+"</h1>");
	  //close stream
	  pw.close();
	}//end service

}
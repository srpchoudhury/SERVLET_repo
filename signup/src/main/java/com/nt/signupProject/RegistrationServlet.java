package com.nt.signupProject;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("name");
		String uemail=request.getParameter("email");
		String upwd=request.getParameter("pass");
		String umobile=request.getParameter("contact");
		RequestDispatcher dispatcher=null;
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","MYDB6PM","MYDB6PM");
		    pst=con.prepareStatement("INSERT INTO USERS (ID,UNAME,UPWD,UEMAIL,UMOBILE) VALUES (USER_SEQ.NAXTVAL,?,?,?,?)");
		  pst.setString(1, uname);
		  pst.setString(2, upwd);
		  pst.setString(3, uemail);
		  pst.setString(4, umobile);
		  
		  int rowCount=pst.executeUpdate();
		  dispatcher=request.getRequestDispatcher("registration.jsp");
		  if(rowCount>0) {
			  request.setAttribute("status", "sucess");	  
		  }else {
			  request.setAttribute("status", "failed");  
		  }
		  dispatcher.forward(request, response);
	
		}	
		catch(SQLException se) {
			se.printStackTrace();
	   } 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null)
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		}

       
	}
}

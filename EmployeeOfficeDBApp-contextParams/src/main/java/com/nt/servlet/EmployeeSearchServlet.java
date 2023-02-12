

package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet {
	 private static final String GET_EMP_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	 @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 System.out.println("EmployeeSearchServlet.doGet()");
		 //get print writer
		 PrintWriter pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 //get access tp serveltContext obj
		 ServletContext sc=getServletContext();
		 
		 System.out.println("EmployeeSearchServlet servletContext obj :: "+sc.hashCode());
		 //read servlet init param values
		 String driver=sc.getInitParameter("driverClass");
		 String url=sc.getInitParameter("url");
		 String user=sc.getInitParameter("dbuser");
		 String pwd=sc.getInitParameter("dbpwd");
		 
		 
		 //read form data
		 int no=Integer.parseInt(req.getParameter("eno"));
		 try {
			 Class.forName(driver);
		 }catch(ClassNotFoundException cnfe) {
			 cnfe.printStackTrace();
		 }
		 
		 try(Connection con=DriverManager.getConnection(url,user,pwd);
				PreparedStatement ps=con.prepareStatement(GET_EMP_BY_NO) ){
			 if(ps!=null)
				 ps.setInt(1, no);
			 try(ResultSet rs=ps.executeQuery()){
				    if(rs!=null) {
				    	if(rs.next()) {
				    		pw.println("<h1 style='color:blue;text-align:center'>Employee Details are</h1>");
				    		
				    		pw.println("<p style='text-align:center'><b>Employee Number :: "+rs.getInt(1)+"</b><br>");
				    		pw.println("<b> Employee Name :: "+rs.getString(2)+"</b><br>");
				    		pw.println("<b> Employee JOB :: "+rs.getString(3)+"</b><br>");
				    		pw.println("<b> Employee Salary :: "+rs.getFloat(4)+"</b><br>");
				    		pw.println("<b> Employee Dept Number:: "+rs.getFloat(5)+"</b><br></p>");
				    	}//if
				    	else {
				    		pw.println("<h1 style='color:red;text-align:center'>Employee not found</h1>");
				    	}//else
				    }//if
				    pw.println("<br><br><p style='text-align:center'><a href='search.html'>home</a>");
				 
				    //close stream
				    pw.close();
			 }//try2
			 
		 }//try1
		 catch(SQLException se) {
			 se.printStackTrace();
		 }
		
	}//doGet(-,-)
	 
	 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
           
}//class


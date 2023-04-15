package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String GET_EMP_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	 @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 System.out.println("EmployeeSearchServlet.doGet()");
		 //get print writer
		 PrintWriter pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 //include header content
		 RequestDispatcher rd1=req.getRequestDispatcher("/headurl");
		 rd1.include(req, res);
		 //read form data
		 int no=Integer.parseInt(req.getParameter("eno"));
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		 }catch(ClassNotFoundException cnfe) {
			 cnfe.printStackTrace();
		 }
		 
		 try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","MYDB6PM","mydb6pm");
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
				 
				 
				   
			 }//try2
			 
	
		 
		 //include footer content
		 RequestDispatcher rd2=req.getRequestDispatcher("/footer.html");
		 rd2.include(req, res);
		   //close stream
		 pw.close();
	 }//try
		 catch(SQLException se) {
			 se.printStackTrace();
		 }
}
		

	 
	 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
           
}//class*/
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CustomerRegistrationServlet extends HttpServlet {
           private final String CUSTOMER_INSERT_QUERY="INSERT INTO SERVLET_CUSTOMER VALUES (CUSTOMER_SEQ.NEXTVAL,?,?,?)";
           
           @Override
        public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
               //get Print Writer
        	   PrintWriter pw=res.getWriter();
        	   ///set response content type
        	   res.setContentType("text/html");
        	   //read form data (req param values)
        	   String name=req.getParameter("cname");
        	   String addrs=req.getParameter("cadd");
        	   float billAmt=Float.parseFloat(req.getParameter("billAmt"));
        	   long mobileNo=Long.parseLong(req.getParameter("mobileNo"));
        	   
        	   //get polled jdbc connection obj
        	   try(Connection con=getPolledConnection();
        			   PreparedStatement ps=con.prepareStatement(CUSTOMER_INSERT_QUERY)
        					   ){
        		   //set values to query param
        		   ps.setString(1, name);
        		   ps.setString(2, addrs);
        		   ps.setFloat(3, billAmt);
        		   ps.setLong(4, mobileNo);
        		   
        		   //execute the query
        		   int result=ps.executeUpdate();
        		   //process the result
        		   if(result==1)
        			   pw.println("<h1 style='color:green'>Customer is registerd</h1>");
        		   else
        			   pw.println("<h1 style='color:green'>Customer is not registerd</h1>");  
        		   
        		   //add hyperlink
        		   pw.println("<br><br><a href='Customer_register.html'>home</a>");
        		   //close stream
        		   pw.close();
        	   }//try
        	   catch(SQLException se) {
        		   se.printStackTrace();
        		   pw.println("<h1 style='color:green'>Internal Problem"+se.getMessage()+"</h1>");
          		   //add hyperlink
        		   pw.println("<br><br><a href='Customer_register.html'>home</a>");
        	   }catch(Exception e) {
        		   e.printStackTrace();
        		   pw.println("<h1 style='color:green'>Internal Problem"+e.getMessage()+"</h1>");
          		   //add hyperlink
        		   pw.println("<br><br><a href='Customer_register.html'>home</a>");
        	   }
        	   
        }//doGet(-,-)
           @Override
        public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                 doGet(req,res);
        }//doPost(-,-)
           
           //helper method
           private Connection getPolledConnection()throws Exception{
        	   //create initialContext object
        	   InitialContext ic=new InitialContext();
        	   //Get datasource object ref through lookup operation
        	   //DataSource ds=(DataSource)ic.lookup("Dsjndi");     //for GlashFish server
        	   //get DsJndi Name from servlet init param
        	   String jndiName=getServletConfig().getInitParameter("jndi");
        	   DataSource ds=(DataSource)ic.lookup(jndiName);
        	   
        	   //get pooled jdbc connection
        	   Connection con=ds.getConnection();
        	   return con;
           }
}

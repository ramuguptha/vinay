package com.vinay;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForgotRec extends HttpServlet
	{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		
		
		String number=req.getParameter("num");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "vinaydb1", "pass");
			PreparedStatement smt = con.prepareStatement("select * from narndhar where mobileNo=?");
			//ResultSet rs = smt.executeQuery("select * from narndhar where mobileNo=?");
			
			smt.setString(1, number);
			
	        ResultSet rs = smt.executeQuery();
			
			if(rs.next()) {
				out.println("<html>");
		        out.println("<body>");
		    	out.println("<center>");
				out.println("<div>");
				out.println("<label>FristName : &nbsp; </label>"+rs.getString("fname")+"<br/>");
				out.println("<label>LastName : &nbsp; </label>"+rs.getString("lname")+"<br/>");
				out.println("<label>FullName : &nbsp; </label>"+rs.getString("funame")+"<br/>");
				out.println("<label>Gender : &nbsp; </label>"+rs.getString("gender")+"<br/>");
				out.println("<label>MobileNo : &nbsp; </label>"+rs.getString("mobileNo")+"<br/>");
				out.println("<label>Email : &nbsp; </label>"+rs.getString("email")+"<br/>");
				out.println("<label>Password : &nbsp; </label>"+rs.getString("password")+"<br/>");
				out.println("<label>Country : &nbsp; </label>"+rs.getString("country")+"<br/>");
				out.println("<label>Date of registration : &nbsp; </label>"+rs.getString("dateofreg")+"<br/>");
				out.println("</div>");
				out.println("</center>");
		        out.println("</body>");
		    	out.println("</html>");
			}
			else {
				out.println("error");
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}

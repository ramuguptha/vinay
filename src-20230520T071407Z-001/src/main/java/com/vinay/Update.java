package com.vinay;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Update extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		res.setContentType("text/htm");
		
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String funame=req.getParameter("funame");
		String gender=req.getParameter("gen");
		String email=req.getParameter("email");
		String password=req.getParameter("pwd");
		String country=req.getParameter("country");
		String dateofreg=req.getParameter("date");
		String mobileNo=req.getParameter("mnumber");
		//System.out.println(dateofreg.length());
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "vinaydb1", "pass");
			PreparedStatement smt=con.prepareStatement("update narndhar set fname=?,lname=?,funame=?,gender=?,email=?,password=?,country=?,dateofreg=? where mobileNo=?;");
			
			
			smt.setString(1, fname);
			smt.setString(2, lname);
			smt.setString(3, funame);
			smt.setString(4, gender);
			smt.setString(5, email);
			smt.setString(6, password);
			smt.setString(7, country);
			smt.setString(8, dateofreg);
			smt.setString(9, mobileNo);
			
			int n=smt.executeUpdate();
			
			if(n>0)
				out.print("sucess");
			else
				out.print("failure plz check the code");
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}

package com.vinay;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.Statement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteOfRec extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		
		String number=req.getParameter("num");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "vinaydb1", "pass");
			PreparedStatement smt=con.prepareStatement("delete from narndhar where mobileNo=?");
			smt.setString(1, number);
			
			int n=smt.executeUpdate();
			if(n>0)
				out.println("deletion sucess");
			else
				out.print("missing");

		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}

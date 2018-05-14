package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestDbServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			
			/*Because we already setup this user in the mysql database, with the SQL script
			we ran earlier, we can do this.  */
			
			String userName= "springstudent";
			
			String password= "springstudent";
			
			String jdbcUrl= "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
			
			String driver= "com.mysql.jdbc.Driver";
			
			PrintWriter out= response.getWriter();
			
			out.println("Connecting to database " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection connection= DriverManager.getConnection(jdbcUrl, userName, password);
			
			out.println("Successfull");
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			throw new ServletException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

package com.project.bookstore.BookStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	static Connection con;
	
	public static Connection creatC() {
		
		try {
			// Driver loading
			//Class.forName("com.mysql.jdbc.Driver");
			
			// create the connection...
			String url = "jdbc:mysql://localhost:3306/project_db_customer";
			String user="root";
			String password = "Palikundwar@11";
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Successfull connection!\n");
			System.out.println("");
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return con;
	}
}
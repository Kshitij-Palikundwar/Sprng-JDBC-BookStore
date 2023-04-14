package com.project.bookstore.BookStoreDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.project.bookstore.BookStore.ConnectionProvider;
import com.project.bookstore.BookStore.User;

public class UserDao {
	public static boolean insertUserToDB(User user)  {
		boolean f=false;
		// JDBC code to Insert Users data
		
		try {
			Connection con = ConnectionProvider.creatC();
			
			String q = "insert into user_table(userName,userPh,userMail,userAddr,userPassw) values(?,?,?,?,?)";
			
			// Prepared Statement
			PreparedStatement psmt = con.prepareStatement(q);
			
			// Setting values of parameter values ???
			psmt.setString(1, user.getuName());
			psmt.setString(2, user.getuPh());
			psmt.setString(3, user.getuMail());
			psmt.setString(4, user.getuAddr());
			psmt.setString(5, user.getuPass());
			
			// Executing...
			psmt.executeUpdate();
			f = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static void showAllUser() {
		// JDBC code to Show Users data
		try {
			Connection con = ConnectionProvider.creatC();
			
			String q = "select * from user_table;";
			
			// Create Statement
			Statement smt = con.createStatement();
			
//			// Setting values of parameter values ???
//			psmt.setString(1, user.getuName());
//			psmt.setString(2, user.getuPh());
//			psmt.setString(3, user.getuMail());
//			psmt.setString(4, user.getuAddr());
//			psmt.setString(5, user.getuPass());
			
			// Executing...
			ResultSet set = smt.executeQuery(q);
			
			// Showing each row 
			System.out.println("User Details -");
			while(set.next()) {
				int id = set.getInt(1);  // Here userID is in 1st column hence getInt(1)
				String name = set.getString(2);
				String ph = set.getString(3);
				String mail = set.getString(4);
				String addr = set.getString(5);
				String pass = set.getString(6);
				
				System.out.println("ID-"+id+"\nName-"+name+"\nPhone-"+ph+
						"\nmail-"+mail+"\nAddress-"+addr+"\nPassword-"+pass+"\n"+"\n++++++++++++++++++++++++++\n");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

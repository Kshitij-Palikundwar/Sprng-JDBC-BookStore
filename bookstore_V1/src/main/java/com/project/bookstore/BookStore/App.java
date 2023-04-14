package com.project.bookstore.BookStore;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.project.bookstore.BookStoreDAO.ProductDao;
import com.project.bookstore.BookStoreDAO.UserDao;

import java.io.IOException;

public class App{

	public static void main(String[] args) throws IOException {
		
		System.out.println("Hello...\nWelcome to Book Store");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Press 1 to ADD User.");
			System.out.println("Press 2 to Show User");
			System.out.println("Press 3 to Show Products");
			System.out.println("Press 4 to Exit");
			//System.out.println("Press 5 to Update");
			
			// To get the input from user to perform required operation 
			int input = Integer.parseInt(br.readLine());
			
			if(input == 1) {
				// ADD User data operations
				System.out.println("Enter User Name: ");
				String name = br.readLine();
				
				System.out.println("Enter your Phone No: ");
				String phno = br.readLine();
				
				System.out.println("Enter your Mail Id: ");
				String mail = br.readLine();
				
				System.out.println("Enter your Address: ");
				String addr = br.readLine();
				
				System.out.println("Enter Password: ");
				String psw = br.readLine();
				
				// Now creating User object to store users data
				User user = new User(name, phno, mail, addr, psw);
				boolean ans = UserDao.insertUserToDB(user);
				if(ans)
					System.out.println("New user successfully added!!!");
				else
					System.out.println("Something went wrong. Sorry no user data is added.");
				System.out.println(user);
				
				
			}else if(input == 2){
				// Show User data
				UserDao.showAllUser();
			}
			else if(input == 3){
				// Show Products Data
				ProductDao.showAllProducts();
			}
			else if(input == 4){
				// Exit
				break;
			}
//			else if(input == 5) {
//				
//			}
			else {
				
			}
			
		}
		System.out.println("Thanks for using app have a great day...");
	}

}
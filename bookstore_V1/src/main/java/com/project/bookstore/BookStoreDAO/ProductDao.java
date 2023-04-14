package com.project.bookstore.BookStoreDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.project.bookstore.BookStore.ConnectionProvider;


public class ProductDao {

	public static void showAllProducts() {
		// JDBC code to Show Books data
		try {
			Connection con = ConnectionProvider.creatC();
			// MySQL query to show product_table data
			String q = "select * from product_table;";

			// Create Statement
			Statement smt = con.createStatement();

			// Executing...
			ResultSet set = smt.executeQuery(q);

			// Showing each row of product_table
			System.out.println("Books Catalog -");
			while (set.next()) {
				int id = set.getInt(1); // Here productID is in 1st column hence getInt(1)
				String userId = set.getString(2);
				String prodName = set.getString(3);
				String auth = set.getString(4);
				String descr = set.getString(5);
				String price = set.getString(6);
				String quant = set.getString(7);

				System.out.println("Book ID-" + id + "\nUser ID-" + userId + "\nBook Name-" + prodName + "\nAuthor-"
						+ auth + "\nDescription-" + descr + "\nPrice-Rs." + price + "\nQuantity-" + quant + "\n" + "\n"
						+ "----------------------------------------------------------------------------------\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

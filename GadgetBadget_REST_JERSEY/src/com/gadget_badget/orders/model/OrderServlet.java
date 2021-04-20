package com.gadget_badget.orders.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderServlet 
{
		// Common for every function
		private Connection connect()  { 
			Connection connection = null; 
			try { 
				Class.forName("com.mysql.jdbc.Driver"); 
				// Change your configurations settings
				connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget_rest_jersey", "root", "issa123"); 
			} catch (Exception e)  {e.printStackTrace();} 
			 	return connection; 
		}   
		
		public String insertOrder(String order_code, String customer_id, String customer_email, String customer_name, String order_total_amount, String card_no, String cvv_no) 
		 { 
			 String output = ""; 
			 try { 
				 Connection connection = connect(); 
				 if (connection == null)  {
					 return "Error while connecting to the database for inserting."; 
				 } 
				 
			 	 String query = "INSERT INTO order_tab"
			 	 		+ "(`orderID`,`orderCode`,`customerID`,`customerEmail`,`customerName`,`orderTotalAmount`,`cardNo`,`cvvNo`)"
			 	 		+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; 
				 PreparedStatement preparedStatement = connection.prepareStatement(query); 
				 
				 preparedStatement.setInt(1, 0);
				 preparedStatement.setString(2, order_code);
				 preparedStatement.setString(3, customer_id);
				 preparedStatement.setString(4, customer_email);
				 preparedStatement.setString(5, customer_name);
				 preparedStatement.setDouble(6, Double.parseDouble(order_total_amount));
				 preparedStatement.setString(7, card_no);
				 preparedStatement.setString(8, cvv_no);
				 preparedStatement.execute(); 
				 connection.close(); 
				 
				 output = "Order has been placed successfully..!"; 
			 }   catch (Exception e)  { 
				 output = "Error while inserting the order into the database..!.";
				 System.err.println(e.getMessage());
			 } 
		 	return output; 
		 } 
} 
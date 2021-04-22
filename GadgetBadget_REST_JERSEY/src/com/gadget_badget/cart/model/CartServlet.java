package com.gadget_badget.cart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CartServlet 
{
	private Connection connect() 
	{ 
		Connection con = null; 
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver"); 
			 
			 //Provide the correct details: DBServer/DBName, username, password 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget_rest_jersey", "root", ""); 
		} 
		catch (Exception e) 
		{e.printStackTrace();} 
		 	return con; 
		} 


        public String insertCart(String cart_code, String project_code, String project_name, String project_qty , String project_unit_price , String customer_id) 
		 { 
			 String output = ""; 
			 try
			 { 
				 Connection con = connect(); 
				 if (con == null) 
				 {
					 return "Error while connecting to the database for inserting."; 
				 } 

                 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while inserting the project into the cart..!."; 
				 System.err.println(e.getMessage()); 
			 } 
		 	return output; 
		 }

} 
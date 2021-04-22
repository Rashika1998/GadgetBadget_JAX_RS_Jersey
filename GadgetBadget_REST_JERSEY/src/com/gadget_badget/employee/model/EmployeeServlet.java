package com.gadget_badget.employee.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeServlet 
{
	//A common method to connect to the DB
	private Connection connect() 
	{ 
		Connection connection = null; 
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver"); 
			 
			 //Provide the correct details: DBServer/DBName, username, password 
		
					
connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget_rest_jersey", "root", ""); 
		} 
		catch (Exception e) 
		{e.printStackTrace();} 
		 	return connection; 
		} 

public String insertCart(String cart_code, String project_code, String project_name, String project_qty , String project_unit_price , String customer_id) 
		 { 
			 String output = ""; 
			 try
			 { 
				 Connection connection = connect(); 
				 if (connection == null) 
				 {
					 return "Error while connecting to the database for inserting."; 
				 } 
			 	 	 // create a prepared statement
				 	 String query = " INSERT INTO cart_tab(`cartID`,`cartCode`,`projectCode`,`projectName`,`projectQty`,`projectUnitPrice`,`customerID`)"
				     + " VALUES (?, ?, ?, ?, ? ,? ,?)"; 
					 PreparedStatement preparedStmt = connection.prepareStatement(query); 
					 
					 
					 // binding values
					 preparedStmt.setInt(1, 0); 
					 preparedStmt.setString(2, cart_code); 
					 preparedStmt.setString(3, project_code); 
					 preparedStmt.setString(4, project_name);
					 preparedStmt.setDouble(5, Double.parseDouble(project_qty)); 
					 preparedStmt.setDouble(6, Double.parseDouble(project_unit_price)); 
					 preparedStmt.setString(7, customer_id); 
					 
				 
					 preparedStmt.execute(); 
					 connection.close(); 
					 output = "Project has been added into the cart successfully..!"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while inserting the project into the cart..!."; 
				 System.err.println(e.getMessage()); 
			 } 
		 	return output; 
		 } 	
public String insertCart(String cart_code, String project_code, String project_name, String project_qty , String project_unit_price , String customer_id) 
		 { 
			 String output = ""; 
			 try
			 { 
				 Connection connection = connect(); 
				 if (connection == null) 
				 {
					 return "Error while connecting to the database for inserting."; 
				 } 
			 	 	 // create a prepared statement
				 	 String query = " INSERT INTO cart_tab(`cartID`,`cartCode`,`projectCode`,`projectName`,`projectQty`,`projectUnitPrice`,`customerID`)"
				     + " VALUES (?, ?, ?, ?, ? ,? ,?)"; 
					 PreparedStatement preparedStmt = connection.prepareStatement(query); 
					 
					 
					 // binding values
					 preparedStmt.setInt(1, 0); 
					 preparedStmt.setString(2, cart_code); 
					 preparedStmt.setString(3, project_code); 
					 preparedStmt.setString(4, project_name);
					 preparedStmt.setDouble(5, Double.parseDouble(project_qty)); 
					 preparedStmt.setDouble(6, Double.parseDouble(project_unit_price)); 
					 preparedStmt.setString(7, customer_id); 
					 
				 
					 preparedStmt.execute(); 
					 connection.close(); 
					 output = "Project has been added into the cart successfully..!"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while inserting the project into the cart..!."; 
				 System.err.println(e.getMessage()); 
			 } 
		 	return output; 
		 } 
} 
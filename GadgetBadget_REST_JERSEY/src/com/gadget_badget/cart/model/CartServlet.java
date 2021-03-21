package com.gadget_badget.cart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CartServlet 
{
	
	//A common method to connect to the DB
	private Connection connect() 
	{ 
		Connection con = null; 
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver"); 
			 
			 //Provide the correct details: DBServer/DBName, username, password 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget_rest_jersey", "root", "issa123"); 
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
			 	 	 // create a prepared statement
				 	 String query = " INSERT INTO cart_tab(`cartID`,`cartCode`,`projectCode`,`projectName`,`projectQty`,`projectUnitPrice`,`customerID`)"
				     + " VALUES (?, ?, ?, ?, ? ,? ,?)"; 
					 PreparedStatement preparedStmt = con.prepareStatement(query); 
					 
					 
					 // binding values
					 preparedStmt.setInt(1, 0); 
					 preparedStmt.setString(2, cart_code); 
					 preparedStmt.setString(3, project_code); 
					 preparedStmt.setString(4, project_name);
					 preparedStmt.setDouble(5, Double.parseDouble(project_qty)); 
					 preparedStmt.setDouble(6, Double.parseDouble(project_unit_price)); 
					 preparedStmt.setString(7, customer_id); 
					 
				 
					 preparedStmt.execute(); 
					 con.close(); 
					 output = "Project has been added into the cart successfully..!"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while inserting the project into the cart..!."; 
				 System.err.println(e.getMessage()); 
			 } 
		 	return output; 
		 } 
		 
		 
		 
		 public String readCart() 
		 { 
			 String output = ""; 
			 String boostrap_link = "<head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\' integrity=\'sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\' crossorigin=\'anonymous\'></head>";
			 try
			 { 
				 Connection con = connect(); 
				 if (con == null) 
				 {return "Error while connecting to the database for reading."; } 
				 // Prepare the html table to be displayed
				 output = boostrap_link + "<table border='1' style='text-align:center'><tr>"
				 + "<th>Cart Code</th>"
				 + "<th>Project Code</th>" +
				 "<th>Project Name</th>" + 
				 "<th>Project Quentity</th>" + 
				 "<th>Project Unit Price</th>" +
				 "<th>Customer ID</th>" +
				 "<th>Update</th><th>Remove</th></tr>"; 
			 
				 String query = "SELECT * FROM cart_tab"; 
				 Statement stmt = con.createStatement(); 
				 ResultSet rs = stmt.executeQuery(query); 
				 // iterate through the rows in the result set
				 while (rs.next()) 
				 { 
					 String cartID = Integer.toString(rs.getInt("cartID")); 
					 String cartCode = rs.getString("cartCode"); 
					 String projectCode = rs.getString("projectCode"); 
					 String projectName = rs.getString("projectName"); 
					 String projectQty = Double.toString(rs.getDouble("projectQty")); 
					 String projectUnitPrice = Double.toString(rs.getDouble("projectUnitPrice")); 
					 String customerID = rs.getString("customerID"); 
					 
					 
					 // Add into the html table
					 output += "<tr><td>" + cartCode + "</td>"; 
					 output += "<td>" + projectCode + "</td>"; 
					 output += "<td>" + projectName + "</td>"; 
					 output += "<td>" + projectQty + "</td>"; 
					 output += "<td>" + projectUnitPrice + "</td>"; 
					 output += "<td>" + customerID + "</td>"; 
					 
					 
					 // buttons
					 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
					 + "<td><form method='post' action='items.jsp'>"
					 + "<input style='margin-top:15px' name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
					 + "<input name='itemID' type='hidden' value='" + cartID 
					 + "'>" + "</form></td></tr>"; 
				 } 
				 	 con.close(); 
				 	 // Complete the html table
				 	 output += "</table>"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while reading the project details...!"; 
				 System.err.println(e.getMessage()); 
			 } 
		 	 return output; 
		 } 
		
		
		
		public String updateCart(String cart_id, String cart_code, String project_code, String project_name, String project_qty , String project_unit_price , String customer_id)
		{ 
			 String output = ""; 
			 try
			 { 
				 Connection con = connect(); 
				 if (con == null) 
				 {
					 return "Error while connecting to the database for updating."; 
				 } 
				 // create a prepared statement
				 String query = "UPDATE cart_tab SET cartCode=? , projectCode=? , projectName=? , projectQty=? , projectUnitPrice=? , customerID=?  WHERE cartID=?"; 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 // binding values
				 preparedStmt.setString(1, cart_code); 
				 preparedStmt.setString(2, project_code); 
				 preparedStmt.setString(3, project_name); 
				 preparedStmt.setDouble(4, Double.parseDouble(project_qty)); 
				 preparedStmt.setDouble(5, Double.parseDouble(project_unit_price)); 
				 preparedStmt.setString(6, customer_id); 
				 preparedStmt.setInt(7, Integer.parseInt(cart_id)); 
				 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 output = "Project details have been updated in cart successfully...!"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while updating cart details...!"; 
				 System.err.println(e.getMessage()); 
			 } 
			 	return output; 
			 } 
		
		
		
			 public String deleteCart(String cartID) 
			 { 
				 String output = ""; 
			 try
			 { 
				 Connection con = connect(); 
			 if (con == null) 
			 {
				 return "Error while connecting to the database for deleting."; 
			 } 
			 
			 	 // create a prepared statement
				 String query = "DELETE FROM cart_tab WHERE cartID=?"; 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 // binding values
				 preparedStmt.setInt(1, Integer.parseInt(cartID)); 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 output = "Project has been deleted from cart successfully"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while deleting the project from the cart."; 
				 System.err.println(e.getMessage()); 
			 } 
			 return output; 
			 } 
} 
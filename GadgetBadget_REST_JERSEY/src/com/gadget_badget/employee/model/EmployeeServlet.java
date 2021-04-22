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
public String readCart() 
		 { 
			 String output = ""; 
			 String boostrap_link_1 = "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\' integrity=\'sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\' crossorigin=\'anonymous\'>";
			 String boostrap_link_2 = "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>";
			 String meta_1 = "<meta charset='utf-8'>";
			 String meta_2 = "<meta name='viewport' content='width=device-width, initial-scale=1'>";
			 String script_1 = "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>";
			 String script_2 = "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>";
			 
			 
			 String header = "<nav class='navbar navbar-inverse'>"
			 		+ "<div class='container-fluid'>"
			 		+ "<div class='navbar-header'>"
			 		+ "<a class='navbar-brand' href='#'>GadgetBadget</a>"
			 		+ "</div>"
			 		+ "<ul class='nav navbar-nav'>"
			 		+ "<li class='active'><a href='#'>Home</a></li>"
			 		+ "<li class='dropdown'><a class='dropdown-toggle' data-toggle='dropdown' href='#'>Category<span class='caret'></span></a>"
			 		+ "<ul class='dropdown-menu'>"
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Projects'>UI Design</a></li>"
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Carts'>Back End</a></li>"
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Orders'>UI/UX</a></li>"
			 		+ "</ul>"
			 		+ "</li>"
			 		+ ""
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Projects'>Products</a></li>"
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Carts'>Cart</a></li>"
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Orders'>Order</a></li>"
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Employees'>Employees</a></li>"
			 		+ "<li><a href='#'>Contact Us</a></li>"
			 		+ "<li><a href='#'>About Us</a></li>"
			 		+ ""
			 		+ "</ul>"
			 		+ "<ul class='nav navbar-nav navbar-right'>"
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/SignUp.jsp'><span class='glyphicon glyphicon-user'></span> Sign Up</a></li>"
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/SignIn.jsp'><span class='glyphicon glyphicon-log-in'></span> Login</a></li>"
			 		+ "</ul>"
			 		+ "</div>"
			 		+ "</nav>";
			 
			 try
			 { 
				 Connection connection = connect(); 
				 if (con == null) 
				 {return "Error while connecting to the database for reading."; } 
				 // Prepare the html table to be displayed
				 output = "<head>" + meta_1 + meta_2 + boostrap_link_2 +  script_1 + script_2 +  "</head>" + header + "<div class='container'><table border='1' style='text-align:center'><tr>"
				 + "<th style='padding:10px; text-align:center;'>Cart Code</th>"
				 + "<th style='padding:10px; text-align:center;'>Project Code</th>" +
				 "<th style='padding:10px; text-align:center;'>Project Name</th>" + 
				 "<th style='padding:10px; text-align:center;'>Project Quentity</th>" + 
				 "<th style='padding:10px; text-align:center;'>Project Unit Price</th>" +
				 "<th style='padding:10px; text-align:center;'>Customer ID</th>" +
				 "<th style='padding:10px; text-align:center;'>Update</th><th style='padding:10px; text-align:center;'>Remove</th></tr>"; 
			 
				 String query = "SELECT * FROM cart_tab"; 
				 Statement stmt = connection.createStatement(); 
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
					 output += "<tr><td style='padding:10px; text-align:center;'>" + cartCode + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + projectCode + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + projectName + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + projectQty + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + projectUnitPrice + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + customerID + "</td>"; 
					 
					 
					 // buttons
					 output += "<td style='padding:10px; text-align:center;'><input name='btnUpdate' type='button' value='Update' class='btn btn-info'></td>"
					 + "<td style='padding:10px; text-align:center;'><form method='post' action='items.jsp'>"
					 + "<input style='margin-top:15px' name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
					 + "<input name='itemID' type='hidden' value='" + cartID 
					 + "'>" + "</form></td></tr>"; 
				 } 
				 	 connection.close(); 
				 	 // Complete the html table
				 	 output += "</table></div>"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while reading the project details...!"; 
				 System.err.println(e.getMessage()); 
			 } 
		 	 return output; 
		 } 
} 
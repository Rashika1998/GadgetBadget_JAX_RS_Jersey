package com.gadget_badget.orders.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderServlet 
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
	
	
	
	
		 public String insertOrder(String order_code, String customer_id, String customer_email, String customer_name, String order_total_amount, String card_no, String cvv_no) 
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
				 	 String query = "INSERT INTO order_tab(`orderID`,`orderCode`,`customerID`,`customerEmail`,`customerName`,`orderTotalAmount`,`cardNo`,`cvvNo`)"
				     + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; 
					 PreparedStatement preparedStmt = con.prepareStatement(query); 
					 
					 
					 // binding values
					 preparedStmt.setInt(1, 0);
					 preparedStmt.setString(2, order_code);
					 preparedStmt.setString(3, customer_id);
					 preparedStmt.setString(4, customer_email);
					 preparedStmt.setString(5, customer_name);
					 preparedStmt.setDouble(6, Double.parseDouble(order_total_amount));
					 preparedStmt.setString(7, card_no);
					 preparedStmt.setString(8, cvv_no);
					 
				 
					 preparedStmt.execute(); 
					 con.close(); 
					 output = "Order has been placed successfully..!"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while inserting the order into the database..!.";
				 System.err.println(e.getMessage());
			 } 
		 	return output; 
		 } 
		 
		 
		 
		 public String readOrder() 
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
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Employees'>Employee</a></li>"
			 		+ "<li><a href='#'>Contact Us</a></li>"
			 		+ "<li><a href='#'>About Us</a></li>"
			 		+ ""
			 		+ "</ul>"
			 		+ "<ul class='nav navbar-nav navbar-right'>"
			 		+ "<li><a href='#'><span class='glyphicon glyphicon-user'></span> Sign Up</a></li>"
			 		+ "<li><a href='#'><span class='glyphicon glyphicon-log-in'></span> Login</a></li>"
			 		+ "</ul>"
			 		+ "</div>"
			 		+ "</nav>";
			 
			 try
			 { 
				 Connection con = connect(); 
				 if (con == null) 
				 {return "Error while connecting to the database for reading."; } 
				 // Prepare the html table to be displayed
				 output = "<head>" + meta_1 + meta_2 + boostrap_link_2 +  script_1 + script_2 +  "</head>" + header +  "<div class='container'><table border='1' style='text-align:center'><tr>"
				 + "<th>Order Code</th>"
				 + "<th>Customer ID</th>" +
				 "<th>Customer Email</th>" + 
				 "<th>Customer Name</th>" + 
				 "<th>Total Amount</th>" +
				 "<th>Card No</th>" +
				 "<th>CVV No</th>" +
				 "<th>Update</th><th>Remove</th></tr>"; 
			 
				 String query = "SELECT * FROM order_tab"; 
				 Statement stmt = con.createStatement(); 
				 ResultSet rs = stmt.executeQuery(query); 
				 // iterate through the rows in the result set
				 while (rs.next()) 
				 { 
					 String orderID = Integer.toString(rs.getInt("orderID")); 
					 String orderCode = rs.getString("orderCode"); 
					 String customerID = rs.getString("customerID"); 
					 String customerEmail = rs.getString("customerEmail"); 
					 String customerName = rs.getString("customerName"); 
					 String orderTotalAmount = Double.toString(rs.getDouble("orderTotalAmount")); 
					 String cardNo = rs.getString("cardNo");
					 String cvvNo = rs.getString("cvvNo");
					 
					 
					 // Add into the html table
					 output += "<tr><td>" + orderCode + "</td>"; 
					 output += "<td>" + customerID + "</td>"; 
					 output += "<td>" + customerEmail + "</td>"; 
					 output += "<td>" + customerName + "</td>"; 
					 output += "<td>" + orderTotalAmount + "</td>"; 
					 output += "<td>" + cardNo + "</td>"; 
					 output += "<td>" + cvvNo + "</td>"; 
					 
					 
					 
					 // buttons
					 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-info'></td>"
					 + "<td><form method='post' action='items.jsp'>"
					 + "<input style='margin-top:15px' name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
					 + "<input name='orderID' type='hidden' value='" + orderID 
					 + "'>" + "</form></td></tr>"; 
				 } 
				 	 con.close(); 
				 	 // Complete the html table
				 	 output += "</table></div>"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while reading the order details...!"; 
				 System.err.println(e.getMessage()); 
			 } 
		 	 return output; 
		 } 
		
		
		
		public String updateOrder(String order_id, String order_code, String customer_id, String customer_email, String customer_name , String order_total_amount , String card_no , String cvv_no)
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
				 String query = "UPDATE order_tab SET orderCode=? , customerID=? , customerEmail=? , customerName=? , orderTotalAmount=? , cardNo=? , cvvNo=?  WHERE orderID=?"; 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 // binding values
				 preparedStmt.setString(1, order_code); 
				 preparedStmt.setString(2, customer_id); 
				 preparedStmt.setString(3, customer_email); 
				 preparedStmt.setString(4, customer_name); 
				 preparedStmt.setDouble(5, Double.parseDouble(order_total_amount)); 
				 preparedStmt.setString(6, card_no); 
				 preparedStmt.setString(7, cvv_no); 
				 preparedStmt.setInt(8, Integer.parseInt(order_id)); 
				 
				 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 output = "Order details have been updated successfully...!"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while updating order details...!"; 
				 System.err.println(e.getMessage()); 
			 } 
			 	return output; 
			 } 
		
		
		
			 public String deleteOrder(String orderID) 
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
				 String query = "DELETE FROM order_tab WHERE orderID=?"; 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 
				 // binding values
				 preparedStmt.setInt(1, Integer.parseInt(orderID)); 
				 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 output = "Order has been deleted successfully"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while deleting the order."; 
				 System.err.println(e.getMessage()); 
			 } 
			 return output; 
			 } 
} 
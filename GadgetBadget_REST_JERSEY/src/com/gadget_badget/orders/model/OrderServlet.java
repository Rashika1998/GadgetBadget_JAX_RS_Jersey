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
			 		+ "<li><a href='myService/Projects'>UI Design</a></li>"
			 		+ "<li><a href='myService/Carts'>Back End</a></li>"
			 		+ "<li><a href='myService/Orders'>UI/UX</a></li>"
			 		+ "</ul>"
			 		+ "</li>"
			 		+ ""
			 		+ "<li><a href='myService/Projects'>Products</a></li>"
			 		+ "<li><a href='myService/Carts'>Cart</a></li>"
			 		+ "<li><a href='myService/Orders'>Order</a></li>"
			 		+ "<li><a href='myService/Employees'>Employee</a></li>"
			 		+ "<li><a href='#'>Contact Us</a></li>"
			 		+ "<li><a href='#'>About Us</a></li>"
			 		+ ""
			 		+ "</ul>"
			 		+ "<ul class='nav navbar-nav navbar-right'>"
			 		+ "<li><a href='SignUp.jsp'><span class='glyphicon glyphicon-user'></span> Sign Up</a></li>"
			 		+ "<li><a href='SignIn.jsp'><span class='glyphicon glyphicon-log-in'></span> Login</a></li>"
			 		+ "</ul>"
			 		+ "</div>"
			 		+ "</nav>";
			 
			 try  { 
				 Connection connection = connect(); 
				 if (connection == null)  {return "Error while connecting to the database for reading."; } 

				 output = "<head>" + meta_1 + meta_2 + boostrap_link_2 +  script_1 + script_2 +  "</head>" + header +  "<div class='container'><table border='1' style='text-align:center'><tr>"
				 + "<th style='padding:10px; text-align:center;'>Order Code</th>"
				 + "<th style='padding:10px; text-align:center;'>Customer ID</th>" +
				 "<th style='padding:10px; text-align:center;'>Customer Email</th>" + 
				 "<th style='padding:10px; text-align:center;'>Customer Name</th>" + 
				 "<th style='padding:10px; text-align:center;'>Total Amount</th>" +
				 "<th style='padding:10px; text-align:center;'>Card No</th>" +
				 "<th style='padding:10px; text-align:center;'>CVV No</th>" +
				 "<th style='padding:10px; text-align:center;'>Update</th><th style='padding:10px; text-align:center;'>Remove</th></tr>"; 
			 
				 String query = "SELECT * FROM order_tab"; 
				 Statement statement = connection.createStatement(); 
				 ResultSet resultSet = statement.executeQuery(query); 

				 while (resultSet.next())  { 
					 String orderID = Integer.toString(resultSet.getInt("orderID")); 
					 String orderCode = resultSet.getString("orderCode"); 
					 String customerID = resultSet.getString("customerID"); 
					 String customerEmail = resultSet.getString("customerEmail"); 
					 String customerName = resultSet.getString("customerName"); 
					 String orderTotalAmount = Double.toString(resultSet.getDouble("orderTotalAmount")); 
					 String cardNo = resultSet.getString("cardNo");
					 String cvvNo = resultSet.getString("cvvNo");

					 output += "<tr><td style='padding:10px; text-align:center;'>" + orderCode + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + customerID + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + customerEmail + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + customerName + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + orderTotalAmount + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + cardNo + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + cvvNo + "</td>"; 

					 output += "<td style='padding:10px; text-align:center;'><input name='btnUpdate' type='button' value='Update' class='btn btn-info'></td>"
					 + "<td style='padding:10px; text-align:center;'><form method='post' action='items.jsp'>"
					 + "<input style='margin-top:15px' name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
					 + "<input name='orderID' type='hidden' value='" + orderID 
					 + "'>" + "</form></td></tr>"; 
				 } 
				 connection.close(); 
			 	 output += "</table></div>"; 
			 } 
			 catch (Exception e)  { 
				 output = "Error while reading the order details...!"; 
				 System.err.println(e.getMessage()); 
			 } 
		 	 return output; 
		 } 
} 
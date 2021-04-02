package com.gadget_badget.researcher.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResearcherServlet 
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
	
	
	
	
		 public String insertResearcher(String res_code, String res_name, String res_email, String res_age , String res_address , String res_role , String join_date) 
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
				 	 String query = " INSERT INTO researcher_tab(`resID`,`resCode`,`resName`,`resEmail`,`resAge`,`resAddress`,`resRole`,`joinDate`)"
				     + " VALUES (?, ?, ?, ?, ? ,? ,? ,?)"; 
					 PreparedStatement preparedStmt = con.prepareStatement(query); 
					 
					 
					 // binding values
					 preparedStmt.setInt(1, 0); 
					 preparedStmt.setString(2, res_code); 
					 preparedStmt.setString(3, res_name); 
					 preparedStmt.setString(4, res_email);
					 preparedStmt.setString(5, res_age); 
					 preparedStmt.setString(6, res_address);
					 preparedStmt.setString(7, res_role); 
					 preparedStmt.setString(8, join_date); 
					 
				 
					 preparedStmt.execute(); 
					 con.close(); 
					 output = "Researcher details have been inserted successfully..!"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while inserting the researcher details..!."; 
				 System.err.println(e.getMessage()); 
			 } 
		 	return output; 
		 } 
		 
		 
		 
		 public String readResearchers() 
		 { 
			 String output = ""; 
			 //String boostrap_link_1 = "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\' integrity=\'sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\' crossorigin=\'anonymous\'>";
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
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Projects'>Back End</a></li>"
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Projects'>UI/UX</a></li>"
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
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/SignUp.jsp'><span class='glyphicon glyphicon-user'></span> Sign Up</a></li>"
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/SignIn.jsp'><span class='glyphicon glyphicon-log-in'></span> Login</a></li>"
			 		+ "</ul>"
			 		+ "</div>"
			 		+ "</nav>";
			 
			 
			 
			 try
			 { 
				 Connection con = connect(); 
				 if (con == null) 
				 {return "Error while connecting to the database for reading."; } 
				 // Prepare the html table to be displayed
				 
				 output = "<head>" + meta_1 + meta_2 + boostrap_link_2 +  script_1 + script_2 + "</head>" + header + "<div class='container'><table border='1' style='text-align:center'><tr>"
				 + "<th style='padding:10px; text-align:center;'>Researcher Code</th>"
				 + "<th style='padding:10px; text-align:center;'>Researcher Name</th>" +
				 "<th style='padding:10px; text-align:center;'>Researcher email</th>" + 
				 "<th style='padding:10px; text-align:center;'>Researcher age</th>" + 
				 "<th style='padding:10px; text-align:center;'>Researcher address</th>" +
				 "<th style='padding:10px; text-align:center;'>Researcher Role</th>" +
				 "<th style='padding:10px; text-align:center;'>Joined Date</th>" +
				 "<th style='padding:10px; text-align:center;'>Update</th><th style='padding:10px; text-align:center;'>Remove</th></tr>"; 
			 
				 String query = "SELECT * FROM researcher_tab"; 
				 Statement stmt = con.createStatement(); 
				 ResultSet rs = stmt.executeQuery(query); 
				 // iterate through the rows in the result set
				 while (rs.next()) 
				 { 
					 String resID = Integer.toString(rs.getInt("resID")); 
					 String resCode = rs.getString("resCode"); 
					 String resName = rs.getString("resName"); 
					 String resEmail = rs.getString("resEmail"); 
					 String resAge = rs.getString("resAge"); 
					 String resAddress = rs.getString("resAddress"); 
					 String resRole = rs.getString("resRole"); 
					 String joinDate = rs.getString("joinDate"); 
					 
					 // Add into the html table
					 output += "<tr><td style='padding:10px; text-align:center;'>" + resCode + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + resName + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + resEmail + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + resAge + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + resAddress + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + resRole + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + joinDate + "</td>"; 
					 
					 // buttons
					 output += "<td style='padding:10px; text-align:center;'><input name='btnUpdate' type='button' value='Update' class='btn btn-info'></td>"
					 + "<td style='padding:10px; text-align:center;'><form method='post' action='items.jsp'>"
					 + "<input style='margin-top:15px' name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
					 + "<input name='itemID' type='hidden' value='" + resID 
					 + "'>" + "</form></td></tr>"; 
				 } 
				 	 con.close(); 
				 	 // Complete the html table
				 	 output += "</table></div>"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while reading the researcher details...!"; 
				 System.err.println(e.getMessage()); 
			 } 
		 	 return output; 
		 } 
		
		
		
		public String updateResearcher(String res_id, String res_code, String res_name, String res_email, String res_age, String res_address , String res_role , String join_date)
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
				 String query = "UPDATE researcher_tab SET resCode=? , resName=? , resEmail=? , resAge=? , resAddress=? , resRole=? , joinDate=?  WHERE resID=?"; 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 // binding values
				 preparedStmt.setString(1, res_code); 
				 preparedStmt.setString(2, res_name); 
				 preparedStmt.setString(3, res_email); 
				 preparedStmt.setString(4, res_age); 
				 preparedStmt.setString(5, res_address); 
				 preparedStmt.setString(6, res_role); 
				 preparedStmt.setString(7, join_date); 
				 preparedStmt.setInt(8, Integer.parseInt(res_id)); 
				 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 output = "Researcher details have been updated successfully...!"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while updating researcher details...!"; 
				 System.err.println(e.getMessage()); 
			 } 
			 	return output; 
			 } 
		
		
		
			 public String deleteResearcher(String resID) 
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
				 String query = "DELETE FROM employee_tab WHERE empID=?"; 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 // binding values
				 preparedStmt.setInt(1, Integer.parseInt(resID)); 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 output = "Employee has been deleted successfully"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while deleting the project from the database."; 
				 System.err.println(e.getMessage()); 
			 } 
			 return output; 
			 } 
} 
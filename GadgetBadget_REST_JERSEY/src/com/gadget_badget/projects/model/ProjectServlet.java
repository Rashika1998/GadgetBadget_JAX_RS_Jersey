package com.gadget_badget.projects.model;

import java.sql.*;

public class ProjectServlet 
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
	
	
	
	
		 public String insertProject(String p_code, String p_name, String p_desc, String p_dev_by , String p_price , String p_category , String p_service_charge) 
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
				 	 String query = " INSERT INTO project_tab(`projectID`,`projectCode`,`projectName`,`projectDesc`,`projectDevBy`,`projectPrice`,`projectCategory`,`projectServiceCharge`)"
				     + " VALUES (?, ?, ?, ?, ? ,? ,? ,?)"; 
					 PreparedStatement preparedStmt = con.prepareStatement(query); 
					 
					 
					 // binding values
					 preparedStmt.setInt(1, 0); 
					 preparedStmt.setString(2, p_code); 
					 preparedStmt.setString(3, p_name); 
					 preparedStmt.setString(4, p_desc);
					 preparedStmt.setString(5, p_dev_by); 
					 preparedStmt.setDouble(6, Double.parseDouble(p_price)); 
					 preparedStmt.setString(7, p_category); 
					 preparedStmt.setDouble(8, Double.parseDouble(p_service_charge)); 
					 
				 
					 preparedStmt.execute(); 
					 con.close(); 
					 output = "Project details have been inserted successfully..!"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while inserting the project details..!."; 
				 System.err.println(e.getMessage()); 
			 } 
		 	return output; 
		 } 
		 
		 
		 
		 public String readProjects() 
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
				 Connection con = connect(); 
				 if (con == null) 
				 {return "Error while connecting to the database for reading."; } 
				 // Prepare the html table to be displayed
				 
				 output = "<head>" + meta_1 + meta_2 + boostrap_link_2 +  script_1 + script_2 + "</head>" + header + "<div class='container'><table border='1' style='text-align:center'><tr>"
				 + "<th style='padding:10px; text-align:center;'>Project Code</th>"
				 + "<th style='padding:10px; text-align:center;'>Project Name</th>" +
				 "<th style='padding:10px; text-align:center;'>Project Description</th>" + 
				 "<th style='padding:10px; text-align:center;'>Project Developed By</th>" + 
				 "<th style='padding:10px; text-align:center;'>Project Price</th>" +
				 "<th style='padding:10px; text-align:center;'>Project Category</th>" +
				 "<th style='padding:10px; text-align:center;'>Project Service Charge</th>" +
				 "<th style='padding:10px; text-align:center;'>Update</th><th>Remove</th></tr>"; 
			 
				 String query = "SELECT * FROM project_tab"; 
				 Statement stmt = con.createStatement(); 
				 ResultSet rs = stmt.executeQuery(query); 
				 // iterate through the rows in the result set
				 while (rs.next()) 
				 { 
					 String projectID = Integer.toString(rs.getInt("projectID")); 
					 String projectCode = rs.getString("projectCode"); 
					 String projectName = rs.getString("projectName"); 
					 String projectDesc = rs.getString("projectDesc"); 
					 String projectDevBy = rs.getString("projectDevBy"); 
					 String projectPrice = Double.toString(rs.getDouble("projectPrice")); 
					 String projectCategory = rs.getString("projectCategory"); 
					 String projectServiceCharge = Double.toString(rs.getDouble("projectServiceCharge")); 
					 
					 // Add into the html table
					 output += "<tr><td style='padding:10px; text-align:center;'>" + projectCode + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + projectName + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + projectDesc + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + projectDevBy + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + projectPrice + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + projectCategory + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + projectServiceCharge + "</td>"; 
					 
					 // buttons
					 output += "<td style='padding:10px; text-align:center;'><input name='btnUpdate' type='button' value='Update' class='btn btn-info'></td>"
					 + "<td style='padding:10px; text-align:center;'><form method='post' action='items.jsp'>"
					 + "<input style='margin-top:15px' name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
					 + "<input name='itemID' type='hidden' value='" + projectID 
					 + "'>" + "</form></td></tr>"; 
				 } 
				 	 con.close(); 
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
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 public String readProjectsDetailsOnly() 
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
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Projects/onlyDetails'>UI Design</a></li>"
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Projects/onlyDetails'>Back End</a></li>"
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Projects/onlyDetails'>UI/UX</a></li>"
			 		+ "</ul>"
			 		+ "</li>"
			 		+ ""
			 		
			 		+ "<li><a href='http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Carts'>Cart</a></li>"
			 		
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
				 
				 output = "<head>" + meta_1 + meta_2 + boostrap_link_2 +  script_1 + script_2 + "</head>" + header + "<div class='container'><table border='1' style='text-align:center;'><tr>"
				 + "<th style='padding:10px; text-align:center;'>Project Code</th>"
				 + "<th style='padding:10px; text-align:center;'>Project Name</th>" +
				 "<th style='padding:10px; text-align:center;'>Project Description</th>" + 
				 "<th style='padding:10px; text-align:center;'>Project Developed By</th>" + 
				 "<th style='padding:10px; text-align:center;'>Project Price</th>" +
				 "<th style='padding:10px; text-align:center;'>Project Category</th>" +
				 "<th style='padding:10px; text-align:center;'>Project Service Charge</th>"+
				 "<th style='padding:10px; text-align:center;'>Add to cart</th>";
				 
				 //+
				 //"<th>Update</th><th>Remove</th></tr>"; 
			 
				 String query = "SELECT * FROM project_tab"; 
				 Statement stmt = con.createStatement(); 
				 ResultSet rs = stmt.executeQuery(query); 
				 // iterate through the rows in the result set
				 while (rs.next()) 
				 { 
					 String projectID = Integer.toString(rs.getInt("projectID")); 
					 String projectCode = rs.getString("projectCode"); 
					 String projectName = rs.getString("projectName"); 
					 String projectDesc = rs.getString("projectDesc"); 
					 String projectDevBy = rs.getString("projectDevBy"); 
					 String projectPrice = Double.toString(rs.getDouble("projectPrice")); 
					 String projectCategory = rs.getString("projectCategory"); 
					 String projectServiceCharge = Double.toString(rs.getDouble("projectServiceCharge")); 
					 
					 // Add into the html table
					 output += "<tr><td style='padding:10px; text-align:center;'>" + projectCode + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + projectName + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + projectDesc + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + projectDevBy + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + projectPrice + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + projectCategory + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + projectServiceCharge + "</td>"; 
					 output += "<td><input name='btnUpdate' type='button' value='Add' class='btn btn-info'></td></tr>";
					 
					 
					 // buttons
					 //output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-info'></td>";
					 //+ "<td><form method='post' action='items.jsp'>"
					 //+ "<input style='margin-top:15px' name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
					 //+ "<input name='itemID' type='hidden' value='" + projectID 
					 //+ "'>" + "</form></td></tr>"; 
				 } 
				 	 con.close(); 
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
		 
		 
		 
		 
		 
		 
		 
		 
		
		
		
		public String updateProject(String p_ID, String p_code, String p_name, String p_desc, String p_dev_by , String p_price , String p_category , String p_service_charge)
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
				 String query = "UPDATE project_tab SET projectCode=? , projectName=? , projectDesc=? , projectDevBy=? , projectPrice=? , projectCategory=? , projectServiceCharge=?  WHERE projectID=?"; 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 // binding values
				 preparedStmt.setString(1, p_code); 
				 preparedStmt.setString(2, p_name); 
				 preparedStmt.setString(3, p_desc); 
				 preparedStmt.setString(4, p_dev_by); 
				 preparedStmt.setDouble(5, Double.parseDouble(p_price)); 
				 preparedStmt.setString(6, p_category); 
				 preparedStmt.setDouble(7, Double.parseDouble(p_service_charge)); 
				 preparedStmt.setInt(8, Integer.parseInt(p_ID)); 
				 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 output = "Project details have been updated successfully...!"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while updating project details...!"; 
				 System.err.println(e.getMessage()); 
			 } 
			 	return output; 
			 } 
		
		
		
			 public String deleteProject(String projectID) 
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
				 String query = "DELETE FROM project_tab WHERE projectID=?"; 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 // binding values
				 preparedStmt.setInt(1, Integer.parseInt(projectID)); 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 output = "Project has been deleted successfully"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while deleting the project from the database."; 
				 System.err.println(e.getMessage()); 
			 } 
			 return output; 
			 } 
} 

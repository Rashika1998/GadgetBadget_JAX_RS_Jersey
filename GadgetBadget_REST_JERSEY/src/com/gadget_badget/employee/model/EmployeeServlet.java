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
	public String insertEmployee(String emp_code, String emp_name, String emp_email, String emp_age , String emp_address , String emp_role , String job_started_date) 
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
				 	 String query = " INSERT INTO employee_tab(`empID`,`empCode`,`empName`,`empEmail`,`empAge`,`empAddress`,`empRole`,`jobStartedDate`)"
				     + " VALUES (?, ?, ?, ?, ? ,? ,? ,?)"; 
					 PreparedStatement preparedStmt = con.prepareStatement(query); 
					 
					 
					 // binding values
					 preparedStmt.setInt(1, 0); 
					 preparedStmt.setString(2, emp_code); 
					 preparedStmt.setString(3, emp_name); 
					 preparedStmt.setString(4, emp_email);
					 preparedStmt.setString(5, emp_age); 
					 preparedStmt.setString(6, emp_address);
					 preparedStmt.setString(7, emp_role); 
					 preparedStmt.setString(8, job_started_date); 
					 
				 
					 preparedStmt.execute(); 
					 connection.close(); 
					 output = "Employee details have been inserted successfully..!"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while inserting the employee details..!."; 
				 System.err.println(e.getMessage()); 
			 } 
		 	return output; 
		 } 
		  public String readEmployees() 
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
				 Connection connection = connect(); 
				 if (connection == null) 
				 {return "Error while connecting to the database for reading."; } 
				 // Prepare the html table to be displayed
				 
				 output = "<head>" + meta_1 + meta_2 + boostrap_link_2 +  script_1 + script_2 + "</head>" + header + "<div class='container'><table border='1' style='text-align:center'><tr>"
				 + "<th style='padding:10px; text-align:center;'>Employee Code</th>"
				 + "<th style='padding:10px; text-align:center;'>Employee Name</th>" +
				 "<th style='padding:10px; text-align:center;'>Employee email</th>" + 
				 "<th style='padding:10px; text-align:center;'>Employee age</th>" + 
				 "<th style='padding:10px; text-align:center;'>Employee address</th>" +
				 "<th style='padding:10px; text-align:center;'>Employee Role</th>" +
				 "<th style='padding:10px; text-align:center;'>Job Started Date</th>" +
				 "<th style='padding:10px; text-align:center;'>Update</th><th style='padding:10px; text-align:center;'>Remove</th></tr>"; 
			 
				 String query = "SELECT * FROM employee_tab"; 
				 Statement stmt = connection.createStatement(); 
				 ResultSet rs = stmt.executeQuery(query); 
				 // iterate through the rows in the result set
				 while (rs.next()) 
				 { 
					 String empID = Integer.toString(rs.getInt("empID")); 
					 String empCode = rs.getString("empCode"); 
					 String empName = rs.getString("empName"); 
					 String empEmail = rs.getString("empEmail"); 
					 String empAge = rs.getString("empAge"); 
					 String empAddress = rs.getString("empAddress"); 
					 String empRole = rs.getString("empRole"); 
					 String jobStartedDate = rs.getString("jobStartedDate"); 
					 
					 // Add into the html table
					 output += "<tr><td style='padding:10px; text-align:center;'>" + empCode + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + empName + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + empEmail + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + empAge + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + empAddress + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + empRole + "</td>"; 
					 output += "<td style='padding:10px; text-align:center;'>" + jobStartedDate + "</td>"; 
					 
					 // buttons
					 output += "<td style='padding:10px; text-align:center;'><input name='btnUpdate' type='button' value='Update' class='btn btn-info'></td>"
					 + "<td style='padding:10px; text-align:center;'><form method='post' action='items.jsp'>"
					 + "<input style='margin-top:15px' name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
					 + "<input name='itemID' type='hidden' value='" + empID 
					 + "'>" + "</form></td></tr>"; 
				 } 
				 	 connection.close(); 
				 	 // Complete the html table
				 	 output += "</table></div>"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while reading the employee details...!"; 
				 System.err.println(e.getMessage()); 
			 } 
		 	 return output; 
		 } 
		 public String updateEmployee(String emp_id, String emp_code, String emp_name, String emp_email, String emp_age, String emp_address , String emp_role , String job_started_date)
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
				 String query = "UPDATE employee_tab SET empCode=? , empName=? , empEmail=? , empAge=? , empAddress=? , empRole=? , jobStartedDate=?  WHERE empID=?"; 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 // binding values
				 preparedStmt.setString(1, emp_code); 
				 preparedStmt.setString(2, emp_name); 
				 preparedStmt.setString(3, emp_email); 
				 preparedStmt.setString(4, emp_age); 
				 preparedStmt.setString(5, emp_address); 
				 preparedStmt.setString(6, emp_role); 
				 preparedStmt.setString(7, job_started_date); 
				 preparedStmt.setInt(8, Integer.parseInt(emp_id)); 
				 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 output = "Employee details have been updated successfully...!"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while updating employee details...!"; 
				 System.err.println(e.getMessage()); 
			 } 
			 	return output; 
			 } 
}
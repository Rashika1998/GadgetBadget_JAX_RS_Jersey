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
				 Connection con = connect(); 
				 if (con == null) 
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
					 con.close(); 
					 output = "Employee details have been inserted successfully..!"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while inserting the employee details..!."; 
				 System.err.println(e.getMessage()); 
			 } 
		 	return output; 
		 } 
}
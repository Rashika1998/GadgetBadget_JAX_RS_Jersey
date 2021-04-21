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
	
} 
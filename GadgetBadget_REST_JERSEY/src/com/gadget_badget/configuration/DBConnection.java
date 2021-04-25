package com.gadget_badget.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class  DBConnection {

	private static Connection dBConnection;

	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			// Change your configurations settings
			//ex: Password, Username
			dBConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget_rest_jersey", "root", ""); 
		} catch (Exception e)  {e.printStackTrace();} 
		return dBConnection; 
	}

}

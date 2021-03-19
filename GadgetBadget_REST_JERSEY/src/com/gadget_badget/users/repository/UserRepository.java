package com.gadget_badget.users.repository;

import java.util.ArrayList;
import java.util.List;
import com.gadget_badget.users.model.User;
import java.sql.*;

public class UserRepository 
{
	
	Connection con = null;
	
	public UserRepository()
	{
		String url = "jdbc:mysql://localhost:3306/gadgetbadget_rest_jersey";
		String username = "root";
		String password = "issa123";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url , username , password);
		}
		catch(Exception e)
		{
			System.out.println("Error : " + e);
		}
		
		
		
	}
	
	
	public List<User> getUsers()
	{
		List<User> users = new ArrayList<>();
		String sql = "SELECT * FROM user";
		
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				User user = new User();
				
				user.setUserID(rs.getInt(1));
				user.setUserProfileName(rs.getString(2));
				user.setBio(rs.getString(3));
				user.setDob(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setUsername(rs.getString(6));
				user.setPassword(rs.getString(7));
				
				users.add(user);
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
		
		return users;
	}
	
	
	
	public User getUser(int userID)
	{
		
		String sql = "SELECT * FROM user WHERE userID =" +userID;
		User user = new User();
		
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next())
			{
				
				user.setUserID(rs.getInt(1));
				user.setUserProfileName(rs.getString(2));
				user.setBio(rs.getString(3));
				user.setDob(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setUsername(rs.getString(6));
				user.setPassword(rs.getString(7));
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
		
		return user;
		
	}


	public void createUser(User user) 
	{
		String sql = "INSERT INTO user VALUES(? , ? , ? , ? , ? , ? , ?)";
		
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, user.getUserID());
			st.setString(2, user.getUserProfileName());
			st.setString(3, user.getBio());
			st.setString(4, user.getDob());
			st.setString(5, user.getEmail());
			st.setString(6, user.getUsername());
			st.setString(7, user.getPassword());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
	}
	
	
	
	public void updateUser(User user) 
	{
		String sql = "UPDATE user SET userProfileName = ? , bio = ? , dob = ? , email = ? , username = ? , password = ? WHERE userID = ?";
		
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setString(1, user.getUserProfileName());
			st.setString(2, user.getBio());
			st.setString(3, user.getDob());
			st.setString(4, user.getEmail());
			st.setString(5, user.getUsername());
			st.setString(6, user.getPassword());
			st.setInt(7, user.getUserID());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
	}


	public void deleteUser(int userID) 
	{

		String sql = "DELETE FROM user WHERE userID = ?";
		
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1 , userID);
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
		
	}
	
	
	

}

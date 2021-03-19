package com.gadget_badget.projects.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gadget_badget.projects.model.Project;
import com.gadget_badget.users.model.User;

public class ProjectRepository 
{
	
	Connection con = null;
	
	public ProjectRepository()
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
	
	
	
	
	
	public List<Project> getProject()
	{
		List<Project> projects = new ArrayList<>();
		String sql = "SELECT * FROM project";
		
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				Project project = new Project();
				
				project.setProjectID(rs.getInt(1));
				project.setProjectName(rs.getString(2));
				project.setProjectCategory(rs.getString(3));
				project.setProjectDESC(rs.getString(4));
				project.setProjectPrice(rs.getString(5));
				project.setProjectDevBy(rs.getString(6));
				
				projects.add(project);
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
		
		return projects;
	}
	
	
	
	
	
	
	
	public Project getProject(int projectID)
	{
		String sql = "SELECT * FROM product WHERE projectID =" +projectID;
		Project project = new Project();
		
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next())
			{
				
				project.setProjectID(rs.getInt(1));
				project.setProjectName(rs.getString(2));
				project.setProjectCategory(rs.getString(3));
				project.setProjectDESC(rs.getString(4));
				project.setProjectPrice(rs.getString(5));
				project.setProjectDevBy(rs.getString(6));
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
		
		return project;
	}
	
	
	
	
	
	
	public void createProject(Project project) 
	{
		String sql = "INSERT INTO project VALUES(? , ? , ? , ? , ? , ?)";
		
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, project.getProjectID());
			st.setString(2, project.getProjectName());
			st.setString(3, project.getProjectCategory());
			st.setString(4, project.getProjectDESC());
			st.setString(5, project.getProjectPrice());
			st.setString(6, project.getProjectDevBy());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
	}
	
	
	
	
	
	
	
	
	public void updateProject(Project project) 
	{
		String sql = "UPDATE project SET projectName = ? , projectCategory = ? , projectDESC = ? , projectPrice = ? , projectDevBy = ?  WHERE projectID = ?";
		
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, project.getProjectName());
			st.setString(2, project.getProjectCategory());
			st.setString(3, project.getProjectDESC());
			st.setString(4, project.getProjectPrice());
			st.setString(5, project.getProjectDevBy());
			st.setInt(6, project.getProjectID());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
	}
	
	
	
	
	
	
	public void deleteProject(int projectID) 
	{
		String sql = "DELETE FROM project WHERE projectID = ?";
		
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1 , projectID);
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
	}
	
	
}

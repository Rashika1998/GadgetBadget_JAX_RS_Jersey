package com.gadget_badget.projects.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gadget_badget.projects.model.Project;
import com.gadget_badget.projects.repository.ProjectRepository;


@Path("projects")
public class ProjectResource 
{
	
	//Create Project Repository called 'repo'
	ProjectRepository repo = new ProjectRepository();
	
	
	
	//Resource for getting all project
	@GET
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public List<Project> getProjects()
	{
		System.out.println("GetProject method called.");
		return repo.getProject();
	}
	
	
	
	//Resource for getting a user by projectID
	@GET
	@Path("project/{projectID}")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public Project getProject(@PathParam("projectID") int projectID)
	{
		return repo.getProject(projectID);
	}
	
	
	
	//Resource for creating a project
	@POST
	@Path("project")
	@Consumes({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public Project createProject(Project project)
	{
		System.out.println(project);
		repo.createProject(project);
		return project;
	}
	
	
	
	//Resource for updating a project
	@PUT
	@Path("project")
	@Consumes({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public Project updateProject(Project project)
	{
		System.out.println(project);
		
		if(repo.getProject(project.getProjectID()).getProjectID() == 0)
		{
			repo.createProject(project);
		}
		else
		{
			repo.updateProject(project);
		}
		
		return project;
	}
	
	
	
	
	//Resourse for deleting project
	@DELETE
	@Path("project/{projectID}")
	public Project deleteProject(@PathParam("projectID") int projectID)
	{
		Project project = repo.getProject(projectID);
		
		if(project.getProjectID() != 0)
		{
			repo.deleteProject(projectID);
		}
		else
		{
			System.out.println("Something wrong..!");
		}
		
		return project;
	}
	
}

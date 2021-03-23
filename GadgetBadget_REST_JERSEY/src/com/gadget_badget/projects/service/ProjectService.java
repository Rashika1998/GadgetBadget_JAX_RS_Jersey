package com.gadget_badget.projects.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.gadget_badget.projects.model.ProjectServlet;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



@Path("/Projects") 
public class ProjectService 
{
	
	ProjectServlet projectObj = new ProjectServlet(); 
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readProjects() 
	{ 
		return projectObj.readProjects(); 
	} 
	
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertProject(
		 @FormParam("projectCode") String projectCode, 
		 @FormParam("projectName") String projectName, 
		 @FormParam("projectDesc") String projectDesc, 
		 @FormParam("projectDevBy") String projectDevBy,
		 @FormParam("projectPrice") String projectPrice,
		 @FormParam("projectCategory") String projectCategory,
		 @FormParam("projectServiceCharge") String projectServiceCharge) 
	{ 
		String output = projectObj.insertProject(projectCode, projectName, projectDesc, projectDevBy, projectPrice, projectCategory, projectServiceCharge); 
		return output; 
	}
	
	
	
	
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateProject(String projectData) 
	{ 
		//Convert the input string to a JSON object 
		 JsonObject projectObject = new JsonParser().parse(projectData).getAsJsonObject(); 
		//Read the values from the JSON object
		 String projectID = projectObject.get("projectID").getAsString(); 
		 String projectCode = projectObject.get("projectCode").getAsString(); 
		 String projectName = projectObject.get("projectName").getAsString(); 
		 String projectDesc = projectObject.get("projectDesc").getAsString(); 
		 String projectDevBy = projectObject.get("projectDevBy").getAsString(); 
		 String projectPrice = projectObject.get("projectPrice").getAsString(); 
		 String projectCategory = projectObject.get("projectCategory").getAsString(); 
		 String projectServiceCharge = projectObject.get("projectServiceCharge").getAsString(); 
		 String output = projectObj.updateProject(projectID, projectCode, projectName, projectDesc, projectDevBy, projectPrice, projectCategory, projectServiceCharge); 
		 return output; 
	}
	
	
	
	
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteProject(String projectData) 
	{ 
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(projectData, "", Parser.xmlParser()); 
		 
		//Read the value from the element <itemID>
		 String projectID = doc.select("projectID").text(); 
		 String output = projectObj.deleteProject(projectID); 
		 return output; 
	}

}

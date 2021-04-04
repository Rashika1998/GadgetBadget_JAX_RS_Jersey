package com.gadget_badget.researcher.service;

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

import com.gadget_badget.researcher.model.ResearcherServlet;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("/Researchers") 
public class ResearcherService 
{
	
	ResearcherServlet researcherObj = new ResearcherServlet(); 
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readResearchers() 
	{ 
		return researcherObj.readResearchers(); 
	} 
	
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertResearcher(
		 @FormParam("resCode") String resCode, 
		 @FormParam("resName") String resName, 
		 @FormParam("resEmail") String resEmail, 
		 @FormParam("resAge") String resAge,
		 @FormParam("resAddress") String resAddress,
		 @FormParam("resRole") String resRole,
		 @FormParam("joinDate") String joinDate) 
	{ 
		String output = researcherObj.insertResearcher(resCode, resName, resEmail, resAge, resAddress, resRole, joinDate); 
		return output; 
	}
	
	
	
	
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateResearcher(String researcherData) 
	{ 
		//Convert the input string to a JSON object 
		 JsonObject researcherObject = new JsonParser().parse(researcherData).getAsJsonObject(); 
		//Read the values from the JSON object
		 String resID = researcherObject.get("resID").getAsString(); 
		 String resCode = researcherObject.get("resCode").getAsString(); 
		 String resName = researcherObject.get("resName").getAsString(); 
		 String resEmail = researcherObject.get("resEmail").getAsString(); 
		 String resAge = researcherObject.get("resAge").getAsString(); 
		 String resAddress = researcherObject.get("resAddress").getAsString(); 
		 String resRole = researcherObject.get("resRole").getAsString(); 
		 String joinDate = researcherObject.get("joinDate").getAsString(); 
		 String output = researcherObj.updateResearcher(resID, resCode, resName, resEmail, resAge, resAddress, resRole, joinDate); 
		 return output; 
	}
	
	
	
	
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteResearcher(String researcherData) 
	{ 
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(researcherData, "", Parser.xmlParser()); 
		 
		//Read the value from the element <itemID>
		 String resID = doc.select("resID").text(); 
		 String output = researcherObj.deleteResearcher(resID); 
		 return output; 
	}

}
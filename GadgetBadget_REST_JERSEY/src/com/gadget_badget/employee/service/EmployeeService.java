package com.gadget_badget.employee.service;

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

import com.gadget_badget.employee.model.EmployeeServlet;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("/Employees") 
public class EmployeeService 
{
	EmployeeServlet employeeObj = new EmployeeServlet(); 
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readEmployees() 
	{ 
		return employeeObj.readEmployees(); 
	} 
	
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertEmployee(
		 @FormParam("empCode") String empCode, 
		 @FormParam("empName") String empName, 
		 @FormParam("empEmail") String empEmail, 
		 @FormParam("empAge") String empAge,
		 @FormParam("empAddress") String empAddress,
		 @FormParam("empRole") String empRole,
		 @FormParam("jobStartedDate") String jobStartedDate) 
	{ 
		String output = employeeObj.insertEmployee(empCode, empName, empEmail, empAge, empAddress, empRole, jobStartedDate); 
		return output; 
	}
}
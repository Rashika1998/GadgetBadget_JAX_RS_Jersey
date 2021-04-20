package com.gadget_badget.orders.service;

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

import com.gadget_badget.orders.model.OrderServlet;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("/Orders") 
public class OrderService 
{
	OrderServlet orderObj = new OrderServlet(); 
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readOrder() 
	{ 
		return orderObj.readOrder(); 
	} 
}
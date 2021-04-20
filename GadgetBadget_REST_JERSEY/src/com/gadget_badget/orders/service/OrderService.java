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
	OrderServlet orderServlet = new OrderServlet(); 
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readOrder() 
	{ 
		return orderObj.readOrder(); 
	} 
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertOrder(
		 @FormParam("orderCode") String orderCode, 
		 @FormParam("customerID") String customerID, 
		 @FormParam("customerEmail") String customerEmail, 
		 @FormParam("customerName") String customerName,
		 @FormParam("orderTotalAmount") String orderTotalAmount,
		 @FormParam("cardNo") String cardNo,
		 @FormParam("cvvNo") String cvvNo)
		 
	{ 
		String output = orderServlet.insertOrder(orderCode, customerID, customerEmail, customerName, orderTotalAmount, cardNo, cvvNo); 
		return output; 
	}
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateOrder(String orderData) 
	{ 
		 JsonObject orderObject = new JsonParser().parse(orderData).getAsJsonObject(); 
		 String orderID = orderObject.get("orderID").getAsString(); 
		 String orderCode = orderObject.get("orderCode").getAsString(); 
		 String customerID = orderObject.get("customerID").getAsString(); 
		 String customerEmail = orderObject.get("customerEmail").getAsString(); 
		 String customerName = orderObject.get("customerName").getAsString(); 
		 String orderTotalAmount = orderObject.get("orderTotalAmount").getAsString(); 
		 String cardNo = orderObject.get("cardNo").getAsString(); 
		 String cvvNo = orderObject.get("cvvNo").getAsString(); 
		 
		 String output = orderServlet.updateOrder(orderID, orderCode, customerID, customerEmail, customerName, orderTotalAmount, cardNo, cvvNo); 
		 return output; 
	}
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteOrder(String orderData) 
	{ 
		 Document document = Jsoup.parse(orderData, "", Parser.xmlParser()); 
		 
		 String orderID = document.select("orderID").text(); 
		 String output = orderServlet.deleteOrder(orderID); 
		 return output; 
	}
}
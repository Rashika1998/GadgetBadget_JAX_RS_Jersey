package com.gadget_badget.cart.service;

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

import com.gadget_badget.cart.model.CartServlet;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("/Carts") 
public class CartService 
{
	CartServlet cartObj = new CartServlet(); 
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readCart() 
	{ 
		return cartObj.readCart(); 
	} 
	
    @POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertCart(
		 @FormParam("cartCode") String cartCode, 
		 @FormParam("projectCode") String projectCode, 
		 @FormParam("projectName") String projectName, 
		 @FormParam("projectQty") String projectQty,
		 @FormParam("projectUnitPrice") String projectUnitPrice,
		 @FormParam("customerID") String customerID)
		 
	{ 
		String output = cartObj.insertCart(cartCode, projectCode, projectName, projectQty, projectUnitPrice, customerID); 
		return output; 
	}

    	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateCart(String cartData) 
	{ 
		//Convert the input string to a JSON object 
		 JsonObject cartObject = new JsonParser().parse(cartData).getAsJsonObject(); 
		//Read the values from the JSON object
		 String cartID = cartObject.get("cartID").getAsString(); 
		 String cartCode = cartObject.get("cartCode").getAsString(); 
		 String projectCode = cartObject.get("projectCode").getAsString(); 
		 String projectName = cartObject.get("projectName").getAsString(); 
		 String projectQty = cartObject.get("projectQty").getAsString(); 
		 String projectUnitPrice = cartObject.get("projectUnitPrice").getAsString(); 
		 String customerID = cartObject.get("customerID").getAsString(); 
		 
		 String output = cartObj.updateCart(cartID, cartCode, projectCode, projectName, projectQty, projectUnitPrice, customerID); 
		 return output; 
	}
	
    	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteCart(String cartData) 
	{ 
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(cartData, "", Parser.xmlParser()); 
		 
		//Read the value from the element <itemID>
		 String cartID = doc.select("cartID").text(); 
		 String output = cartObj.deleteCart(cartID); 
		 return output; 
	}

	
}
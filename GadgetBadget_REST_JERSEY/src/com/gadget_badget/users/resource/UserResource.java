package com.gadget_badget.users.resource;

import java.util.Arrays;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gadget_badget.users.model.User;
import com.gadget_badget.users.repository.UserRepository;

@Path("users")
public class UserResource 
{
	
	UserRepository repo = new UserRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public List<User> getUsers()
	{
		System.out.println("GetUser method called.");
		return repo.getUsers();
	}
	
	
	
	
	@GET
	@Path("user/{userID}")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public User getUser(@PathParam("userID") int userID)
	{
		return repo.getUser(userID);
	}
	
	
	
	
	@POST
	@Path("user")
	public User createUser(User user)
	{
		System.out.println(user);
		repo.createUser(user);
		return user;
	}
	
	
}

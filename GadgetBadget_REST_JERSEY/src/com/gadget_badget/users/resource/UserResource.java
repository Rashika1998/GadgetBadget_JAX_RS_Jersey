package com.gadget_badget.users.resource;

import java.util.Arrays;
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

import com.gadget_badget.users.model.User;
import com.gadget_badget.users.repository.UserRepository;

@Path("users")
public class UserResource 
{
	
	//Create User Repository called 'repo'
	UserRepository repo = new UserRepository();
	
	
	
	//Resource for getting all users
	@GET
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public List<User> getUsers()
	{
		System.out.println("GetUser method called.");
		return repo.getUsers();
	}
	
	
	
	//Resource for getting a user by userID
	@GET
	@Path("user/{userID}")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public User getUser(@PathParam("userID") int userID)
	{
		return repo.getUser(userID);
	}
	
	
	
	//Resource for creating a user
	@POST
	@Path("user")
	@Consumes({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public User createUser(User user)
	{
		System.out.println(user);
		repo.createUser(user);
		return user;
	}
	
	
	
	//Resource for updating a user
	@PUT
	@Path("user")
	@Consumes({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public User updateUser(User user)
	{
		System.out.println(user);
		
		if(repo.getUser(user.getUserID()).getUserID() == 0)
		{
			repo.createUser(user);
		}
		else
		{
			repo.updateUser(user);
		}
		
		return user;
	}
	
	
	//Resource for deleting a user
	@DELETE
	@Path("user/{userID}")
	public User deleteUser(@PathParam("userID") int userID)
	{
		User user = repo.getUser(userID);
		
		if(user.getUserID() != 0)
		{
			repo.deleteUser(userID);
		}
		else
		{
			System.out.println("Something wrong..!");
		}
		
		return user;
	}
	
	
}

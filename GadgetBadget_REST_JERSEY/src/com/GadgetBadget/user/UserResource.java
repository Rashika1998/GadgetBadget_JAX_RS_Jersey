package com.GadgetBadget.user;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("users")
public class UserResource 
{
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUser()
	{
		System.out.println("GetUser method called.");
		
		User new_user = new User();
		
		new_user.setUserID(100);
		new_user.setUserProfileName("Rashika Madhushanka");
		new_user.setBio("Software Engineer, UI/UX Designer");
		new_user.setDob("98/03/16");
		new_user.setUsername("@rashika");
		new_user.setPassword("rashika123");
		
		User new_user1 = new User();
		
		new_user1.setUserID(100);
		new_user1.setUserProfileName("Rashika Rathnayaka");
		new_user1.setBio("Software Engineer, UI/UX Designer");
		new_user1.setDob("98/03/16");
		new_user1.setUsername("@rathnayaka");
		new_user1.setPassword("rashika12345");
		
		List<User> users = Arrays.asList(new_user , new_user1);
		
		return users;
		
		
		
	}
}

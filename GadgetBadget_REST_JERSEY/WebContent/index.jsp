<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
<title>GadgetBadget JAX/RS REST_JERSEY</title>
</head>
<body>

	<h1>GadgetBadget</h1>
	<p>Project Initialization</p>
	<p>get all users : http://localhost:9002/GadgetBadget_REST_JERSEY/myService/users</p>
	<p>get Unique user : http://localhost:9002/GadgetBadget_REST_JERSEY/myService/users/user/userID</p>
	<p>GET request</p>
	<p>No Body</p>
	<br>
	<br>
	<br>
	
	<p>Insert To The MySql Database : http://localhost:9002/GadgetBadget_REST_JERSEY/myService/users/user</p>
	<p>POST request</p>
	<p>Create Body</p>
	<!-- 
	<user>
	    <userID>ID</userID>
	    <userProfileName>Profile name</userProfileName>
	    <bio>Bio</bio>
	    <dob>Dob</dob>
	    <email>email</email>
	    <username>username</username>
	    <password>password</password>
	</user> 
	-->
	
	<p>Update in The MySql Database : http://localhost:9002/GadgetBadget_REST_JERSEY/myService/users/user</p>
	<p>PUT request</p>
	<p>Create Body</p>
	<!-- 
	<user>
	    <userID>ID</userID>
	    <userProfileName>Profile name</userProfileName>
	    <bio>Bio</bio>
	    <dob>Dob</dob>
	    <email>email</email>
	    <username>username</username>
	    <password>password</password>
	</user> 
	-->
	
	<p>Update in The MySql Database : http://localhost:9002/GadgetBadget_REST_JERSEY/myService/users/user/userID</p>
	<p>DELETE request</p>
	<p>No Body</p>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\' integrity=\'sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\' crossorigin=\'anonymous\'>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
<title>GadgetBadget JAX/RS REST_JERSEY</title>
</head>
<body>
	
	<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">GadgetBadget</a>
		    </div>
		    <ul class="nav navbar-nav">
		      <li class="active"><a href="#">Home</a></li>
		      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Projects">Products</a></li>
		          <li><a href="http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Carts">Cart</a></li>
		          <li><a href="http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Orders">Order</a></li>
		        </ul>
		      </li>
		      
		      <li><a href="http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Projects">Products</a></li>
		      <li><a href="http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Carts">Cart</a></li>
		      <li><a href="http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Orders">Order</a></li>
		      <li><a href="http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Employees">Employee Manage</a></li>
		      <li><a href="#">Contact Us</a></li>
		      <li><a href="#">About Us</a></li>
		      
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		    </ul>
		  </div>
	</nav>




	<div class="container">
	<h1>GadgetBadget</h1>
	<p>Project Initialization</p>
	<p>get all users : http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Projects</p>
	<p>GET request</p>
	<p>No Body</p>
	<br>
	<br>
	<br>
	
	<p>Insert To The MySql Database : http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Projects</p>
	<p>POST request</p>
	
	<p>Create Body</p>
	<!-- 
	{
    
    "projectCode" : "p_code_01",
    "projectName" : "Html , Css Design",
    "projectDesc" : "Bootstrap framework, Mobile friendly",
    "projectDevBy" : "R.M. Rashika Rathnayaka",
    "projectPrice" : "260.00",
    "projectCategory" : "HTML UI design",
    "projectServiceCharge" : "200.00"
}
	-->
	
	<p>Update in The MySql Database : http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Projects</p>
	<p>PUT request</p>
	<p>Create Body</p>
	<!-- 
	{
    "projectID" : "3",
    "projectCode" : "p_code_01",
    "projectName" : "Html , Css Design",
    "projectDesc" : "Bootstrap framework, Mobile friendly",
    "projectDevBy" : "R.M. Rashika Rathnayaka",
    "projectPrice" : "260.00",
    "projectCategory" : "HTML UI design",
    "projectServiceCharge" : "200.00"
}
	-->
	
	<p>Delete from The MySql Database : http://localhost:9002/GadgetBadget_REST_JERSEY/myService/Projects</p>
	<p>DELETE request</p>
	<p>No Body</p>
	
	</div>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="main_styles.css">
<title>Insert title here</title>
</head>
<body>


<!-- navibar-inverse -->
	<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="http://localhost:9002/GadgetBadget_REST_JERSEY/">GadgetBadget</a>
		    </div>
		    <ul class="nav navbar-nav">
		      <li class="active"><a href="http://localhost:9002/GadgetBadget_REST_JERSEY/">Home</a></li>
	
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
	<form action="" method="post">
		  
		  <div class="container">
			    <label for="uname"><b>Username</b></label>
			    <input type="text" placeholder="Enter Username" name="uname" >
			
			    <label for="psw"><b>Password</b></label>
			    <input type="password" placeholder="Enter Password" name="psw" >
			
			    <button type="submit"><a href="http://localhost:9002/GadgetBadget_REST_JERSEY/" style="text-decoration:none; color:white;">Login</a></button>
			    <label>
			      <input type="checkbox" checked="checked" name="remember"> Remember me
			    </label>
		  </div>
		
		  <div class="container" style="background-color:#f1f1f1">
			    <button type="button" class="cancelbtn">Cancel</button>
			    <span class="psw">Forgot <a href="#">password?</a></span>
		  </div>
		  
		  <div class="container">
		  		<label>
		      		<input type="checkbox"  name="remember"><a href="adminPanal.jsp" style="text-decoration:none; margin-left:10px;">I am an Adimn?</a>
		    	</label>
		  </div>
	</form>
</div>


</body>
</html>
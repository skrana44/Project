<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %> 
<%@ include file="Header.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PetPeers</title>
<script type="text/javascript">

window.setTimeout(function() 
{
	var label = document.getElementById("msg");
	if (label != null) {label.style.display = 'none';}}, 2000);
function valpass()
{
	document.getElementById("passvalidate").innerHTML="";
	if(document.getElementById("p2").value!=document.getElementById("p1").value)
		{
		document.getElementById("passvalidate").innerHTML="Passwords do not match";
		return false;
	
	}
	return true;
}
</script>
</head>
<body>
<div class="container">
<h2>Welcome to PetPeers</h2>
<div id="s1" style="width: 50%;float: left">
<h3>Login</h3><br>
<form action="UserActionLogin" name="login" method="post">
<input type="text" placeholder="Enter Username" name="userid" required><br>
<input type="Password" placeholder="Enter Password" name="password" required><br>
<button type="submit">Login</button>
<button type="reset">Reset</button><br><br>
<br><br>
</form>
</div>
<div id="s2" style="display: block">
<h3>Sign Up</h3><br>
<form action="UserActionSignup" name="signup" method="post" onsubmit="return valpass()">
<input type="text" placeholder="Name" required name="name"><br>
<input type="text" placeholder="Choose Username" required name="userid"><br>
<input type="Password" placeholder="Enter Password" required id="p1" name="password"><br>
<input id="p2" type="Password" placeholder="Re-enter Password" required name="repass"><br>
<p id="passvalidate" style="color:red"></p><br>
<button type="submit"   style="float: right;margin-right: 145px">Sign Up</button><br><br>
<p id="msg" style="color:red">${invalid}</p>
<p id="msg" style="color:green;text-align: center">${message}</p>
<br><br><br>
</form>
</div>
</div>
</body>
</html>
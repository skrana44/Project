<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %> 
<%@ include file="Header.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
window.setTimeout(function() 
 {
	var label = document.getElementById("nf");
        if (label!= null) 
        {label.style.display = 'none';}}, 5000);
        
window.setTimeout(function() 
		 {
			var label = document.getElementById("nf1");
		        if (label!= null) 
		        {label.style.display = 'none';}}, 5000);
		        
window.setTimeout(function() 
		 {
			var label = document.getElementById("nf2");
		        if (label!= null) 
		        {label.style.display = 'none';}}, 5000);
</script>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<div style="float:right;margin-right: 20px">
<a href = "pet_Welcome.jsp" class = "Home">Home</a>
<a href = "UserActionLogout" class="Logout">Logout</a>
</div>

<div class="container">
<h2>Welcome : ${name}</h2>
<a href="add_pet.jsp" class="useropt">Add Pet</a><br>
<a href="search_pet.jsp" class="useropt">Search Pet</a><br>
<a href="PetActionSearchAll" class="useropt">Buy Pet</a><br>

<a href="<%=request.getContextPath()%>/PetActionShowmypet" class="useropt">Pets added by me</a><br>

<a href="<%=request.getContextPath()%>/PetActionPurchaseHistory" class="useropt">Purchase History</a><br><br>
<p id="nf" style="color:red">${norecord}</p>
<p id="nf1" style="color:red">${nopets}</p>
<p id="nf2" style="color:red">${emptylist}</p>
</div>


</body>
</html>
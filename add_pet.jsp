<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page errorPage="error.jsp" %> 
         <%@ include file="Header.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Pet</title>

<script type="text/javascript">
window.setTimeout(function() 
 {var label = document.getElementById("msg");
        if (label != null) {
            label.style.display = 'none';}}, 5000);
            
window.setTimeout(function() 
 {var label = document.getElementById("exception");
		        if (label != null) {
		            label.style.display = 'none';}}, 5000);
</script>
</head>
<body>
<div style="float:right;margin-right: 20px">
<a href = "pet_Welcome.jsp" class ="Home">Home</a>
<a href = "UserActionLogout" class="Logout">Logout</a>
</div>
<div class="container">
<h2>Welcome : ${name}</h2>
<h2>Add your Pet</h2>
<form method="post" action="PetActionAdd">
<select name="ptype" required>
<option>Dog</option> 
<option>Cat</option> 
</select><br><br>
<input type="radio" name="psize" value="Large" required>Large
<input type="radio" name="psize" value="Small" required>Small
<input type="radio" name="psize" value="Medium" required>Medium<br><br>
<input type="text" name="pname" placeholder="Name" required><br>
<input type="text" name="page" placeholder="Age (in years)" required pattern="\d" id="page"><br>

<input id="searchTextField" type="text" name="pplace" placeholder="Place" required><br>

<select name="psex" required>
<option>Male</option> 
<option>Female</option> 
</select><br><br>

<button type="submit">Save</button>
<button type="reset" name="cancel">Cancel</button><br><br>
<p id="msg" style="color:green">${added}</p>
<p id="exception" style="color:red">${exception}</p>
</form>
</div>
</body>
</html>
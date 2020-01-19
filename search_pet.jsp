<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        {label.style.display = 'none';}}, 2000);
</script>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Search Pet</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div style="float:right;margin-right: 20px">
<a href = "pet_Welcome.jsp" class = "Home">Home</a>
<a href = "UserActionLogout" class="Logout">Logout</a>
</div>
<div class="container">
<h2>Welcome : ${name}</h2>

<h2>Search Pet</h2>
<form action="PetActionSearch" method="post">
<select name="ptype">
<c:forEach items="${types}" var="type">
<option>${type.pet_type}</option>
</c:forEach>
</select>
<br><br>S

<input type="radio" name="psize" value="Large">Large
<input type="radio" name="psize" value="Medium">Medium
<input type="radio" name="psize" value="Small">Small<br><br>
<input type="text" name="pname" placeholder="Name"><br>
<input type="text" name="pplace" placeholder="Place"><br>
<input type="text" name="page" placeholder="Age (in years)" pattern="\d"><br><br>
<button type="submit">Search</button>
<button type="reset">Reset</button><br><br>
<p id="nf" style="color:red">${norecord}</p>
</form>
</div>
</body>
</html>
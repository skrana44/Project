<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="error.jsp" %> 
     <%@ include file="Header.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Search Results</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div style="float:right;margin-right: 20px">
<a href = "pet_Welcome.jsp" class = "Home">Home</a>
<a href = "UserActionLogout" class="Logout">Logout</a>
</div>
<div class="container">
<h2>Welcome : ${name}</h2>
<h2>Search Results</h2>
<table border="1" class="tablecontainer">
<tr style="background-color: burlywood;">
<td>PetId</td>
<td>Pet Name</td>
<td>Pet Age</td>
<td>Pet Place</td>
<td>Pet Type</td>
<td>Pet Size</td>
<td>Pet Sex</td>
<td>Remove Pet</td>
</tr>

<c:forEach items="${list1}" var="nm">
<tr>
<td>${nm.pet_id}</td>
<td>${nm.pet_name}</td>
<td>${nm.pet_age}</td>
<td>${nm.pet_place}</td>
<td>${nm.pet_type}</td>
<td>${nm.pet_size}</td>
<td>${nm.pet_sex}</td>
<td><a href="PetActionRemove?${nm.pet_id}">Remove</a></td>
</tr>
</c:forEach>
</table><br>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ include file="Header.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase History</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div style="float:right;margin-right: 20px">
<a href = "pet_Welcome.jsp" class = "Home">Home</a>
<a href = "UserActionLogout" class="Logout">Logout</a>
</div>
<div class="container">
<h2>Welcome : ${name}</h2>
<h2>Purchase History</h2>
<table border="1" class="tablecontainer">
<tr>
<td>PetId</td>
<td>Owner</td>

</tr>

<c:forEach items="${plist}" var="m">
<tr>
<td>${m.pet_id}</td>
<td>${m.user_id}</td>
</tr>
</c:forEach>
</table><br>
</div>
</body>
</html>
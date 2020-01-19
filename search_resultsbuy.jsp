<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="error.jsp" %> 
     <%@ include file="Header.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function confirmbuy()
{
	var confirm = window.confirm("Are you sure you want to Buy");
	if (confirm == true) 
	{
	     x = "Congratulations for buying a Pet !";
	     document.getElementById("bought").innerHTML=x;
	     return true;
	}
	return false;
}
</script>
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

<h3>Search Results</h3>
<table border="1" class="tablecontainer" id="results">
<tr style="background-color: burlywood;">
<td>PetId</td>
<td>Owner</td>
<td>Pet Name</td>
<td>Pet Age</td>
<td>Pet Place</td>
<td>Pet Type</td>
<td>Pet Size</td>
<td>Pet Sex</td>
<td></td>
</tr>
<c:forEach items="${list1}" var="l">
<tr>
<td>${l.pet_id}</td>
<td>${l.user_id}</td>
<td>${l.pet_name}</td>
<td>${l.pet_age}</td>
<td>${l.pet_place}</td>
<td>${l.pet_type}</td>
<td>${l.pet_size}</td>
<td>${l.pet_sex}</td>
<td>
<c:set var="sessionid" value="${userid}"/>
<c:set var="ownerid" value="${l.user_id}"/>

<c:choose>
<c:when test="${sessionid!=ownerid}">
<a href="PetActionBuy?${l.pet_id}" onclick="return confirmbuy()">Buy</a>
</c:when>
<c:otherwise>
<a href="PetActionRemove?${l.pet_id}"></a>
</c:otherwise>
</c:choose>

</td>
</tr>
</c:forEach>
</table><br>
<p id="bought"></p>
</div>
</body>
</html>
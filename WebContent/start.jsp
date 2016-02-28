<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<%-- <jsp:include page="_head.jsp"></jsp:include> --%>
	<link rel = "stylesheet" type = "text/css" href = "css/normalize.css"/>
	<link rel = "stylesheet" type = "text/css" href = "css/mpg.css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<ul>
		<li><a href = "./start.jsp">Home</a></li>
	</ul>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MPG Tracker</title>
</head>
<body>
	<form name = "get">
		<input type = "submit" class="buttons" name = "submit" value = "GET"/>
	</form>

	<form name = "getID">
		<input type = "submit" class="buttons" name = "submit" value = "GET BY ID"/>
		<select name = "select" class="buttons">
		</select>
	</form>

	<form name = "updateID">
		<input type = "text" name = "desc" placeholder="Trip Desciption"/>
		<input type = "text" name = "miles" placeholder="Miles Driven"/>
		<input type = "text" name = "gallons" placeholder="Gallons Purchased"/>
		<input type = "text" name = "gas" placeholder="Price Of Gas"/>
		<input type = "submit" class="buttons" name = "submit" value = "UPDATE BY ID"/>
		<select name = "select" class="buttons">
		</select>
	</form>

	<form name = "deleteID">
		<input type = "submit" class="buttons" name = "submit" value = "DELETE BY ID"/>
		<select name = "select" class="buttons">
		</select>
	</form>

	<form name="add">
		<input type = "text" name = "desc" placeholder="Trip Desciption"/>
		<input type = "text" name = "miles" placeholder="Miles Driven"/>
		<input type = "text" name = "gallons" placeholder="Gallons Purchased"/>
		<input type = "text" name = "gas" placeholder="Price Of Gas"/>
		<input type = "submit" class="buttons" name = "submit" value = "ADD NEW TRIP"/>
	</form>
	<%-- <table name="table"></table> --%>

	<script src="./js/mpg.js"></script>
</body>
</html>

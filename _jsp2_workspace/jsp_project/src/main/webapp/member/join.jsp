<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>
	<form action="/mem/register" method="post">
	ID : <input type="text" name="id"><br>
	PASSWORD : <input type="text" name="password"><br>
	Email : <input type="text" name="email">
	AGE : <input type="text" name="age"><br>
	<button type="submit">join</button>
	</form>
</body>
</html>
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
	<h1>Index Page</h1>
	<form action="/mem/login" method="post">
	ID : <input type="text" name="id"><br>
	PASSWORD : <input type="text" name="password"><br>
	<button type="submit">login</button><br>
	<a href="/mem/join.jsp">회원가입</a>
	</form>
	
	<!-- 로그인 연결시 -->
	
	
	<a href="/mem/join">join</a>
	<a href="/mem/list">Member List</a>
	
	

	<ul>
		<li>
			<a href="/brd/register">글쓰기 Page로 이동</a>
		</li>
		<li>
			<a href="/brd/list">Board List로 이동</a>
		</li>
	</ul>
	
</body>
</html>
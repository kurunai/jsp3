<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Modify Page</h1>
	<form action="/mem/update" method="post">
		ID : <input type="text" name="id" value="${mvo.id }" readonly><br>
		PASSWORD : <input type="text" name="password" value="${mvo.password }"><br>
		Email : <input type="text" name="email" value="${mvo.email }"><br>
		AGE : <input type="text" name="age" value="${mvo.age }"><br>
		<button type="submit">수정</button>
	</form>
	<a href="/mem/remove?id=${mvo.id }"><button type="button">삭제</button></a>
</body>
</html>
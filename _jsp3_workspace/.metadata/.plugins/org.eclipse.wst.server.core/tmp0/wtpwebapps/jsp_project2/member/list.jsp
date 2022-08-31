<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Member Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Member List Page</h2>
  <p>Member List</p>
  <c:forEach items="${list }" var="mvo">
  <ul class="list-group list-group-horizontal">
    <li class="list-group-item">${mvo.reg_at }</li>
    <li class="list-group-item">${mvo.last_login }</li>
    <li class="list-group-item">${mvo.nick_name }</li>
    <li class="list-group-item">(<a href="/mem/modify?email=${mvo.email }">${mvo.email }</a>)</li>
  </ul>
  </c:forEach>
</div>

</body>
</html>


<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member List Page</h1>
<a href="/">Main</a>
	<c:forEach items="${list }" var="mvo">
		<div>
			<p>
				reg_date : ${mvo.reg_at }<br>
				last_login : ${mvo.last_login }<br>
				${mvo.nick_name }<br>
				(<a href="/mem/modify?email=${mvo.email }">${mvo.email }</a>)
			</p>
		</div>	
	</c:forEach>
</body>
</html> --%>
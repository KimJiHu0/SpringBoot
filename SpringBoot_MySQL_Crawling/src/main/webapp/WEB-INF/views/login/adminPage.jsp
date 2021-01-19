<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>adminPage</h1>
	<button onclick="location.href='/'">메인으로</button>
	
	<p>${dto.membername } 님 어서오세요.</p>
	<button onclick="location.href='logout.do'">LogOut</button>

</body>
</html>
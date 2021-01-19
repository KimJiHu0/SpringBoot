<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
<link href="/CSS/boardList.css" rel="stylesheet">
</head>
<body>

	<h1>boardList</h1>

	<table border="1">
	<col width="100">
	<col width="200">
	<col width="300">
		<tr>
			<th class="title">No</th>
			<th class="title">Name</th>
			<th class="title">Title</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<td colspan="3" align="center">현재 작성된 글이 없습니다.</td>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="list">
					<tr>
						<td class="content">${list.boardno }</td>
						<td class="content">${list.boardname }</td>
						<td class="content"><a class="clicktitle" href="boarddetail.do?boardno=${list.boardno }">${list.boardtitle }</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="3" align="right">
				<button onclick="location.href='boardinsert.do'">글작성</button>
			</td>
		</tr>
	</table>

</body>
</html>
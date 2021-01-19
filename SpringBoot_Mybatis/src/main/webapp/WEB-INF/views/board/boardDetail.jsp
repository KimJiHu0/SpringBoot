<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetail.jsp</title>
<link href="/CSS/boardDetail.css" rel="stylesheet">
</head>
<body>

	<h1>boardDetail</h1>

	<table border="1">
	<col width="100">
		<tr>
			<th class="title">No</th>
			<td>${dto.boardno }</td>
		</tr>
		<tr>
			<th class="title">Name</th>
			<td>${dto.boardname }</td>
		</tr>
		<tr>
			<th class="title">Title</th>
			<td>${dto.boardtitle }</td>
		</tr>
		<tr>
			<th class="title">Content</th>
			<td>
				<textarea class="boardcontent" rows="15" cols="80" readonly="readonly">${dto.boardcontent }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<button onclick="location.href='boardupdate.do?boardno=${dto.boardno}'">수정</button>
				<button onclick="location.href='boarddelete.do?boardno=${dto.boardno}'">삭제</button>
				<button onclick="location.href='boardlist.do'">뒤로</button>
			</td>
		</tr>
	</table>

</body>
</html>
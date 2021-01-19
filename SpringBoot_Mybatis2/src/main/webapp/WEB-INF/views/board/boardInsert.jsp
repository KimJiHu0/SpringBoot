<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardInsert.jsp</title>
<link href="/CSS/boardInsert.css" rel="stylesheet">
</head>
<body>

	<h1>boardInsert</h1>
	
	<form action="boardinsertres.do" method="post">
	<table border="1">
	<col width="100">
		<tr>
			<th class="title">Name</th>
			<td><input type="text" class="content" name="boardname" placeholder="작성자를 입력하세요"></td>
		</tr>
		<tr>
			<th class="title">Title</th>
			<td><input type="text" class="content" name="boardtitle" placeholder="제목을 입력하세요"></td>
		</tr>
		<tr>
			<th class="title">Content</th>
			<td>
				<textarea rows="15" cols="80" class="boardcontent" name="boardcontent"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="right">
				<input type="submit" value="작성"/>
				<input type="button" value="취소" onclick="location.href='boardlist.do'"/>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
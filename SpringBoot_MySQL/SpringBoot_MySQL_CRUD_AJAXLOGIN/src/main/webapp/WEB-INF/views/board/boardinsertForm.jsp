<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	textarea{
		resize : none;
	}

</style>
</head>
<body>

	<h1>Insert</h1>
	
	<form action="insertres.do" method="post">
		<table border="1">
		<tr>
			<th>Writer</th>
			<td><input type="text" placeholder="작성자를 입력해주세요." name="boardwriter"/></td>
		</tr>
		<tr>
			<th>Title</th>
			<td><input type="text" placeholder="제목을 입력해주세요." name="boardtitle"/></td>
		</tr>
		<tr>
			<th>Content</th>
			<td>
				<textarea rows="10" cols="60" placeholder="내용을 입력해주세요." name="boardcontent"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="right">
				<input type="button" value="취소" onclick="location.href='list.do'">
				<input type="submit" value="작성완료">
			</td>
		</tr>
	</table>
	</form>

</body>
</html>
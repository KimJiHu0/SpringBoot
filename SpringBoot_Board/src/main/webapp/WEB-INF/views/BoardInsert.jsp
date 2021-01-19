<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Insert</h1>
	
	<form action="/insertres" method="post">
		<table border="1">
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="boardtitle"/></td>
			</tr>
			<tr>
				<th>WRITER</th>
				<td><input type="text" name="boardwriter"/></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td>
					<textarea rows="10" cols="60" name="boardcontent"></textarea>
				</td>
			</tr>
			<tr>
				<th colspan="2" align="right">
					<input type="submit" value="작성완료"/>
					<input type="button" value="작성취소" onclick="location.href='/list'"/>	
				</th>
			</tr>
		</table>
	</form>

</body>
</html>
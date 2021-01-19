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

	<h1>Detail</h1>
	
	<table border="1">
	<col width="100">
	<col width="150">
		<tr>
			<th>No</th>
			<td>${dto.boardno }번글</td>
		</tr>
		<tr>
			<th>Writer</th>
			<td>${dto.boardwriter }</td>
		</tr>
		<tr>
			<th>Title</th>
			<td>${dto.boardtitle }</td>
		</tr>
		<tr>
			<th>Content</th>
			<td>
				<textarea rows="10" cols="60" readonly="readonly">${dto.boardcontent }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="수정" onclick="location.href='update.do?boardno=${dto.boardno}'"/>
				<input type="button" value="삭제" onclick="location.href='delete.do?boardno=${dto.boardno}'"/>
				<input type="button" value="뒤로" onclick="location.href='list.do'"/>
			</td>
		</tr>
	</table>

</body>
</html>
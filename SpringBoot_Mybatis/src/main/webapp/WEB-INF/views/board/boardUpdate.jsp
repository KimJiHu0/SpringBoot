<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardUpdate.jsp</title>
<link href="/CSS/boardUpdate.css" rel="stylesheet">
</head>
<body>

	<h1>boardUpdate</h1>
	
	<form action="boardupdateres.do" method="post">
		<table border="1">
		<col width="100">
			<tr>
				<th class="title">No</th>
				<td><input type="text" class="content" name="boardno" value="${dto.boardno }" readonly="readonly"></td>
			</tr>
			<tr>
				<th class="title">Name</th>
				<td><input type="text" class="content" name="boardname" value="${dto.boardname }"></td>
			</tr>
			<tr>
				<th class="title">Title</th>
				<td>
					<input type="text" class="content" name="boardtitle" value="${dto.boardtitle }">
				</td>
			</tr>
			<tr>
				<th class="title">Content</th>
				<td>
					<textarea rows="15" cols="80" class="boardcontent" name="boardcontent">${dto.boardcontent }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="right">
					<input type="submit" value="수정">
					<input type="button" value="뒤로" onclick="location.href='boarddetail.do?boardno=${dto.boardno}'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
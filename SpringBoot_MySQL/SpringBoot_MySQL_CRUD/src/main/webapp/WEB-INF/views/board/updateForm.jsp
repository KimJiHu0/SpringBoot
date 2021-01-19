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

	<h1>Update</h1>
	
	<form action="updateres.do" method="post">
	<input type="hidden" value="${dto.boardno }" name="boardno"/>
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
				<td><input type="text" value="${dto.boardtitle }" placeholder="제목을 입력해주세요." name="boardtitle"/></td>
			</tr>
			<tr>
				<th>Content</th>
				<td>
					<textarea rows="10" cols="60" placeholder="내용을 입력해주세요." name="boardcontent">${dto.boardcontent }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="right">
					<input type="submit" value="수정완료"/>
					<input type="button" value="수정취소" onclick="location.href='detail.do?boardno=${dto.boardno}'"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
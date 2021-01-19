<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

var msg = '${msg}';
if(msg != ''){
	alert(msg);
}

</script>
</head>
<body>

	<h1>BoardDetail</h1>
	
	<table border="1">
		<tr>
			<th>TITLE</th>
			<td>${boarddto.boardtitle }</td>
		</tr>
		<tr>
			<th>WRITER</th>
			<td>${boarddto.boardwriter }</td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td>
				<textarea rows="10" cols="60" readonly>${boarddto.boardcontent }</textarea>
			</td>
		</tr>
		<tr>
			<th>DATE</th>
			<td><fmt:formatDate value="${boarddto.boardregdate }" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정하기" onclick="location.href='/update?boardno=${boarddto.boardno}'"/>
				<input type="button" value="삭제하기" onclick="location.href='/delete?boardno=${boarddto.boardno}'"/>
				<input type="button" value="뒤로가기" onclick="location.href='/list'"/>
			</td>
		</tr>
	</table>

</body>
</html>
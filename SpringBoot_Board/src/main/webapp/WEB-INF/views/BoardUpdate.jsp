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

	<h1>BoardUpdate</h1>
	
	<form action="/updateres" method="post">
	<input type="hidden" value="${boarddto.boardno }" name="boardno"/>
		<table border="1">
			<tr>
				<th>TITLE</th>
				<td><input type="text" value="${boarddto.boardtitle }" name="boardtitle"/></td>
			</tr>
			<tr>
				<th>WRITER</th>
				<td>${boarddto.boardwriter }</td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td>
					<textarea rows="10" cols="60" name="boardcontent">${boarddto.boardcontent }</textarea>
				</td>
			</tr>
			<tr>
				<th>DATE</th>
				<td><fmt:formatDate value="${boarddto.boardregdate }" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정완료"/>
					<input type="button" value="뒤로가기" onclick="/selectone?boardno=${boarddto.boardno}"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
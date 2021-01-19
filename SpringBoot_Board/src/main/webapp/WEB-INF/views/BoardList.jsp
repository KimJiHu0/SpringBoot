<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<h1>BoardList</h1>
	
	<table border="1">
		<tr>
			<th>NO</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>DATE</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<th>현재 작성된 글이 없습니다.</th>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="list">
				<tr>
					<td>${list.boardno }</td>
					<td><a href="/selectone?boardno=${list.boardno }">${list.boardtitle }</a></td>
					<td>${list.boardwriter }</td>
					<td><fmt:formatDate value="${list.boardregdate }" pattern="yyyy-MM-dd"/></td>
				</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<th colspan="4" align="right">
				<input type="button" value="글 작성하기" onclick="location.href='/insert'"/>
			</th>
		</tr>
	</table>

</body>
</html>
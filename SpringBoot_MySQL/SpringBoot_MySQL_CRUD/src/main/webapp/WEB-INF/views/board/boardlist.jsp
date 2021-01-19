<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
	MySQL과 SpringBoot를 연동해서 값을 가져올 때 application.properties의 작성은 아래와 같았다.
	spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
	spring.datasource.url=jdbc:mysql://localhost:3360/SpringBoot
	spring.datasource.username=KimJiHu0
	spring.datasource.password=jihu0000
	
	pom.xml에서 mysql-connector-java version이 5.1.x 이후 버전부터는 KST TimeZone을 인식하지 못하는 이슈가 있다.
	그래서 spring.datasource.url부분을 수정해주어야한다.
	
	수정후 => spring.datasource.url=jdbc:mysql://localhost:3360/SpringBoot?serverTimezone=UTC&useSSL-true 라고 수정을 해주면
	TimeZone 이슈를 해결할 수 있다.
 -->

	<h1>List</h1>

	<table>
		<col width="100">
		<col width="100">
		<col width="200">
		<tr>
			<th>NO</th>
			<th>WRITER</th>
			<th>TITLE</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th colspan="3" align="center">현재 등록된 글이 없습니다.</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="list">
					<tr>
						<td>${list.boardno }</td>
						<td>${list.boardwriter }</td>
						<td><a href="detail.do?boardno=${list.boardno }">${list.boardtitle }</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="3" align="right"><input type="button" value="글작성" onclick="location.href='insert.do'"/>
			</td>
		</tr>
	</table>

</body>
</html>
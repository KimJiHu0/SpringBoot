<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>registForm</h1>
	
	<form action="registres.do" method="post">
		<table border="1">
			<tr>
				<th>ID</th>
				<td><input type="text" name="memberid" placeholder="아이디를 입력해주세요"/></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="text" name="memberpw" placeholder="비밀번호를 입력해주세요"/></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="membername" placeholder="이름을 입력해주세요"/></td>
			</tr>
			<tr>
				<td colspan="3" align="right">
					<input type="submit" value="회원가입"/>
					<input type="button" value="취소하기" onclick="location.href='login.do'"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
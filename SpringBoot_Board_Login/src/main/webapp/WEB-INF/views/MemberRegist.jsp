<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<h1>Regist</h1>
	
	<form action="/registres" method="post">
		<table border="1">
			<tr>
				<th>ID</th>
				<td><input type="text" placeholder="아이디를 입력하세요" name="memberid"/></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="text" placeholder="비밀번호를 입력하세요" name="memberpw"/></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" placeholder="이름을 입력하세요" name="membername"/></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="회원가입"/>
					<input type="button" value="뒤로가기" onclick="location.href='/login'"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
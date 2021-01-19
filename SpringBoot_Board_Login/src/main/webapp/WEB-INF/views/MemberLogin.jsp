<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">

var msg = '${msg}';
if(msg != ''){
	alert(msg);
}


</script>
</head>
<body>

	<h1>Login</h1>
	
	<form action="/loginres" method="post">
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
			<td colspan="2" align="right">
				<input type="submit" value="로그인"/>
				<input type="button" value="회원가입" onclick="location.href='/regist'"/>
			</td>
		</tr>
	</table>
	</form>

</body>
</html>
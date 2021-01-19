<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardLoginForm.jsp</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link href="/CSS/boardLoginForm.css" rel="stylesheet">
<script type="text/javascript" src="/JS/login.js"></script>
<script type="text/javascript">

	var msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}

</script>
</head>
<body>

	<h1>LoginForm</h1>
	
	<table border="1">
	<col width="80">
		<tr>
			<th class="title">ID</th>
			<td>
				<input class="inputbox" type="text" id="memberid" placeholder="아이디를 입력하세요.">
			</td>
		</tr>
		<tr>
			<th class="title">PW</th>
			<td>
				<input class="inputbox" type="text" id="memberpw" placeholder="비밀번호를 입력하세요.">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="Sign In" onclick="loginCheck();">
				<input type="button" value="Sign Up" onclick="location.href='boardregist.do'">
			</td>
		</tr>
	</table>

</body>
</html>
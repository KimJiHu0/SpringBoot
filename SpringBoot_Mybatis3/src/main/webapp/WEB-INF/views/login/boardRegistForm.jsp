<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardRegistForm.jsp</title>
<link href="/CSS/boardRegistForm.css" rel="stylesheet">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/JS/regist.js"></script>
<script type="text/javascript">

	var msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}

</script>
</head>
<body>

	<h1>RegistForm</h1>
	
		<table border="1">
			<col width="200">
			<col width="250">
			<tr>
				<th class="title">ID</th>
				<td>
					<input type="text" class="content" onkeyup="memberid();" id="memberid" name="memberid" placeholder="아이디를 입력하세요.">
					<span id="idcheck"></span>
				</td>
			</tr>
			<tr>
				<th class="title">PASSWORD</th>
				<td>
					<input type="text" class="content" id="memberpw" onkeyup="memberpw();" placeholder="비밀번호를 입력하세요.">
					<span id="pwcheck"></span>
				</td>
			</tr>
			<tr>
				<th class="title">PASSWORD CHECK</th>
				<td>
					<input type="text" class="content" id="memberpwcheck" onkeyup="memberpwcheck();" placeholder="비밀번호를 다시 입력하세요.">
					<span id="pwrecheck"></span>
				</td>
			</tr>
			<tr>
				<th class="title">NAME</th>
				<td>
					<input type="text" class="content" onkeyup="membernamecheck();" id="membername" placeholder="이름를 입력하세요.">
				</td>
			</tr>
			<tr>
				<td colspan="4" align="right">
					<input type="button" value="Sign Up" onclick="goController();">
					<input type="button" value="Cancel" onclick="location.href='boardlogin.do'">
				</td>
			</tr>
		</table>
	<ul>
		<li><b>아이디</b>는 영문으로 시작하며, 숫자 영문조합 4~15자리로 입력하셔야 합니다.</li>
		<li><b>비밀번호</b>는 영문, 숫자 조합 10자~15자 사이로 입력하셔야 합니다.</li>
		<li><b>이름</b>은 한글만 사용 가능하며, 두글자에서 다섯글자 사이로 입력하셔야 합니다.</li>
		<li>공백은 사용하실 수 없습니다.</li>
	</ul>

</body>
</html>
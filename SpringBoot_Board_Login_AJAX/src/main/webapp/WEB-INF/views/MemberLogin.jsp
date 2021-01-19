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

function loginCheck(){
	var memberid = $("#memberid").val().trim();
	var memberpw = $("#memberpw").val().trim();
	
	var loginVal = {
			"memberid" : memberid,
			"memberpw" : memberpw
	}
	
	if(memberid == null || memberid == ''){
		alert("ID를 제대로 입력해주세요.");
	} else if(memberpw == null || memberpw == ''){
		alert("PASSWORD를 제대로 입력해주세요.");
	} else {
		$.ajax({
			url : "/loginres",
			type : "post",
			data : JSON.stringify(loginVal),
			dataType : "json",
			contentType : "application/json",
			success : function(res){
				if(res.check == true){
					alert("로그인에 성공했습니다.");
					location.href="/list";
				} else {
					alert("ID혹은 PASSWORD가 일치하지 않습니다. 다시 로그인해주세요.");
					location.href="/login";
				}
			},
			error : function(){
				alert("실패");
			}
		})
	}
}

</script>
</head>
<body>

	<h1>Login</h1>
	
	<form action="/loginres" method="post">
	<table border="1">
		<tr>
			<th>ID</th>
			<td><input type="text" placeholder="아이디를 입력하세요" name="memberid" id="memberid"/></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" placeholder="비밀번호를 입력하세요" name="memberpw" id="memberpw"/></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="로그인" onclick="loginCheck();"/>
				<input type="button" value="회원가입" onclick="location.href='/regist'"/>
			</td>
		</tr>
	</table>
	</form>

</body>
</html>
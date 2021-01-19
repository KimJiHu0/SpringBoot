<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	
<script type="text/javascript">
	function loginCheck(){
		var memberid = $("#memberid").val().trim();
		var memberpw = $("#memberpw").val().trim();
		
		var loginVal = {
			"memberid" : memberid,
			"memberpw" : memberpw
		};
		
		if(memberid == '' || memberid == null){
			alert("ID를 입력해주세요.");
		} else if(memberpw == '' || memberpw == null){
			alert("PW를 입력해주세요.");
		} else {
			$.ajax({
				type : "post",
				contentType : "application/json",
				data : JSON.stringify(loginVal),
				dataType : "json",
				url : "ajaxlogin.do",
				success : function(data){
					if(data.check == true){
						if(data.id == 'ADMIN'){
							location.href='admin.do';
						} else {
							location.href="user.do";
						}
					} else {
						alert("로그인에 실패하였습니다. 다시 진행해주세요.");
					}
				},
				error : function(){
					alert("실패");
				},
				complete : function(){
					alert("무조건 실행");
				}
			})
		}
	}
</script>
</head>
<body>

	<h1 class="goMain">LoginForm</h1>
	<button onclick="location.href='/'">메인으로</button>
	
	<table border="1">
		<tr>
			<th>ID</th>
			<td><input type="text" placeholder="아이디를 입력해주세요." id="memberid"/></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" placeholder="비밀번호를 입력해주세요." id="memberpw"/></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="로그인" onclick="loginCheck();"/>
				<input type="button" value="회원가입" onclick="location.href='regist.do'"/>
			</td>
		</tr>
	</table>

</body>
</html>
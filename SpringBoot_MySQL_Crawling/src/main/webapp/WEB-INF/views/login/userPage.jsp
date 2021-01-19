<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

.userInfo{
	border : black solid 1px;
}

</style>
</head>
<body>

	<h1>User Page</h1>
	<button onclick="location.href='/'">메인으로</button>
	
	<div class="userInfo">
		<p>사용자 아이디 : ${dto.memberid }</p>
		<p><b>${dto.membername }</b>님 환영합니다.</p>
		<p>
			<button onclick="location.href='logout.do'">LogOut</button>
		</p>
		
		<button onclick="location.href='list.do'">List</button>
		<button onclick="location.href='kakaomap.do'">현재 내 위치 보러 가기</button>
		<button onclick="location.href='crawling.do'">CGV영화 순위 보러 가기</button>
	</div>

</body>
</html>
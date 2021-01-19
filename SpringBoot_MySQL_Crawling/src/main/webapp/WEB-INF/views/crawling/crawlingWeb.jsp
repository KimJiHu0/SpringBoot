<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

	img{
		width : 150px;
		height : 200px;
	}

</style>

<!-- ajax를 사용하기 위해서 jQuery library를 추가해줍니다. -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">

	// 이 페이지가 화면에 보여지자마자 ajax를 실행하기 위해서 선언했습니다.
	$(function(){
		$.ajax({
			type : "post",
			dataType : "json",
			contentType : "application/json",
			url : "webcrawling.do",
			success : function(data){
				// data의 길이는 43입니다. [2020.12.25 현재기준] => 이는 영화가 바뀔때마다 크기가 달라집니다.
				for(var i = 0; i < data.length; i++){
					// table이라는 id를 가진 table태그에
					$("#table").append(
							// th태그들을 append해주고,
							"<col width='50px'>"+
				        	"<col width='100px'>"+
				        	"<col width='150px'>"+
				        	"<col width='50px'>"+
								"<tr>" +
								"<th>영화 순위</th>" +
								"<th>영화 제목</th>" +
								"<th>영화 포스터</th>" +
								"<th>영화 예매율</th>"
					);
					$("#table").append(
							// data의 i번지에서 movieTitle, movieImgSrc, moviePercent를 꺼내서 td태그에 넣어줍니다.
							// src같은 경우에는 td태그에 넣게되면 그대로 text로 출력되기 때문에 img태그를 만들어서 담아줍니다.
						"<tr>" +
						"<td>" + (i + 1) + "</td>" +
						"<td>" + data[i].movieTitle + "</td>" +
						"<td><img alt = '영화 포스터' src = '"+ data[i].movieImgSrc + "'/></td>" +
						"<td>" + data[i].moviePercent + "</td>"
					);
				}
			},
			error : function(){
				alert("실패");
			}
		})
	});

</script>
</head>
<body>

	<h1>Crawling Web</h1>
	
	<h2>영화 예매율 순위</h2>
	<table id ="table" border="1">
	</table>

</body>
</html>
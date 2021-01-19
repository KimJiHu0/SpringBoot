<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script type="text/javascript">

	$(function(){
		$(".summernote").summernote({
			height : 300,
			minHeight : null,
			maxHeight : null,
			lang : 'ko-KR'
		})
	})

</script>
<style type="text/css">

	textarea{
		resize : none;
	}

</style>
</head>
<body>

	<h1>Insert</h1>
	
	<form action="insertres.do" method="post">
		<table border="1">
		<tr>
			<th>Writer</th>
			<td><input type="text" value="${dto.membername }" readonly="readonly" name="boardwriter"/></td>
		</tr>
		<tr>
			<th>Title</th>
			<td><input type="text" placeholder="제목을 입력해주세요." name="boardtitle"/></td>
		</tr>
		<tr>
			<th>Content</th>
			<td>
				<textarea rows="10" cols="60" placeholder="내용을 입력해주세요." name="boardcontent" class="summernote"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="right">
				<input type="button" value="취소" onclick="location.href='list.do'">
				<input type="submit" value="작성완료">
			</td>
		</tr>
	</table>
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetail.jsp</title>
<link href="/CSS/boardDetail.css" rel="stylesheet">
<link href="/CSS/replyCss.css" rel="stylesheet">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/JS/replyJs.js"></script>
<script type="text/javascript">
	
	// 삭제 버튼을 클릭했을 떄 replyno를 받아서 replydelete.do라는 요청과
	// 파라미터로 replyno를 보내줍니다.
	function replydelete(replyno, boardno){
		location.href="replydelete.do?replyno="+replyno + "&boardno="+boardno;
	}

</script>
</head>
<body>

	<h1>boardDetail</h1>

	<table border="1">
		<col width="100">
		<tr>
			<th class="title">No</th>
			<td>${dto.boardno }</td>
		</tr>
		<tr>
			<th class="title">Name</th>
			<td>${dto.boardname }</td>
		</tr>
		<tr>
			<th class="title">Title</th>
			<td>${dto.boardtitle }</td>
		</tr>
		<tr>
			<th class="title">Content</th>
			<td><textarea class="boardcontent" rows="15" cols="120"
					readonly="readonly">${dto.boardcontent }</textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<button onclick="location.href='boardupdate.do?boardno=${dto.boardno}'">수정</button>
				<button onclick="location.href='boarddelete.do?boardno=${dto.boardno}'">삭제</button>
				<button onclick="location.href='boardlist.do'">뒤로</button>
			</td>
		</tr>
		<c:choose>
			<c:when test="${empty replylist }">
				<tr>
					<td colspan="2" align="center" class="title">등록된 댓글이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${replylist }" var="replylist">
					<tr class="${replylist.replyno }">
						<th class="title">댓글</th>
						<td class="updatereply">
							<div class="replyall">
								<div class="writer">
									<b>작성자 :</b> ${replylist.replywriter }
								</div>
								<div class="content">
									<b>내용 :</b> ${replylist.replycontent }
								</div>
								<div class="date">
									<b>작성 날짜 :</b> ${replylist.replydate }
								</div>
								<div class="replybtn">
									<input type="button" value="수정" onclick="replyupdate('${replylist.replywriter }', '${replylist.replycontent }', ${replylist.replyno}, ${dto.boardno });">
									<input type="button" value="삭제" onclick="replydelete(${replylist.replyno}, ${dto.boardno });">
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<!-- 댓글 추가버튼 -->
		<tr>
			<td colspan="2" align="center">
				<button id="replyadd">댓글 추가</button>
			</td>
		</tr>
	</table>
	<!-- 댓글 추가하는 창 -->
	<form action="replyinsert.do" method="post" class="reply">
	<input type="hidden" name="boardno" value="${dto.boardno }">
		<table border="1">
		<col width="100">
			<tr>
				<th class="title">Writer</th>
				<td>
					<input type="text" name="replywriter" class="replycontent" placeholder="작성자를 입력해주세요.">
				</td>
			</tr>
			<tr>
				<th class="title">Content</th>
				<td>
					<textarea cols="120" name="replycontent" class="replycontent" placeholder="댓글은 최대 50자까지 가능합니다."></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="추가">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
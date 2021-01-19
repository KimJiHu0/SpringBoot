$(function () {

	// 페이지가 켜지자마자 reply이라는 class이름을 가진 태그는 숨겨집니다.
	$(".reply").hide();

	// id가 replyadd인 태그를 click이라는 변수에 담고,
	var click = document.getElementById("replyadd");

	// 그 변수가 클릭 이벤트가 발생하
	click.onclick = function () {
		// class이름 reply인 태그를 보여줍니다.
		$(".reply").show();
	}



})
// 삭제 버튼을 클릭했을 떄 replyno를 받아서 replydelete.do라는 요청과
// 파라미터로 replyno를 보내줍니다.
function replydelete(replyno, boardno) {
	location.href = "replydelete.do?replyno=" + replyno + "&boardno=" + boardno;
}

// 수정 버튼을 클릭했을 때 replyno를 받아서
// html을 변경해주어야합니다.
function replyupdate(replywriter, replycontent, replyno, boardno) {
	// date와 replybtn 숨겨줍니다.
	$(".date").hide();
	$(".replybtn").hide();
	
	// 작성자 부분 html 바꿔주기
	$(".writer").html("<b>작성자 : </b> <input type='text' class='replycontent' placeholder='" + replywriter + "' id='updatewriter'>");
	// 내용 부분 html 바꿔주
	$(".content").html("<b>내용 : </b> <textarea cols='120' id='updatecontent' class='replycontent' placeholder='" + replycontent + "'></textarea>");

	// 수정 완료 버튼과 수정 취소 버튼을 만들어줍니다.
	// 각각 클릭했을 때 이벤트가 발생할 수 있도록  함수를 지정해주고 파라미터로 값을 넘겨줍니다.
	$(".replyall").append("<button onclick='replyUpdate(" + replyno + "," + boardno + ")'>수정완료</button>");
	$(".replyall").append("<button onclick='boardDetail(" + boardno + ")'>수정취소</button>");
}

// 수정 취소버튼을 누르면 boardDetail로 가기 위한 함수가 실행됩니다.
// 넘겨받은 값 boardno를 통해서 다시 detail을 보여줍니다.
function boardDetail(boardno){
	location.href="boarddetail.do?boardno="+boardno;
}

function replyUpdate(replyno, boardno){
	// 작성자의 value를 가져와서 담아줍니다.
	var replywriter = $("#updatewriter").val().trim();
	// 내용의 text를 가져와 담아줍니다.
	var replycontent = $("#updatecontent").val();
	
	location.href="replyupdate.do?replyno="+replyno+"&replywriter="+replywriter+"&replycontent="+replycontent + "&boardno=" + boardno;
}
// SummerNote를 사용하기 위한 스크립트
// 수정하지 못하게 막았습니다.
$(document).ready(function(){
	// summernote의 세로 길이를 300으로 지정 후
	$("#summernote").summernote({
		height: 300,
	});
	// 수정하지 못하게 막았습니다.
	$("#summernote").summernote('disable');

	// 처음에 들어오자마자 reply라는 class이름을 가진 태그는 보이지 않습니다.
	$(".reply").hide();

	// click라는 변수에 replyadd라는 id를 가진태그를 담아두고,
	var click = document.getElementById("replyadd");

	// 이를 클릭했을 때에는 함수가 실행됩니다.
	click.onclick = function(){
		// 숨겨져 있던 class이름이 reply인 애를 보여줍니다.
		$(".reply").show();
	}
});

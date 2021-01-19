$(function(){
	// 페이지가 켜지자마자 ID입력칸에 포커스를 줍니다.
	$("#memberid").focus();
});


// 입력한 id,pw,name이 사용 가능한 것들인지 체크하여 버튼을 활성화/비활성화 해줄지 정해주는 변수
var checkarray = [false, false, false, false];

// 아이디 체크 함수
function memberid(){
	// memberid라는 id값을 가진 태그의 value값을 가져와 memberidcheck라는 변수에 담아줍니다.
	var memberidcheck = $("#memberid").val().trim();

	// 아이디 체크 정규식 5부터 15자
	// a-z로 시작하고, 소문자 영문, 숫자조합 5~15
	var idcheck = /^[a-z]+[a-z0-9]{4,15}$/;
	
	// 만일 정규식 표현에 일치하지 않는다면, 
	if(!idcheck.test(memberidcheck)){
		// 그리고 memberidcheck의 길이가 0 이상이라면. 즉, 한 글자라도 입력했다면( 대신 정규식 표현에도 일치하지 않는다면 )
		if(memberidcheck.length > 0){
			// id가 idcheck라는 값을 가진 span 태그의 text를 바꿔주고, css인 글씨 색 color을 red로 바꿔줍니다.
			$("#idcheck").text("사용불가능한 아이디입니다.");
			$("#idcheck").css("color", "red");
			// 배열의 첫번째를 fasle로 만들어주고
			checkarray[0] = false;
		// 길이가 0 이상이 아니라면. 즉, 한 글자도 입력하지 않았다면 span태그의 text를 아무것도 없게 만들어줍니다.
		} else {
			$("#idcheck").text("");
		}
	// 정규식 표현에 일치한다
	} else {
		// JSON형태로 보내주기 위해서 memberid라는 id값을 가진 태그의 value값을 가져와 객체리터럴로 선언을 해줍니다.
		var memberid = {
			"memberid": memberidcheck
		}
		// 그 후 ajax를 실행합니다.
		$.ajax({
			// 어떤 요청값을 보낼지 url을 설정하고,
			url: "memberidcheck.do",
			// 보내는 데이터를 JSON형태의 String값으로 변형하고,
			data: JSON.stringify(memberid),
			// 보내는 타입은 post,
			type: "post",
			// 받는 데이터 타입은 json,
			dataType: "json",
			// json형태로 받아줍니다.
			contentType: "application/json",
			// AJAX통신에 성공했다면 해당 url에서 넘어온 데이터는 data라는 변수로 받아줍니다.
			success: function(data){
				// 만일 받아온 값 data중에 check의 이름을 가진 값이 true라
				if(data.check == true){
					// 사용이 가능한 아이디이기 때문에 text와 글씨 색을 변경해주
					$("#idcheck").text("사용가능한 아이디입니다.");
					$("#idcheck").css("color", "blue");
					// 사용 가능하기 때문에 배열의 첫번째 값을 true로 바꿔줍니다.
					checkarray[0] = true;
				// 그렇지 않고 check라는 값이 false라면
				} else {
					// 이미 존재하는 아이디이기 때문에 text와 css를 변경해주고,
					$("#idcheck").text("이미 존재하는 아이디입니다.");
					$("#idcheck").css("color", "red");
					// 배열의 첫번째 값을 false로 변경합니다.
					checkarray[0] = false;
				}
			},
			error: function(){
				alert("실패");
			}
		})
	}
}

// 비밀번호 체크 함수
function memberpw(){

	// idcheck라는 변수에 id가 idcheck인 태그의 text를 담아줍니다.
	var idcheck = $("#idcheck").text();

	// 만일 idcheck가 사용가능한 아이디입니다. 가 아닐 경우에는 사용 불가능한 id를 사용하려고 하기 떄문에
	if(idcheck != '사용가능한 아이디입니다.'){
		// alert를 띄어주고,
		alert("아이디를 다시 확인해주세요.");
		// id입력하는 태그로 다시 포커스를 잡아줍니다.
		$("#memberid").focus();
		$("#memberpw").val("");
	// 그렇지 않고, 사용 가능한 아이디를 작성했다면
	} else {
		// memberpwcheck라는 변수에 memberpw라는 id를 가진 태그의 value값을 담아주고,
		var memberpwcheck = $("#memberpw").val().trim();
		// pwcheck이라는 변수에 비밀번호 정규식 표현을 작성해 줍니다.
		// 이 의미는 소문자 영문과 숫자 조합으로 10~15자리를 작성해야 한다는 의미입니다.
		var pwcheck = /^[a-z0-9]{10,15}$/;

		// 이게 일치하지 않는 경우에는
		if(!pwcheck.test(memberpwcheck)){
			// 그리고 한글자 이상 작성했을 경우에는
			if(memberpwcheck.length > 0){
				// pwcheck라는 id를 가진 span태그의 text와 css를 변경해주고,
				$("#pwcheck").text("사용불가능한 비밀번호입니다.");
				$("#pwcheck").css("color", "red");
				// 사용 불가능한 비밀번호이기 때문에 checkarray의 두번째 값을 false로 변경합니다.
				checkarray[1] = false;
			// 한글자도 작성하지 않았다면,
			} else {
				// span태그의 text를 지워줍니다.
				$("#pwcheck").text("");
			}
		// 만일 정규식 표현에 일치한다면
		} else {
			// 정규식 표현이 일치하면 바로 비밀번호 밑에 사용 가능한 비밀번호
			// 문구를 추가해줍니다.
			$("#pwcheck").text("사용가능한 비밀번호입니다.");
			$("#pwcheck").css("color", "blue");
			checkarray[1] = true;

			// 비밀번호 확인란과 비밀번호 칸의 value를 가져옵니다.
			var memberpwcheck = $("#memberpwcheck").val();
			var memberpw = $("#memberpw").val();

			// 만일 비밀번호 확인란과 비밀번호 입력칸이 같지 않고
			// 비밀번호 확인란이 비어있지 않다면
			if(memberpwcheck != memberpw && memberpwcheck != ''){
				// 비밀번호 확인란의 text를 비밀번호가 일치하지 않다고 변경해줍니다.
				$("#pwrecheck").text("비밀번호가 일치하지 않습니다.");
				$("#pwrecheck").css("color", "red");
				checkarray[1] = false;
			// 그렇지 않고 두 입력값이 같고, 비밀번호 확인란의 text가 비어있지 않다면
			} else if(memberpwcheck == memberpw && memberpwcheck != '') {
				// 비밀번호 확인란과 비밀번호 입력칸의 text를 변경해줍니다.
				$("#pwcheck").text("사용가능한 비밀번호입니다.");
				$("#pwcheck").css("color", "blue");

				$("#pwrecheck").text("비밀번호가 일치합니다.");
				$("#pwrecheck").css("color", "blue");
				// 그리고 checkarray의 두번째 값을 true로 변경합니다.
				checkarray[1] = true;

			}
			// 결정적으로 비밀번호는 다른 회원들과 겹쳐도 되기 때문에 DB에서 유효성을 해주지 않았습니다.
		}
	}
}


// 비밀번호 확인.
function memberpwcheck(){
	// pwcheck라는 변수에 id가 pwcheck라는 태그의 text를 가져와서 담아줍니다.
	var pwcheck = $("#pwcheck").text();

	// 사용가능한 비밀번호입니다. 라는 문구가 아닐 경우에는
	if(pwcheck != '사용가능한 비밀번호입니다.'){
		// 다시 비밀번호를 입력하게 포커스해줍니다.
		alert("비밀번호를 다시 확인해주세요.");
		$("#memberpw").focus();
		$("#memberpwcheck").val("");
	// 그렇지 않다면
	} else {
		// memberpw라는 변수에 memberpw의 valeu를 담아주고,
		var memberpw = $("#memberpw").val().trim();
		// memberpwcheck라는 변수에 id가 memberpwcheck라는 태그의 value를 담아줍니다.
		var memberpwcheck = $("#memberpwcheck").val().trim();
		// 만일 memberpwcheck의 길이가 0이상이면 ( 한글자 이상 쳤으면 )
		if(memberpwcheck.length > 0){
			// 그리고 memberpw랑 memberpwcheck랑 같지 않다면
			if(memberpw != memberpwcheck){
				// 비밀번호가 일치하지 않기 때문에 아래처럼 변경해주고,
				$("#pwrecheck").text("비밀번호가 일치하지 않습니다.");
				$("#pwrecheck").css("color", "red");
				// checkarray의 세 번째 값을 false로 변경합니다.
				checkarray[2] = false;
			// memberpw와 memberpwcheck의 값이 같다면
			} else {
				// 비밀번호가 같기 때문에 아래와 같이 변경합니다.
				$("#pwrecheck").text("비밀번호가 일치합니다.");
				$("#pwrecheck").css("color", "blue");
				// 그리고 checkarray의 세 번째 값을 true로 변경해줍니다.
				checkarray[2] = true;
			}
		// 아무런 글씨도 작성하지 않으면 문구를 지워줍니다.
		} else {
			$("#pwrecheck").text("");
		}

	}
}

// 이름의 경우 중복체크 할 필요는 없지만, 입력하고 나서 지워버리면
// 회원가입 버튼이 활성화 되기 때문에 이를 방지하고자 onkeyup으로 설정
function membernamecheck(){

	// 비밀번호 확인란에 text를 가져옵니다.
	var pwrecheck = $("#pwrecheck").text();

	// 만일 비밀번호가 일치합니다. 라는 문구가 아니라면
	if(pwrecheck != '비밀번호가 일치합니다.'){
		// 다시 비밀번화 확인란에 포커스를 해줍니다.
		alert("비밀번호 확인을 다시 해주세요.");
		$("#memberpwcheck").focus();
		$("#membername").val("");
	// 비밀번호가 일치하다면
	} else {
		// 이름을 입력하는 태그의 value를 담아줍니다.
		var membernamecheck = $("#membername").val().trim();

		// 이는 한글만 입력가능하고, 2~5글자만 입력이 가능하다는 정규식입니다.
		var namecheck = /^[가-힣]{2,5}$/;

		// 정규식 표현이 맞지 않는다면
		if(!namecheck.test(membernamecheck)){
			// checkarray의 마지막은 false로 변경하고
			checkarray[3] = false;
		// 일치한다면
		} else {
			// checkarray의 마지막을 true로 변경합니다.
			checkarray[3] = true;
		}
	}
}


// 이제 회원가입 버튼을 눌렀을 때 다시한번 checkarray를 확인하여
// 하나라도 false가 있다면 취소해줍니다.
function goController(){

	check();

	var cnt = 0;
	for(var i = 0; i < checkarray.length; i++){
		if(checkarray[i] == true){
			cnt++;
		}
	}
	
	if(cnt != 4){
		alert("회원 정보를 다시 확인하고 작성해주세요.");
	} else {
		var memberid = $("#memberid").val().trim();
		var memberpw = $("#memberpw").val().trim();
		var membername = $("#membername").val().trim();
	
		location.href="boardregistres.do?memberid="+memberid+"&memberpw="+memberpw+"&membername="+membername;
	}
}

var check = function(){
	// 전부 다 input태그의 value들 가져오고,
	// 만일 아이디가 입력 안되어있거나, 사용불가능한 아이디입니다.문국 ㅏ나왔을 떄에는 아이디 입력으로 포커스 return false
	// else if(만일 비밀번호가 입력되어있거나@!#@!#$@)

}
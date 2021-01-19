function loginCheck(){
	// id가 memberid, memberpw인 태그의 value값을 각각의 변수에 담아줍니다.
	var memberid = $("#memberid").val().trim();
	var memberpw = $("#memberpw").val().trim();

	// 객체리터럴 변수인 loginVal이라는 변수에 담아줍니다.
	// 이는 JSON형태로 보내주기 위해 작성했습니다.
	var loginVal = {
		"memberid": memberid,
		"memberpw": memberpw
	}

	// 만일 memberid가 null이거나 비어있다면
	if(memberid == null || memberid == ''){
		// 아래의 alert을 띄어주고,
		alert("ID를 입력해주세요.");
	// 그렇지 않고 비밀번호가 비어있다
	} else if(memberpw == null || memberpw == ''){
		// 아래의 alert을 띄어줍니다.
		alert("PW를 입력해주세요.");
	// 둘 다 아니라면 제대로 작성이 됐다는 것이기 때문에
	} else {
		// ajax를 실행해줍니다.
		$.ajax({
			// post타입,
			type: "post",
			// 보내주는 형
			contentType: "application/json",
			// 보내는 데이터를 loginVal이라는 변수를
			// JSON형태의 String값으로 보내줍니다.
			data: JSON.stringify(loginVal),
			// 받는 타입은 json타입,
			dataType: "json",
			// 보내는 요청값은 아래와 같습니다.
			url: "boardlogincheck.do",
			// ajax통신에 성공한다
			success: function(data){
				// 만일 data의 check이 true라면 로그인이 잘 되어있는 것이
				if(data.check == true){
					// 아래의 alert을 띄어준 후
					alert(data.id + "님 환영합니다.");
					// 만일 id가 admin이면
					if(data.id == 'admin'){
						// adminpage로 이동하기 위한 요청값을 요청
						location.href="boardadminpage.do";
					// 그렇지 않다면 User이기 때문에
					} else {
						// UserPage로 이동하기 위한 요청값 요청
						location.href="boarduserpage.do";
					}
				// data.check가 false라면 아래의 alert을 띄어줍니다.
				} else {
					alert("로그인에 실패했습니다. 다시 진행해주세요.");
					location.href="boardlogin.do";
				}
			},
			error: function(){
				alert("실패");
			}
		})
	}
}
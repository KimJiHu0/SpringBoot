package com.spring.boot.board.biz;

import com.spring.boot.board.dto.MemberDto;

public interface MemberBiz {
	
	// 회원가입
	public int regist(MemberDto memberdto);
	
	// 로그인
	public MemberDto login(MemberDto memberdto);

}

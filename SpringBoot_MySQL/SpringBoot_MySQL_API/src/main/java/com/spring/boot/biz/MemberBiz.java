package com.spring.boot.biz;

import com.spring.boot.dto.MemberDto;

public interface MemberBiz {
	
	public MemberDto loginUser(MemberDto dto);
	
	public int registUser(MemberDto dto);

}

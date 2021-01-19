package com.spring.boot.biz;

import java.util.List;

import com.spring.boot.dto.MemberDto;

public interface MemberBiz {
	
	public MemberDto loginMember(MemberDto dto);
	
	public int selectMemberAll(String memberid);
	
	public int registMember(MemberDto dto);

}

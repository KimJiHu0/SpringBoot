
package com.spring.boot.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dto.MemberDto;
import com.spring.boot.mapper.MemberMapper;

@Service
public class MemberBizImpl implements MemberBiz {

	@Autowired
	private MemberMapper membermapper;
	
	@Override
	public MemberDto loginMember(MemberDto dto) {
		return membermapper.loginMember(dto);
	}

	@Override
	public int selectMemberAll(String memberid) {
		return membermapper.selectMemberAll(memberid);
	}

	@Override
	public int registMember(MemberDto dto) {
		return membermapper.registMember(dto);
	}

}

package com.spring.boot.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dto.MemberDto;
import com.spring.boot.mapper.MemberMappper;

@Service
public class MemberBizImpl implements MemberBiz {

	@Autowired
	private MemberMappper membermapper;
	
	@Override
	public MemberDto loginUser(MemberDto dto) {
		return membermapper.loginUser(dto);
	}

	@Override
	public int registUser(MemberDto dto) {
		return membermapper.registUser(dto);
	}

}

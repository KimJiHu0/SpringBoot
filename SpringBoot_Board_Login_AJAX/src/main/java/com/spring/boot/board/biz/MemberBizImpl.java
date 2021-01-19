package com.spring.boot.board.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.board.dto.MemberDto;
import com.spring.boot.board.mapper.MemberMapper;

@Service
public class MemberBizImpl implements MemberBiz {

	@Autowired
	private MemberMapper membermapper;
	
	@Override
	public int regist(MemberDto memberdto) {
		return membermapper.regist(memberdto);
	}

	@Override
	public MemberDto login(MemberDto memberdto) {
		return membermapper.login(memberdto);
	}

}

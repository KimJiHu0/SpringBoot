package com.spring.boot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.boot.dto.MemberDto;

@Mapper
public interface MemberMappper {
	
	@Select(" SELECT MEMBERID, MEMBERPW, MEMBERNAME, MEMBERREGDATE FROM MEMBER WHERE MEMBERID = #{memberid} AND MEMBERPW = #{memberpw} ")
	public MemberDto loginUser(MemberDto dto);
	
	@Insert(" INSERT INTO MEMBER VALUES(#{memberid}, #{memberpw}, #{membername}, NOW()) ")
	public int registUser(MemberDto dto);

}

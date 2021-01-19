package com.spring.boot.board.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.boot.board.dto.MemberDto;

@Mapper
public interface MemberMapper {
	
	@Insert(" INSERT INTO MEMBER VALUES( #{memberid}, #{memberpw}, #{membername}, SYSDATE ) ")
	int regist(MemberDto memberdto);
	
	@Select(" SELECT MEMBERID, MEMBERPW, MEMBERNAME, MEMBERREGISTDATE FROM MEMBER WHERE MEMBERID = #{memberid} AND MEMBERPW = #{memberpw} ")
	MemberDto login(MemberDto memberdto);

}

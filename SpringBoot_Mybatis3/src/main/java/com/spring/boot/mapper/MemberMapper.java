package com.spring.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.boot.dto.MemberDto;

@Mapper
public interface MemberMapper {

	@Select(" SELECT MEMBERIDX, MEMBERID, MEMBERPW, MEMBERNAME, MEMBERREGDATE FROM BOARDMEMBER WHERE MEMBERID = #{memberid} AND MEMBERPW = #{memberpw} ")
	public MemberDto loginMember(MemberDto dto);
	
	@Select(" SELECT COUNT(*) FROM BOARDMEMBER WHERE MEMBERID = #{memberid} ")
	public int selectMemberAll(String memberid);
	
	@Insert(" INSERT INTO BOARDMEMBER(MEMBERID, MEMBERPW, MEMBERNAME, MEMBERREGDATE) VALUES(#{memberid}, #{memberpw}, #{membername}, NOW()) ")
	public int registMember(MemberDto dto);
}

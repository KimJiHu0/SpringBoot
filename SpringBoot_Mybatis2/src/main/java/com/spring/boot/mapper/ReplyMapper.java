package com.spring.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.boot.dto.ReplyDto;

@Mapper
public interface ReplyMapper {

	@Select(" SELECT R.REPLYNO, R.REPLYWRITER, R.REPLYCONTENT, R.REPLYDATE, R.BOARDNO FROM BOARDREPLY R JOIN BOARDLIST L ON R.BOARDNO = L.BOARDNO WHERE R.BOARDNO = #{boardno} ")
	public List<ReplyDto> replyList(int boardno);
	
	@Insert(" INSERT INTO BOARDREPLY(REPLYWRITER, REPLYCONTENT, REPLYDATE, BOARDNO) VALUES(#{replywriter}, #{replycontent}, now(), #{boardno}) ")
	public int replyInsert(ReplyDto dto);
	
	@Delete(" DELETE FROM BOARDREPLY WHERE REPLYNO = #{replyno} ")
	public int replyDelete(int replyno);
	
	@Update(" UPDATE BOARDREPLY SET REPLYWRITER = #{replywriter}, REPLYCONTENT = #{replycontent}, REPLYDATE = NOW() WHERE REPLYNO = #{replyno} ")
	public int replyUpdate(ReplyDto dto);
}
 
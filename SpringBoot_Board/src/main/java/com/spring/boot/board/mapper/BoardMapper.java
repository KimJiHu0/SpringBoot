package com.spring.boot.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.boot.board.dto.BoardDto;

@Mapper
public interface BoardMapper {

	@Select(" SELECT BOARDNO, BOARDTITLE, BOARDCONTENT, BOARDWRITER, BOARDREGDATE FROM BOARD ORDER BY BOARDNO DESC ")
	List<BoardDto> selectList();
	
	@Insert(" INSERT INTO BOARD VALUES( BOARD_SEQ.NEXTVAL, #{boardtitle}, #{boardcontent}, #{boardwriter}, SYSDATE ) ")
	int insertList(BoardDto boarddto);
	
	@Select(" SELECT BOARDNO, BOARDTITLE, BOARDCONTENT, BOARDWRITER, BOARDREGDATE FROM BOARD WHERE BOARDNO = #{boardno} ")
	BoardDto selectOne(int boardno);
	
	@Update(" UPDATE BOARD SET BOARDTITLE = #{boardtitle}, BOARDCONTENT = #{boardcontent} WHERE BOARDNO = #{boardno} ")
	int update(BoardDto boarddto);
	
	@Delete(" DELETE FROM BOARD WHERE BOARDNO = #{boardno} ")
	int delete(int boardno);
	
}

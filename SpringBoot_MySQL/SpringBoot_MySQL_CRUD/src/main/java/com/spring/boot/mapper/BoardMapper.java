package com.spring.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.boot.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	@Select(" SELECT BOARDNO, BOARDWRITER, BOARDTITLE, BOARDCONTENT FROM BOARD ")
	public List<BoardDto> selectList();
	
	@Insert(" INSERT INTO BOARD(BOARDWRITER, BOARDTITLE, BOARDCONTENT) VALUES(#{boardwriter}, #{boardtitle}, #{boardcontent}) ")
	public int insertList(BoardDto dto);
	
	@Select(" SELECT BOARDNO, BOARDWRITER, BOARDTITLE, BOARDCONTENT FROM BOARD WHERE BOARDNO = #{boaradno} ")
	public BoardDto selectOne(int boardno);
	
	@Update(" UPDATE BOARD SET BOARDTITLE = #{boardtitle}, BOARDCONTENT = #{boardcontent} WHERE BOARDNO = #{boardno} ")
	public int UpdateList(BoardDto dto);
	
	@Delete(" DELETE FROM BOARD WHERE BOARDNO = #{boardno} ")
	public int deleteList(int boardno);

}

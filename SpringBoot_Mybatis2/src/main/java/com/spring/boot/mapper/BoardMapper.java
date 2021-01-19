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
	
	// 글 목록 출력하는 Mapper
	@Select(" SELECT BOARDNO, BOARDNAME, BOARDTITLE, BOARDCONTENT FROM BOARDLIST ")
	public List<BoardDto> boardList();
	
	// 글 상세보기 출력하는 Mapper
	@Select(" SELECT BOARDNO, BOARDNAME, BOARDTITLE, BOARDCONTENT FROM BOARDLIST WHERE BOARDNO = #{boardno} ")
	public BoardDto boardDetail(int boardno);
	
	
	// 글 작성을 처리하는 Mapper
	@Insert(" INSERT INTO BOARDLIST(BOARDNAME, BOARDTITLE, BOARDCONTENT) VALUES(#{boardname}, #{boardtitle}, #{boardcontent}) ")
	public int boardInsert(BoardDto dto);
	
	// 수정처리하는 Mapper
	@Update(" UPDATE BOARDLIST SET BOARDNAME = #{boardname}, BOARDTITLE = #{boardtitle}, BOARDCONTENT = #{boardcontent} WHERE BOARDNO = #{boardno} ")
	public int boardUpdate(BoardDto dto);
	
	// 삭제처리하는 Mapper
	@Delete(" DELETE FROM BOARDLIST WHERE BOARDNO = #{boardno} ")
	public int boardDelete(int boardno);
}

package com.spring.boot.board.biz;

import java.util.List;


import com.spring.boot.board.dto.BoardDto;

public interface BoardBiz {
	
	public List<BoardDto> selectList();
	
	public int insertList(BoardDto boarddto);
	
	public BoardDto selectOne(int boardno);
	
	int update(BoardDto boarddto);
	
	int delete(int boardno);

}

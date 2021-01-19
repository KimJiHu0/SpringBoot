package com.spring.boot.biz;

import java.util.List;

import com.spring.boot.dto.BoardDto;

public interface BoardBiz {
	
	public List<BoardDto> boardList();
	
	public BoardDto boardDetail(int boardno);

	public int boardInsert(BoardDto dto);
	
	public int boardUpdate(BoardDto dto);
	
	public int boardDelete(int boardno);
}

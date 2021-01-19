package com.spring.boot.biz;

import java.util.List;

import com.spring.boot.dto.BoardDto;

public interface BoardBiz {
	
	public List<BoardDto> selectList();
	
	public int insertList(BoardDto dto);
	
	public BoardDto selectOne(int boardno);
	
	public int UpdateList(BoardDto dto);
	
	public int deleteList(int boardno);

}

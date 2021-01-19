package com.spring.boot.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dto.BoardDto;
import com.spring.boot.mapper.BoardMapper;

@Service
public class BoardBizImpl implements BoardBiz {

	@Autowired
	private BoardMapper boardmapper;
	
	@Override
	public List<BoardDto> boardList() {
		return boardmapper.boardList();
	}

	@Override
	public BoardDto boardDetail(int boardno) {
		return boardmapper.boardDetail(boardno);
	}

	@Override
	public int boardInsert(BoardDto dto) {
		return boardmapper.boardInsert(dto);
	}

	@Override
	public int boardUpdate(BoardDto dto) {
		return boardmapper.boardUpdate(dto);
	}

	@Override
	public int boardDelete(int boardno) {
		return boardmapper.boardDelete(boardno);
	}

}

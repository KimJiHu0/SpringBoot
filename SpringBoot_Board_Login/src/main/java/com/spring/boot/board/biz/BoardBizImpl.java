package com.spring.boot.board.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.board.dto.BoardDto;
import com.spring.boot.board.mapper.BoardMapper;

@Service
public class BoardBizImpl implements BoardBiz {
	
	@Autowired
	private BoardMapper boardmapper;

	@Override
	public List<BoardDto> selectList() {
		return boardmapper.selectList();
	}

	@Override
	public int insertList(BoardDto boarddto) {
		return boardmapper.insertList(boarddto);
	}

	@Override
	public BoardDto selectOne(int boardno) {
		return boardmapper.selectOne(boardno);
	}

	@Override
	public int update(BoardDto boarddto) {
		return boardmapper.update(boarddto);
	}

	@Override
	public int delete(int boardno) {
		return boardmapper.delete(boardno);
	}

}

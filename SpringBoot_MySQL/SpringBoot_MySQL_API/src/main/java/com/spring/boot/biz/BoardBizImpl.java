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
	public List<BoardDto> selectList() {
		return boardmapper.selectList();
	}

	@Override
	public int insertList(BoardDto dto) {
		return boardmapper.insertList(dto);
	}

	@Override
	public BoardDto selectOne(int boardno) {
		return boardmapper.selectOne(boardno);
	}

	@Override
	public int UpdateList(BoardDto dto) {
		return boardmapper.UpdateList(dto);
	}

	@Override
	public int deleteList(int boardno) {
		return boardmapper.deleteList(boardno);
	}

}

package com.spring.boot.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.boot.dto.BoardReplyDto;

public interface BoardReplyDao extends JpaRepository<BoardReplyDto, Integer> {

	// 모든 댓글 다 가져오기.
	public List<BoardReplyDto> findAll();
	 
}

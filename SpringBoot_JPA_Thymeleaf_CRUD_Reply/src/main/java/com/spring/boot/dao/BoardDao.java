package com.spring.boot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.dto.BoardListDto;

public interface BoardDao extends JpaRepository<BoardListDto, Integer> {

	// hibernate가 알아서 JAVA객체와 SQL문을 Mapping해줍니다.
	// JpaRepository에 있는 메소드들이 있어서 재정의하지 않아도 됩니다.
	// return까지 다 해줘서 굳이 JPADao를 상속받는 class를 만들 필요가 없습니다.

	// 전체 출력하는 (selectList) 메소드
	public List<BoardListDto> findAll();

	// 글작성하는 (insert) 메소드이면서, 
	// 하나의 글을 수정하기 위한 메소드
	// 수정한 값과, boardno를 통해서 해당하는 글을 수정합니다.
	public BoardListDto save(BoardListDto dto);
	// public JPADto saveAndFlush(JPADto dto); => save하고 적용하는 느낌?

	// 하나의 글을 상세보기 하기위한 메소드
	// boardno를 통해서 하나를 찾겠다는 메소드입니다.
	public BoardListDto findByBoardno(int boardno);
	
	// 삭제를 할 수 있는 메소드입니다.
	@Transactional
	public void deleteByBoardno(int boardno);
}

package com.spring.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.dto.JPADto;

public interface JPADao extends JpaRepository<JPADto, Integer> {

	// hibernate가 알아서 JAVA객체와 SQL문을 Mapping해줍니다.
	// JpaRepository에 있는 메소드들이 있어서 재정의하지 않아도 됩니다.
	// return까지 다 해줘서 굳이 JPADao를 상속받는 class를 만들 필요가 없습니다.

	public List<JPADto> findAll();

}

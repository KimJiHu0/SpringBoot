package com.spring.boot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


// BOARDLIST라는 테이블이라는 것을 의미합니다.
@Table(name="BOARDLIST")
@Entity

// Table : 만들어준 객체를 BOARDLIST라는 것을 의미합니다.
// Entity : Table가 될 객체야. 라는 것을 알려줍니다. 아래의 java class를 Table로 만들어줍니다.
public class JPADto {
	
	@Id // primary key 라는 것을 명시합니다.
	@Column // Column이라는 것을 명시합니다.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 주키의 값을 위한 자동 생성 전략을 명시합니다. 알아서 db에 맞게 자동 선택합니다.
	private int boardno;
	
	@Column // Column이라는 것을 명시합니다.
	private String boardname;
	
	@Column // Column이라는 것을 명시합니다.
	private String boardtitle;
	
	@Column // Column이라는 것을 명시합니다.
	private String boardcontent;

	public JPADto() {
		super();
	}

	public JPADto(int boardno, String boardname, String boardtitle, String boardcontent) {
		super();
		this.boardno = boardno;
		this.boardname = boardname;
		this.boardtitle = boardtitle;
		this.boardcontent = boardcontent;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public String getBoardname() {
		return boardname;
	}

	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}

	public String getBoardtitle() {
		return boardtitle;
	}

	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}

	public String getBoardcontent() {
		return boardcontent;
	}

	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}
}

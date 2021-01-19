package com.spring.boot.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;


// BOARDLIST라는 테이블이라는 것을 의미합니다.
@Table(name="BOARDLIST")
@Entity

// Table : 만들어준 객체를 BOARDLIST라는 것을 의미합니다.
// Entity : Table가 될 객체야. 라는 것을 알려줍니다. 아래의 java class를 Table로 만들어줍니다.
public class BoardListDto {
	
	@Id // primary key 라는 것을 명시합니다.
	@Column // Column이라는 것을 명시합니다.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 주키의 값을 위한 자동 생성 전략을 명시합니다. 알아서 db에 맞게 자동 선택합니다.
	private int boardno;
	
	@Column // Column이라는 것을 명시합니다.
	@NonNull
	private String boardname;
	
	@Column // Column이라는 것을 명시합니다.
	@NonNull
	private String boardtitle;
	
	@Column // Column이라는 것을 명시합니다.
	@NonNull
	private String boardcontent;

	// 1개의 글에는 여러개의 댓글이 달려있을 수 있기 때문에 1 : N관계입니다.
	// 불필요한 양쪽 테이블 조회를 막기 위해서 양쪽 모두 지연로딩 설정
	@OneToMany(mappedBy = "boardlistdto", fetch = FetchType.LAZY)
	private List<BoardReplyDto> reply;

	public BoardListDto() {
		super();
	}

	public BoardListDto(int boardno, String boardname, String boardtitle, String boardcontent,
			List<BoardReplyDto> reply) {
		super();
		this.boardno = boardno;
		this.boardname = boardname;
		this.boardtitle = boardtitle;
		this.boardcontent = boardcontent;
		this.reply = reply;
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

	public List<BoardReplyDto> getReply() {
		return reply;
	}

	public void setReply(List<BoardReplyDto> reply) {
		this.reply = reply;
	}

	
}

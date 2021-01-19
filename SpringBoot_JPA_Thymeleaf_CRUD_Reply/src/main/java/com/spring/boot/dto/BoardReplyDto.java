package com.spring.boot.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Table(name="BOARDREPLY") // BOARDREPLY라는 테이블이라는 것을 의미.
@Entity // 테이블이 될 객체라는 것을 의미.
public class BoardReplyDto {
	
	@Id // 기본키 지정
	@Column // 컬림이라는 것을 명시
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 주키의 값을 위한 자동 생성 전략을 명시
	private int replyno;
	
	@Column // 컬럼 명시
	@NonNull // NOT NULL명시
	private String replywriter;
	
	@Column // 컬럼 명시
	@NonNull // NOT NULL명시
	private String replycontent;
	
	@Column(insertable = true) // 컬럼 명시
	@NonNull // NOT NULL명시
	private Date replydate;
	
	@JoinColumn(name = "boardno") // BOARDNO로 조인한다는 것을 명시.
	@ManyToOne(fetch = FetchType.LAZY) // 다대일 관계를 명시 , 여러개의 댓글은 하나의 글에 존재하니까 N : 1
	private BoardListDto boardlistdto; // BOARDLIST를 조인해주기 위해 선언

	public BoardReplyDto() {
		super();
	}

	public BoardReplyDto(int replyno, String replywriter, String replycontent, Date replydate,
			BoardListDto boardlistdto) {
		super();
		this.replyno = replyno;
		this.replywriter = replywriter;
		this.replycontent = replycontent;
		this.replydate = replydate;
		this.boardlistdto = boardlistdto;
	}

	public int getReplyno() {
		return replyno;
	}

	public void setReplyno(int replyno) {
		this.replyno = replyno;
	}

	public String getReplywriter() {
		return replywriter;
	}

	public void setReplywriter(String replywriter) {
		this.replywriter = replywriter;
	}

	public String getReplycontent() {
		return replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}

	public Date getReplydate() {
		return replydate;
	}

	public void setReplydate(Date replydate) {
		this.replydate = replydate;
	}

	public BoardListDto getBoardlistdto() {
		return boardlistdto;
	}

	public void setBoardlistdto(BoardListDto boardlistdto) {
		this.boardlistdto = boardlistdto;
	}
	
	
}

package com.spring.boot.board.dto;

import java.util.Date;

public class BoardDto {
	
	private int boardno;
	private String boardtitle;
	private String boardcontent;
	private String boardwriter;
	private Date boardregdate;
	
	public BoardDto() {
		
	}
	
	public BoardDto(int boardno, String boardtitle, String boardcontent, String boardwriter, Date boardregdate) {
		super();
		this.boardno = boardno;
		this.boardtitle = boardtitle;
		this.boardcontent = boardcontent;
		this.boardwriter = boardwriter;
		this.boardregdate = boardregdate;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
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
	public String getBoardwriter() {
		return boardwriter;
	}
	public void setBoardwriter(String boardwriter) {
		this.boardwriter = boardwriter;
	}
	public Date getBoardregdate() {
		return boardregdate;
	}
	public void setBoardregdate(Date boardregdate) {
		this.boardregdate = boardregdate;
	}
	
	

}

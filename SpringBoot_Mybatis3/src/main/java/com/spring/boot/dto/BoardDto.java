package com.spring.boot.dto;

public class BoardDto {
	
	private int boardno;
	private String boardname;
	private String boardtitle;
	private String boardcontent;
	
	public BoardDto() {
		super();
	}
	public BoardDto(int boardno, String boardname, String boardtitle, String boardcontent) {
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

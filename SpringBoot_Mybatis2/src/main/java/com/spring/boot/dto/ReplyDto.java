package com.spring.boot.dto;

public class ReplyDto {
	
	private int replyno;
	private String replywriter;
	private String replycontent;
	private String replydate;
	private int boardno;
	
	
	public ReplyDto() {
		super();
	}
	public ReplyDto(int replyno, String replywriter, String replycontent, String replydate, int boardno) {
		super();
		this.replyno = replyno;
		this.replywriter = replywriter;
		this.replycontent = replycontent;
		this.replydate = replydate;
		this.boardno = boardno;
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
	public String getReplydate() {
		return replydate;
	}
	public void setReplydate(String replydate) {
		this.replydate = replydate;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

}

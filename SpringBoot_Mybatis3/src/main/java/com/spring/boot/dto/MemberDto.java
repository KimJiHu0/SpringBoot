package com.spring.boot.dto;

import java.util.Date;

public class MemberDto {
	
	private int memberidx;
	private String memberid;
	private String memberpw;
	private String membername;
	private Date memberregdate;
	
	public MemberDto() {
		super();
	}
	public MemberDto(int memberidx, String memberid, String memberpw, String membername, Date memberregdate) {
		super();
		this.memberidx = memberidx;
		this.memberid = memberid;
		this.memberpw = memberpw;
		this.membername = membername;
		this.memberregdate = memberregdate;
	}
	public int getMemberidx() {
		return memberidx;
	}
	public void setMemberidx(int memberidx) {
		this.memberidx = memberidx;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMemberpw() {
		return memberpw;
	}
	public void setMemberpw(String memberpw) {
		this.memberpw = memberpw;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public Date getMemberregdate() {
		return memberregdate;
	}
	public void setMemberregdate(Date memberregdate) {
		this.memberregdate = memberregdate;
	}
}

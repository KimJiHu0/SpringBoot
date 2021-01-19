package com.spring.boot.biz;

import java.util.List;

import com.spring.boot.dto.ReplyDto;

public interface ReplyBiz {
	
	public List<ReplyDto> replyList(int boardno);
	
	public int replyInsert(ReplyDto dto);

	public int replyDelete(int replyno);
	
	public int replyUpdate(ReplyDto dto);
}

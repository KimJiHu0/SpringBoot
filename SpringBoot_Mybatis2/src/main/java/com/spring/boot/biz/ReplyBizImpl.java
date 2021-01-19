package com.spring.boot.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dto.ReplyDto;
import com.spring.boot.mapper.ReplyMapper;

@Service
public class ReplyBizImpl implements ReplyBiz {

	@Autowired
	private ReplyMapper replymapper;
	
	@Override
	public List<ReplyDto> replyList(int boardno) {
		return replymapper.replyList(boardno);
	}

	@Override
	public int replyInsert(ReplyDto dto) {
		return replymapper.replyInsert(dto);
	}

	@Override
	public int replyDelete(int replyno) {
		return replymapper.replyDelete(replyno);
	}

	@Override
	public int replyUpdate(ReplyDto dto) {
		return replymapper.replyUpdate(dto);
	}

}

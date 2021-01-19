package com.spring.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.biz.ReplyBiz;
import com.spring.boot.dto.ReplyDto;

@Controller
public class ReplyController {

	@Autowired
	private ReplyBiz replybiz;
	
	@PostMapping("replyinsert.do")
	public String replyInsert(ReplyDto dto) {
		
		replybiz.replyInsert(dto);
		
		return "redirect:/boarddetail.do?boardno="+dto.getBoardno();
	}
	
	
	@GetMapping("replydelete.do")
	public String replyDelete(int replyno, int boardno) {
		
		replybiz.replyDelete(replyno);
		
		return "redirect:/boarddetail.do?boardno="+boardno;
	}
	
	@GetMapping("replyupdate.do")
	public String replyUpdate(ReplyDto dto) {
		
		replybiz.replyUpdate(dto);
		
		return "redirect:/boarddetail.do?boardno="+dto.getBoardno();
	}
	
}

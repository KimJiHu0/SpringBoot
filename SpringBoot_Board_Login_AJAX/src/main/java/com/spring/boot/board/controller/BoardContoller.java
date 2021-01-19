package com.spring.boot.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.boot.board.biz.BoardBiz;
import com.spring.boot.board.dto.BoardDto;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class BoardContoller {
	
	@Autowired
	private BoardBiz boardbiz;
	
	// 전체글보기를 클릭하면 넘어오는 list값을 받아서 처리.
	@GetMapping("/list")
	public String BoardMain(Model model) {
		
		model.addAttribute("list", boardbiz.selectList());
		
		return "BoardList";
	}
	
	// 글작성을 클릭하면 넘어오는 요청값을 받아서 처리.
	@GetMapping("/insert")
	public String BoardInsert() {
		return "BoardInsert";
	}
	
	@PostMapping("/insertres")
	public String BoardInsertres(BoardDto boarddto, RedirectAttributes msg) {
		
		int res = boardbiz.insertList(boarddto);
		
		if(res > 0) {
			msg.addFlashAttribute("msg", "글 작성이 완료되었습니다.");
			return "redirect:/list";
		} else {
			msg.addFlashAttribute("msg", "글 작성이 실패되었습니다.");
			return "redirect:/insert";
		}
	}
	
	@GetMapping("/selectone")
	public String selectOne(int boardno, Model model) {
		
		BoardDto boarddto = boardbiz.selectOne(boardno);
		
		model.addAttribute("boarddto", boarddto);
		
		return "BoardDetail";
	}
	
	@GetMapping("/update")
	public String updateForm(int boardno, Model model) {
		
		BoardDto boarddto = boardbiz.selectOne(boardno);
		
		model.addAttribute("boarddto", boarddto);
		
		return "BoardUpdate";
	}
	
	@PostMapping("/updateres")
	public String updateres(BoardDto boarddto, RedirectAttributes msg) {
		
		int res = boardbiz.update(boarddto);
		
		if(res > 0) {
			msg.addFlashAttribute("msg", "글 수정이 완료되었습니다.");
			return "redirect:/selectone?boardno=" + boarddto.getBoardno();
		} else {
			msg.addFlashAttribute("msg", "글 수정이 실패되였습니다.");
			return "redirect:/update?boardno=" + boarddto.getBoardno();
		}
	}
	
	@GetMapping("/delete")
	public String delete(int boardno, RedirectAttributes msg) {
		
		int res = boardbiz.delete(boardno);
		
		if(res > 0) {
			msg.addFlashAttribute("msg", "글 삭제가 완료되었습니다.");
			return "redirect:/list";
		} else {
			msg.addFlashAttribute("msg", "글 삭제가 실패되었습니다.");
			return "redirect:/update?boardno=" + boardno;
		}
		
	}
	
}

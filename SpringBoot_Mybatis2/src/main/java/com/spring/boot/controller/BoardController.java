package com.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.boot.biz.BoardBiz;
import com.spring.boot.biz.ReplyBiz;
import com.spring.boot.dto.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	private BoardBiz boardbiz;
	
	@Autowired
	private ReplyBiz replybiz;

	// 글 전체목록을 출력하는 메소드
	@GetMapping("boardlist.do")
	public String boardList(Model model) {
		
		model.addAttribute("list", boardbiz.boardList());
		
		return "/board/boardList";
	}
	
	// 글 상세보기 하는 메소드
	@GetMapping("boarddetail.do")
	public String boardDetail(int boardno, Model model) {
		
		model.addAttribute("dto", boardbiz.boardDetail(boardno));
		
		// Detail로 넘어온 값 boardno를 통해서 댓글 출력하기
		model.addAttribute("replylist", replybiz.replyList(boardno));
		
		return "/board/boardDetail";
	}
	
	// 글 작성을 눌렀을 때 들어오는 메소드
	@GetMapping("boardinsert.do")
	public String boardInsert() {
		return "/board/boardInsert";
	}
	
	// 작성버튼을 클릭했을 때 모든 값을 가지고 이 메소드로 들어옵니다.
	@PostMapping("boardinsertres.do")
	public String boardInsertRes(BoardDto dto) {
		
		// boardbiz에 있는 boardInsert 메소드를 실행합니다.
		// 반환타입은 int타입입니다.
		// 만일 insert가 되면 1, 그렇지 않으면 0을 담아줍니다.
		int res = boardbiz.boardInsert(dto);
		
		// 만일 성공했다면
		if(res > 0) {
			// list를 보여줍니다.
			return "redirect:/boardlist.do";
		}
		// 만일 실패했다면
		else {
			// 다시 insert를 보여줍니다.
			return "redirect:/boardinsert.do";
		}
	}
	
	// 수정 버튼을 누르면 들어오는 메소드입니다.
	@GetMapping("boardupdate.do")
	public String boardUpdate(int boardno, Model model) {
		
		model.addAttribute("dto", boardbiz.boardDetail(boardno));

		return "/board/boardUpdate";
	}
	
	// 수정버튼을 눌렀을 때에 DB에 반영하기 위해 들어오는 메소드
	@PostMapping("/boardupdateres.do")
	public String boardUpdateRes(BoardDto dto, Model model) {
		
		// 업데이트 해주는 메소드를 실행하여 결과값을 res라는 변수에 담아줍니다.
		// 이는 insert와 동일하게 성공은 1, 실패는 0을 담아줍니다.
		int res = boardbiz.boardUpdate(dto);
		
		// 만일 res가 0보다 커서 성공하면
		if(res > 0) {
			// 상세보기로 넘겨줍니다.
			return "redirect:/boarddetail.do?boardno="+dto.getBoardno();
		}
		// 그렇지 않고 실패했다면
		else {
			// 다시 수정하는 페이지로 이동합니다.
			return "redirect:/boardupdate.do?boardno="+dto.getBoardno();
		}
	}
	
	// 삭제버튼을 누르면 들어오는 메소드
	@GetMapping("boarddelete.do")
	public String boardDelete(int boardno) {
		
		// boardDelete 메소드를 실행한 결과값을 res에 담아줍니다.
		// 이 또한 성공은 1 실패는 0입니다.
		int res = boardbiz.boardDelete(boardno);
		
		// 성공했다면
		if(res > 0) {
			// boardList를 보여주고,
			return "redirect:/boardlist.do";
		}
		// 실패했다면 다시 boardDetail을 보여줍니다.
		else {
			return "redirect:/boarddetail.do?boardno="+boardno;
		}
		
	}
}

package com.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.boot.dao.JPADao;

@Controller
public class BoardController {
	
	// JPADao interface의 값과 연결?해준다는 의미로 생각하고 있습니다.
	// 이를 작성하지 않으면 연결고리가 끊겨서 List를 출력할 수 없습니다.
	@Autowired
	private JPADao dao;

	// list.do라는 요청이 들어오게 되면 해당 Method와 연결됩니다.
	@GetMapping("/list.do")
	public String boardList(Model model) {
		
		// model이라는 객체에 list라는 이름으로 dao에 있는 findAll Method의 return값을 담아서
		// board Folder 밑에 있는 boardList.html에 보내집니다.
		model.addAttribute("list", dao.findAll());
		for(int i = 0; i < dao.findAll().size(); i++) {
			System.out.println("번호 : "+dao.findAll().get(i).getBoardno());
			System.out.println("이름 : "+dao.findAll().get(i).getBoardname());
			System.out.println("제목 : "+dao.findAll().get(i).getBoardtitle());
			System.out.println();
		}
		
		return "/board/boardList";
	}
	
}

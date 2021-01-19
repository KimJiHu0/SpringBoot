package com.spring.boot.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.boot.board.biz.MemberBiz;
import com.spring.boot.board.dto.MemberDto;

@Controller
public class MemberController {
	
	@Autowired
	private MemberBiz memberbiz;
	
	@GetMapping("/login")
	public String Login() {
		return "MemberLogin";
	}
	
	@PostMapping("/loginres")
	public String LoginRes(HttpSession session, MemberDto memberdto, RedirectAttributes msg) {
		
		MemberDto loginuser = memberbiz.login(memberdto);
		
		if(loginuser == null) {
			msg.addFlashAttribute("msg","로그인이 실패했습니다. 다시 로그인을 진행해주세요.");
			return "redirect:/login";
		} else {
			session.setAttribute("login", loginuser);
			msg.addFlashAttribute("msg","로그인이 성공했습니다.");
			return "redirect:/list";
		}
	}
	
	@GetMapping("/regist")
	public String Regist() {
		return "MemberRegist";
	}
	
	@PostMapping("/registres")
	public String RegistRes(MemberDto memberdto, RedirectAttributes msg) {
		
		int res = memberbiz.regist(memberdto);
		
		if(res > 0) {
			msg.addFlashAttribute("msg", "회원가입이 완료되었습니다. 로그인을 진행해주세요");
			return "redirect:/login";
		} else {
			msg.addFlashAttribute("msg", "회원가입이 실패했습니다. 다시 진행해주세요");
			return "redirect:/regist";
		}
	}

}

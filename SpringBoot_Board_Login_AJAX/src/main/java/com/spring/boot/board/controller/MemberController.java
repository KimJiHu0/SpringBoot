package com.spring.boot.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@ResponseBody
	public Map<Object, Object> LoginRes(HttpSession session, @RequestBody MemberDto memberdto, RedirectAttributes msg) {
		
		Map<Object, Object> login = new HashMap<Object, Object>();

		boolean check = false;
		
		MemberDto memberlogin = memberbiz.login(memberdto);
		
		if(memberlogin != null) {
			check = true;
			session.setAttribute("login", memberlogin);
			login.put("check", check);
		} else {
			login.put("check", check);
		}
		return login;
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

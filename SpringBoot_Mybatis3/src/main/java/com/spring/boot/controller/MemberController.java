package com.spring.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.boot.biz.MemberBiz;
import com.spring.boot.dto.MemberDto;

@Controller
public class MemberController {
	
	@Autowired
	private MemberBiz memberbiz;

	// index.jsp에서 Login버튼을 클릭했을 때 넘어오는 요청값 boardlogin.do를 통해서
	// 해당 메소드와 연결하여 login Folder 안에 있는 boardLoginForm.jsp를 화면에 보여줍니다.
	@GetMapping("boardlogin.do")
	public String loginForm() {
		return "/login/boardLoginForm";
	}
	
	@PostMapping("boardlogincheck.do")
	@ResponseBody
	public Map<Object, Object> boardLoginCheck(@RequestBody MemberDto dto, HttpSession session){
		// JSON형태로 내보내기 위해서 MAP을 선언하였습니다.
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		// user라는 MemberDto 타입에 memberbiz에 있는 loginMember이라는 메소드를 실행한
		// 결과값을 담아준 후
		MemberDto user = memberbiz.loginMember(dto);
		
		// 그 변수가 null이 아니라면. 즉, 제대로 값을 찾아왔다면
		if(user != null) {
			// session에 User라는 이름으로 user변수를 담아주고,
			session.setAttribute("User", user);
			// map에는 id라는 이름으로 user에서 나온 Memberid값을 담아주고,
			map.put("id", user.getMemberid());
			// check라는 이름으로 true를 담아주며
			map.put("check", true);
		// 그렇지 않고 null이라면
		} else {
			// map에 check라는 이름으로 false를 담아준 후
			map.put("check", false);
		}
		// return합니다.
		return map;
	}
	
	// adminPage를 보여주기 위한 메소드
	@GetMapping("boardadminpage.do")
	public String adminPage(Model model, HttpSession session) {
		// model객체에 session값인 User의 값을 User이라는 이름으로 담아서 보내줍니다.
		model.addAttribute("User", session.getAttribute("User"));
		return "/admin/boardAdmin";
	}
	
	// userPage를 보여주기 위한 메소드
	@GetMapping("boarduserpage.do")
	public String userPage(Model model, HttpSession session) {
		// model객체에 session값인 User의 값을 User이라는 이름으로 담아서 보내줍니다.
		model.addAttribute("User", session.getAttribute("User"));
		return "/user/boardUser";
	}
	
	// 로그아웃을 눌렀을 떄 들어오는 메소드
	@GetMapping("boardlogout.do")
	public String LogOut(HttpSession session) {
		
		session.invalidate();
		
		return "/";
	}
	
	// Sign Up 버튼을 클릭했을 때 들어오는 메소드
	@GetMapping("boardregist.do")
	public String boardSignUp() {
		return "/login/boardRegistForm";
	}
	
	// id값을 받아서 이를 통해서 db에서 전체 출력하여, id가 동일한게 있는지 확인하기
	@PostMapping("memberidcheck.do")
	@ResponseBody
	public Map<Object,Object> memberidcheck(@RequestBody MemberDto dto){
		Map<Object,Object> map = new HashMap<Object, Object>();
		
		String memberid = dto.getMemberid();
		
		int cnt = memberbiz.selectMemberAll(memberid);
		
		if(cnt > 0) {
			map.put("check", false);
		} else {
			map.put("check", true);
		}
		return map;
	}
	
	// 회원가입 진행시키는 메소드
	@GetMapping("boardregistres.do")
	public String boardRegistRes(MemberDto dto ,RedirectAttributes msg) {
		
		int res = memberbiz.registMember(dto);
		
		if(res > 0) {
			msg.addFlashAttribute("msg", "회원가입 되었습니다. 로그인을 진행해주세요.");
			return "redirect:/boardlogin.do";
		} else {
			msg.addFlashAttribute("msg", "회원가입에 실패했습니다. 다시 회원가입해주세요.");
			return "redirect:/boardregist.do";
		}
	}
	
}

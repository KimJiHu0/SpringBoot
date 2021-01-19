package com.spring.boot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.biz.MemberBiz;
import com.spring.boot.dto.MemberDto;

@Controller
public class MemberController {
	
	@Autowired
	private MemberBiz memberbiz;
	
	// 로그인 버튼을 클릭하게 되면 아래의 메소드로 들어와서 login Folder에 있는 loginForm.jsp를 찾아서 화면에 보여주게 됩니다.
	@RequestMapping("login.do")
	public String loginForm() {
		return "login/loginForm";
	}
	
	// 로그인 화면에서 아이디와 비밀번호를 입력하면 JSON형태로 값이 넘어오게 됩니다.
	// 이를 받아주기 위해서는 @RequestBody를 사용하며, 아래의 메소드에서 return값을 JSON형태로 보내주기 위해서는
	// @ResponseBody를 사용합니다.
	// 위 두 개의 어노테이션을 사용하려면 pom.xml에서 jackson-core-asl과 jackson-mapper.asl을 추가해야합니다.
	// 스프링이 4.x 이상 버전이면 databind를 사용합니다.
	@RequestMapping("ajaxlogin.do")
	@ResponseBody
	public Map<Object, Object> ajaxLogin(@RequestBody MemberDto dto, HttpSession session){
		
		// Map을 선언을 하고,
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		// 받아온 dto를 파라미터로 넣어서 memberbiz에 있는 loginUser를 호출하게 되고,
		// Mapper에서 작성한 쿼리문을 토대로 해당 값이 있는지 없는지를 가져와서 담아주게 됩니다.
		// 만일 해당하는 아이디와 비밀번호가 존재하지 않는다면, loginUser라는 Dto에는 아무런 값이 들어가지 않습니다.
		MemberDto loginUser = memberbiz.loginUser(dto);
		
		// 만일 loginUser에 아무런 값이 들어가지 않았다면
		if(loginUser == null) {
			// map에 check라는 이름으로 false를 입력해주고,
			map.put("check", false);
		// 무언가 값이 들어왔다면
		} else {
			// session에 login이라는 이름으로 loginUser을 저장하고,
			session.setAttribute("login", loginUser);
			// map에 check이름으로 true라는 값과
			map.put("check", true);
			// id라는 이름으로 loginUser의 memberid를 담아서 return해줍니다.
			map.put("id", loginUser.getMemberid());
		}
		return map;
	}
	
	// 회원가입을 누르면 아래의 메소드로 들어와서 login Folder 밑에 있는 registForm.jsp를 화면에 보여준다.
	@RequestMapping("regist.do")
	public String registForm() {
		return "login/registForm";
	}
	
	// 가입완료를 누르면 아래로 들어갑니다.
		@RequestMapping("registres.do")
		public String registRes(MemberDto dto) {
			
			int res = memberbiz.registUser(dto);
			
			if(res > 0) {
				return "redirect:/login.do";
			} else {
				return "redirect:/regist.do";
			}
		}
	
	
	// 관리자 페이지로 넘어가게 해준다.
	@RequestMapping("admin.do")
	public String adminPage(HttpSession session, Model model) {
		
		// dto에 session의 login값을 담아주고,
		MemberDto dto = (MemberDto) session.getAttribute("login");
		// model에 dto라는 이름으로 dto를 담아서 보내준다.
		model.addAttribute("dto", dto);
		
		return "login/adminPage";
	}
	
	// 로그아웃을 누르게 되면 아래의 메소드로 들어오게 되고, session.ivalidate(); 를 통해 session을 만료시킨다.
	@RequestMapping("logout.do")
	public String logOut(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/login.do";
	}
}

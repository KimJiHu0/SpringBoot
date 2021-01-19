package com.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("vue.do")
	public String vueTest() {
		return "/vue/vueTest";
	}
	
}

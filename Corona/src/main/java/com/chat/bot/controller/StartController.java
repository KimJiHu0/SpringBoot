package com.chat.bot.controller;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {

	@RequestMapping("/")
	public String index() throws InterruptedException {
		sendMessage();
		return "index";
	}

	@RequestMapping("/coronanum")
	public String Corona(Model model) {

		// CoronaNumController에 있는 coronaNum이라는 메소드를 실행한
		// 반환되는 결과값을 String타입의 coronaData에 담아준다.
		String coronaData = CoronaNumController.coronaNum();
		// coronaData라는 이름으로 coronaData라는 값을 담아서 보낸다.
		model.addAttribute("coronaData", coronaData);

		return "Corona";
	}

	// 초 분 시 매일 아래의 함수가 실행.
	@Scheduled(cron= "0 10 10 * * *")
	// 1초마다 아래의 함수 실행
	// @Scheduled(fixedDelay = 5000)
	public static void sendMessage() throws InterruptedException {
		
		String msg = CoronaNumController.coronaNum();
		// 기존 코드
		// "4801726508666992", "4801827032518748", "4801831251332198", "4801829415372910", "4801819604980843", "4801841941435498"
		// String[] urls = { "4801726508666992", "4801831251332198", "4801829415372910" };

		// for (int i = 0; i < urls.length; i++) {
		// 	KakaoChannel.sendMessage(urls[i], msg);
		// }
		KakaoChannel.sendMessage(msg);
	}
}

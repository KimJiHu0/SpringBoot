package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
// 아직 DataBase에 연결하지 않았기 때문에 오류가 나는 것으로 보인다.
// 그래서 Controller이라는 Annotation이 아닌 EnableAutoCogifguration이라는 설정을 준다.
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
@Controller
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/test")
	public String test() {
		return "/test/test";
	}

}

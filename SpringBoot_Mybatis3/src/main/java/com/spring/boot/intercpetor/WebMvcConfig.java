package com.spring.boot.intercpetor;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 정적 리소스 파일을 제외하기 위해서 excludePathPatterns를 사용했습니다.
		// 또한 프로젝트가 켜졌을 때 요청되는 값 "/" 를 제외시켜 주었으며, 로그인과, 회원가입도 제외시켰습니다.
		
		List<String> excludePath = Arrays.asList(
				// 정적인 파일은 CSS, JS파일이 담겨있는 Folder의 경로를 모두 제외했으며
				// 프로젝트 실행 시 가장 처음으로 들어오는 경로 "/",
				// 로그인과 회원가입을 제외시켰습니다.
				"/CSS/**","/JS/**", "/", "/boardlogin.do", "/boardlogincheck.do",
				"/boardregist.do", "/boardregistres.do" ,"/memberidcheck.do"
				);
		
		registry.addInterceptor(new BootInterceptor()).excludePathPatterns(excludePath);
	}
	
}

package com.spring.boot.common.interceptor;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 우선 interceptor을 작성하기 위한 Config를 작성해야합니다.
// 현재 class에 어노테이션으로 Configuration을 걸어줍니다.
// 그 후 WebMvcConfigurer을 implements받아서 addInterceptors라는 메소드를 만들어줍니다.

@Configuration
public class IntercepotrConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// BoardInterceptor이라는 java파일을 객체로 생성하여, interceptor에 추가해줍니다.
		// addPathPatterns는 어떠한 요청값을 사용할건지 추가해줍니다.
		// 이 때, addPathPatterns("list.do") 로 여러개를 붙여 사용할 수 있고 아래와 같이 List로 만들어서 사용할 수 있습니다.
		// excludePathPattends는 제외할 URL패턴을 적용합니다.
		
		// interceptor에서 걸러 줄 URL 모음
		// List<String> ADD_URL_Pattern = Arrays.asList("/list.do", "/insert.do", "/insertres.do", "/detail.do", "/update.do", "/updateres.do", "/delete.do", "/login.do", "/ajaxlogin.do", "/regist.do", "/registres.do", "/admin.do", "/logout.do");
		// interceptor에서 제외시킬 URL 모음
		List<String> EXC_URL_Pattern = Arrays.asList("/", "/login.do","/ajaxlogin.do", "/regist.do", "/registres.do");
		
		registry.addInterceptor(new BoardInterceptor()).addPathPatterns("/**").excludePathPatterns(EXC_URL_Pattern);
		
	}
	
	

}

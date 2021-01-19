package com.spring.boot.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.dto.MemberDto;

public class BoardInterceptor implements HandlerInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(BoardInterceptor.class);
	
	// Alt + Shift + S 를 누른 후 V를 눌러 원하는 메소드를 사용하면 됩니다.

	
	// Controller의 메소드에 매핑된 특정 url을 호출했을 때 Controller에 접근하기 전 실행되는 메소드.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("\n ----preHandle----");
		
		HttpSession session = request.getSession();
		Object dto = session.getAttribute("login");
		
		
		if(dto != null) {
			return true;
		} else {
			response.sendRedirect("/login.do");
			return false;
		}
	}

	// Controller를 경유한 다음 View로 결과를 전달하기 전 실행되는 메소드.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info("\n ----postHandle----");
		logger.info("\n ModelAndView : " + modelAndView);
	}
}

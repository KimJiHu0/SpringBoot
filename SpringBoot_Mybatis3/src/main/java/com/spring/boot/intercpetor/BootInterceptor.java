package com.spring.boot.intercpetor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class BootInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(BootInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("\n ========================");
		logger.info("\n ==========시작==========");
		
		// 만일 session값 중 이름이 User인 객체가 null이 아니라면
		if(request.getSession().getAttribute("User") != null) {
			
			logger.info("\n Session에 값이 존재합니다.");
			
			// 넘어가는 것을 허락해줍니다.
			return true;
		}
		
		// 만일 session값 중 이름이 User인 객체가 null이라면
		if(request.getSession().getAttribute("User") == null) {
			
			logger.info("\n Session에 값이 존재하지 않습니다.");
			
			// boardlogin.do를 요청하여 로그인 페이지로 넘기고,
			response.sendRedirect("/boardlogin.do");
			// 넘어가는 것을 허락하지 않습니다.
			return false;
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info("\n ===========끝===========");
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

}

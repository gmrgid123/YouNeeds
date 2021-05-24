package com.web.youneeds.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.web.youneeds.dto.MemberDto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MemberDto loginDto = (MemberDto)request.getSession().getAttribute("login");
		
		if(request.getRequestURI().contains("/notice_write")) {
			if( loginDto==null || !(loginDto.getM_type().equals("관리")) ) {
				jsResponse("관리자만 이용 가능합니다.", "notice_board?p=1" , response);
				return false;
			}
		}
		
		return true;
	}
	
	
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String s = "<script type='text/javascript'>"+
					"alert('"+ msg +"');" + 
					"location.href='"+ url +"';"+
					"</script>";
		PrintWriter out = response.getWriter();
		out.print(s);
	}
}

package com.newlecture.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		
		// 변수 선언 -> 전달한 내용이 무조건 문자열이기 때문에 문자열로 받음
		String[] num_ = request.getParameterValues("num");
		
		int result = 0;
		
		// 반복할 때마다 변수가 선언되는 것 아닌가? 라는 생각을 할 수 있지만
		// 반복하기 전에 한 번만 선언되고 연산만 반복됨
		for (int i=0; i<num_.length; i++) {
			int num = Integer.parseInt(num_[i]);
			result += num;
		}
		
		response.getWriter().printf("result is %d\n", result);
		
	}

}

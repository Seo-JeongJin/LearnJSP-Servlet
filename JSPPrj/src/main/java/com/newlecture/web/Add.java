package com.newlecture.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		
		// 변수 선언 -> 전달한 내용이 무조건 문자열이기 때문에 문자열로 받음
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		
		// 사용자로부터 빈 문자열을 받았을 때 기본 값
		int x = 0;
		int y = 0;
		
		// x, y 가 빈 문자열이 아닐 때 요청받은 값을 정수화
		// name="x" -> name 속성은 서버로 전송할 때 사용할 파라미터 이름! 즉, 쿼리스트링의 키 값
		// -> submit 버튼을 누르면 null이 오는 일은 없음 -> 빈 문자열이거나 값이 들어오거나
		if (!x_.equals("")) x = Integer.parseInt(x_);
		if (!y_.equals("")) y = Integer.parseInt(y_);
		
		int result = x + y;
		
		response.getWriter().printf("result is %d\n", result);
		
	}

}
